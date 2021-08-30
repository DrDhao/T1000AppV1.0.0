package com.example.t1000appv100;

import android.util.Log;

import javax.security.auth.login.LoginException;


public class CustomMassageProgram {
    private MainActivity main;

    int activeProgram_m = -1;
    boolean[][] zone_m = new boolean[3][10];
    int[] type_m = {-1, -1, -1}; //0 Durchgehend an, 1 An Aus Abwechselnd, 2 Langsam hoch und wieder runter
    int[] speed_m = {1, 1, 1};
    int[] intensity_m = {-128, -128, -128};
    int[] time_m = {20, 20, 20};
    public boolean stopMassage = false;


    public void setActiveProgram(int activeProgram) {
        activeProgram_m = activeProgram;
    }

    public int getActiveProgram() {
        return activeProgram_m;
    }

    public void setZone(int zone, boolean zoneValue) {
        zone_m[activeProgram_m][zone] = zoneValue;
    }

    public boolean getZone(int zone) {
        return zone_m[activeProgram_m][zone];
    }

    public void setType(int type) {
        type_m[activeProgram_m] = type;
    }

    public int getType() {
        return type_m[activeProgram_m];
    }

    public void setSpeed(int speed) {
        speed_m[activeProgram_m] = speed;
    }

    public int getSpeed(){ return  speed_m[activeProgram_m];}

    public void setIntensity(int intensity) {
        intensity_m[activeProgram_m] = intensity;
    }

    public int getIntensity(){ return intensity_m[activeProgram_m];}

    public void setTime(int time) {
        time_m[activeProgram_m] = time;
    }

    public int getTime(){return time_m[activeProgram_m];}

    public void startProgram(boolean startProgram) {
        if (startProgram) {
            stopMassage = false;
            MassageRunThread massageRunThread = new MassageRunThread(zone_m, type_m, speed_m, intensity_m, time_m);
            massageRunThread.start();
        } else stopMassage = true;
    }

    class MassageRunThread extends Thread {
        boolean[][] zone_m;
        int[] type_m;
        int[] speed_m;
        int[] intensity_m;
        int[] time_m;

        int speedCtr;
        int timeCtr;
        boolean toggleRem = true;
        int[] waveValues = {0, 20, 40, 60, 80, 100, 80, 60, 40, 20};
        int waveValeusRem;


        MassageRunThread(boolean[][] zone, int[] type, int[] speed, int[] intensity, int[] time) {

            main = MainActivity.getInstance();
            zone_m = zone;
            type_m = type;
            speed_m = speed;
            intensity_m = intensity;
            time_m = time;
        }

        @Override
        public void run() {
            int programNumber = 0;
            while (programNumber <= 2) {

                Log.i("ProgramNumber", "NEXT PROGRAM");
                speedCtr = (151 - speed_m[programNumber]);
                toggleRem = true;
                timeCtr = time_m[programNumber];
                while (timeCtr > 0) {
                    if (stopMassage) {
                        byte[] dataToSend = {-128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128, -128};
                        main.setMotorData(dataToSend);
                        return;
                    }
                    timeCtr--;
                    switch (type_m[programNumber]) {
                        case -1:
                            timeCtr = 0;
                            break;
                        case 0:
                            runType1Massage(programNumber, zone_m, intensity_m);
                            break;
                        case 1:
                            runType2Massage(programNumber, zone_m, intensity_m, speed_m);
                            break;
                        case 2:
                            runType3Massage(programNumber, zone_m, intensity_m, speed_m);
                            break;
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (programNumber == 2) programNumber = 0;
                else programNumber++;
            }
        }

        public void runType1Massage(int programNubmer, boolean[][] zone, int[] intensity) {
            byte[] dataToSend = new byte[24];

            if (zone[programNubmer][0]) {
                dataToSend[22] = (byte) intensity[programNubmer];
                dataToSend[20] = (byte) intensity[programNubmer];
                dataToSend[18] = (byte) intensity[programNubmer];
            } else {
                dataToSend[22] = -128;
                dataToSend[20] = -128;
                dataToSend[18] = -128;
            }
            if (zone[programNubmer][1]) {
                dataToSend[23] = (byte) intensity[programNubmer];
                dataToSend[21] = (byte) intensity[programNubmer];
                dataToSend[19] = (byte) intensity[programNubmer];
            } else {
                dataToSend[23] = -128;
                dataToSend[21] = -128;
                dataToSend[19] = -128;
            }
            if (zone[programNubmer][2]) {
                dataToSend[16] = (byte) intensity[programNubmer];
                dataToSend[14] = (byte) intensity[programNubmer];
                dataToSend[12] = (byte) intensity[programNubmer];
            } else {
                dataToSend[16] = -128;
                dataToSend[14] = -128;
                dataToSend[12] = -128;
            }
            if (zone[programNubmer][3]) {
                dataToSend[17] = (byte) intensity[programNubmer];
                dataToSend[15] = (byte) intensity[programNubmer];
                dataToSend[13] = (byte) intensity[programNubmer];
            } else {
                dataToSend[17] = -128;
                dataToSend[15] = -128;
                dataToSend[13] = -128;
            }

            if (zone[programNubmer][4]) {
                dataToSend[4] = (byte) intensity[programNubmer];
                dataToSend[8] = (byte) intensity[programNubmer];
                dataToSend[10] = (byte) intensity[programNubmer];
            } else {
                dataToSend[4] = -128;
                dataToSend[8] = -128;
                dataToSend[10] = -128;
            }

            if (zone[programNubmer][5]) {
                dataToSend[11] = (byte) intensity[programNubmer];
                dataToSend[9] = (byte) intensity[programNubmer];
                dataToSend[5] = (byte) intensity[programNubmer];
            } else {
                dataToSend[11] = -128;
                dataToSend[9] = -128;
                dataToSend[5] = -128;
            }

            if (zone[programNubmer][6]) {
                dataToSend[2] = (byte) intensity[programNubmer];
            } else {
                dataToSend[2] = -128;
            }

            if (zone[programNubmer][7]) {
                dataToSend[3] = (byte) intensity[programNubmer];
            } else {
                dataToSend[3] = -128;
            }

            if (zone[programNubmer][8]) {
                dataToSend[0] = (byte) intensity[programNubmer];
            } else {
                dataToSend[0] = -128;
            }

            if (zone[programNubmer][9]) {
                dataToSend[1] = (byte) intensity[programNubmer];
            } else {
                dataToSend[1] = -128;
            }

            dataToSend[6] = -128;
            dataToSend[7] = -128;

            main.setMotorData(dataToSend);
        }

        public void runType2Massage(int programNubmer, boolean[][] zone, int[] intensity, int[] speed) {
            byte[] dataToSend = new byte[24];

            if (speedCtr > 0) {
                speedCtr--;
                if (toggleRem) {
                    if (zone[programNubmer][0]) {
                        dataToSend[22] = (byte) intensity[programNubmer];
                        dataToSend[20] = (byte) intensity[programNubmer];
                        dataToSend[18] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[22] = -128;
                        dataToSend[20] = -128;
                        dataToSend[18] = -128;
                    }

                    if (zone[programNubmer][1]) {
                        dataToSend[23] = (byte) intensity[programNubmer];
                        dataToSend[21] = (byte) intensity[programNubmer];
                        dataToSend[19] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[23] = -128;
                        dataToSend[21] = -128;
                        dataToSend[19] = -128;
                    }

                    if (zone[programNubmer][2]) {
                        dataToSend[16] = (byte) intensity[programNubmer];
                        dataToSend[14] = (byte) intensity[programNubmer];
                        dataToSend[12] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[16] = -128;
                        dataToSend[14] = -128;
                        dataToSend[12] = -128;
                    }

                    if (zone[programNubmer][3]) {
                        dataToSend[17] = (byte) intensity[programNubmer];
                        dataToSend[15] = (byte) intensity[programNubmer];
                        dataToSend[13] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[17] = -128;
                        dataToSend[15] = -128;
                        dataToSend[13] = -128;
                    }

                    if (zone[programNubmer][4]) {
                        dataToSend[4] = (byte) intensity[programNubmer];
                        dataToSend[8] = (byte) intensity[programNubmer];
                        dataToSend[10] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[4] = -128;
                        dataToSend[8] = -128;
                        dataToSend[10] = -128;
                    }

                    if (zone[programNubmer][5]) {
                        dataToSend[11] = (byte) intensity[programNubmer];
                        dataToSend[9] = (byte) intensity[programNubmer];
                        dataToSend[5] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[11] = -128;
                        dataToSend[9] = -128;
                        dataToSend[5] = -128;
                    }

                    if (zone[programNubmer][6]) {
                        dataToSend[2] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[2] = -128;
                    }

                    if (zone[programNubmer][7]) {
                        dataToSend[3] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[3] = -128;
                    }

                    if (zone[programNubmer][8]) {
                        dataToSend[0] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[0] = -128;
                    }

                    if (zone[programNubmer][9]) {
                        dataToSend[1] = (byte) intensity[programNubmer];
                    } else {
                        dataToSend[1] = -128;
                    }

                    dataToSend[6] = -128;
                    dataToSend[7] = -128;
                } else {
                    for (int i = 0; i <= 23; i++) {
                        dataToSend[i] = -128;
                    }
                }
                main.setMotorData(dataToSend);
            } else {
                speedCtr = (151 - speed[programNubmer]);
                toggleRem = !toggleRem;
            }
        }

        public void runType3Massage(int programNubmer, boolean[][] zone, int[] intensity, int[] speed) {
            byte[] dataToSend = new byte[24];
            speedCtr--;
            if (zone[programNubmer][0]) {
                dataToSend[22] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[20] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[18] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[22] = -128;
                dataToSend[20] = -128;
                dataToSend[18] = -128;
            }

            if (zone[programNubmer][1]) {
                dataToSend[23] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[21] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[19] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[23] = -128;
                dataToSend[21] = -128;
                dataToSend[19] = -128;
            }

            if (zone[programNubmer][2]) {
                dataToSend[16] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[14] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[12] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[16] = -128;
                dataToSend[14] = -128;
                dataToSend[12] = -128;
            }

            if (zone[programNubmer][3]) {
                dataToSend[17] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[15] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[13] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[17] = -128;
                dataToSend[15] = -128;
                dataToSend[13] = -128;
            }

            if (zone[programNubmer][4]) {
                dataToSend[4] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[8] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[10] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[4] = -128;
                dataToSend[8] = -128;
                dataToSend[10] = -128;
            }

            if (zone[programNubmer][5]) {
                dataToSend[11] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[9] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
                dataToSend[5] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[11] = -128;
                dataToSend[9] = -128;
                dataToSend[5] = -128;
            }

            if (zone[programNubmer][6]) {
                dataToSend[2] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[2] = -128;
            }

            if (zone[programNubmer][7]) {
                dataToSend[3] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[3] = -128;
            }

            if (zone[programNubmer][8]) {
                dataToSend[0] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[0] = -128;
            }

            if (zone[programNubmer][9]) {
                dataToSend[1] = (byte) ((((intensity[programNubmer] + 128) * waveValues[waveValeusRem]) / 100) - 128);
            } else {
                dataToSend[1] = -128;
            }
            dataToSend[6] = -128;
            dataToSend[7] = -128;

            if (speedCtr == 0) {
                if (waveValeusRem < 9) waveValeusRem++;
                else waveValeusRem = 0;
                speedCtr = (151 - speed[programNubmer]);
            }
            main.setMotorData(dataToSend);
        }
    }
}

