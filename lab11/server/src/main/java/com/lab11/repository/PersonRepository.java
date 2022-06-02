package com.lab11.repository;

import com.lab11.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findTop3ByOrderByTotalFriendsDesc();
}
