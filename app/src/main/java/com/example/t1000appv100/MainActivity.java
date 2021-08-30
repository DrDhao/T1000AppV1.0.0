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
import fragments.PageFragment5;

public class MainActivity extends AppCompatActivity {


    private static MainActivity instance;
    private static final String TAG = "Motor Data Ausgabe";
    private int motorCount = 24;
    private byte[] currentMotorData = new byte[motorCount];

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private NetworkTasker networkTasker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        resetMotorData();

        setContentView(R.layout.activity_main);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment4());
        list.add(new PageFragment5());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                SlidePagerAdapter.getInstance().stopOtherFragments(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        networkTasker = new NetworkTasker();
        new MassageProgramHandler();
    }

    private void sendMotordata() {
        networkTasker.sendPostRequest(buildMotorDataOutputString(currentMotorData));
    }

    private String buildMotorDataOutputString(byte[] newMotorData) { //builds 0 String when newMotorData equals null
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

    public void setMotorData(byte[] array) { //reset to -128 with array = null
        if(array == null){
            resetMotorData();
        }else{
            currentMotorData = array;
        }
        sendMotordata();
    }

    private void resetMotorData() {
        for (byte i = 0; i < currentMotorData.length; i++) {
        currentMotorData[i] = -128;
        }
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

