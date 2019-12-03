package com.example.individualproject.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.individualproject.CustomAdapter;
import com.example.individualproject.R;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    Button button;
    HashMap<String,String>map =new HashMap<>();
    CustomAdapter mAdapter;
    EditText ET;
    RecyclerView recyclerView;
    String TX;
    boolean FeverSearch;
    boolean ColdSearch;
    boolean runnybiseSearch;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ET = view.findViewById(R.id.ET);
        recyclerView = view.findViewById(R.id.search_recycler);
        button = view.findViewById(R.id.input);



        map.put("Antipyretic","코덱신정,루니펜,리리스정,클로니펜,레펜콜,푸로콜에스캡슐,에코리자정,한신타미놀캡,렉스판정,뉴트라");
        map.put("Respiratory","하나인산코데인정,비씨인산코데인,명문인산코데인정,구주인산코데인정정,가이콜캡,감콜캡슐,헤로스판");
        map.put("Inflammation","가단,가스칸정,가스타놀정,게스타렌,광동플루비펜플루스타,록소날,록소나린,사조핀,살라진");
        map.put("headache","가이콜캡슐,가이펜캡슐,라니린에이정,레피콜에이캡슐,러지코정,메가텐정,코에드애프정,올판토에프정");

        final String[]Antipyretic;
        final String[]Respiratory;
        final String[]Inflammation;
        String[]Headache;


        Antipyretic= map.get("Antipyretic").split(",");
        Inflammation =map.get("Inflammation").split(",");
        Respiratory = map.get("Respiratory").split(",");
        Headache = map.get("headache").split(",");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TX = ET.getText().toString();

                FeverSearch = TX.contains("열");
                ColdSearch = TX.contains("기침");
                runnybiseSearch = TX.contains("가레");
                runnybiseSearch = TX.contains("콧물");


                if (FeverSearch){

                    mAdapter  = new CustomAdapter(Antipyretic);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }
                else if (ColdSearch){

                    mAdapter = new CustomAdapter(Inflammation);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                }
                else if (runnybiseSearch){
                    mAdapter = new CustomAdapter(Respiratory);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }




            }
        });





        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());


        recyclerView.setLayoutManager(mLinearLayoutManager);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);




        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),mLinearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);





        // Inflate the layout for this fragment
        return view;
    }

}
