package com.TreueTechnologies.OnineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String name;

    String email;

    String mobileNo;

    String age;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    Cart cart;


}
