package com.example.tcp.server;

/**
 * Handle the thread.
 */
public class ThreadHandler extends Thread {

    /**
     * Holds the string value.
     */
    private String textToPrint;

    /**
     * Constructor accepts and set string value passed from client.
     * @param textInputed string value inserted.
     */
    public ThreadHandler(final String textInputed) {
        this.textToPrint = textInputed;
    }

    @Override
    public synchronized void run() {
        System.out.print("Executing Thread \t" + "Input\t:\t");
        System.out.println(this.textToPrint + "\n");
    }
}
