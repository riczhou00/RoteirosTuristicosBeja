package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.R;
import ipbeja.pac.roteirosturisticosdebeja.models.MainAdapter;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;
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

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMain);
        MainAdapter adapter = new MainAdapter(context, new MainAdapter.OnMonumentClickListener() {
            @Override
            public void onMonumentClick(long id) {
                NavDirections navDirections = MainFragmentDirections.actionMainFragmentToMonumentFragment(id);
                NavHostFragment.findNavController(MainFragment.this).navigate(navDirections);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        mViewModel.getAllMonuments().observe(getViewLifecycleOwner(), new Observer<List<Monuments>>() {
            @Override
            public void onChanged(List<Monuments> monuments) {
                adapter.updateList(monuments);
            }
        });

    }
}