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

import ipbeja.pac.roteirosturisticosdebeja.models.User;
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

        User user = mViewModel.getActiveSession();
        if (user != null) {
            NavDirections navDirections = InitialFragmentDirections.actionInicialFragmentToMainFragment(user.getId());
            NavHostFragment.findNavController(InitialFragment.this).navigate(navDirections);
        }

        Button buttonToLogin = view.findViewById(R.id.buttonGoLogIn);
        Button buttonToSignin = view.findViewById(R.id.buttonGoSignIn);
        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = InitialFragmentDirections.actionInicialFragmentToLogInFragment();
                NavHostFragment.findNavController(InitialFragment.this).navigate(navDirections);
            }
        });
        buttonToSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = InitialFragmentDirections.actionInicialFragmentToSignInFragment();
                NavHostFragment.findNavController(InitialFragment.this).navigate(navDirections);
            }
        });
    }
}