# postgres

### ElementCollection, CollectionTable

- As storing a list of elements in one column is not recommended, we have to make a table for values
  in the list with one-to-many relation from parent to child.
  The traditional way is to create an object and make a relationship. however with this
  annotation `@ElementCollection(fetch = FetchType.EAGER)` we can achieve same functionality.
  If we like ti change any default properties, we can change it with these
  annotations`  @CollectionTable(name = "book_ratings", joinColumns = @JoinColumn(name = "book_id"))
  @Column(name = "rating")`

### JoinTable

- In order mak ea join table, we traditionally have to make another entity for join table and
  establish relationships like many-to-many. Instead, when all we have to do to establish
  relationship and join table itself doesn't have any extra properties to it, we can use these
  annotations together.
  ``` 
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "book_references", joinColumns = @JoinColumn(name = "book_id"))
  @AttributeOverrides({
      @AttributeOverride(name = "name", column = @Column(name = "name_value")),
      @AttributeOverride(name = "type", column = @Column(name = "type_value"))
  })
  Set<Reference> references = new HashSet<>();
  ```

Such Way we can avoid embeded objects and directly have the list of childs associated with
parent, instead of list of join table entities.

### SPRING-DATA-REST

- It is as simple as adding dependency to gradle
  file. `implementation 'org.springframework.boot:spring-boot-starter-data-rest'` .
- All the entities that have repository layers are exposed with GET, POST, PUT, PATCH and DELETE
  operations.
- If the embedded objects have no declared repository,

### OPEN-API-3.0

- As a Spring-boot project we can add this
  dependency `implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'`.
- swagger ui is available at http://localhost:8081/swagger-ui/index.html
- swagger docs url is available at http://localhost:8081/v3/api-docs
- By defining a bean of Docket we can further configure swagger more granular level, like how to
  hide all delete end points.

```
@Bean
  public OpenApiCustomizer removeDeleteOperations() {
    return openApi -> openApi.getPaths().values().forEach(pathItem ->
        pathItem.setDelete(null)
    );
  }
```

