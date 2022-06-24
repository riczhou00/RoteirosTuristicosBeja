package ipbeja.pac.roteirosturisticosdebeja.models.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ipbeja.pac.roteirosturisticosdebeja.models.Comments;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;

@Database(entities = {Comments.class, Monuments.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppDAO getAppDAO();
    private static AppDataBase INSTANCE;
    public static AppDataBase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"roteirosDB").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
