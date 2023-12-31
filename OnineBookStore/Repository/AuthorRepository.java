package com.TreueTechnologies.OnineBookStore.Repository;

import com.TreueTechnologies.OnineBookStore.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByEmail(String email);

    Author findByName(String name);
}
