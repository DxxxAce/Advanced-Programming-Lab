package com.server;

import com.social.Person;
import com.social.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8100;
    private static ServerSocket serverSocket = null;
    private static boolean acceptConnections = true;

    public Server() throws IOException {

        try {

            serverSocket = new ServerSocket(PORT);

            while (true) {

                if(acceptConnections) {

                    System.out.println("Waiting for a client...");
                    Socket socket = serverSocket.accept();
                    ClientThread clientThread = new ClientThread(socket);
                    clientThread.start();
                }
                else {

                    break;
                }
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        finally {

            serverSocket.close();
        }
    }
    public static void stop() throws IOException {

        acceptConnections = false;
    }


    public static void main(String[] args) throws IOException {

        Server server = new Server();

    }
}
