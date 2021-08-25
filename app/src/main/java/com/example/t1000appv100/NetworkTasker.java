package com.example.t1000appv100;

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
    private final String serverIp = "192.168.4.1:8080";
    private final MainActivity main;
    private final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
    private final String postUrl;

    public NetworkTasker() {
        this.main = MainActivity.getInstance();
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

                RequestQueue requestQueue = Volley.newRequestQueue(main.getApplicationContext());
                requestQueue.add(jsonObjectRequest);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }
}
