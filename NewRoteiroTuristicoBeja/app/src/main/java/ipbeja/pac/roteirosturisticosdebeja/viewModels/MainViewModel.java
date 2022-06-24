package ipbeja.pac.roteirosturisticosdebeja.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.models.AppRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;

public class MainViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.appRepository = new AppRepository(application.getApplicationContext());
    }
    public LiveData<List<Monuments>> getAllMonuments(){
        return this.appRepository.getAllMonuments();
    }
}