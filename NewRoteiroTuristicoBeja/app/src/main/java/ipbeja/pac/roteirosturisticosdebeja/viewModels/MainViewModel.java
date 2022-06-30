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

public class MainViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private SessionRepository sessionRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.appRepository = new AppRepository(application.getApplicationContext());
        this.sessionRepository = new SessionRepository(application.getApplicationContext());
    }
    public LiveData<List<Monuments>> getAllMonuments(){
        return this.appRepository.getAllMonuments();
    }

    public User getActiveSession(){
        return sessionRepository.getActiveSession();
    }

    public void clearSession(){
        sessionRepository.clearSession();
    }
}