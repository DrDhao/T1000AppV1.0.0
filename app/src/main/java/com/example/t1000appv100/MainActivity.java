package com.example.t1000appv100;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;


import java.util.ArrayList;
import java.util.List;

import fragments.PageFragment1;
import fragments.PageFragment2;
import fragments.PageFragment3;
import fragments.PageFragment4;

public class MainActivity extends AppCompatActivity {


    private static MainActivity instance;
    private static final String TAG = "Motor Data Ausgabe";
    private int motorCount = 24;
    private byte[] currentMotorData = new byte[motorCount];

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private NetworkTasker networkTasker;
    MassageProgramHandler massageProgramHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        for (byte i = 0; i < currentMotorData.length; i++) {
            currentMotorData[i] = -128;
        }

        setContentView(R.layout.activity_main);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment4());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

        networkTasker = new NetworkTasker();
        massageProgramHandler = new MassageProgramHandler();
    }

    private void sendMotordata() {
        networkTasker.sendPostRequest(buildMotorDataOutputString(currentMotorData));
    }

    private String buildMotorDataOutputString(byte[] newMotorData) { //builds 0 String when newMotorData equals null
        if (newMotorData == null) {
            newMotorData = new byte[getMotorCount()];
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < newMotorData.length - 1; i++) {
            s.append(newMotorData[i]);
            s.append("S");
        }
        s.append(newMotorData[newMotorData.length - 1]);
        return s.toString();
    }

    //GETTER UND SETTER

    public int getMotorCount() {
        return motorCount;
    }

    public void setMotorData(byte[] array) { //reset to 0 with array = null
        currentMotorData = array;
        sendMotordata();
    }

    public void setMotorValue(byte motorNum, byte intensity) {
        currentMotorData[motorNum] = intensity;
        //Log.i(TAG, "setMotorData: " + motorNum + " = " + intensity);
        sendMotordata();
    }

    public byte getMotorValue(byte motorNum) {
        return currentMotorData[motorNum];
    }

    public static MainActivity getInstance() {
        return instance;
    }


}

