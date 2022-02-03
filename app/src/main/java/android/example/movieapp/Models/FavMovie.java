package android.example.movieapp.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"mID","uEmail"})
public class FavMovie {

    @ColumnInfo(name = "mID")
    public int favID;

    @NonNull
    @ColumnInfo(name = "uEmail")
    public String userEmail;

    @ColumnInfo(name = "mTitle")
    public String favTitle;

    @ColumnInfo(name = "mPosterUrl")
    public String favUrl;

}
