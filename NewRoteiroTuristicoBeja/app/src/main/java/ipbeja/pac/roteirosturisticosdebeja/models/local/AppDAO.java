package ipbeja.pac.roteirosturisticosdebeja.models.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ipbeja.pac.roteirosturisticosdebeja.models.Comments;
import ipbeja.pac.roteirosturisticosdebeja.models.Monuments;
import ipbeja.pac.roteirosturisticosdebeja.models.User;

@Dao
public interface AppDAO {
    @Query("SELECT * FROM Monuments")
    List<Monuments> getAllMonuments();

    @Query("SELECT * FROM Monuments WHERE id =:id ")
    Monuments getMonumentByID(long id);

    @Query("SELECT * FROM Comments WHERE monument_id =:monument_id")
    List<Comments> getCommentsByMonumentsId(long monument_id);

    @Insert
    void addComment(Comments comments);

    @Query("UPDATE Monuments SET likes = likes + 1 WHERE id=:id")
    void addLike(long id);

    @Query("UPDATE Monuments SET dislikes = dislikes + 1 WHERE id=:id")
    void addDislike(long id);

    @Query("SELECT * FROM User WHERE email =:email AND password =:password")
    User getUserByCredentials(String email,String password);

    @Query("SELECT * FROM User WHERE email =:email")
    User getUserByEmail(String email);

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM User WHERE id =:user_id")
    User getUserById(long user_id);
}
