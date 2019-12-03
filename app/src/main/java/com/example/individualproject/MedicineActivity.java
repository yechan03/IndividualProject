package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class MedicineActivity extends AppCompatActivity {



    HashMap<String,String> map = new HashMap<>();

    TextView textView;

    RecyclerView recyclerView;
    CustomAdapter mAdapter;
    String[] List;
    String medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        Intent intent = getIntent();
        medicine = intent.getStringExtra("medicine");



        map.put("Antipyretic","코덱신정,루니펜,리리스정,클로니펜,레펜콜,푸로콜에스캡슐,에코리자정,한신타미놀캡,렉스판정,뉴트라");
        map.put("Respiratory","하나인산코데인정,비씨인산코데인,명문인산코데인정,구주인산코데인정정,가이콜캡,감콜캡슐,헤로스판");
        map.put("Inflammation","가단,가스칸정,가스타놀정,게스타렌,광동플루비펜플루스타,록소날,록소나린,사조핀,살라진");
        map.put("headache","가이콜캡슐,가이펜캡슐,라니린에이정,레피콜에이캡슐,러지코정,메가텐정,코에드애프정,올판토에프정");

        //출처:약학정보원

        String[]Antipyretic;
        String[]Respiratory;
        String[]Inflammation;
        String[]Headache;


        Antipyretic= map.get("Antipyretic").split(",");
        Inflammation =map.get("Inflammation").split(",");
        Respiratory = map.get("Respiratory").split(",");
        Headache = map.get("headache").split(",");


        textView = findViewById(R.id.TV);



        switch (medicine){
            case "Fever":
                textView.setText("열이 심하면 다음과 같은 약을 먹으면 좋습니다 추천음식은 :인동차(로니세라티),생강죽,호박등 입니다");
               mAdapter = new CustomAdapter(Antipyretic);
                mAdapter.notifyDataSetChanged();
                break;
            case "Inflammation":
                textView.setText("기침이 심하면 다음과 같은 약을 먹으면 좋습니다 추천음식은:도라지,무,은행,모,오미자,생강차 등입니다");
                mAdapter = new CustomAdapter(Inflammation);
                mAdapter.notifyDataSetChanged();
                break;
            case "cold":
                textView.setText("가래와 콧물이 심하면 다음과 같은 약을 먹으면 좋습니다 추천음식은:파인애플,자몽,수박,허브,마늘,샐러리,양파 등이있습니다");
                mAdapter = new CustomAdapter(Respiratory);
                mAdapter.notifyDataSetChanged();
                break;

            case "headache":
                textView.setText("두통등이 심하면 다음과 깥은 약ㄱ을 먹으면 좋습니다 추천음식은 :바나나,아몬드,커피,연어,버섯,시금치 입니다");
                mAdapter = new CustomAdapter(Headache);
                mAdapter.notifyDataSetChanged();
                break;


        }


        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);


        recyclerView.setLayoutManager(mLinearLayoutManager);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),mLinearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



    }
}
