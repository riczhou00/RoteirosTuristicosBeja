package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class FreeVisitActivity extends AppCompatActivity {
    private static final String KEY_MONUID = "monuId";
    private static final String TAG = "SecondActivity";

    RecyclerView recyclerView;

    public static void startActivity(Context context, long monuId) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_MONUID, monuId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_visit);

        recyclerView = findViewById(R.id.recyclerFreeVisit);

        RecyclerSingleAdapter adapter = new RecyclerSingleAdapter(this, AppDatabase.getInstance(this).getMonumentDAO().getAll());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}