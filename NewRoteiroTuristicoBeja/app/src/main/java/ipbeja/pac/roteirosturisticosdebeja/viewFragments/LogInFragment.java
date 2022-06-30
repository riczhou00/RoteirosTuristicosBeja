package ipbeja.pac.roteirosturisticosdebeja.viewFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
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
import android.widget.EditText;
import android.widget.Toast;

import ipbeja.pac.roteirosturisticosdebeja.models.User;
import ipbeja.pac.roteirosturisticosdebeja.viewModels.LogInViewModel;
import ipbeja.pac.roteirosturisticosdebeja.R;

public class LogInFragment extends Fragment {

    private LogInViewModel mViewModel;
    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LogInViewModel.class);
        this.context = this.getContext();

        Toolbar toolbar = view.findViewById(R.id.toolBarLogIn);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Entrar");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText editTextEmail = view.findViewById(R.id.edtEditEmail);
        EditText editTextPassword = view.findViewById(R.id.edittxtPassword);
        Button buttonLogin = view.findViewById(R.id.btnLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    mViewModel.getUserByCredentials(email,password).observe(getViewLifecycleOwner(), new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            if (user != null) {
                                mViewModel.saveSession(user);
                                NavDirections navDirections = LogInFragmentDirections.actionLogInFragmentToMainFragment(user.getId());
                                NavHostFragment.findNavController(LogInFragment.this).navigate(navDirections);
                            }else {
                                Toast.makeText(context,"Erro! Email/Password incorretos",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(context,"Erro! Campo/s vazio/s",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}