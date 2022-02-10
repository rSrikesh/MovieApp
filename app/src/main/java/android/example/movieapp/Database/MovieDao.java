package android.example.movieapp.Database;

import android.example.movieapp.Models.FavMovie;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM favmovie WHERE uEmail = :email")
    List<FavMovie> getFavMovies(String email);

    @Insert
    void insertMovie(FavMovie... movie);

    @Query("DELETE FROM favmovie where mID = :ID and uEmail = :email")
    void deleteMovie(int ID,String email);

    @Query("SELECT * from favmovie WHERE mID = :ID and uEmail = :email")
    List<FavMovie> searchMovie(int ID,String email);
}
