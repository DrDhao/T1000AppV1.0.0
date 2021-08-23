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
import android.widget.ImageView;

import com.example.t1000appv100.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PageFragment4 extends Fragment {

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.page_4, container
                        , false);

        rootView.findViewById(R.id.seatBackrest).setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewPosition(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return true;
                case MotionEvent.ACTION_UP:
                    Executors.newSingleThreadExecutor().submit(() -> handleNewPosition(Math.round(motionEvent.getX()), Math.round(motionEvent.getY())));
                    return false;
                default: return false;
            }
        });

        return rootView;
    }

    private void handleNewPosition(int posX, int posY) {
        System.out.println("Position: " + posX + "|" + posY);
    }


}