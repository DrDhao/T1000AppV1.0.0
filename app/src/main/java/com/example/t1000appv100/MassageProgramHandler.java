package com.example.t1000appv100;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MassageProgramHandler{

    private MainActivity main;
    private final int TIMESTEP_MIN = 100;
    private int timestepInMs = 200;
    private byte selectedProgramNum = -1; //Programs start at num 0

    private ArrayList<MassageProgram> massagePrograms = new ArrayList<>();
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public MassageProgramHandler() {
        main = MainActivity.getInstance();
        massagePrograms.add(new EverySingleMotorMassage(this, 12));
        //PROGRAMME ADDEN
    }

    public boolean startMassage(byte massageNumber) {
        if(selectedProgramNum >= 0){return false;}

        selectedProgramNum = massageNumber;
        Runnable next = () -> main.setMotorData(massagePrograms.get(selectedProgramNum).nextStep());
        scheduledExecutorService.scheduleAtFixedRate(next, 0, getTimestepInMs(), TimeUnit.MILLISECONDS);
        return true;
    }

    public void stop(){
        scheduledExecutorService.shutdownNow();
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



