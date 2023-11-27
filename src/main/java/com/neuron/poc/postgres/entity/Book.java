package com.neuron.poc.postgres.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String isbn;
  String title;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "book_ratings", joinColumns = @JoinColumn(name = "book_id"))
  @Column(name = "rating")
  List<Integer> ratings;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "book_references", joinColumns = @JoinColumn(name = "book_id"))
  @AttributeOverrides({
      @AttributeOverride(name = "name", column = @Column(name = "name_value")),
      @AttributeOverride(name = "type", column = @Column(name = "type_value"))
  })
  Set<Reference> references = new HashSet<>();

}
