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

    public void addLike(long id){
        appDAO.addLike(id);
    }

    public void addDislike(long id){
        appDAO.addDislike(id);
    }

    public LiveData<List<Comments>> getCommentsById(long id){
        MutableLiveData<List<Comments>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(appDAO.getCommentsByMonumentsId(id));
        return mutableLiveData;
    }

    public void addComment(Comments comments){
        appDAO.addComment(comments);
    }

    public LiveData<User> getUserByCredentials(String email, String password){
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        User user = appDAO.getUserByCredentials(email,password);
        if (user != null) {
            mutableLiveData.setValue(user);
        }else {
            mutableLiveData.setValue(null);
        }
        return mutableLiveData;
    }

    public LiveData<User> getUserByEmail(String email){
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        User user = appDAO.getUserByEmail(email);
        if (user != null) {
            mutableLiveData.setValue(user);
        }else {
            mutableLiveData.setValue(null);
        }
        return mutableLiveData;
    }

    public void addUser(User user){
        appDAO.addUser(user);
    }

    public User getUserById(long user_id) {
        return appDAO.getUserById(user_id);
    }
}
