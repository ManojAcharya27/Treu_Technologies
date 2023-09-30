package com.TreueTechnologies.OnineBookStore.Repository;

import com.TreueTechnologies.OnineBookStore.Entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
