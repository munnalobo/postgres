package com.neuron.poc.postgres.respository;

import com.neuron.poc.postgres.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
