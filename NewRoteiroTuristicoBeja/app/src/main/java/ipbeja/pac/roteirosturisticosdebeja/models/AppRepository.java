package ipbeja.pac.roteirosturisticosdebeja.models;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.models.local.AppDAO;
import ipbeja.pac.roteirosturisticosdebeja.models.local.AppDataBase;

public class AppRepository {
    private final Context context;
    private AppDAO appDAO;

    public AppRepository(Context context){
        this.context = context;
        appDAO = AppDataBase.getInstance(context).getAppDAO();
    }

    public LiveData<List<Monuments>> getAllMonuments(){
        MutableLiveData<List<Monuments>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(appDAO.getAllMonuments());
        return mutableLiveData;
    }

    public LiveData<Monuments> getMonumentByID(long id){
        MutableLiveData<Monuments> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(appDAO.getMonumentByID(id));
        return mutableLiveData;
    }
}
