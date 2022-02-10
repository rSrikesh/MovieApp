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
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        MovieDB mb = MovieDB.getInstance(c);
        if(mb.movieDao().searchMovie(mv.favID, mv.userEmail).size() == 0){
            Toast.makeText(c, "Movie not available in Favourites", Toast.LENGTH_SHORT).show();
        }else{
            mb.movieDao().deleteMovie(mv.favID,mv.userEmail);
            Toast.makeText(c, "Removed from Favourites", Toast.LENGTH_SHORT).show();
        }
        super.onPostExecute(unused);
    }
}

