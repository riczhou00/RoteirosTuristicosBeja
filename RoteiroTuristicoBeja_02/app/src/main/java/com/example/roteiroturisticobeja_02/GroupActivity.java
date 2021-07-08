package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class GroupActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_group);

        recyclerView = findViewById(R.id.recyclerGroup);

        RecyclerGroupAdapter adapter = new RecyclerGroupAdapter(this, AppDatabase.getInstance(this).getMonumentDAO().getAll());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}