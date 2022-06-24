package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ipbeja.pac.roteirosturisticosdebeja.viewModels.InitialViewModel;
import ipbeja.pac.roteirosturisticosdebeja.R;

public class InitialFragment extends Fragment {

    private InitialViewModel mViewModel;
    private Context context;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_initial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InitialViewModel.class);
        context = this.getContext();

        Button buttonToMain = view.findViewById(R.id.buttonGoMain);
        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = InitialFragmentDirections.actionInicialFragmentToMainFragment();
                NavHostFragment.findNavController(InitialFragment.this).navigate(navDirections);
            }
        });
    }
}