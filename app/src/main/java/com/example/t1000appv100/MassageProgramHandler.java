package com.example.t1000appv100;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MassageProgramHandler{

    private static MassageProgramHandler instance;
    private MainActivity main;
    private final int TIMESTEP_MIN = 100;
    private int timestepInMs = 200;
    private byte selectedProgramNum = -1; //Programs start at num 0

    private ArrayList<MassageProgram> massagePrograms = new ArrayList<>();
    private ScheduledExecutorService scheduledExecutorService;

    public MassageProgramHandler() {
        instance = this;
        main = MainActivity.getInstance();
        massagePrograms.add(new EverySingleMotorMassage(this, 255));
        massagePrograms.add(new TwoThirdsPowerMassage(this, 255));
        massagePrograms.add(new testMassage(this));
        massagePrograms.add(new WaveMassage(this, 255));
        massagePrograms.add(new BackCircleMassage(this, 255));
        massagePrograms.add(new TwoThirdsPowerMassage(this, 255));
        massagePrograms.add(new FullPowerMassageOnlySmall(this, 255));

        //Nicht gelistet in Fragment2
        massagePrograms.add(new BreathInandOutMassage(this));
    }

    public static MassageProgramHandler getInstance() {
        return instance;
    }

    public boolean startMassage(int massageNumber) {
        if(selectedProgramNum == massageNumber){
            stop();
            return true;
        }
        if(selectedProgramNum >= 0){
            stop();
        }

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        selectedProgramNum = (byte) massageNumber;
        massagePrograms.get(selectedProgramNum).getReady();
        Runnable next = () -> main.setMotorData(massagePrograms.get(selectedProgramNum).nextStep());
        scheduledExecutorService.scheduleAtFixedRate(next, 0, getTimestepInMs(), TimeUnit.MILLISECONDS);
        return true;
    }

    public void stop(){
        if(scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            scheduledExecutorService = null;
        }
        main.setMotorData(null);
        selectedProgramNum = -1;
        //alles auf null setzen
    }


    //GETTER UND SETTER
    public int getTimestepInMs() {
        return timestepInMs;
    }

    public boolean setTimestepInMs(int timestepInMs) {
        if(timestepInMs < TIMESTEP_MIN)  {
            return false;
        }else{
            this.timestepInMs = timestepInMs;
            return true;
        }
    }

    protected int getMotorCount(){
        return main.getMotorCount();
    }
}



