package com.example.t1000appv100;

import java.util.Arrays;

import fragments.PageFragment5;

public abstract class MassageProgram {
    protected MassageProgramHandler handler;

    public MassageProgram(MassageProgramHandler handler) {
        this.handler = handler;
    }

    public abstract byte[] nextStep();
}

class WaveMassage extends MassageProgram {

    private final int[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public WaveMassage(MassageProgramHandler handler, int SizeOfBigIntensity) {
        super(handler);
        int bigIntensity = SizeOfBigIntensity;
        double littleFactor = 0.5;
        double mediumFactor = 0.75;
        int risingLittleIntensity = (int) (littleFactor * bigIntensity);
        int fallingLittleIntensity = (int) (littleFactor * bigIntensity);
        int risingMediumIntensity = (int) (mediumFactor * bigIntensity);
        int fallingMediumIntensity = (int) (mediumFactor * bigIntensity);
        boolean changeIntensity = false;

        valueTable = new int[handler.getMotorCount()][numberOfColumns];
        int numberOfGroups = 11;
        int[] groupIntensity = new int[numberOfGroups];
        for (int j = 0; j < numberOfColumns; j++) {
            if (j == 0) {
                groupIntensity[0] = bigIntensity;
            }
            for (int i = 0; i < handler.getMotorCount(); i++) {
                if (changeIntensity && groupIntensity[i] == fallingLittleIntensity) {
                    if (i==10){
                        groupIntensity[i] = 0;
                        groupIntensity[0] = bigIntensity;
                    } else {
                        groupIntensity[i] = 0;
                        groupIntensity[i + 1] = bigIntensity;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == fallingMediumIntensity) {
                    if (i==10){
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[0] = risingMediumIntensity;
                    } else {
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[i + 1] = risingMediumIntensity;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == bigIntensity) {
                    if (i==10){
                        groupIntensity[i] = fallingMediumIntensity;
                        groupIntensity[0] = risingLittleIntensity;
                    } else {
                        groupIntensity[i] = fallingMediumIntensity;
                        groupIntensity[i + 1] = risingLittleIntensity;
                    }
                    changeIntensity = false;
                }

            }
            valueTable[23][j] = groupIntensity[0];
            valueTable[22][j] = groupIntensity[0];

            valueTable[21][j] = groupIntensity[1];
            valueTable[7][j] = groupIntensity[1];
            valueTable[20][j] = groupIntensity[1];

            valueTable[19][j] = groupIntensity[2];
            valueTable[18][j] = groupIntensity[2];

            valueTable[17][j] = groupIntensity[3];
            valueTable[6][j] = groupIntensity[3];
            valueTable[16][j] = groupIntensity[3];

            valueTable[15][j] = groupIntensity[4];
            valueTable[14][j] = groupIntensity[4];

            valueTable[13][j] = groupIntensity[5];
            valueTable[12][j] = groupIntensity[5];

            valueTable[11][j] = groupIntensity[6];
            valueTable[10][j] = groupIntensity[6];

            valueTable[9][j] = groupIntensity[7];
            valueTable[8][j] = groupIntensity[7];

            valueTable[5][j] = groupIntensity[8];
            valueTable[4][j] = groupIntensity[8];

            valueTable[3][j] = groupIntensity[9];
            valueTable[2][j] = groupIntensity[9];

            valueTable[1][j] = groupIntensity[10];
            valueTable[0][j] = groupIntensity[10];
            if ((j+1) % 40 == 0){
                changeIntensity = true;
            }
        }
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) ((valueTable[i][columnCounter])-128);
        }
        if (columnCounter < numberOfColumns) {
            columnCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }

    public void resetColumnCounter() {
        columnCounter = 0;
    }
}

class FullPowerMassage extends MassageProgram {

    private final int[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public FullPowerMassage(MassageProgramHandler handler, int SizeOfBigIntensity) {
        super(handler);
        int bigIntensity = SizeOfBigIntensity;

        valueTable = new int[handler.getMotorCount()][numberOfColumns];
        for (int i = 0; i < handler.getMotorCount(); i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                valueTable[i][j] = bigIntensity;
            }
        }
        columnCounter = 0;
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) (valueTable[i][columnCounter]-128);
        }
        if (columnCounter < numberOfColumns) {
            columnCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }

    public void resetColumnCounter() {
        columnCounter = 0;
    }
}

class EverySingleMotorMassage extends MassageProgram {

    private final int[][] valueTable;
    private final int frequency = 40; // Jeder Motor eine Sek ansteuern
    private final int numberOfTimeSteps = 2*frequency * handler.getMotorCount();
    private int timeStepCounter;


    public EverySingleMotorMassage(MassageProgramHandler handler, int SizeOfBigIntensity) {
        super(handler);
        int bigIntensity = SizeOfBigIntensity;
        double littleFactor = 0.5;
        int risingLittleIntensity = (int) (littleFactor * bigIntensity);
        int fallingLittleIntensity = (int) (littleFactor * bigIntensity);
        boolean nextMotor = false;
        int[] groupIntensity = new int[handler.getMotorCount()];
        valueTable = new int[handler.getMotorCount()][numberOfTimeSteps];

        for (int j = 0; j < numberOfTimeSteps; j++) {
            for (int i = 0; i < handler.getMotorCount(); i++) {

                if(j==0){
                    groupIntensity[0] = bigIntensity;
                }

                if (nextMotor && groupIntensity[i] == fallingLittleIntensity) {
                    if (i == handler.getMotorCount()-1){
                        groupIntensity[i] = 0;
                        groupIntensity[0] = bigIntensity;
                    } else {
                        groupIntensity[i] = 0;
                        groupIntensity[i + 1] = bigIntensity;
                    }
                    nextMotor = false;
                }

                if (nextMotor && groupIntensity[i] == bigIntensity) {
                    if (i == handler.getMotorCount()-1){
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[0] = risingLittleIntensity;
                    } else {
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[i + 1] = risingLittleIntensity;
                    }
                    nextMotor = false;
                }
            }
            valueTable[0][j] = groupIntensity[0];
            valueTable[1][j] = groupIntensity[1];
            valueTable[2][j] = groupIntensity[2];
            valueTable[3][j] = groupIntensity[3];
            valueTable[4][j] = groupIntensity[4];
            valueTable[5][j] = groupIntensity[5];
            valueTable[6][j] = groupIntensity[6];
            valueTable[7][j] = groupIntensity[7];
            valueTable[8][j] = groupIntensity[8];
            valueTable[9][j] = groupIntensity[9];
            valueTable[10][j] = groupIntensity[10];
            valueTable[11][j] = groupIntensity[11];
            valueTable[12][j] = groupIntensity[12];
            valueTable[13][j] = groupIntensity[13];
            valueTable[14][j] = groupIntensity[14];
            valueTable[15][j] = groupIntensity[15];
            valueTable[16][j] = groupIntensity[16];
            valueTable[17][j] = groupIntensity[17];
            valueTable[18][j] = groupIntensity[18];
            valueTable[19][j] = groupIntensity[19];
            valueTable[20][j] = groupIntensity[20];
            valueTable[21][j] = groupIntensity[21];
            valueTable[22][j] = groupIntensity[22];
            valueTable[23][j] = groupIntensity[23];


            if ((j+1)%40==0){
                nextMotor = true;
            }
        }
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) (valueTable[i][timeStepCounter] - 128);
        }
        if (timeStepCounter < numberOfTimeSteps) {
            timeStepCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }

    public void resetColumnCounter() {
        timeStepCounter = 0;
    }
}

class testMassage extends MassageProgram {

    public testMassage(MassageProgramHandler handler) {
        super(handler);
    }

    @Override
    public byte[] nextStep() {
        byte[] array = new byte[handler.getMotorCount()];
        array[7] = 120;
        return array;
    }
}

class BackCircleMassage extends MassageProgram{

    private final int[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public BackCircleMassage(MassageProgramHandler handler, int SizeOfBigIntensity) {
        super(handler);
        int bigIntensity = SizeOfBigIntensity;
        double littleFactor = 0.5;
        double mediumFactor = 0.75;
        int risingLittleIntensity = (int) (littleFactor * bigIntensity);
        int fallingLittleIntensity = (int) (littleFactor * bigIntensity);
        int risingMediumIntensity = (int) (mediumFactor * bigIntensity);
        int fallingMediumIntensity = (int) (mediumFactor * bigIntensity);
        boolean changeIntensity = false;

        valueTable = new int[handler.getMotorCount()][numberOfColumns];
        int numberOfGroups = 3;
        int[] groupIntensity = new int[numberOfGroups];
        for (int j = 0; j < numberOfColumns; j++) {
            if (j == 0) {
                groupIntensity[0] = bigIntensity;
            }
            for (int i = 0; i < numberOfGroups; i++) {
                if (changeIntensity && groupIntensity[i] == fallingLittleIntensity) {
                    if (i==2){
                        groupIntensity[i] = 0;
                        groupIntensity[0] = bigIntensity;
                    } else {
                        groupIntensity[i] = 0;
                        groupIntensity[i + 1] = bigIntensity;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == fallingMediumIntensity) {
                    if (i==2){
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[0] = risingMediumIntensity;
                    } else {
                        groupIntensity[i] = fallingLittleIntensity;
                        groupIntensity[i + 1] = risingMediumIntensity;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == bigIntensity) {
                    if (i==2){
                        groupIntensity[i] = fallingMediumIntensity;
                        groupIntensity[0] = risingLittleIntensity;
                    } else {
                        groupIntensity[i] = fallingMediumIntensity;
                        groupIntensity[i + 1] = risingLittleIntensity;
                    }
                    changeIntensity = false;
                }

            }
            valueTable[7][j] = groupIntensity[0];
            valueTable[6][j] = groupIntensity[0];

            valueTable[11][j] = groupIntensity[1];
            valueTable[10][j] = groupIntensity[1];
            valueTable[15][j] = groupIntensity[1];
            valueTable[14][j] = groupIntensity[1];
            valueTable[19][j] = groupIntensity[1];
            valueTable[18][j] = groupIntensity[1];

            valueTable[9][j] = groupIntensity[2];
            valueTable[8][j] = groupIntensity[2];
            valueTable[13][j] = groupIntensity[2];
            valueTable[12][j] = groupIntensity[2];
            valueTable[17][j] = groupIntensity[2];
            valueTable[16][j] = groupIntensity[2];
            valueTable[21][j] = groupIntensity[2];
            valueTable[20][j] = groupIntensity[2];
            valueTable[23][j] = groupIntensity[2];
            valueTable[22][j] = groupIntensity[2];

            if ((j+1) % 40 == 0){
                changeIntensity = true;
            }
        }
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) ((valueTable[i][columnCounter])-128);
        }
        if (columnCounter < numberOfColumns) {
            columnCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }

    public void resetColumnCounter() {
        columnCounter = 0;
    }
}

class BreathInandOutMassage extends MassageProgram{
    int breathTime = 6;
    int frequency = 40;
    int[][] valueTable = new int[handler.getMotorCount()][frequency * breathTime];
    int columnCounter = 0;

    public BreathInandOutMassage(MassageProgramHandler handler) {
        super(handler);
        if(PageFragment5.getInstance().isTall()){
            generateValueTable((short) 8);
        }else{
            generateValueTable((short) 7);
        }


    }

    private void generateValueTable(short motorNum) {
        int intensity = 0;
        int cap  = (int) (((double) valueTable.length / 2) / 256.0);
        int c = 0;

        for (int i = 0; i < valueTable.length; i++) {
            if(i == (valueTable.length-1)/2){
                c = 0;
            }
            if(i < (valueTable.length-1)/2){
                //breath in
                if( c < cap){
                    c++;
                }else  {
                    c = 0;
                    intensity++;
                }
            }else{
                //breath out
                if( c < cap){
                    c++;
                }else  {
                    c = 0;
                    intensity--;
                }
            }
            valueTable[motorNum][i] = intensity;
        }
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) ((valueTable[i][columnCounter])-128);
        }
        if (columnCounter < frequency * breathTime) {
            columnCounter++;
        } else {
            resetColumnCounter();
        }
        return column;
    }
    public void resetColumnCounter() {
        columnCounter = 0;
    }

}

