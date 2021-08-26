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
import com.example.t1000appv100.MyFragment;
import com.example.t1000appv100.R;

import java.util.concurrent.Executors;

public class PageFragment5 extends Fragment implements MyFragment {
    private static PageFragment5 instance;
    private ViewGroup rootView;
    private MainActivity main;


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        instance = this;
        rootView = (ViewGroup) inflater.inflate(R.layout.page_5, container, false);
        main = ((MainActivity) getActivity());

        rootView.findViewById(R.id.seatButtonFrg5).setOnClickListener(view ->{
            Executors.newSingleThreadScheduledExecutor().execute(()->{


            });
        });
        return rootView;
    }




    //GETTER, SETTER & STOP
    public static PageFragment5 getInstance() {
        return instance;
    }

    @Override
    public void stop() {

    }
}