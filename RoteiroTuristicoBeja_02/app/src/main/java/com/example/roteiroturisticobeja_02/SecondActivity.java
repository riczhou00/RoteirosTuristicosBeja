package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    private static final String KEY_MONUID = "monuId";
    private static final String TAG = "SecondActivity";

    private Monuments monuments;
    
    private ImageView mainImageView;
     private TextView title, description;

    public static void startActivity(Context context, long monuId) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_MONUID, monuId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long monuId = bundle.getLong(KEY_MONUID, -1);
            if (monuId == -1) {
                Log.e(TAG, "Ivalido!");
                finish();
                return;
            }

            this.monuments = DataSource.getMonument(this, monuId);
            this.title.setText(monuments.getMonument_name());
            this.description.setText(monuments.getDescription());
            Glide.with(this).load(this.monuments.getImage()).into(this.mainImageView);
        }
    }
}