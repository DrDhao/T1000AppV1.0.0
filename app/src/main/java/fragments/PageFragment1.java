package fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    private ImageButton[] motorButtons = new ImageButton[24];

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_1, container, false);
        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRightFrg1);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg1);
        SeekBar seekBar = rootView.findViewById(R.id.seekBar);
        TextView intensityTextView = rootView.findViewById(R.id.intensityTextView);

        motorButtons[0] = rootView.findViewById(R.id.motorButton1);
        motorButtons[1] = rootView.findViewById(R.id.motorButton2);
        motorButtons[2] = rootView.findViewById(R.id.motorButton3);
        motorButtons[3] = rootView.findViewById(R.id.motorButton4);
        motorButtons[4] = rootView.findViewById(R.id.motorButton5);
        motorButtons[5] = rootView.findViewById(R.id.motorButton6);
        motorButtons[6] = rootView.findViewById(R.id.motorButton7);
        motorButtons[7] = rootView.findViewById(R.id.motorButton8);
        motorButtons[8] = rootView.findViewById(R.id.motorButton9);
        motorButtons[9] = rootView.findViewById(R.id.motorButton10);
        motorButtons[10] = rootView.findViewById(R.id.motorButton11);
        motorButtons[11] = rootView.findViewById(R.id.motorButton12);
        motorButtons[12] = rootView.findViewById(R.id.motorButton13);
        motorButtons[13] = rootView.findViewById(R.id.motorButton14);
        motorButtons[14] = rootView.findViewById(R.id.motorButton15);
        motorButtons[15] = rootView.findViewById(R.id.motorButton16);
        motorButtons[16] = rootView.findViewById(R.id.motorButton17);
        motorButtons[17] = rootView.findViewById(R.id.motorButton18);
        motorButtons[18] = rootView.findViewById(R.id.motorButton19);
        motorButtons[19] = rootView.findViewById(R.id.motorButton20);
        motorButtons[20] = rootView.findViewById(R.id.motorButton21);
        motorButtons[21] = rootView.findViewById(R.id.motorButton22);
        motorButtons[22] = rootView.findViewById(R.id.motorButton23);
        motorButtons[23] = rootView.findViewById(R.id.motorButton24);

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
                Log.i(TAG, "Intensity: " + intensity);

                if(motorNum <= 7){
                    if(intensity > -128) motorButtons[motorNum].setImageDrawable(getResources().getDrawable(R.drawable.motorgrossan));
                    else motorButtons[motorNum].setImageDrawable(getResources().getDrawable(R.drawable.motorgrossaus));
                }

                else{
                    if(intensity > -128) motorButtons[motorNum].setImageDrawable(getResources().getDrawable(R.drawable.motorkleinan));
                    else motorButtons[motorNum].setImageDrawable(getResources().getDrawable(R.drawable.motorkleinaus));
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


