package fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.t1000appv100.MassageProgramHandler;
import com.example.t1000appv100.MyFragment;
import com.example.t1000appv100.R;


public class PageFragment5 extends Fragment implements MyFragment {
    private static PageFragment5 instance;


    TextView breathText;
    private boolean isTall = false;
    private boolean isTextBreathIn = true;
    private boolean isBtnTallPressed = false;
    private boolean isBtnLittlePressed = false;


    public boolean isTall() {
        return isTall;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        instance = this;
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page_5, container, false);

        ImageButton seatButtonCenter = rootView.findViewById(R.id.seatButtonCenterFrg5);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg5);
        Button tallPersonBtn = rootView.findViewById(R.id.buttonTallPerson);
        Button littlePersonBtn = rootView.findViewById(R.id.buttonLittlePerson);
        breathText = rootView.findViewById(R.id.atmenTextView);

        seatButtonCenter.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.VISIBLE);
            seatButtonLeft.setClickable(true);
            seatButtonCenter.setVisibility(View.INVISIBLE);
            seatButtonCenter.setClickable(false);
            tallPersonBtn.setVisibility(View.VISIBLE);
            tallPersonBtn.setClickable(true);
            littlePersonBtn.setVisibility(View.VISIBLE);
            littlePersonBtn.setClickable(true);
        });
        seatButtonLeft.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.INVISIBLE);
            seatButtonLeft.setClickable(false);
            seatButtonCenter.setVisibility(View.VISIBLE);
            seatButtonCenter.setClickable(true);
            tallPersonBtn.setVisibility(View.INVISIBLE);
            tallPersonBtn.setClickable(false);
            tallPersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
            littlePersonBtn.setVisibility(View.INVISIBLE);
            littlePersonBtn.setClickable(false);
            littlePersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
            isBtnLittlePressed = false;
            isBtnTallPressed = false;
            breathText.setVisibility(View.INVISIBLE);
            stop();
        });

        tallPersonBtn.setOnClickListener(view ->{
            if(!isBtnTallPressed){
                tallPersonBtn.setBackgroundColor(Color.parseColor("#018786"));
                littlePersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
                breathText.setVisibility(View.VISIBLE);
                isBtnTallPressed = true;
                startBreath(true);
            } else {
                tallPersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
                breathText.setVisibility(View.INVISIBLE);
                isBtnTallPressed = false;
                stop();
            }

        });
        littlePersonBtn.setOnClickListener(view ->{
            if (!isBtnLittlePressed){
                littlePersonBtn.setBackgroundColor(Color.parseColor("#018786"));
                tallPersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
                breathText.setVisibility(View.VISIBLE);
                isBtnLittlePressed = true;
                startBreath(false);
            } else {
                littlePersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
                breathText.setVisibility(View.INVISIBLE);
                isBtnLittlePressed = false;
                stop();
            }

        });
        return rootView;
    }

    private void startBreath(boolean isTall){
        this.isTall = isTall;
        isTextBreathIn = true;
        MassageProgramHandler.getInstance().startMassage(7);
    }


    //GETTER, SETTER & STOP
    public static PageFragment5 getInstance() {
        return instance;
    }



    public void switchBreathText(){
        if(isTextBreathIn){
            breathText.setText("");
            isTextBreathIn = false;
        }else{
            breathText.setText("Einatmen");
            isTextBreathIn = true;
        }

    }

    @Override
    public void stop() {

    }
}