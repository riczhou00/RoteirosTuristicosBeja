package ipbeja.pac.roteirosturisticosdebeja.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.models.AppRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;
import ipbeja.pac.roteirosturisticosdebeja.models.SessionRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.User;

public class InitialViewModel extends AndroidViewModel {

    private SessionRepository sessionRepository;

    public InitialViewModel(@NonNull Application application) {
        super(application);
        this.sessionRepository = new SessionRepository(application.getApplicationContext());
    }

    public User getActiveSession(){
        return sessionRepository.getActiveSession();
    }
}