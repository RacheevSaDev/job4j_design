package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String strFirst = in.readLine();
                    for (String str = strFirst; str != null && !str.isEmpty();
                         str = in.readLine()) {

                        System.out.println(str);
                    }
                    if ("/?msg=Exit".equals(strFirst.split(" ")[1])) {
                        break;
                    }
                    if ("/?msg=Hello".equals(strFirst.split(" ")[1])) {
                        out.write("Hello, dear friend.".getBytes());
                    } else {
                        out.write("What".getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}