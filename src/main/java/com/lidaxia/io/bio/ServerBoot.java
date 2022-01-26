package com.lidaxia.io.bio;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/26 16:18（
 */
public class ServerBoot {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }

}
