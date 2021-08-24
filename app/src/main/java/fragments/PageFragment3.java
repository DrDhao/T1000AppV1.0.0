package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t1000appv100.MainActivity;
import com.example.t1000appv100.R;

public class PageFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_3, container, false);




        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        ((MainActivity) getActivity()).setMotorData(null);
    }

}