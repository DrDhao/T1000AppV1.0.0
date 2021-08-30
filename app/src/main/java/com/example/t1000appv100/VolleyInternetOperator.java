package com.example.t1000appv100;
import android.content.Context;

import com.android.volley.*;
import com.android.volley.toolbox.Volley;

public class VolleyInternetOperator
{
    private static VolleyInternetOperator mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private VolleyInternetOperator(Context context)
    {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyInternetOperator getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyInternetOperator(context);
        }
        return mInstance;
    }


    public static synchronized VolleyInternetOperator getInstance()
    {
        if (null == mInstance)
        {
            throw new IllegalStateException(VolleyInternetOperator.class.getSimpleName() +
                    " is not initialized, call getInstance(...) first");
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx);
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }



}