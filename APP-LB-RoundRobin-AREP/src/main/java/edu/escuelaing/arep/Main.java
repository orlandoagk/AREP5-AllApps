package edu.escuelaing.arep;

import edu.escuelaing.arep.components.LoadBalancer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        port(getPort());
        LoadBalancer loadBalancer = new LoadBalancer();
        get("/",(req,res)->{
            List<JSONObject> array = null;
            try {
                array = loadBalancer.getMessage();

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            return inputDataPage(array);
        });
        post("/sendMessage",(req,res)->{
            List<JSONObject> array = null;
            try {
                if(req.body().equals("message=")){
                    array = loadBalancer.putMessage(" ");
                } else {
                    array = loadBalancer.putMessage(URLDecoder.decode(req.body().split("=")[1], StandardCharsets.UTF_8.name()));
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            return inputDataPage(array);
        });
    }

    /**
     * This function returns the HTML structure to present the input data
     * @param array A list with the messages that you receive
     * @return A String that have a template of a HTML
     */
    private static String inputDataPage(List<JSONObject> array) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<head><meta charset=\"ISO-8859-1\"> </head>"
                + "<body>"
                + "<h2>Orlando's Chat</h2>"
                + "<form action=\"/sendMessage\" method=\"POST\">"
                + "  Message:<br>"
                + "  <input type=\"text\" name=\"message\" value=\"\">"
                + "<br/>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>";

        for(int i = 0;i<array.size();i++){
            pageContent+= "<p>"+array.get(i).get("dateHuman") +" - "+array.get(i).get("message")+"</p>";
        }

        pageContent+="</body>"
                + "</html>";
        return pageContent;
    }
    private static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
