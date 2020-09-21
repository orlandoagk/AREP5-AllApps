package edu.escuelaing.arep.components;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class ApiConnect {

    public static String getMessage(String server){
        HttpResponse<String> response = null;
        try {
            response = Unirest.get(server+"/getMessages")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public static String putMessage(String server,String message){
        HttpResponse<String> response = null;

        JSONObject messageJSON = new JSONObject();
        messageJSON.put("message",message);
        try {
            response = Unirest.post(server+"/putMessage").body(messageJSON).asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();

    }
}
