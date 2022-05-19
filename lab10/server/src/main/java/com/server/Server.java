package com.server;

import com.social.Person;
import com.social.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8100;
    private static ServerSocket serverSocket = null;

    Server() throws IOException {

        try {

            serverSocket = new ServerSocket(PORT);

            while (true) {

                if(!serverSocket.isClosed()) {

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
        serverSocket.close();
    }


    public static void main(String[] args) throws IOException {

        Server server = new Server();

    }
}
