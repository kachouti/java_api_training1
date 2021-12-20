package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class serverHttp {
    private final int myPort;

    public serverHttp(int myPort) {
        this.myPort = myPort;
    }

    public void Create(int myPort) throws IOException {



         HttpServer srv = HttpServer.create(new InetSocketAddress(myPort), 0);//utiliser com.sun.net.httpserver.HttpServer#create
        srv.setExecutor(Executors.newFixedThreadPool(1));//utiliser com.sun.net.httpserver.HttpServer#create
        srv.createContext("/ping", new CallHandler());//Utiliser la méthode createContext pour associer au chemin /ping une implémentation de CallHandler qui renverra une trame HTTP de statut OK (200) et de corps OK
    srv.createContext("/api/game/start", new PostHandler());
            srv.createContext("/api/game/fire", new FireHandler());

       // srv.createContext("/api/game/start", new PostHandler());//Ajouter un contexte pour le chemin /api/game/start qui répondra au verbe POST
        srv.start();

       

    }

   
}
