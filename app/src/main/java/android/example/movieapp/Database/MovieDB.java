package android.example.movieapp.Database;

import android.content.Context;
import android.example.movieapp.Models.FavMovie;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavMovie.class},version = 1,exportSchema = false)
public abstract class MovieDB extends RoomDatabase {
    public abstract MovieDao movieDao();

    public static MovieDB INSTANCE;

    public static MovieDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDB.class, "movies")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
