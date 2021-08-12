package fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.R;

public class PageFragment1 extends Fragment {

    private static final String TAG = "Augabe intensität Fragment1";
    private MainActivity main;

    private byte motorNum;
    private byte intensity;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_1, container, false);
        ImageButton imageButton10 = rootView.findViewById(R.id.imageButton10);
        ImageButton imageButton11 = rootView.findViewById(R.id.imageButton11);
        SeekBar seekBar = rootView.findViewById(R.id.seekBar);
        TextView textView1 = rootView.findViewById(R.id.textView1);
        ImageButton motorButton0 = rootView.findViewById(R.id.imageButtonMotor0);
        ImageButton motorButton1 = rootView.findViewById(R.id.imageButtonMotor1);
        ImageButton motorButton2 = rootView.findViewById(R.id.imageButtonMotor2);
        ImageButton motorButton3 = rootView.findViewById(R.id.imageButtonMotor3);
        ImageButton motorButton4 = rootView.findViewById(R.id.imageButtonMotor4);
        ImageButton motorButton5 = rootView.findViewById(R.id.imageButtonMotor5);
        ImageButton motorButton6 = rootView.findViewById(R.id.imageButtonMotor6);
        ImageButton motorButton7 = rootView.findViewById(R.id.imageButtonMotor7);
        ImageButton motorButton8 = rootView.findViewById(R.id.imageButtonMotor8);
        ImageButton motorButton9 = rootView.findViewById(R.id.imageButtonMotor9);
        ImageButton motorButton10 = rootView.findViewById(R.id.imageButtonMotor10);
        ImageButton motorButton11 = rootView.findViewById(R.id.imageButtonMotor11);

        imageButton10.setOnClickListener(view -> {
        imageButton10.setVisibility(View.INVISIBLE);
        imageButton10.setClickable(false);
        imageButton11.setVisibility(View.VISIBLE);
        imageButton11.setClickable(true);
        seekBar.setVisibility(View.VISIBLE);
        seekBar.setClickable(true);
        textView1.setVisibility(View.VISIBLE);
        motorButton0.setVisibility(View.VISIBLE);
        motorButton0.setClickable(true);
        motorButton1.setVisibility(View.VISIBLE);
        motorButton1.setClickable(true);
        motorButton2.setVisibility(View.VISIBLE);
        motorButton2.setClickable(true);
        motorButton3.setVisibility(View.VISIBLE);
        motorButton3.setClickable(true);
        motorButton4.setVisibility(View.VISIBLE);
        motorButton4.setClickable(true);
        motorButton5.setVisibility(View.VISIBLE);
        motorButton5.setClickable(true);
        motorButton6.setVisibility(View.VISIBLE);
        motorButton6.setClickable(true);
        motorButton7.setVisibility(View.VISIBLE);
        motorButton7.setClickable(true);
        motorButton8.setVisibility(View.VISIBLE);
        motorButton8.setClickable(true);
        motorButton9.setVisibility(View.VISIBLE);
        motorButton9.setClickable(true);
        motorButton10.setVisibility(View.VISIBLE);
        motorButton10.setClickable(true);
        motorButton11.setVisibility(View.VISIBLE);
        motorButton11.setClickable(true);
        });


        imageButton11.setOnClickListener(view -> {
            imageButton11.setVisibility(View.INVISIBLE);
            imageButton11.setClickable(false);
            imageButton10.setVisibility(View.VISIBLE);
            imageButton10.setClickable(true);
            seekBar.setVisibility(View.INVISIBLE);
            seekBar.setClickable(false);
            textView1.setVisibility(View.INVISIBLE);
            motorButton0.setVisibility(View.INVISIBLE);
            motorButton0.setClickable(false);
            motorButton1.setVisibility(View.INVISIBLE);
            motorButton1.setClickable(false);
            motorButton2.setVisibility(View.INVISIBLE);
            motorButton2.setClickable(false);
            motorButton3.setVisibility(View.INVISIBLE);
            motorButton3.setClickable(false);
            motorButton4.setVisibility(View.INVISIBLE);
            motorButton4.setClickable(false);
            motorButton5.setVisibility(View.INVISIBLE);
            motorButton5.setClickable(false);
            motorButton6.setVisibility(View.INVISIBLE);
            motorButton6.setClickable(false);
            motorButton7.setVisibility(View.INVISIBLE);
            motorButton7.setClickable(false);
            motorButton8.setVisibility(View.INVISIBLE);
            motorButton8.setClickable(false);
            motorButton9.setVisibility(View.INVISIBLE);
            motorButton9.setClickable(false);
            motorButton10.setVisibility(View.INVISIBLE);
            motorButton10.setClickable(false);
            motorButton11.setVisibility(View.INVISIBLE);
            motorButton11.setClickable(false);
        });

        //Motor Nummer ändern und Intensitäten zuweisen
        {
            motorButton0.setOnClickListener(view -> {
                motorNum = 0;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton1.setOnClickListener(view -> {
                motorNum = 1;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton2.setOnClickListener(view -> {
                motorNum = 2;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton3.setOnClickListener(view -> {
                motorNum = 3;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton4.setOnClickListener(view -> {
                motorNum = 4;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton5.setOnClickListener(view -> {
                motorNum = 5;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton6.setOnClickListener(view -> {
                motorNum = 6;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton7.setOnClickListener(view -> {
                motorNum = 7;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton8.setOnClickListener(view -> {
                motorNum = 8;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton9.setOnClickListener(view -> {
                motorNum = 9;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton10.setOnClickListener(view -> {
                motorNum = 10;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton11.setOnClickListener(view -> {
                motorNum = 11;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                intensity = (byte) seekBar.getProgress();
                main.setMotorData(motorNum, intensity);
                if(intensity < 0){
                    switch (motorNum){
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        main = (MainActivity) getActivity();

        return rootView;
    }



    
}


