package com.example.t1000appv100;

public abstract class MassageProgram {
    protected MassageProgramHandler handler;

    public MassageProgram(MassageProgramHandler handler){
        this.handler = handler;
    }

    public abstract byte[] nextStep();
}

 class WaveMassage extends MassageProgram{

     private final byte[][] valueTable;
     private int columnCounter;
     private final int numberOfColumns = 1920;

     public WaveMassage(MassageProgramHandler handler) {
         super(handler);
         byte bigIncrement;
         byte littleIncrement;

         valueTable = new byte[handler.getMotorCount()][numberOfColumns];
         for (int i = 0; i < handler.getMotorCount(); i++) {
             for (int j = 0; j < numberOfColumns; j++) { //TODO füllen von 2d array

             }
         }
     }

     @Override
    public byte[] nextStep() {
         byte[] column = new byte[super.handler.getMotorCount()];
         for (int i = 0; i < super.handler.getMotorCount(); i++) {
             column[i] = valueTable[i][columnCounter];
         }
         if (columnCounter<numberOfColumns){
             columnCounter++;
         } else {
             resetColumnCounter();
         }
         return column;
    }
     public void resetColumnCounter(){
         columnCounter = 0;
     }
}

class FullPowerMassage extends MassageProgram{

    private final byte[][] valueTable;
    private int columnCounter;
    private final int numberOfColumns = 1920;

    public FullPowerMassage(MassageProgramHandler handler) {
        super(handler);
        byte bigIncrement = 127;

        valueTable = new byte[handler.getMotorCount()][numberOfColumns];
        for (int i = 0; i < handler.getMotorCount(); i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                valueTable[i][j] = bigIncrement;
            }
        }
        columnCounter = 0;
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = valueTable[i][columnCounter];
        }
        if (columnCounter<numberOfColumns){
            columnCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }

    public void resetColumnCounter(){
        columnCounter = 0;
    }
}
