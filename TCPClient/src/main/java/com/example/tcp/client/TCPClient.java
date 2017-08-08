package com.example.tcp.client;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Client Class sends request to server.
 */

public class TCPClient {

    /**
     *
     * @param args command line arguments.
     *      args[0] : port number server listing to.
     *      args[1] : Text sends to process in server
     * @throws Exception when server could not find
     */
    public static void main(String[] args) throws Exception {
        int portNumber = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 4444;
        String textToSend = (args.length > 1 && args[1] != null) ? args[0] : "Hellow Server......!"; ;
        Socket socket = new Socket("localhost", portNumber);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(textToSend);
        dataOutputStream.flush();
        dataOutputStream.close();
        socket.close();
    }
}
