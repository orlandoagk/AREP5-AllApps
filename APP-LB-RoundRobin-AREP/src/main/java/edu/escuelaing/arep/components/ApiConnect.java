package edu.escuelaing.arep.components;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.net.*;

public class ApiConnect {

    public static String getMessage(String server){
        HttpResponse<String> response = null;
        System.out.println(server+" Server");
        try {

            response = Unirest.get("http://"+server+"/getMessages")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    public static String putMessage(String server,String message) {
        HttpResponse<String> response = null;
        System.out.println(server+" Server");
        JSONObject messageJSON = new JSONObject();
        messageJSON.put("message",message);
        try {
            response = Unirest.post("http://"+server+"/putMessage").body(messageJSON).asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();

    }
}
