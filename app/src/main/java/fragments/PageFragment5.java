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

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.MassageProgramHandler;
import com.example.t1000appv100.MyFragment;
import com.example.t1000appv100.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PageFragment5 extends Fragment implements MyFragment {
    private static PageFragment5 instance;
    private ViewGroup rootView;
    private MainActivity main;
    ImageButton seatButtonCenter;
    ImageButton seatButtonLeft;
    Button tallPersonBtn;
    Button littlePersonBtn;
    TextView breathText;
    ScheduledExecutorService executorService;
    private int breatheTimeInSeconds = 3;
    private boolean isTall = false;

    public boolean isTall() {
        return isTall;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        instance = this;
        rootView = (ViewGroup) inflater.inflate(R.layout.page_5, container, false);
        main = ((MainActivity) getActivity());
        seatButtonCenter = rootView.findViewById(R.id.seatButtonCenterFrg5);
        seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg5);
        tallPersonBtn = rootView.findViewById(R.id.buttonTallPerson);
        littlePersonBtn = rootView.findViewById(R.id.buttonLittlePerson);
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
            breathText.setVisibility(View.INVISIBLE);
            stop();
        });

        tallPersonBtn.setOnClickListener(view ->{
            tallPersonBtn.setBackgroundColor(Color.parseColor("#018786"));
            littlePersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
            breathText.setVisibility(View.VISIBLE);
            startBreath(true);
        });
        littlePersonBtn.setOnClickListener(view ->{
            littlePersonBtn.setBackgroundColor(Color.parseColor("#018786"));
            tallPersonBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
            breathText.setVisibility(View.VISIBLE);
            startBreath(false);
        });
        return rootView;
    }

    private void startBreath(boolean isTall){
        this.isTall = isTall;
        MassageProgramHandler.getInstance().startMassage(5);
    }


    //GETTER, SETTER & STOP
    public static PageFragment5 getInstance() {
        return instance;
    }

    @Override
    public void stop() {
        executorService.shutdownNow();
        executorService = null;
    }
}