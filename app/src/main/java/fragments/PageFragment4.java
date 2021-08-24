package fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.R;

import java.util.concurrent.Executors;

public class PageFragment4 extends Fragment {
    private ViewGroup rootView;
    private final int[] seatCoords = new int[2];
    private boolean viewCoordsSet = false;
    private final int[][] motorPositionSeat = new int[24][2];
    private MainActivity main;
    private final double intensityForSwipe = 12;



    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater
                .inflate(R.layout.page_4, container
                        , false);

        main = ((MainActivity) getActivity());
        
        rootView.findViewById(R.id.seatFrg4).setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    Executors.newSingleThreadExecutor().execute(() -> handleNewSeatEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return true;
                case MotionEvent.ACTION_UP:
                    Executors.newSingleThreadExecutor().execute(() -> handleNewSeatEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return false;
                default: return false;
            }

        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        main.setMotorData(null);
        viewCoordsSet = false;
    }

    private void handleNewSeatEvent(int posX, int posY) {
        if(!viewCoordsSet){
            setViewCoords();
            setMotorArray();
        }
        posX = posX - seatCoords[0];
        posY = posY - seatCoords[1];
        System.out.println("Position: " + posX + "|" + posY);
        main.setMotorData(calculateIntensity( posX, posY));
    }

    private byte[] calculateIntensity(int posX, int posY) {
        byte[] intensity = new byte[main.getMotorCount()];
        int selectedX;
        int selectedY;
        for (int i = 0; i < main.getMotorCount(); i++) {
            intensity[i] =  (byte) ((intensityForSwipe / Math.sqrt(Math.pow(posX - motorPositionSeat[i][0], 2) + Math.pow(posY - motorPositionSeat[i][1], 2))) -128);
        }
        return intensity;
    }

    private void setMotorArray() {
        motorPositionSeat[0][0] = 1630;
        motorPositionSeat[1][0] = 1630;
        motorPositionSeat[2][0] = 1250;
        motorPositionSeat[3][0] = 1250;
        motorPositionSeat[4][0] = 1050;
        motorPositionSeat[5][0] = 1050;
        motorPositionSeat[6][0] = 750;
        motorPositionSeat[7][0] = 600;

        motorPositionSeat[8][0] = 930;
        motorPositionSeat[9][0] = 930;
        motorPositionSeat[10][0] = 870;
        motorPositionSeat[11][0] = 870;
        motorPositionSeat[12][0] = 870;
        motorPositionSeat[13][0] = 870;
        motorPositionSeat[14][0] = 800;
        motorPositionSeat[15][0] = 800;
        motorPositionSeat[16][0] = 750;
        motorPositionSeat[17][0] = 750;
        motorPositionSeat[18][0] = 670;
        motorPositionSeat[19][0] = 670;
        motorPositionSeat[20][0] = 600;
        motorPositionSeat[21][0] = 600;
        motorPositionSeat[22][0] = 500;
        motorPositionSeat[23][0] = 500;

        motorPositionSeat[0][1] = 600;
        motorPositionSeat[1][1] = 200;
        motorPositionSeat[2][1] = 600;
        motorPositionSeat[3][1] = 200;
        motorPositionSeat[4][1] = 600;
        motorPositionSeat[5][1] = 200;

        motorPositionSeat[6][1] = 400;
        motorPositionSeat[7][1] = 400;

        motorPositionSeat[8][1] = 530;
        motorPositionSeat[9][1] = 270;
        motorPositionSeat[10][1] = 470;
        motorPositionSeat[11][1] = 330;
        motorPositionSeat[12][1] = 600;
        motorPositionSeat[13][1] = 200;
        motorPositionSeat[14][1] = 500;
        motorPositionSeat[15][1] = 300;
        motorPositionSeat[16][1] = 600;
        motorPositionSeat[17][1] = 200;
        motorPositionSeat[18][1] = 530;
        motorPositionSeat[19][1] = 270;
        motorPositionSeat[20][1] = 600;
        motorPositionSeat[21][1] = 200;
        motorPositionSeat[22][1] = 630;
        motorPositionSeat[23][1] = 170;
    }


    private void setViewCoords(){
        rootView.findViewById(R.id.seatFrg4).getLocationInWindow(seatCoords);
        viewCoordsSet = true;
    }
}
