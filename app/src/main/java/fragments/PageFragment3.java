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

public class PageFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_3, container, false);
//Deklarartion der UI Objekte
        ImageButton seatRight = rootView.findViewById(R.id.seatButtonRightFrg3);
        ImageButton seatLeft = rootView.findViewById(R.id.seatButtonLeftFrg3);
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
        Button typeButton1 = rootView.findViewById(R.id.typeButton1);
        Button typeButton2 = rootView.findViewById(R.id.typeButton2);
        Button typeButton3 = rootView.findViewById(R.id.typeButton3);
        TextView textViewSpeed = rootView.findViewById(R.id.textViewSpeed);
        TextView textViewIntensity = rootView.findViewById(R.id.textViewIntensity);
        TextView textViewTime = rootView.findViewById(R.id.textViewTime);
        SeekBar seekBarSpeed = rootView.findViewById(R.id.seekBarSpeed);
        SeekBar seekBarIntensity = rootView.findViewById(R.id.seekBarIntensity);
        SeekBar seekBarTime = rootView.findViewById(R.id.seekBarTime);
        Button startButton = rootView.findViewById(R.id.startButton);












        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) getActivity()).setMotorData(null);
    }

}