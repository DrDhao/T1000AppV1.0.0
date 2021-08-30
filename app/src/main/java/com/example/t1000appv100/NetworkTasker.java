package com.example.t1000appv100;

import com.android.volley.*;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NetworkTasker {
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
    private final String postUrl;
    private final Object tag = "ja";



    public NetworkTasker() {
        String serverIp = "192.168.4.1:8080";
        postUrl = "http://" + serverIp + "/motorData";
    }


    public void sendPostRequest(String message) {
        executor.execute(()->{
            try {
                JSONObject postData = new JSONObject();
                postData.put("motorData", message);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, System.out::println, Throwable::printStackTrace);
                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                        0,
                        0,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                ));
                jsonObjectRequest.setTag(tag);
                synchronized (this){
                    //RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.getInstance().getApplicationContext());
                    MainActivity.getInstance().sendToVolley(jsonObjectRequest);

                    //requestQueue.add(jsonObjectRequest);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    VolleyInternetOperator.getInstance().getRequestQueue().cancelAll(tag);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        });



    }

}
