package com.example.t1000appv100;

import java.util.ArrayList;

public class MassageProgramHandler{

    private final MainActivity main;
    private final int TIMESTEP_MIN = 100;
    private int timestepInMs = 200;
    private boolean massageRunning = false;
    private ArrayList<MassageProgram> massagePrograms;

    public MassageProgramHandler(MainActivity main) {
        massagePrograms.add(new EverySingleMotorMassage(this));
        this.main = main;
    }

    public void startMassage(byte massageNumber) {

        massageRunning = true;
    }

    public void stop(){
        massageRunning = false;
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



