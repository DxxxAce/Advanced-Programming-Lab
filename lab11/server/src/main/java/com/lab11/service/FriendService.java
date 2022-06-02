package com.lab11.service;

import com.lab11.model.Person;
import com.lab11.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FriendService {

    private final FriendRepository repo;

    public List<Person> get(Long id) {

        Optional<Person> personById = repo.findById(id);

        return personById.map(Person::getFriends).orElse(null);
    }

    public boolean save(Long id, String name) {

        Optional<Person> personById = repo.findById(id);

        if (personById.isPresent()) {

            List<Person> personByName = repo.findByName(name);

            if (!personByName.isEmpty()) {

                Person otherPerson = personByName.get(0);

                if (!personById.get().getFriends().contains(otherPerson)) {

                    personById.get().addFriend(otherPerson);
                    personById.get().setTotalFriends(personById.get().getTotalFriends() + 1);

                    otherPerson.addFriend(personById.get());
                    otherPerson.setTotalFriends(otherPerson.getTotalFriends() + 1);

                    repo.save(personById.get());

                    return true;
                }
            }
        }

        return false;
    }
}
