package com.lab11;

import com.lab11.restcontroller.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);

        WebService webService = new WebService();

        webService.savePerson("Alin");
        webService.savePerson("Bogdan");
        webService.savePerson("Alejandro");
        webService.getPeople();

        webService.savePerson("Razvan");
        webService.savePerson("Claudiu");
        webService.savePerson("Paul");
        webService.updatePerson(3L,"Alessandro");
        webService.getPeople();

        webService.deletePerson(6L);
        webService.getPeople();

        webService.addFriend(1L,"Razvan");
        webService.addFriend(1L,"Bogdan");
        webService.addFriend(1L,"Claudiu");
        webService.addFriend(2L,"Alessandro");
        webService.getFriends(1L);

        webService.getTop();
    }
}
