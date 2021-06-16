package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.castelo_de_beja, R.drawable.museu_regional, R.drawable.nucleo, R.drawable.museu_visigotico};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycleView);

        s1 = getResources().getStringArray(R.array.Bem_vindo_a_Beja);
        s2 = getResources().getStringArray(R.array.description);

        MonumentAdapter myAdapter = new MonumentAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

//https://www.youtube.com/watch?v=18VcnYN5_LM
//https://www.youtube.com/watch?v=xgpLYwEmlO0