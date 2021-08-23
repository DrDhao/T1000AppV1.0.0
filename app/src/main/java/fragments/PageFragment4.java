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
    private int[] backrestCoords = new int[2];
    private int[] cushionCoords = new int[2];
    private boolean viewCoordsSet = false;


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater
                .inflate(R.layout.page_4, container
                        , false);


        rootView.findViewById(R.id.seatBackrest).setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewBackrestEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return true;
                case MotionEvent.ACTION_UP:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewBackrestEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return false;
                default: return false;
            }

        });
        rootView.findViewById(R.id.seatingSurface).setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewCushionEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return true;
                case MotionEvent.ACTION_UP:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewCushionEvent(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
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

    @Override
    public void onResume() {
        super.onResume();
    }



    private void handleNewBackrestEvent(int posX, int posY) {
        if(!viewCoordsSet){
            setViewCoords();
        }
        posX = posX - backrestCoords[0];
        posY = posY - backrestCoords[1];
        System.out.println("BackrestPosition: " + posX + "|" + posY);
    }

    private void handleNewCushionEvent(int posX, int posY) {
        if(!viewCoordsSet){
            setViewCoords();
        }
        posX = posX - cushionCoords[0];
        posY = posY - cushionCoords[1];
        System.out.println("KissenPosition: " + posX + "|" + posY);
    }

    private void setViewCoords(){
        rootView.findViewById(R.id.seatBackrest).getLocationInWindow(backrestCoords);
        rootView.findViewById(R.id.seatingSurface).getLocationInWindow(cushionCoords);
        viewCoordsSet = true;
    }
}