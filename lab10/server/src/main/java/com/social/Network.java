package com.social;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Network {

    private static List<Person> network = new ArrayList<>();

    public static void addPerson(Person person) {

        network.add(person);
    }

    public static boolean verifyPerson(String name) {

        for(Person person : network) {

            if(person.getName().equals(name)) {

                return true;
            }
        }

        return false;
    }

    public static Person getPersonByName(String name) {

        for(Person person : network) {

            if(person.getName().equals(name)) {

                return person;
            }
        }

        return null;
    }

    public static String getNameBySocket(Socket socket) {

        for(Person person : network) {

            if(person.getSocket() != null && person.getSocket().getPort() == socket.getPort()) {

                return person.getName();
            }
        }

        return null;
    }

    public static List<Person> getNetwork() {

        return network;
    }
}
