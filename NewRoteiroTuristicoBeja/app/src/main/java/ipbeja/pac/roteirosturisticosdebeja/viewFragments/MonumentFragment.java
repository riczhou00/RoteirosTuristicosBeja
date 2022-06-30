package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.tts.TextToSpeech;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.MapView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Locale;

import ipbeja.pac.roteirosturisticosdebeja.models.Comments;
import ipbeja.pac.roteirosturisticosdebeja.models.CommentsAdapter;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;
import ipbeja.pac.roteirosturisticosdebeja.viewModels.MonumentViewModel;
import ipbeja.pac.roteirosturisticosdebeja.R;

public class MonumentFragment extends Fragment implements TextToSpeech.OnInitListener {

    private MonumentViewModel mViewModel;
    private Context context;
    private Activity activity;
    private TextToSpeech textToSpeech;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonumentViewModel.class);
        this.context = this.getContext();
        this.activity = this.getActivity();

        Toolbar toolbar = view.findViewById(R.id.toolBarMonument);
        long monumentid = MonumentFragmentArgs.fromBundle(getArguments()).getId();
        mViewModel.getMonumentById(monumentid).observe(getViewLifecycleOwner(), new Observer<Monuments>() {
            @Override
            public void onChanged(Monuments monuments) {
                toolbar.setTitle(monuments.getMonument_name());
            }
        });

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView imageMonument = view.findViewById(R.id.imgViewMonument);
        TextView textViewMonumentName = view.findViewById(R.id.txtViewMonumentName);
        Button likeMonument = view.findViewById(R.id.btnLikeMonument);
        Button dislikeMonument = view.findViewById(R.id.btnDislikeMonument);
        TextView textViewMonumentDiscription = view.findViewById(R.id.txtViewMonumentDescription);
        textViewMonumentDiscription.setMovementMethod(new ScrollingMovementMethod());
        RecyclerView recyclerView = view.findViewById(R.id.recyViewComments);

        EditText editTextComment = view.findViewById(R.id.edtTxtComment);
        ImageButton imgBtnAddComment = view.findViewById(R.id.imgBtnSendComment);
        FloatingActionButton floatBtnTxtSpeek = view.findViewById(R.id.flotBtnTxtSpeek);
        FloatingActionButton floatBtnGoogleMaps = view.findViewById(R.id.flotBtnMap);

        ScrollView scrollView = view.findViewById(R.id.scrollView);

        CommentsAdapter adapter = new CommentsAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        mViewModel.getCommentsById(monumentid).observe(getViewLifecycleOwner(), new Observer<List<Comments>>() {
            @Override
            public void onChanged(List<Comments> comments) {
                adapter.updateList(comments);
            }
        });

        mViewModel.getMonumentById(monumentid).observe(getViewLifecycleOwner(), new Observer<Monuments>() {
            @Override
            public void onChanged(Monuments monuments) {
                Glide.with(context).load(monuments.getImage()).into(imageMonument);
                textViewMonumentName.setText(monuments.getMonument_name());

                if (monuments.getLikes() > 0) {
                    likeMonument.setText(String.valueOf(monuments.getLikes()));
                }else {
                    likeMonument.setText("Gosto");
                }
                if (monuments.getDislikes() > 0) {
                    dislikeMonument.setText(String.valueOf(monuments.getDislikes()));
                }else {
                    dislikeMonument.setText("Não Gosto");
                }

                textViewMonumentDiscription.setText(monuments.getMonument_descriptions());

            }
        });

        likeMonument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likes = mViewModel.getMonumentById(monumentid).getValue().getLikes();
                mViewModel.addLike(monumentid);
                likeMonument.setText(String.valueOf(likes+1));
            }
        });


        dislikeMonument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dislikes = mViewModel.getMonumentById(monumentid).getValue().getDislikes();
                mViewModel.addDislike(monumentid);
                dislikeMonument.setText(String.valueOf(dislikes+1));
            }
        });

        imgBtnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextComment.getText().toString().isEmpty()) {
                    long monumentID = mViewModel.getMonumentById(monumentid).getValue().getId();
                    Comments comments = new Comments(0,monumentID,editTextComment.getText().toString());
                    mViewModel.addComment(comments);
                    adapter.addToList(comments);
                    editTextComment.setText("");
                }
            }
        });

        textToSpeech = new TextToSpeech(context,this);

        floatBtnTxtSpeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monumentDesc = mViewModel.getMonumentById(monumentid).getValue().getMonument_descriptions();
                speak(monumentDesc);
            }
        });

        floatBtnGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monumentMaps = mViewModel.getMonumentById(monumentid).getValue().getCoordinates();
                Uri gmmIntentUri = Uri.parse(monumentMaps);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                textViewMonumentDiscription.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });

        textViewMonumentDiscription.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                textViewMonumentDiscription.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

    }

    private void speak(String monumentDesc) {
        textToSpeech.speak(monumentDesc,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(new Locale("pt","PT"));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
    }
}