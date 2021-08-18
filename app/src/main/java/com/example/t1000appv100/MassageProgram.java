package com.example.t1000appv100;

public abstract class MassageProgram {
    private MassageProgramHandler handler;

    public MassageProgram(MassageProgramHandler handler){
        this.handler = handler;
    }

    public abstract byte[] nextStep();
}

 class WaveMassage extends MassageProgram{

     public WaveMassage(MassageProgramHandler handler) {
         super(handler);
     }

     @Override
    public byte[] nextStep() {


         return new byte[0];
    }
}

class FullPowerMassage extends MassageProgram{

    public FullPowerMassage(MassageProgramHandler handler) {
        super(handler);
    }

    @Override
    public byte[] nextStep() {
        return new byte[0];
    }
}
