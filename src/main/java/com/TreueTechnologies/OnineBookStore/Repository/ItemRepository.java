package com.TreueTechnologies.OnineBookStore.Repository;

import com.TreueTechnologies.OnineBookStore.Entity.Item;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
