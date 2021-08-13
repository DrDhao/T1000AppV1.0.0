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
    //private byte intensity;
    private ImageButton[] motorButtons;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_1, container, false);
        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRight);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeft);
        SeekBar seekBar = rootView.findViewById(R.id.seekBar);
        TextView intensityTextView = rootView.findViewById(R.id.intensityTextView);

        motorButtons[1] = rootView.findViewById(R.id.motorButton1);
        motorButtons[2] = rootView.findViewById(R.id.motorButton2);
        motorButtons[3] = rootView.findViewById(R.id.motorButton3);
        motorButtons[4] = rootView.findViewById(R.id.motorButton4);
        motorButtons[5] = rootView.findViewById(R.id.motorButton5);
        motorButtons[6] = rootView.findViewById(R.id.motorButton6);
        motorButtons[7] = rootView.findViewById(R.id.motorButton7);
        motorButtons[8] = rootView.findViewById(R.id.motorButton8);
        motorButtons[9] = rootView.findViewById(R.id.motorButton9);
        motorButtons[10] = rootView.findViewById(R.id.motorButton10);
        motorButtons[11] = rootView.findViewById(R.id.motorButton11);
        motorButtons[12] = rootView.findViewById(R.id.motorButton12);
        motorButtons[13] = rootView.findViewById(R.id.motorButton13);
        motorButtons[14] = rootView.findViewById(R.id.motorButton14);
        motorButtons[15] = rootView.findViewById(R.id.motorButton15);
        motorButtons[16] = rootView.findViewById(R.id.motorButton16);
        motorButtons[16] = rootView.findViewById(R.id.motorButton17);
        motorButtons[16] = rootView.findViewById(R.id.motorButton18);
        motorButtons[16] = rootView.findViewById(R.id.motorButton19);
        motorButtons[16] = rootView.findViewById(R.id.motorButton20);
        motorButtons[16] = rootView.findViewById(R.id.motorButton21);
        motorButtons[16] = rootView.findViewById(R.id.motorButton22);
        motorButtons[16] = rootView.findViewById(R.id.motorButton23);
        motorButtons[16] = rootView.findViewById(R.id.motorButton24);





        //ImageButtons einblenden und aktivieren
        seatButtonRight.setOnClickListener(view -> {
            seatButtonRight.setVisibility(View.INVISIBLE);
            seatButtonRight.setClickable(false);
            seatButtonLeft.setVisibility(View.VISIBLE);
            seatButtonLeft.setClickable(true);
            seekBar.setVisibility(View.VISIBLE);
            seekBar.setClickable(true);
            intensityTextView.setVisibility(View.VISIBLE);
            for (ImageButton button: motorButtons) {
                button.setVisibility(View.VISIBLE);
                button.setClickable(true);
            }
        });

        //ImageButton ausblenden und deaktivieren
        seatButtonLeft.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.INVISIBLE);
            seatButtonLeft.setClickable(false);
            seatButtonRight.setVisibility(View.VISIBLE);
            seatButtonRight.setClickable(true);
            seekBar.setVisibility(View.INVISIBLE);
            seekBar.setClickable(false);
            intensityTextView.setVisibility(View.INVISIBLE);

            for (ImageButton button: motorButtons) {
                button.setVisibility(View.INVISIBLE);
                button.setClickable(false);
            }
        });

        //Wenn Motor ausgewählt, Progress Bar setzen
        for (byte i = 0; i < motorButtons.length; i++) {
            byte finalI = i;
            motorButtons[i].setOnClickListener(view -> {
                motorNum = finalI;
                seekBar.setProgress(main.getMotorData(finalI), true);
            });
        }



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                byte intensity = (byte) seekBar.getProgress();
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


