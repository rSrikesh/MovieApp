package android.example.movieapp.Operations;

import android.content.Context;
import android.example.movieapp.Database.MovieDB;
import android.example.movieapp.Models.FavMovie;
import android.os.AsyncTask;
import android.widget.Toast;

public class InsertMovie extends AsyncTask<Void,Void,Void> {

    private Context c;
    private final FavMovie mv;

    public InsertMovie(FavMovie mv,Context c){
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
        if(mb.movieDao().searchMovie(mv.favID, mv.userEmail).size() >= 1){
            Toast.makeText(c, "Already Added to Favourites", Toast.LENGTH_SHORT).show();
        }else{
            mb.movieDao().insertMovie(mv);
            Toast.makeText(c, "Added to Favourites", Toast.LENGTH_SHORT).show();
        }
        super.onPostExecute(unused);
    }
}
