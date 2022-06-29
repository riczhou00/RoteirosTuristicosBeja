package ipbeja.pac.roteirosturisticosdebeja.models.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ipbeja.pac.roteirosturisticosdebeja.models.Comments;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;

@Database(entities = {Comments.class, Monuments.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppDAO getAppDAO();
    private static AppDataBase INSTANCE;
    public static AppDataBase getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"roteirosDB").allowMainThreadQueries().addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Castelo de Beja','O Castelo de Beja localiza-se no extremo da cidade. Esta fortificação medieval é flanqueada por seis torres, incluindo a de Menage, a mais alta e uma das mais belas do território nacional. Apresenta uma vista fantástica vista sobre a cidade de Beja e a planície alentejana em redor.','https://www.google.com/maps/place/Castelo+de+Beja/@38.0173806,-7.8654667,15z/data=!4m5!3m4!1s0x0:0x3e462a2401c78209!8m2!3d38.0173806!4d-7.8654667',0,0,'https://www.vortexmag.net/wp-content/uploads/2015/06/13435626374_c8e9404f3b_k-e1435264983302.jpg')");
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Museu Regional de Beja', 'O espólio do Museu Regional de Beja está instalado no Convento Nossa Sra. da Conceição desde 1927 e foi ampliado com coleções provenientes de outros conventos e palácios da região. Entre o rico acervo do Museu, um dos mais significativos do país, realçamos o núcleo de pintura, composto por obras de mestres portugueses, espanhóis e holandeses, a secção lapidar, a coleção de Ourivesaria, e a secção de Arqueologia, centrada essencialmente no período romano, muito rico nesta região.','https://www.google.com/maps/place/Museu+Regional+de+Beja+-+Museu+Rainha+Dona+Leonor/@38.0139296,-7.8651233,17z/data=!3m1!4b1!4m5!3m4!1s0xd1a748652400705:0xdc7fe59c017285dd!8m2!3d38.0138877!4d-7.8629768',0,0, 'https://c8.quickcachr.fotos.sapo.pt/i/G3e13310e/17908313_AzP8r.jpeg')");
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Núcleo Museológico de Beja', ' Núcleo Museológico da Rua do Sembrano integra um conjunto de estruturas arqueológicas que permitem, apesar de se tratar de uma área restrita no conjunto da estrutura urbana de Beja, entrever alguns momentos da história desta cidade e o modo como o espaço aqui foi evoluindo. As escavações arqueológicas, efetuadas durante as décadas de 80 e 90 do século XX, colocaram a descoberto vestígios que se estendem, cronologicamente, desde a Pré-História até à Época Contemporânea.','https://www.google.com/maps/place/N%C3%BAcleo+Museol%C3%B3gico+da+Rua+do+Sembrano/@38.0149691,-7.8766299,15z/data=!4m5!3m4!1s0xd1a7487af6b3977:0xfe0ed76e3129dda1!8m2!3d38.013364!4d-7.8639659',0,0, 'https://images.turismoenportugal.org/Nucleo-Museologico-da-Rua-do-Sembrano-Beja.jpg')");
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Museu Visigótico de Beja', 'A coleção visigótica do Museu Regional de Beja, constitui o núcleo de peças desta época mais importante do país, tendo motivado para Beja a designação de “Capital da Arte Visigótica em Portugal”. O espólio foi sendo recolhido ao longo de várias dezenas de anos por diversos especialistas, dos quais é justo destacar o nome do arqueólogo Abel Viana.','https://www.google.com/maps/place/N%C3%BAcleo+Visig%C3%B3tico+do+Museu+Regional+de+Beja+-+Igreja+de+Santo+Amaro/@38.0176036,-7.8683195,17z/data=!3m1!4b1!4m5!3m4!1s0xd1a7484127f9bf7:0x8bd18a3418a5f521!8m2!3d38.0175889!4d-7.8661818',0,0, 'https://cdn.visitportugal.com/sites/default/files/styles/encontre_detalhe_poi_destaque/public/mediateca/N4.MON1533d.jpg?itok=yh405U3x')");
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Ruínas Romanas de Pisões de Beja', 'A villa romana de Pisões foi acidentalmente descoberta em Fevereiro de 1967, no decurso de trabalhos agrícolas, tendo as escavações arqueológicas então iniciadas revelado uma villa de grande interesse do ponto de vista do património histórico. Subsistem, no Alentejo, inúmeros testemunhos arqueológicos destas estruturas agrárias romanas, designadas por villae, que caracterizam um tipo de ocupação e exploração agrícola do território.','https://www.google.pt/maps/place/Villa+Romana+de+Pis%C3%B5es/@37.9958681,-7.9504931,15z/data=!4m5!3m4!1s0xd1a727ad904581f:0x7f231532b8b0f64d!8m2!3d37.9975984!4d-7.9492726?hl=pt-PT',0,0, 'https://cm-beja.pt/util/imgLoader2.ashx?img=/upload_files/client_id_1/website_id_1/Villa%20Romana%20de%20Pis%C3%B5es/rui%CC%81nas-romanas-piso%CC%83es-hipocausto-2.jpg')");
                    db.execSQL("INSERT INTO Monuments (monument_name,monument_descriptions,coordinates,likes,dislikes,image) VALUES ('Casa de Santa Vitória de Beja', 'A Santa Vitória é uma empresa do Grupo Vila Galé que produz vinhos e azeites alentejanos de qualidade superior. Fundada em 2002, e fruto de uma paixão pelas vinhas e olival da terra que a fez nascer, desde o início pretende colher e criar com paixão e rigor o que de melhor se produz no Alentejo.','https://www.google.pt/maps/place/Casa+Santa+Vit%C3%B3ria/@37.9116293,-7.940598,12z/data=!4m12!1m6!3m5!1s0xd1a6f6bfdc13279:0x48aeb0228136e4ef!2sCasa+Santa+Vit%C3%B3ria!8m2!3d37.8911337!4d-8.0203347!3m4!1s0xd1a6f6bfdc13279:0x48aeb0228136e4ef!8m2!3d37.8911337!4d-8.0203347?hl=pt-PT',0,0, 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/cc/1f/73/vila-gake-clube-de-campo.jpg?w=1200')");
                }
            }).build();
        }
        return INSTANCE;
    }
}
