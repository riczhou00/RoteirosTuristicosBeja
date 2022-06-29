package ipbeja.pac.roteirosturisticosdebeja.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.models.AppRepository;
import ipbeja.pac.roteirosturisticosdebeja.models.Comments;
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

    public void addLike(long id){
        this.appRepository.addLike(id);
    }

    public void addDislike(long id){
        this.appRepository.addDislike(id);
    }

    public LiveData<List<Comments>> getCommentsById(long id){
        return this.appRepository.getCommentsById(id);
    }

    public void addComment(Comments comments){
        this.appRepository.addComment(comments);
    }
}