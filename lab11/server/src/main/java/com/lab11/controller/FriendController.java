package com.lab11.controller;

import com.lab11.model.Person;
import com.lab11.service.FriendService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person/friends")
public class FriendController {

    private final FriendService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFriends (@PathVariable Long id) {

        List<Person> friends = service.get(id);

        if (friends.isEmpty()) {

            return new ResponseEntity<>("The person doesnt have any friends.", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(friends);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> saveFriend (@PathVariable Long id, @RequestParam String name) {

        if (name==null) {

            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }

        if (!service.save(id,name)) {

            return new ResponseEntity<>("Cannot add friend.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Friend added successfully.", HttpStatus.CREATED);
    }
}
