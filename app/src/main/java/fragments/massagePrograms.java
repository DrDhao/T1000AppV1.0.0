package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.R;

public class massagePrograms extends Fragment {

    MainActivity main = new MainActivity();
    byte motorData[] = new byte[24];
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page_2, container, false);
        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRightFrg2);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg2);







        for (byte i = 0; i < motorData.length; i++) {

            motorData[i] = -128;
        }

        //  startMassage((byte) 2, 0.5f);
        Log.i("massage Programs .jar", "massage Programs. jar: Check");
        return rootView;
    }

    public void startMassage(byte speed, float percent) {
        byte i = 1;

        while (true){
            Log.i("in Methode startMessage", " IN METHODE START MESSAGE");
            motorData[i] = (byte) ((motorData[i] + 2) * percent);
            main.setMotorData(i, motorData[i]);




        }
    }
}

