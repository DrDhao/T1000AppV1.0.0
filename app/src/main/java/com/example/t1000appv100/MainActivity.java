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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Motor Data Ausgabe";
    private byte[] motorData= {-128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128};

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
    }


    public void setMotorData(byte motorNum, byte intensity){
        motorData[motorNum] = intensity;
        Log.i(TAG, "setMotorData: " + motorNum + " = " + intensity);
    }

    public byte getMotorData(byte motorNum) {
        return motorData[motorNum];
    }

}

