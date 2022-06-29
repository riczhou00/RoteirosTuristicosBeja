package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.MapView;

import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;
import ipbeja.pac.roteirosturisticosdebeja.viewModels.MonumentViewModel;
import ipbeja.pac.roteirosturisticosdebeja.R;

public class MonumentFragment extends Fragment {

    private MonumentViewModel mViewModel;
    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MonumentViewModel.class);
        this.context = this.getContext();

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

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.getMonumentById(monumentid).observe(getViewLifecycleOwner(), new Observer<Monuments>() {
                    @Override
                    public void onChanged(Monuments monuments) {
                        Uri gmmIntentUri = Uri.parse(monuments.getCoordinates());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                });
            }
        });
    }
}