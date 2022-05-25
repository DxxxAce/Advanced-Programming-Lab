package com.lab11.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"totalFriends", "friends"})
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="name")
    String name;

    @Column(name="friends")
    long totalFriends;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Person> friends;

    public void addFriend(Person person)
    {
        friends.add(person);
    }
}
