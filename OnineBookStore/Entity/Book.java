package com.TreueTechnologies.OnineBookStore.Entity;

import com.TreueTechnologies.OnineBookStore.Enum.Genre;
import com.TreueTechnologies.OnineBookStore.Enum.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookName;

    int price;

    String description;

    int authorId;


    @Enumerated(EnumType.STRING)
    Genre genre;

    int quantity;

    int Ratings;

    List<String> review=new ArrayList<>();

    int countOfRating;


    @Enumerated(EnumType.STRING)
    Status status;


    @OneToMany(mappedBy = "book" ,cascade = CascadeType.ALL)
    List<Item> itemList=new ArrayList<>();

      @ManyToOne
      @JoinColumn
      Author author;

}
