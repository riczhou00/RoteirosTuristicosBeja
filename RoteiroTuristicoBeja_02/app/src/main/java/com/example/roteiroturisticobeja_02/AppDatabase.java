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
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('1', 'Castelo de Beja', 'O Castelo de Beja localiza-se no extremo da cidade. Esta fortificação medieval é flanqueada por seis torres, incluindo a de Menage, a mais alta e uma das mais belas do território nacional. Apresenta uma vista fantástica vista sobre a cidade de Beja e a planície alentejana em redor.', 'https://www.vortexmag.net/wp-content/uploads/2015/06/13435626374_c8e9404f3b_k-e1435264983302.jpg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('2', 'Museu Regional de Beja', 'O espólio do Museu Regional de Beja está instalado no Convento Nossa Sra. da Conceição desde 1927 e foi ampliado com coleções provenientes de outros conventos e palácios da região. Entre o rico acervo do Museu, um dos mais significativos do país, realçamos o núcleo de pintura, composto por obras de mestres portugueses, espanhóis e holandeses, a secção lapidar, a coleção de Ourivesaria, e a secção de Arqueologia, centrada essencialmente no período romano, muito rico nesta região.', 'https://c8.quickcachr.fotos.sapo.pt/i/G3e13310e/17908313_AzP8r.jpeg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('3', 'Núcleo Museológico', ' Núcleo Museológico da Rua do Sembrano integra um conjunto de estruturas arqueológicas que permitem, apesar de se tratar de uma área restrita no conjunto da estrutura urbana de Beja, entrever alguns momentos da história desta cidade e o modo como o espaço aqui foi evoluindo. As escavações arqueológicas, efetuadas durante as décadas de 80 e 90 do século XX, colocaram a descoberto vestígios que se estendem, cronologicamente, desde a Pré-História até à Época Contemporânea.', 'https://images.turismoenportugal.org/Nucleo-Museologico-da-Rua-do-Sembrano-Beja.jpg')");
                            db.execSQL("INSERT INTO Monuments (id, monument_name, description, image) VALUES ('4', 'Museu Visigótico', 'A coleção visigótica do Museu Regional de Beja, constitui o núcleo de peças desta época mais importante do país, tendo motivado para Beja a designação de “Capital da Arte Visigótica em Portugal”. O espólio foi sendo recolhido ao longo de várias dezenas de anos por diversos especialistas, dos quais é justo destacar o nome do arqueólogo Abel Viana.', 'https://cdn.visitportugal.com/sites/default/files/styles/encontre_detalhe_poi_destaque/public/mediateca/N4.MON1533d.jpg?itok=yh405U3x')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
   }