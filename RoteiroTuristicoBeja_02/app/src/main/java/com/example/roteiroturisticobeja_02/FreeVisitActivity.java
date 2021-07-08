package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class FreeVisitActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_visit);

        recyclerView = findViewById(R.id.recyclerSingle);

        RecyclerSingleAdapter adapter = new RecyclerSingleAdapter(this, AppDatabase.getInstance(this).getMonumentDAO().getAll());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}