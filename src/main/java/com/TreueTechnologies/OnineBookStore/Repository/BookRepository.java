package com.TreueTechnologies.OnineBookStore.Repository;

import com.TreueTechnologies.OnineBookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByName(String name);
}
