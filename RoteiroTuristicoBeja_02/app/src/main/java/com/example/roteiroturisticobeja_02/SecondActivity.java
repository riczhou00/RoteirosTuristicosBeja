package com.example.roteiroturisticobeja_02;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private static final String KEY_MONUID = "monuId";
    private static final String TAG = "SecondActivity";

    private Monuments monuments;

    private ImageView mainImageView;
    private TextView title, description;
    private TextToSpeech TTs;
    private FloatingActionButton FabTextSpeak;
    private FloatingActionButton FabTextStop;
    private Button btnLaunchMap;

    public static void startActivity(Context context, long monuId) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_MONUID, monuId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        FabTextSpeak = findViewById(R.id.FabTextSpeak);

        FabTextStop = findViewById(R.id.FabTextStop);

        mainImageView = findViewById(R.id.mainImageView);

        TTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                   int result = TTs.setLanguage(new Locale("pt"));

                   if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TextToSpeech", "Language not supported");
                   }
                   else{
                        FabTextSpeak.setEnabled(true);
                   }
                }else{
                    Log.e("TextToSpeech", "Initialization failed");
                }
            }
        });

        title = findViewById(R.id.title);

        description = findViewById(R.id.description);

        btnLaunchMap = findViewById(R.id.launchMap);

        FabTextSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

        FabTextStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TTs.stop();
            }
        });

        btnLaunchMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.0188186178525, -7.861163334897463"));
                Intent choose = Intent.createChooser(intent, "Launch Maps");
                startActivity(choose);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            long monuId = bundle.getLong(KEY_MONUID, -1);
            if (monuId == -1) {
                Log.e(TAG, "Inválido!");
                finish();
                return;
            }

            this.monuments = DataSource.getMonument(this, monuId);
            this.title.setText(monuments.getMonument_name());
            this.description.setText(monuments.getDescription());
            Glide.with(this).load(this.monuments.getImage()).into(this.mainImageView);
        }
    }
    private void speak(){
        String readTitle = title.getText().toString();
        String readDescription = description.getText().toString();

        TTs.speak(readTitle + readDescription, TextToSpeech.QUEUE_FLUSH, null);

    }

}