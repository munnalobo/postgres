package com.neuron.poc.postgres.respository;

import com.neuron.poc.postgres.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
