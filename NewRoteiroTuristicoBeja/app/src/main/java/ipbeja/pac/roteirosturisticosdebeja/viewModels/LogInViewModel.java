package ipbeja.pac.roteirosturisticosdebeja.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import ipbeja.pac.roteirosturisticosdebeja.models.AppRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.SessionRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.User;

public class LogInViewModel extends AndroidViewModel {

    private SessionRepository sessionRepository;
    private AppRepository appRepository;

    public LogInViewModel(@NonNull Application application) {
        super(application);
        this.sessionRepository = new SessionRepository(application.getApplicationContext());
        this.appRepository = new AppRepository(application.getApplicationContext());
    }

    public LiveData<User> getUserByCredentials(String email, String password){
        return appRepository.getUserByCredentials(email, password);
    }

    public void saveSession(User user){
        sessionRepository.saveSession(user);
    }

    public void addUser(User user){
        appRepository.addUser(user);
    }
}