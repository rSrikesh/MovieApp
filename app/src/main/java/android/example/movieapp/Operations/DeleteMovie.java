package android.example.movieapp.Operations;

import android.content.Context;
import android.example.movieapp.Database.MovieDB;
import android.example.movieapp.Models.FavMovie;
import android.os.AsyncTask;
import android.widget.Toast;

public class DeleteMovie extends AsyncTask<Void,Void,Void> {

    private final FavMovie mv;
    private Context c;

    public DeleteMovie(FavMovie mv,Context c){
        this.mv = mv;
        this.c = c;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        MovieDB mb = MovieDB.getInstance(c);
        mb.movieDao().deleteMovie(mv.favID,mv.userEmail);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(c, "Removed from Favourites", Toast.LENGTH_SHORT).show();
        super.onPostExecute(unused);
    }
}