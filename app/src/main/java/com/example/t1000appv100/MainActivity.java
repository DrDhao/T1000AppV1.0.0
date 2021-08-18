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
    private int motorCount = 24;
    private byte[] motorData = new byte[motorCount];

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        for(byte i = 0; i < motorData.length; i++){
            motorData[i] = -128;
        }

        setContentView(R.layout.activity_main);
        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);
    }

    public void setMotorData(byte motorNum, byte intensity){ //TODO Namen ändern? eher setMotorValue und nicht die ganze MotorData
        motorData[motorNum] = intensity;
        Log.i(TAG, "setMotorData: " + motorNum + " = " + intensity);
    }

    public byte getMotorData(byte motorNum) { //TODO eher getMotorValue?
        return motorData[motorNum];
    }

    private String buildMotorDataOutputString() {
        byte[] tempMotorData = new byte[motorCount];            //TODO provisorisch! Sinn fehlt
        for (int i = 0; i < tempMotorData.length; i++) {
            tempMotorData[i] = (byte) i;
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tempMotorData.length-1; i++) {
            s.append(tempMotorData[i]);
            s.append("S");
        }
        s.append(tempMotorData[tempMotorData.length-1]);
        return s.toString();
    }

}

