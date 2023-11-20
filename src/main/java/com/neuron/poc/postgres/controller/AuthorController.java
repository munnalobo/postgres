package com.neuron.poc.postgres.controller;

import com.neuron.poc.postgres.entity.Author;
import com.neuron.poc.postgres.respository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorRepository authorRepository;

  @PostMapping("/author")
  public Author saveAuthor(@RequestBody Author author) {
    return authorRepository.save(author);
  }

  @GetMapping("/author/{id}")
  public Author getAuthor(@PathVariable Long id) {
    Author build = Author.builder().build();
    authorRepository.findById(id)
        .ifPresent(x -> {
          build.setFirstName(x.getFirstName());
        });
    return build;
  }
}
