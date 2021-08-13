package fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.t1000appv100.R;
public class PageFragment2 extends Fragment {

    String[] massagePrograms = {"Welle", "Streicheln", "Baba Massage"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_2, container, false);
        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRightFrg2);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg2);



        seatButtonRight.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.VISIBLE);
            seatButtonLeft.setClickable(true);
            seatButtonRight.setVisibility(View.INVISIBLE);
            seatButtonRight.setClickable(false);
        });

        seatButtonLeft.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.INVISIBLE);
            seatButtonLeft.setClickable(false);
            seatButtonRight.setVisibility(View.VISIBLE);
            seatButtonRight.setClickable(true);
        });








        return rootView;
    }

}
