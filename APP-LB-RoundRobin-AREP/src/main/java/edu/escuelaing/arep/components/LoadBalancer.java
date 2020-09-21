package edu.escuelaing.arep.components;


import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private String[] urls;
    private int iUrls;

    public LoadBalancer(){
        if(System.getenv("Environment")!=null) {
            urls = new String[]{"arep5-allapps_logservice_1", "arep5-allapps_logservice_2", "arep5-allapps_logservice_3"};
        } else {
            urls = new String[]{"54.81.77.178:2000", "54.81.77.178:2001", "54.81.77.178:2002"};
        }
        iUrls = 0;
    }

    public List<JSONObject> returnList(JSONArray array){
        List<JSONObject> valueToReturn = new ArrayList<>();
        for(int i=0;i<array.length();i++){
            valueToReturn.add(new JSONObject(array.get(i).toString()));
        }

        return valueToReturn;
    }



    public List<JSONObject> putMessage(String message) throws UnknownHostException {

        List<JSONObject> array = returnList(new JSONArray(ApiConnect.putMessage(urls[iUrls],message)));
        if(iUrls==urls.length-1){
            iUrls=0;
        } else {
            iUrls++;
        }
        return array;
    }

    public List<JSONObject> getMessage() throws URISyntaxException, UnknownHostException {

        List<JSONObject> array = returnList(new JSONArray(ApiConnect.getMessage(urls[iUrls])));
        if(iUrls==urls.length-1){
            iUrls=0;
        } else {
            iUrls++;
        }
        return array;
    }


}
