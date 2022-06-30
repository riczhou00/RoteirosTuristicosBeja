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

import ipbeja.pac.roteirosturisticosdebeja.R;
import ipbeja.pac.roteirosturisticosdebeja.models.User;
import ipbeja.pac.roteirosturisticosdebeja.viewModels.SignInViewModel;

public class SignInFragment extends Fragment {

    private SignInViewModel mViewModel;
    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        this.context = this.getContext();

        Toolbar toolbar = view.findViewById(R.id.toolBarSignIn);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Registar");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText editTextName = view.findViewById(R.id.edtTextNameSignIn);
        EditText editTextEmail = view.findViewById(R.id.edtEditEmailSign);
        EditText editTextPassword = view.findViewById(R.id.edittxtPasswordSign);

        Button btnSignIn = view.findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (!fullname.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    mViewModel.getUserByEmail(email).observe(getViewLifecycleOwner(), new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            if (user == null) {
                                User newUser = new User(0,fullname,email,password);
                                mViewModel.addUser(newUser);
                                User userToSaveSP = mViewModel.getUserByCredentials(newUser.getEmail(), newUser.getPassword()).getValue();
                                mViewModel.saveSession(userToSaveSP);
                                NavDirections navDirections = SignInFragmentDirections.actionSignInFragmentToMainFragment(userToSaveSP.getId());
                                NavHostFragment.findNavController(SignInFragment.this).navigate(navDirections);
                            }else {
                                Toast.makeText(context,"Erro! Email já existente",Toast.LENGTH_SHORT).show();
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