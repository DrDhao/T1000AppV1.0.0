package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.R;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PageFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        AtomicInteger activeProgram = new AtomicInteger(-1);
        boolean[][] zone = new boolean[3][10];


        AtomicBoolean showZoneButtons = new AtomicBoolean(false);
        AtomicBoolean showTypeButtons = new AtomicBoolean(false);
        AtomicBoolean showSeekBars = new AtomicBoolean(false);
        AtomicBoolean showProgram2 = new AtomicBoolean(false);
        AtomicBoolean showProgram3 = new AtomicBoolean(false);

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_3, container, false);
//Deklarartion der UI Objekte

        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRightFrg3);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg3);
        ToggleButton[] zoneButton = new ToggleButton[10];
        zoneButton[0] = rootView.findViewById(R.id.zoneButton1);
        zoneButton[1] = rootView.findViewById(R.id.zoneButton2);
        zoneButton[2] = rootView.findViewById(R.id.zoneButton3);
        zoneButton[3] = rootView.findViewById(R.id.zoneButton4);
        zoneButton[4] = rootView.findViewById(R.id.zoneButton5);
        zoneButton[5] = rootView.findViewById(R.id.zoneButton6);
        zoneButton[6] = rootView.findViewById(R.id.zoneButton7);
        zoneButton[7] = rootView.findViewById(R.id.zoneButton8);
        zoneButton[8] = rootView.findViewById(R.id.zoneButton9);
        zoneButton[9] = rootView.findViewById(R.id.zoneButton10);
        Button programButton1 = rootView.findViewById(R.id.programButton1);
        Button programButton2 = rootView.findViewById(R.id.programButton2);
        Button programButton3 = rootView.findViewById(R.id.programButton3);
        Button[] typeButton = new Button[3];
        typeButton[0] = rootView.findViewById(R.id.typeButton1);
        typeButton[1] = rootView.findViewById(R.id.typeButton2);
        typeButton[2] = rootView.findViewById(R.id.typeButton3);
        TextView[] textViews = new TextView[3];
        textViews[0] = rootView.findViewById(R.id.textViewSpeed);
        textViews[1] = rootView.findViewById(R.id.textViewIntensity);
        textViews[2] = rootView.findViewById(R.id.textViewTime);
        SeekBar[] seekBars = new SeekBar[3];
        seekBars[0] = rootView.findViewById(R.id.seekBarSpeed);
        seekBars[1] = rootView.findViewById(R.id.seekBarIntensity);
        seekBars[2] = rootView.findViewById(R.id.seekBarTime);
        Button startButton = rootView.findViewById(R.id.startButton);


        seatButtonRight.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.VISIBLE);
            seatButtonLeft.setClickable(true);
            seatButtonRight.setVisibility(View.INVISIBLE);
            seatButtonRight.setClickable(false);
            programButton1.setVisibility(View.VISIBLE);
            programButton1.setClickable(true);

            if(showZoneButtons.get()) showZoneButtons(zoneButton);
            if(showTypeButtons.get()) showTypeButtons(typeButton);
            if(showSeekBars.get()) showSeekBars(seekBars, textViews, startButton);
        });

        seatButtonLeft.setOnClickListener(view -> {
            seatButtonRight.setVisibility(View.VISIBLE);
            seatButtonRight.setClickable(true);
            seatButtonLeft.setVisibility(View.INVISIBLE);
            seatButtonLeft.setClickable(false);
            programButton1.setVisibility(View.INVISIBLE);
            programButton1.setClickable(false);

            for(int i = 0; i<= 9; i++){
                zoneButton[i].setVisibility(View.INVISIBLE);
                zoneButton[i].setClickable(false);
            }

            for(int i = 0; i <= 2; i++){
                typeButton[i].setVisibility(View.INVISIBLE);
                typeButton[i].setClickable(false);
            }

            for(int i = 0; i <= 2; i++){
                textViews[i].setVisibility(View.INVISIBLE);
                seekBars[i].setVisibility(View.INVISIBLE);
                seekBars[i].setClickable(false);
            }
            startButton.setVisibility(View.INVISIBLE);
            startButton.setClickable(false);
        });


        programButton1.setOnClickListener(view -> {

            showZoneButtons(zoneButton);
            showZoneButtons.set(true);
            activeProgram.set(0);
            for(int i = 0; i <= 0; i++){
                zoneButton[i].setChecked(zone[0][i]);
            }
        });

        programButton2.setOnClickListener(view -> {
            activeProgram.set(1);
            for(int i = 0; i <= 0; i++){
                zoneButton[i].setChecked(zone[1][i]);
            }
        });

        programButton3.setOnClickListener(view -> {
            activeProgram.set(2);
            for(int i = 0; i <= 0; i++){
                zoneButton[i].setChecked(zone[2][i]);
            }
        });

        zoneButton[0].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][0] = zoneButton[0].isChecked();
        });

        zoneButton[1].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);

            zone[activeProgram.get()][1] = zoneButton[1].isChecked();
        });



        zoneButton[2].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);

            zone[activeProgram.get()][2] = zoneButton[2].isChecked();
        });


        zoneButton[3].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][3] = zoneButton[3].isChecked();
        });

        zoneButton[4].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][4] = zoneButton[4].isChecked();
        });

        zoneButton[5].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][5] = zoneButton[5].isChecked();
        });

        zoneButton[6].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][6] = zoneButton[6].isChecked();
        });

        zoneButton[7].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][7] = zoneButton[7].isChecked();
        });

        zoneButton[8].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][8] = zoneButton[8].isChecked();
        });

        zoneButton[9].setOnClickListener(view -> {
            showTypeButtons(typeButton);
            showTypeButtons.set(true);
            zone[activeProgram.get()][9] = zoneButton[9].isChecked();
        });

        typeButton[0].setOnClickListener(view -> {
            showSeekBars(seekBars, textViews, startButton);
            showSeekBars.set(true);
            if(activeProgram.get() == 1){
                programButton2.setVisibility(View.VISIBLE);
                programButton2.setClickable(true);
                showProgram2.set(true);
            }
            if(activeProgram.get() == 2){
                programButton3.setVisibility(View.VISIBLE);
                programButton3.setClickable(true);
                showProgram3.set(true);
            }
        });

        typeButton[1].setOnClickListener(view -> {
            showSeekBars(seekBars, textViews, startButton);
            showSeekBars.set(true);
        });

        typeButton[2].setOnClickListener(view -> {
            showSeekBars(seekBars, textViews, startButton);
            showSeekBars.set(true);
        });

        return rootView;
    }

    void showZoneButtons(ToggleButton[] zoneButton){
        for(int i = 0; i<= 9; i++){
            zoneButton[i].setVisibility(View.VISIBLE);
            zoneButton[i].setClickable(true);
        }
    }

    void showTypeButtons(Button[] typeButton){
        for(int i = 0; i <= 2; i++){
            typeButton[i].setVisibility(View.VISIBLE);
            typeButton[i].setClickable(true);
        }
    }

    void showSeekBars(SeekBar[] seekBars, TextView[] textViews, Button startButton){
        for(int i = 0; i <= 2; i++){
            textViews[i].setVisibility(View.VISIBLE);
            seekBars[i].setVisibility(View.VISIBLE);
            seekBars[i].setClickable(true);
        }
        startButton.setVisibility(View.VISIBLE);
        startButton.setClickable(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) getActivity()).setMotorData(null);
    }


}

