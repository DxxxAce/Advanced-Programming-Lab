package com.commands;

import com.social.Network;
import com.social.Person;

import java.net.Socket;
import java.util.List;

public class Command {

    public static void register(String name) {

        Network.addPerson(new Person(name));
    }

    public static boolean login(String name, Socket socket) {

        if(Network.verifyPerson(name)) {

            Person person = Network.getPersonByName(name);
            person.setSocket(socket);
            person.setLogged(true);

            return true;
        }

        return false;
    }

    public static boolean friend(String name, List<String> friends) {

        Person person = Network.getPersonByName(name);

        if(person != null && person.isLogged()) {

            for (String friend:friends) {

                Person otherPerson = Network.getPersonByName(friend);

                if (otherPerson != null) {

                    person.addFriend(otherPerson);
                    otherPerson.addFriend(person);
                }
            }

            return true;
        }

        return false;
    }

    public static boolean sendMessage(String name, String message) {

        Person person = Network.getPersonByName(name);

        if (person != null && person.isLogged()) {

            for (Person friend : person.getFriends()) {

                friend.addMessage(message);
            }

            return true;
        }

        return false;
    }

    public static List<String> read(String name) {

        Person person = Network.getPersonByName(name);

        if (person != null && person.isLogged()) {

            return person.getMessages();
        }

        return null;
    }
}
