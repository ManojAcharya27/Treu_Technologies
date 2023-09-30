package com.TreueTechnologies.OnineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int totalCost;


    int numberOfItem;

    User user;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<Item> itemList=new ArrayList<>();

}
