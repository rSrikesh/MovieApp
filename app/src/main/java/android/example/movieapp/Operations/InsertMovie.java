package android.example.movieapp.Operations;

import android.content.Context;
import android.example.movieapp.Database.MovieDB;
import android.example.movieapp.Models.FavMovie;
import android.os.AsyncTask;
import android.widget.Toast;

public class InsertMovie extends AsyncTask<FavMovie,Void,Void> {

    private Context c;

    public InsertMovie(Context c){
        this.c = c;
    }

    @Override
    protected Void doInBackground(FavMovie... favMovies) {
        MovieDB mb = MovieDB.getInstance(c);
        mb.movieDao().insertMovie(favMovies);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(c, "Added to Favourites", Toast.LENGTH_SHORT).show();
        super.onPostExecute(unused);
    }
}
