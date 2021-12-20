package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length < 1) { throw new IllegalArgumentException("Please enter a port number !"); }
        else {
           if(Integer.valueOf(args[0]) <= 0) { throw new IllegalArgumentException("Please enter a positive port number !"); }
           if(args.length == 1) {
                serverHttp serv = new serverHttp(Integer.valueOf(args[0]));
                serv.Create(Integer.valueOf(args[0]));
           }
           if(args.length == 2) {
                PostRequest cl1 = new PostRequest(Integer.valueOf(args[0]));
                cl1.send(args[1]);
                cl1.sendFireRequest(args[1], "A10");
           }
           //if(args.length == 3) {
              //  PostRequest cl2 = new PostRequest(Integer.valueOf(args[0]));
               // cl2.send(args[1]);
               // cl2.sendFireRequest(args[1], "A6");
          // }
        }
    }
}