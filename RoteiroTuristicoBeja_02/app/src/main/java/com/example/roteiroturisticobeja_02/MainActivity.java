package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button buttonGroup;
    Button buttonSingle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recycleView);
        buttonGroup = findViewById(R.id.btnGroup);
        buttonSingle = findViewById(R.id.btnSingle);

        MonumentAdapter myAdapter = new MonumentAdapter(this, AppDatabase.getInstance(this).getMonumentDAO().getAll());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GroupActivity.class));
            }
        });

        buttonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleActivity.class));
            }
        });
    }
}

//https://www.youtube.com/watch?v=18VcnYN5_LM
//https://www.youtube.com/watch?v=xgpLYwEmlO0