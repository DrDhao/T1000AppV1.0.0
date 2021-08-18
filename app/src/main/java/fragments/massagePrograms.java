package fragments;

import android.support.v4.app.Fragment;

import com.example.t1000appv100.MainActivity;

public class massagePrograms extends Fragment {

    MainActivity main = new MainActivity();
    byte[] motorData = new byte[24];
    private volatile boolean stopMassageThread = false;

    MassageThread massageThread = new MassageThread();

    public void startMassage(){
        massageThread.start();



    }
    public void stopMassage(){
        stopMassageThread = true;
    }


        class MassageThread extends Thread{
        @Override
            public void run() {

                for(byte i = -128; i < 126; i++){
                    if(stopMassageThread) return;

                    motorData[1] = (byte) (motorData[1] + 1);
                    main.setMotorData((byte) 1, motorData[1]);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}

