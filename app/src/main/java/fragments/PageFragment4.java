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
    private final int[][] motorBackrestPosition = new int[20][2];


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater
                .inflate(R.layout.page_4, container
                        , false);


        rootView.findViewById(R.id.seatFrg4).setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewSeatEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return true;
                case MotionEvent.ACTION_UP:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewSeatEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return false;
                default: return false;
            }

        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) getActivity()).setMotorData(null);
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
    }

    private void setMotorArray() {
        motorBackrestPosition[0][0] = 12;
        motorBackrestPosition[1][0] = 12;
        motorBackrestPosition[2][0] = 12;
        motorBackrestPosition[3][0] = 12;
        motorBackrestPosition[4][0] = 12;
        motorBackrestPosition[5][0] = 12;
        motorBackrestPosition[6][0] = 12;
        motorBackrestPosition[7][0] = 12;
        motorBackrestPosition[8][0] = 12;
        motorBackrestPosition[9][0] = 12;
        motorBackrestPosition[10][0] = 12;
        motorBackrestPosition[11][0] = 12;
        motorBackrestPosition[12][0] = 12;
        motorBackrestPosition[13][0] = 12;
        motorBackrestPosition[14][0] = 12;
        motorBackrestPosition[15][0] = 12;
        motorBackrestPosition[16][0] = 12;
        motorBackrestPosition[17][0] = 12;
        motorBackrestPosition[18][0] = 12;
        motorBackrestPosition[19][0] = 12;
        motorBackrestPosition[20][0] = 12;
        motorBackrestPosition[21][0] = 12;
        motorBackrestPosition[22][0] = 12;
        motorBackrestPosition[23][0] = 12;

        motorBackrestPosition[0][1] = 12;
        motorBackrestPosition[1][1] = 12;
        motorBackrestPosition[2][1] = 12;
        motorBackrestPosition[3][1] = 12;
        motorBackrestPosition[4][1] = 12;
        motorBackrestPosition[5][1] = 12;
        motorBackrestPosition[6][1] = 12;
        motorBackrestPosition[7][1] = 12;
        motorBackrestPosition[8][1] = 12;
        motorBackrestPosition[9][1] = 12;
        motorBackrestPosition[10][1] = 12;
        motorBackrestPosition[11][1] = 12;
        motorBackrestPosition[12][1] = 12;
        motorBackrestPosition[13][1] = 12;
        motorBackrestPosition[14][1] = 12;
        motorBackrestPosition[15][1] = 12;
        motorBackrestPosition[16][1] = 12;
        motorBackrestPosition[17][1] = 12;
        motorBackrestPosition[18][1] = 12;
        motorBackrestPosition[19][1] = 12;
        motorBackrestPosition[20][1] = 12;
        motorBackrestPosition[21][1] = 12;
        motorBackrestPosition[22][1] = 12;
        motorBackrestPosition[23][1] = 12;
    }

    private void getDistance() {

    }

    private void setViewCoords(){
        rootView.findViewById(R.id.seatFrg4).getLocationInWindow(seatCoords);
        viewCoordsSet = true;
    }
}/* 1. TODO Motorenpsoition als Array (setMotorCushion/backrestarray)
    2. von Position des Imageviews abziehen (pitagores)
    3. davon absolutwert nehmen
    4. dort bis wert x diese stärke wert y sälle stärke usw.
    5. ausgeben
    6. Massage genießen
  */