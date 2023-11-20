package com.neuron.poc.postgres.respository;

import com.neuron.poc.postgres.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
