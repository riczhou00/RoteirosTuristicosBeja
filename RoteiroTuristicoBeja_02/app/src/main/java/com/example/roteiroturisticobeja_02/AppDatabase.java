package com.example.roteiroturisticobeja_02;

import android.content.Context;
import  androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Monuments.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MonumentDAO getMonumentDAO();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "roteiroDB").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('1', 'Castelo de Beja', 'fdeuheiu', 'https://www.vortexmag.net/wp-content/uploads/2015/06/13435626374_c8e9404f3b_k-e1435264983302.jpg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('2', 'Museu Regional de Beja', 'defrdgrggrth', 'https://c8.quickcachr.fotos.sapo.pt/i/G3e13310e/17908313_AzP8r.jpeg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('3', 'Núcleo Museológico', 'efre3eefrefef', 'https://images.turismoenportugal.org/Nucleo-Museologico-da-Rua-do-Sembrano-Beja.jpg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('4', 'Museu Visigótico', 'regtrfgtrgtth', 'https://cdn.visitportugal.com/sites/default/files/styles/encontre_detalhe_poi_destaque/public/mediateca/N4.MON1533d.jpg?itok=yh405U3x')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
   }
