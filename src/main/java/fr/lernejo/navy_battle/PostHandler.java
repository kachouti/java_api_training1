package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.*;

public class PostHandler implements HttpHandler  {
     String verbe = "Not Found ";
    int response = 202;
    
            

    public void handle(HttpExchange exchange) throws IOException {
        if(exchange.getRequestMethod().equals("POST"))
          { response = 404; }
        else {
            InputStreamReader req =  new InputStreamReader(exchange.getRequestBody());
            if(validateJson(req)) { verbe = Reponse(exchange); }
            else {
                response = 400;
                verbe = "Bad request";
            }
        }
        //exchange.sendResponseHeaders(response, body.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(verbe.getBytes());
        }
    }
//ValidationSchema
    public boolean validateJson(InputStreamReader req) throws IOException {
        BufferedReader br = new BufferedReader(req);
        String sch = br.readLine();
        br.close();

        JSONObject ObjSchema  = new JSONObject(sch);
        if (ObjSchema .has("id") && ObjSchema .has("url") && ObjSchema .has("message")) {
                return true;
        }
        return false;
    }



    //il est attendu qu’une telle requête ait un corps respectant le schema suivant 


    public String Reponse(HttpExchange exchange) {
        JSONObject json = new JSONObject();
                int myPort = exchange.getHttpContext().getServer().getAddress().getPort();

        json.put("id", "1");
        json.put("url", "http://localhost:" + myPort);
        json.put("message", "I will crush you !");
        return json.toString();
    }

}
