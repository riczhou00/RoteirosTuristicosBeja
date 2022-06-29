package ipbeja.pac.roteirosturisticosdebeja.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import ipbeja.pac.roteirosturisticosdebeja.models.AppRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;

public class MonumentViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    public MonumentViewModel(@NonNull Application application) {
        super(application);
        this.appRepository = new AppRepository(application.getApplicationContext());
    }
    public LiveData<Monuments> getMonumentById(long id){
        return this.appRepository.getMonumentByID(id);
    }
}