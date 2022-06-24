package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ipbeja.pac.roteirosturisticosdebeja.R;
import ipbeja.pac.roteirosturisticosdebeja.viewModels.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Context context;
    private Activity activity;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = this.getContext();
        this.activity = this.getActivity();
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Toolbar toolbar = view.findViewById(R.id.toolBarMain);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
    }
}