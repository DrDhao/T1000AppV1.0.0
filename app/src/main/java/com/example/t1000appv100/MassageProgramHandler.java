package com.example.t1000appv100;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MassageProgramHandler{

    private static MassageProgramHandler instance;
    private final MainActivity main;
    private int timestepInMs = 200;
    private byte selectedProgramNum = -1; //Programs start at num 0

    private final ArrayList<MassageProgram> massagePrograms = new ArrayList<>();
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public MassageProgramHandler() {
        instance = this;
        main = MainActivity.getInstance();
        massagePrograms.add(new EverySingleMotorMassage(this, 180));
        massagePrograms.add(new FullPowerMassage(this, 180));
        massagePrograms.add(new testMassage(this));
        massagePrograms.add(new TwoThirdsPowerMassage(this, 180));
        massagePrograms.add(new FullPowerMassageOnlySmall(this, 180));

        massagePrograms.add(new WaveMassage(this, 180));
        massagePrograms.add(new BackCircleMassage(this, 180));


    }

    public static MassageProgramHandler getInstance() {
        return instance;
    }

    public void startMassage(int massageNumber) {
        if(selectedProgramNum == massageNumber){
            stop();
            return;
        }
        if(selectedProgramNum >= 0){
            stop();
        }

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        selectedProgramNum = (byte) massageNumber;
        massagePrograms.get(selectedProgramNum).getReady();
        Runnable next = () -> main.setMotorData(massagePrograms.get(selectedProgramNum).nextStep());
        scheduledExecutorService.scheduleAtFixedRate(next, 0, getTimestepInMs(), TimeUnit.MILLISECONDS);
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
        int TIMESTEP_MIN = 100;
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



