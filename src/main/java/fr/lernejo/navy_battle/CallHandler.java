package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class CallHandler implements HttpHandler {
    private final String body = "OK";
    private final int code_test = 200;

    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(code_test, body.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }
    public String getBody() {
        return body;
    }
     public int getCode_test() {
        return code_test;
    }

    
}
