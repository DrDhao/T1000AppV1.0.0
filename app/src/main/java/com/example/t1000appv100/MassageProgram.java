package com.example.t1000appv100;

public abstract class MassageProgram {
    protected MassageProgramHandler handler;

    public MassageProgram(MassageProgramHandler handler) {
        this.handler = handler;
    }

    public abstract byte[] nextStep();
}

class WaveMassage extends MassageProgram {

    private final byte[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public WaveMassage(MassageProgramHandler handler, int SizeOfBigIncrement) {
        super(handler);
        byte bigIncrement = (byte) (10*SizeOfBigIncrement);
        double littleFactor = 0.5;
        double mediumFactor = 0.75;
        byte risingLittleIncrement = (byte) (littleFactor * bigIncrement);
        byte fallingLittleIncrement = (byte) (littleFactor * bigIncrement);
        byte risingMediumIncrement = (byte) (mediumFactor * bigIncrement);
        byte fallingMediumIncrement = (byte) (mediumFactor * bigIncrement);
        boolean changeIntensity = false;

        valueTable = new byte[handler.getMotorCount()][numberOfColumns];
        int numberOfGroups = 11;
        byte[] groupIntensity = new byte[numberOfGroups];
        for (int j = 0; j < numberOfColumns; j++) {
            if (j == 0) {
                groupIntensity[0] = 100;
            }
            for (int i = 0; i < handler.getMotorCount(); i++) {
                if (changeIntensity && groupIntensity[i] == fallingLittleIncrement) {
                    if (i==10){
                        groupIntensity[i] = 0;
                        groupIntensity[0] = bigIncrement;
                    } else {
                        groupIntensity[i] = 0;
                        groupIntensity[i + 1] = bigIncrement;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == fallingMediumIncrement) {
                    if (i==10){
                        groupIntensity[i] = fallingLittleIncrement;
                        groupIntensity[0] = risingMediumIncrement;
                    } else {
                        groupIntensity[i] = fallingLittleIncrement;
                        groupIntensity[i + 1] = risingMediumIncrement;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == bigIncrement) {
                    if (i==10){
                        groupIntensity[i] = fallingMediumIncrement;
                        groupIntensity[0] = risingLittleIncrement;
                    } else {
                        groupIntensity[i] = fallingMediumIncrement;
                        groupIntensity[i + 1] = risingLittleIncrement;
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

    private final byte[][] valueTable;
    private final int numberOfColumns = 1920;
    private int columnCounter;

    public FullPowerMassage(MassageProgramHandler handler, int SizeOfBigIncrement) {
        super(handler);
        byte bigIncrement = (byte) (10*SizeOfBigIncrement);

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

    private final byte[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public EverySingleMotorMassage(MassageProgramHandler handler, int SizeOfBigIncrement) {
        super(handler);
        byte bigIncrement = (byte) (10*SizeOfBigIncrement);
        double littleFactor = 0.25;
        byte littleIncrement = (byte) (littleFactor * bigIncrement);

        valueTable = new byte[handler.getMotorCount()][numberOfColumns];
        for (int i = 0; i < handler.getMotorCount(); i++) {
            for (int j = 0; j < 40; j++) {
                valueTable[i][j] = bigIncrement;
                if (i > 0 && i < (handler.getMotorCount() - 1)) {
                    valueTable[i - 1][j] = littleIncrement;
                    valueTable[i + 1][j] = littleIncrement;
                } else if (i > 0) {
                    valueTable[i - 1][j] = littleIncrement;
                } else if (i < handler.getMotorCount() - 1) {
                    valueTable[i + 1][j] = littleIncrement;
                }
            }
        }
    }

    @Override
    public byte[] nextStep() {
        byte[] column = new byte[super.handler.getMotorCount()];
        for (int i = 0; i < super.handler.getMotorCount(); i++) {
            column[i] = (byte) (valueTable[i][columnCounter] - 128);
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

    private final byte[][] valueTable;
    private final int numberOfColumns = 960;
    private int columnCounter;

    public BackCircleMassage(MassageProgramHandler handler, int SizeOfBigIncrement) {
        super(handler);
        byte bigIncrement = (byte) (10*SizeOfBigIncrement);
        double littleFactor = 0.5;
        double mediumFactor = 0.75;
        byte risingLittleIncrement = (byte) (littleFactor * bigIncrement);
        byte fallingLittleIncrement = (byte) (littleFactor * bigIncrement);
        byte risingMediumIncrement = (byte) (mediumFactor * bigIncrement);
        byte fallingMediumIncrement = (byte) (mediumFactor * bigIncrement);
        boolean changeIntensity = false;

        valueTable = new byte[handler.getMotorCount()][numberOfColumns];
        int numberOfGroups = 3;
        byte[] groupIntensity = new byte[numberOfGroups];
        for (int j = 0; j < numberOfColumns; j++) {
            if (j == 0) {
                groupIntensity[0] = 100;
            }
            for (int i = 0; i < numberOfGroups; i++) {
                if (changeIntensity && groupIntensity[i] == fallingLittleIncrement) {
                    if (i==2){
                        groupIntensity[i] = 0;
                        groupIntensity[0] = bigIncrement;
                    } else {
                        groupIntensity[i] = 0;
                        groupIntensity[i + 1] = bigIncrement;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == fallingMediumIncrement) {
                    if (i==2){
                        groupIntensity[i] = fallingLittleIncrement;
                        groupIntensity[0] = risingMediumIncrement;
                    } else {
                        groupIntensity[i] = fallingLittleIncrement;
                        groupIntensity[i + 1] = risingMediumIncrement;
                    }
                    changeIntensity = false;
                }

                if (changeIntensity && groupIntensity[i] == bigIncrement) {
                    if (i==2){
                        groupIntensity[i] = fallingMediumIncrement;
                        groupIntensity[0] = risingLittleIncrement;
                    } else {
                        groupIntensity[i] = fallingMediumIncrement;
                        groupIntensity[i + 1] = risingLittleIncrement;
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

