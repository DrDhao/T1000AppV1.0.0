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
        ImageButton motorButton1 = rootView.findViewById(R.id.motorButton1);
        ImageButton motorButton2 = rootView.findViewById(R.id.motorButton2);
        ImageButton motorButton3 = rootView.findViewById(R.id.motorButton3);
        ImageButton motorButton4 = rootView.findViewById(R.id.motorButton4);
        ImageButton motorButton5 = rootView.findViewById(R.id.motorButton5);
        ImageButton motorButton6 = rootView.findViewById(R.id.motorButton6);
        ImageButton motorButton7 = rootView.findViewById(R.id.motorButton7);
        ImageButton motorButton8 = rootView.findViewById(R.id.motorButton8);
        ImageButton motorButton9 = rootView.findViewById(R.id.motorButton9);
        ImageButton motorButton10 = rootView.findViewById(R.id.motorButton10);
        ImageButton motorButton11 = rootView.findViewById(R.id.motorButton11);
        ImageButton motorButton12 = rootView.findViewById(R.id.motorButton12);
        ImageButton motorButton13 = rootView.findViewById(R.id.motorButton13);
        ImageButton motorButton14 = rootView.findViewById(R.id.motorButton14);
        ImageButton motorButton15 = rootView.findViewById(R.id.motorButton15);
        ImageButton motorButton16 = rootView.findViewById(R.id.motorButton16);
        ImageButton motorButton17 = rootView.findViewById(R.id.motorButton17);
        ImageButton motorButton18 = rootView.findViewById(R.id.motorButton18);
        ImageButton motorButton19 = rootView.findViewById(R.id.motorButton19);
        ImageButton motorButton20 = rootView.findViewById(R.id.motorButton20);
        ImageButton motorButton21 = rootView.findViewById(R.id.motorButton21);
        ImageButton motorButton22 = rootView.findViewById(R.id.motorButton22);
        ImageButton motorButton23 = rootView.findViewById(R.id.motorButton23);
        ImageButton motorButton24 = rootView.findViewById(R.id.motorButton24);

        //ImageButtons einblenden und aktivieren
        imageButton10.setOnClickListener(view -> {
        imageButton10.setVisibility(View.INVISIBLE);
        imageButton10.setClickable(false);
        imageButton11.setVisibility(View.VISIBLE);
        imageButton11.setClickable(true);
        seekBar.setVisibility(View.VISIBLE);
        seekBar.setClickable(true);
        textView1.setVisibility(View.VISIBLE);
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
        motorButton12.setVisibility(View.VISIBLE);
        motorButton12.setClickable(true);
        motorButton13.setVisibility(View.VISIBLE);
        motorButton13.setClickable(true);
        motorButton14.setVisibility(View.VISIBLE);
        motorButton14.setClickable(true);
        motorButton15.setVisibility(View.VISIBLE);
        motorButton15.setClickable(true);
        motorButton16.setVisibility(View.VISIBLE);
        motorButton16.setClickable(true);
        motorButton17.setVisibility(View.VISIBLE);
        motorButton17.setClickable(true);
        motorButton18.setVisibility(View.VISIBLE);
        motorButton18.setClickable(true);
        motorButton19.setVisibility(View.VISIBLE);
        motorButton19.setClickable(true);
        motorButton20.setVisibility(View.VISIBLE);
        motorButton20.setClickable(true);
        motorButton21.setVisibility(View.VISIBLE);
        motorButton21.setClickable(true);
        motorButton22.setVisibility(View.VISIBLE);
        motorButton22.setClickable(true);
        motorButton23.setVisibility(View.VISIBLE);
        motorButton23.setClickable(true);
        motorButton24.setVisibility(View.VISIBLE);
        motorButton24.setClickable(true);

        });

        //ImageButton ausblenden und deaktivieren
        imageButton11.setOnClickListener(view -> {
            imageButton11.setVisibility(View.INVISIBLE);
            imageButton11.setClickable(false);
            imageButton10.setVisibility(View.VISIBLE);
            imageButton10.setClickable(true);
            seekBar.setVisibility(View.INVISIBLE);
            seekBar.setClickable(false);
            textView1.setVisibility(View.INVISIBLE);
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
            motorButton12.setVisibility(View.INVISIBLE);
            motorButton12.setClickable(false);
            motorButton13.setVisibility(View.INVISIBLE);
            motorButton13.setClickable(false);
            motorButton14.setVisibility(View.INVISIBLE);
            motorButton14.setClickable(false);
            motorButton15.setVisibility(View.INVISIBLE);
            motorButton15.setClickable(false);
            motorButton16.setVisibility(View.INVISIBLE);
            motorButton16.setClickable(false);
            motorButton17.setVisibility(View.INVISIBLE);
            motorButton17.setClickable(false);
            motorButton18.setVisibility(View.INVISIBLE);
            motorButton18.setClickable(false);
            motorButton19.setVisibility(View.INVISIBLE);
            motorButton19.setClickable(false);
            motorButton20.setVisibility(View.INVISIBLE);
            motorButton20.setClickable(false);
            motorButton21.setVisibility(View.INVISIBLE);
            motorButton21.setClickable(false);
            motorButton22.setVisibility(View.INVISIBLE);
            motorButton22.setClickable(false);
            motorButton23.setVisibility(View.INVISIBLE);
            motorButton23.setClickable(false);
            motorButton24.setVisibility(View.INVISIBLE);
            motorButton24.setClickable(false);

        });

        //Motor Nummer ändern und Intensitäten zuweisen
        {
            motorButton1.setOnClickListener(view -> {
                motorNum = 0;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton2.setOnClickListener(view -> {
                motorNum = 1;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton3.setOnClickListener(view -> {
                motorNum = 2;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton4.setOnClickListener(view -> {
                motorNum = 3;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton5.setOnClickListener(view -> {
                motorNum = 4;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton6.setOnClickListener(view -> {
                motorNum = 5;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton7.setOnClickListener(view -> {
                motorNum = 6;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton8.setOnClickListener(view -> {
                motorNum = 7;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton9.setOnClickListener(view -> {
                motorNum = 8;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton10.setOnClickListener(view -> {
                motorNum = 9;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton11.setOnClickListener(view -> {
                motorNum = 10;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton12.setOnClickListener(view -> {
                motorNum = 11;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton13.setOnClickListener(view -> {
                motorNum = 12;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton14.setOnClickListener(view -> {
                motorNum = 13;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton15.setOnClickListener(view -> {
                motorNum = 14;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton16.setOnClickListener(view -> {
                motorNum = 15;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton17.setOnClickListener(view -> {
                motorNum = 16;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton18.setOnClickListener(view -> {
                motorNum = 17;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton19.setOnClickListener(view -> {
                motorNum = 18;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton20.setOnClickListener(view -> {
                motorNum = 19;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton21.setOnClickListener(view -> {
                motorNum = 20;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton22.setOnClickListener(view -> {
                motorNum = 21;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton23.setOnClickListener(view -> {
                motorNum = 22;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
            motorButton24.setOnClickListener(view -> {
                motorNum = 23;
                seekBar.setProgress(main.getMotorData(motorNum), true);
            });
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                ImageButton motorButton1 = rootView.findViewById(R.id.motorButton1);
                ImageButton motorButton2 = rootView.findViewById(R.id.motorButton2);
                ImageButton motorButton3 = rootView.findViewById(R.id.motorButton3);
                ImageButton motorButton4 = rootView.findViewById(R.id.motorButton4);
                ImageButton motorButton5 = rootView.findViewById(R.id.motorButton5);
                ImageButton motorButton6 = rootView.findViewById(R.id.motorButton6);
                ImageButton motorButton7 = rootView.findViewById(R.id.motorButton7);
                ImageButton motorButton8 = rootView.findViewById(R.id.motorButton8);
                ImageButton motorButton9 = rootView.findViewById(R.id.motorButton9);
                ImageButton motorButton10 = rootView.findViewById(R.id.motorButton10);
                ImageButton motorButton11 = rootView.findViewById(R.id.motorButton11);
                ImageButton motorButton12 = rootView.findViewById(R.id.motorButton12);
                ImageButton motorButton13 = rootView.findViewById(R.id.motorButton13);
                ImageButton motorButton14 = rootView.findViewById(R.id.motorButton14);
                ImageButton motorButton15 = rootView.findViewById(R.id.motorButton15);
                ImageButton motorButton16 = rootView.findViewById(R.id.motorButton16);
                ImageButton motorButton17 = rootView.findViewById(R.id.motorButton17);
                ImageButton motorButton18 = rootView.findViewById(R.id.motorButton18);
                ImageButton motorButton19 = rootView.findViewById(R.id.motorButton19);
                ImageButton motorButton20 = rootView.findViewById(R.id.motorButton20);
                ImageButton motorButton21 = rootView.findViewById(R.id.motorButton21);
                ImageButton motorButton22 = rootView.findViewById(R.id.motorButton22);
                ImageButton motorButton23 = rootView.findViewById(R.id.motorButton23);
                ImageButton motorButton24 = rootView.findViewById(R.id.motorButton24);


                intensity = (byte) seekBar.getProgress();
                main.setMotorData(motorNum, intensity);





                switch (motorNum) {
                    case 0 : if (intensity > -128) motorButton1.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton1.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 1 : if (intensity > -128) motorButton2.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton2.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 2 : if (intensity > -128) motorButton3.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                 else motorButton3.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 3 : if (intensity > -128) motorButton4.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton4.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 4 : if (intensity > -128) motorButton5.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton5.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 5 : if (intensity > -128) motorButton6.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton6.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 6 : if (intensity > -128) motorButton7.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton7.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 7 : if (intensity > -128) motorButton8.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                                else motorButton8.setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus)) ;
                    case 8 : if (intensity > -128) motorButton9.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton9.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 9 : if (intensity > -128) motorButton10.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton10.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 10 : if (intensity > -128) motorButton11.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton11.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 11 : if (intensity > -128) motorButton12.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton12.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 12 : if (intensity > -128) motorButton13.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton13.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 13 : if (intensity > -128) motorButton14.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton14.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 14 : if (intensity > -128) motorButton15.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton15.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 15 : if (intensity > -128) motorButton16.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton16.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 16 : if (intensity > -128) motorButton17.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton17.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 17 : if (intensity > -128) motorButton18.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton18.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 18 : if (intensity > -128) motorButton19.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton19.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 19 : if (intensity > -128) motorButton20.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton20.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 20 : if (intensity > -128) motorButton21.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton21.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 21 : if (intensity > -128) motorButton22.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton22.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 22 : if (intensity > -128) motorButton23.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton23.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
                    case 23 : if (intensity > -128) motorButton24.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                                else motorButton24.setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus)) ;
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


