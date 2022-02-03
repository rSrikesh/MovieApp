package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.example.movieapp.Fragments.FavMovieFragment;
import android.os.Bundle;

public class MovieDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        FavMovieFragment fv = new FavMovieFragment();
        Bundle b = getIntent().getExtras();
        if(b != null){
            fv.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.detailframelayout, fv).commit();
        }
    }
}