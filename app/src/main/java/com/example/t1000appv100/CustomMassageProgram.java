package com.example.t1000appv100;

import android.util.Log;

import javax.security.auth.login.LoginException;


public class CustomMassageProgram {


    int activeProgram_m = -1;
    boolean[][] zone_m = new boolean[3][10];
    int[] type_m = {-1, -1, -1}; //0 Durchgehend an, 1 An Aus Abwechselnd, 2 Langsam hoch und wieder runter
    int[] speed_m = {-1, -1, -1};
    int[] intensity_m = {-1, -1, -1};
    int[] time_m = {-1, -1, -1};
    public boolean stopMassage = false;


    public void setActiveProgram(int activeProgram) {
        activeProgram_m = activeProgram;
    }


    public int getActiveProgram() {
        return activeProgram_m;
    }

    public void setZone(int zone, boolean zoneValue) {
        zone_m[activeProgram_m][zone] = zoneValue;
    }

    public boolean getZone(int zone) {
        return zone_m[activeProgram_m][zone];
    }

    public void setType(int type) {
        type_m[activeProgram_m] = type;
    }

    public int getType() {
        return type_m[activeProgram_m];
    }

    public void setSpeed(int speed) {
        speed_m[activeProgram_m] = speed;
    }

    public void setIntensity(int intensity) {
        intensity_m[activeProgram_m] = intensity;
    }

    public void setTime(int time) {
        time_m[activeProgram_m] = time;
    }

    public void startProgram(boolean startProgram) {
        if (startProgram) {
            stopMassage = false;
            MassageRunThread massageRunThread = new MassageRunThread();
            massageRunThread.start();
        } else stopMassage = true;
    }

    class MassageRunThread extends Thread {
        @Override
        public void run() {


            while (true) {

                if (stopMassage) return;

                Log.i("Massage run test", "RUNNING");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
