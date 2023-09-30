package com.TreueTechnologies.OnineBookStore.Repository;

import com.TreueTechnologies.OnineBookStore.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
