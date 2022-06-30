package ipbeja.pac.roteirosturisticosdebeja.models;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "NAME";
    private Context context;
    private static SharedPreferences sharedPreferences;

    private static SharedPreferences getInstance(Context context){
        if (sharedPreferences == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences("Pref",0);
        }
        return sharedPreferences;
    }

    public static User getActiveSession(Context context){
        if (getInstance(context).contains(KEY_ID)) {
            return new User(getInstance(context).getLong(KEY_ID,0),getInstance(context).getString(KEY_NAME,""),null,null);
        }
        return null;
    }

    public static void saveSession(Context context, User user){
        getInstance(context).edit().putLong(KEY_ID,user.getId()).apply();
        getInstance(context).edit().putString(KEY_NAME, user.getName()).apply();
    }

    public static void clearSession(Context contex){
        getInstance(contex).edit().clear().apply();
    }
}
