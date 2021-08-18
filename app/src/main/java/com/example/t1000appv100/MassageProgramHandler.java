package com.example.t1000appv100;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MassageProgramHandler extends Fragment {

    MainActivity main = new MainActivity();
    byte[] motorData = new byte[24];
    private volatile boolean stopMassage = false;


    public void startMassage(byte massageNumber) {

        switch (massageNumber){
            case 0:{
                stopMassage = false;
                MassageRunnable1 massageRunnable = new MassageRunnable1();

            }
            case 1:{
                stopMassage = false;
                MassageRunnable2 massageRunnable = new MassageRunnable2();
            }
            case 2:{
                stopMassage = false;
                MassageRunnable3 massageRunnable = new MassageRunnable3();
            }
        }

        /*
        MassageThread massageThread = new MassageThread(massageNumber);
        massageThread.start();
        */
    }

    public void stopMassage() {
        stopMassage = true;
    }

/*
    class MassageThread extends Thread {

        byte massageNumber;

        MassageThread(byte massageNumber) {
            this.massageNumber = massageNumber;
        }

        @Override
        public void run() {
            for (byte i = -128; i < 127; i++) {
                if (stopMassageThread) return;
                Log.i("Thread run", "is running, massage program: " + massageNumber);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
*/

    class MassageRunnable1 implements Runnable {
        @Override
        public void run() {
            for (byte i = -128; i < 127; i++) {
                if (stopMassage) return;
                Log.i("Thread run", "is running, massage program: 1");

                main.setMotorData((byte) 1, i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MassageRunnable2 implements Runnable {
        @Override
        public void run() {
            for (byte i = -128; i < 127; i++) {
                if (stopMassage) return;
                Log.i("Thread run", "is running, massage program: 2");

                main.setMotorData((byte) 2, i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MassageRunnable3 implements Runnable {
        @Override
        public void run() {
            for (byte i = -128; i < 127; i++) {
                if (stopMassage) return;
                Log.i("Thread run", "is running, massage program: 3");

                main.setMotorData((byte) 3, i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



