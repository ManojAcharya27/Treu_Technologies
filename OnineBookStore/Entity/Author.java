package com.TreueTechnologies.OnineBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String AuthorName;

    String email;

    String mobileNo;

    int age;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> bookList=new ArrayList<>();
}
