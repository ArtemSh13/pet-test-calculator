package com.calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port = 8080;
    private ServerSocket server;

    public Server(int port) throws IOException {
        this.port = port;
        this.server = new ServerSocket(this.port);
    }

    public void runServer() throws Exception {
        Socket client;
        DataOutputStream outputStream;
        DataInputStream inputStream;
        client = this.server.accept();
        outputStream = new DataOutputStream(client.getOutputStream());
        inputStream = new DataInputStream(client.getInputStream());
        while (!client.isClosed()) {
            String entry = inputStream.readUTF();
            if (entry.equalsIgnoreCase("quit")) {
                System.out.println("Client initialize connections suicide ...");
                outputStream.writeUTF("Server reply - " + entry + " - OK");
                outputStream.flush();
                Thread.sleep(3000);
                break;
            }
            outputStream.writeUTF("The expression result is " + getExpressionResult(entry));
            outputStream.flush();
        }
        inputStream.close();
        outputStream.close();
        client.close();
    }

    public static double getExpressionResult(String expression) throws Exception {
        Calculator calculator = new Calculator();
        String delimiter = " ";
        String[] tokens = expression.split(delimiter);
        double result = 0.0;
        switch (tokens[1]) {
            case "+": result = calculator.getSum(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "-": result = calculator.getDifference(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "*": result = calculator.getProduct(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
            case "/": result = calculator.getQuotient(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[2]));
                break;
        }
        return result;
    }
}
