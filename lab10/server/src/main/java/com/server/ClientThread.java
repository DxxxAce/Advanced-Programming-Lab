package com.server;

import com.commands.Command;
import com.social.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread{

    private final Socket socket;

    public ClientThread(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            socket.setSoTimeout(50_000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (request != null) {

                if (request.equals("exit")) {

                    break;
                }

                if (request.equals("stop")) {

                    out.println("Server stopped.");
                    out.flush();
                    Server.stop();
                }
                else
                {
                    String response = "Wrong command.";
                    String[] splitRequest = request.split("\\s+");
                    String command = splitRequest[0];

                    if (command.equals("register") && splitRequest.length > 1) {

                        String name = splitRequest[1];
                        Command.register(name);
                        response = "Registered successfully.";

                    }
                    else if (command.equals("login") && splitRequest.length>1) {

                        String name = splitRequest[1];

                        if (Command.login(name, this.socket)) {

                            response = "Logged in successfully.";
                        }
                        else {

                            response = "Login failed.";
                        }
                    }
                    else if (command.equals("friend") && splitRequest.length > 1) {

                        List<String> friends= new ArrayList<>();

                        for (int i = 1; i < splitRequest.length; i++) {

                            friends.add(splitRequest[i]);
                        }

                        if (Command.friend(Network.getNameBySocket(this.socket), friends)) {

                            response = "Friend(s) added successfully.";
                        }
                        else {

                            response = "You need to login first!";
                        }
                    }
                    else if (command.equals("send") && splitRequest.length > 1) {

                        StringBuilder sb = new StringBuilder();

                        for (int i = 1; i < splitRequest.length; i++) {

                            sb.append(splitRequest[i]);
                            sb.append(' ');
                        }

                        if (Command.sendMessage(Network.getNameBySocket(this.socket), sb.toString())) {

                            response = "Message sent successfully.";
                        }
                        else {

                            response = "You need to login first!";
                        }
                    }
                    else if (command.equals("read")) {

                        List<String> messages=Command.read(Network.getNameBySocket(this.socket));

                        if(messages != null) {

                            StringBuilder sb= new StringBuilder();
                            sb.append("Your messages are: ");
                            System.out.println(messages);

                            for (String message : messages) {

                                sb.append(message);
                                sb.append("; ");
                            }

                            response = sb.toString();
                        }
                        else {

                            response = "You need to login first!";
                        }
                    }

                    out.println(response);
                    out.flush();
                }

                request = in.readLine();
            }
        }
        catch (SocketTimeoutException e)
        {

            try {

                System.err.println("Communication error... " + e);
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                out.println("Time out");
                out.flush();
            }
            catch (IOException ex) {

                ex.printStackTrace();
            }
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        finally {

            try {

                socket.close();
            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}
