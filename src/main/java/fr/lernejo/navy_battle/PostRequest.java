package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest {
    private final int myPort;

    public PostRequest(int myPort) { this.myPort = myPort; }

       public void sendFireRequest(String adversaryUrl, String cell) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requestGet = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/fire?cell="+cell)).GET().build();

        HttpResponse<String> resp = client.send(requestGet, HttpResponse.BodyHandlers.ofString());
        
    }

    public void send(String adversaryUrl) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requestPost = HttpRequest.newBuilder()
            .uri(URI.create(adversaryUrl + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"2\", \"url\":\"http://localhost:" + this.myPort + "\", \"message\":\"client\"}"))
            .build();

        HttpResponse<String> resp = client.send(requestPost, HttpResponse.BodyHandlers.ofString());
        
    }

    public int getMyPort() {
        return myPort;
    }
    
    
}