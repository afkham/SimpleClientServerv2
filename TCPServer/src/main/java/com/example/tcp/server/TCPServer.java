package com.example.tcp.server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * implimentation of TCP Server.
 */
public class TCPServer {
    /**
     * Executor Service creates Thread pool executor.
     */
    private static ExecutorService executorService;

    /**
     * Main methord starting the server.
     * @param args command line arguments.
     *   arg[0] - Port server listing.
     *   arg[1] - Minimum thread count in thread pool.
     *   arg[2] - Maximum thread count in thread pool.
     *   arg[3] - Maximum time to alive for thread.
     * @throws Exception when fails to start server.
     */
    public static void main(String[] args) throws Exception {

        int portNumber = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 4444;
        int minThreadCount = (args.length > 1 && args[0] != null) ? Integer.parseInt(args[1]) : 20;
        int maxThreadCount = (args.length > 2 && args[0] != null) ? Integer.parseInt(args[2]) : 50;
        int maxTimeAlive = (args.length > 3 && args[0] != null) ? Integer.parseInt(args[3]) : 30;

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue(minThreadCount);
        executorService = new ThreadPoolExecutor(minThreadCount, maxThreadCount, maxTimeAlive, TimeUnit.SECONDS, blockingQueue);
        System.out.println("------------------------- Server Started -------------------------");
        System.out.println("Listening to port : " + portNumber);

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String stringReader = (String) dataInputStream.readUTF();
            System.out.println("Input Received");
            executorService.execute(new ThreadHandler(stringReader));
        }
    }
}
