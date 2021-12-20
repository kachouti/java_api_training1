package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStream;

public class FireHandler implements HttpHandler {
    String verbe = " Not Found ";
    int resp = 202;
  

    public void handle(HttpExchange exchange) throws IOException {
         if(exchange.getRequestMethod().equals("GET")) { resp = 404; }
        else {
            String vars = exchange.getRequestURI().getQuery();
            String cell = vars.split("=")[1];
            
            verbe = reponse(exchange);
        }
        exchange.sendResponseHeaders(resp, verbe.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(verbe.getBytes());
        }
    }

    public String reponse(HttpExchange exchange) {
        JSONObject jsonPar = new JSONObject();
        jsonPar.put("par1", "sunk");//consequence
        jsonPar.put("par2", "true");//isshipLeft!
        return jsonPar.toString();
    }

     public String getVerbe() {
        return verbe;
    }

    public int getResp() {
        return resp;
    }
    
}







