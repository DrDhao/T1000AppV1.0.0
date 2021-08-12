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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.t1000appv100.R;

public class PageFragment1 extends Fragment {

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
        Button button1 = rootView.findViewById(R.id.button1);

        imageButton10.setOnClickListener(view -> {
        imageButton10.setVisibility(View.INVISIBLE);
        imageButton10.setClickable(false);
        imageButton11.setVisibility(View.VISIBLE);
        imageButton11.setClickable(true);
        seekBar.setVisibility(View.VISIBLE);
        seekBar.setClickable(true);
        textView1.setVisibility(View.VISIBLE);

        });
        imageButton11.setOnClickListener(view -> {
            imageButton11.setVisibility(View.INVISIBLE);
            imageButton11.setClickable(false);
            imageButton10.setVisibility(View.VISIBLE);
            imageButton10.setClickable(true);
            seekBar.setVisibility(View.INVISIBLE);
            seekBar.setClickable(false);
            textView1.setVisibility(View.INVISIBLE);
        });



        return rootView;
    }



    
}


