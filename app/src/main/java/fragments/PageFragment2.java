package fragments;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.t1000appv100.MassageProgramHandler;
import com.example.t1000appv100.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page_2, container, false);
        ImageButton seatButtonRight = rootView.findViewById(R.id.seatButtonRightFrg2);
        ImageButton seatButtonLeft = rootView.findViewById(R.id.seatButtonLeftFrg2);

        String[] massageProgramList = {
                "Programm 1",
                "Programm 2",
                "Programm 3"
        };

        List<String> massageList = new ArrayList<>(Arrays.asList(massageProgramList));

        ArrayAdapter<String> massageListAdapter = new ArrayAdapter<>(
                getActivity(),  //Die Aktuelle Umgebung Fragment2
                R.layout.massage_list,  //ID der XML-Layout Datei
                R.id.TextMassageList,   //ID des TextViews
                massageList     //Daten in der Array Liste
        );

        ListView massageListView = (ListView) rootView.findViewById(R.id.massageList);
        massageListView.setAdapter(massageListAdapter);


        seatButtonRight.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.VISIBLE);
            seatButtonLeft.setClickable(true);
            seatButtonRight.setVisibility(View.INVISIBLE);
            seatButtonRight.setClickable(false);
            massageListView.setVisibility(View.VISIBLE);
            massageListView.setClickable(true);
        });

        seatButtonLeft.setOnClickListener(view -> {
            seatButtonLeft.setVisibility(View.INVISIBLE);
            seatButtonLeft.setClickable(false);
            seatButtonRight.setVisibility(View.VISIBLE);
            seatButtonRight.setClickable(true);
            massageListView.setVisibility(View.INVISIBLE);
            massageListView.setClickable(false);
            MyProgram.stopMassage();
        });



        massageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int prePosition = -1;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Log.i("Auswahl des Massageprogramms", "Auswahl: " + position);

                MyProgram.startMassage((byte) position);

            }
        });


        return rootView;
    }
}
;
