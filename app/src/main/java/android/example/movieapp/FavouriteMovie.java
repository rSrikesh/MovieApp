package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.example.movieapp.Adapters.FavMovieAdapter;
import android.example.movieapp.Database.MovieDB;
import android.example.movieapp.Models.FavMovie;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;
import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;

public class FavouriteMovie extends AppCompatActivity {
    private RecyclerView favMovRecView;
    FirebaseUser mUser;
    private BubbleTabBar btmNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movie);
        favMovRecView = findViewById(R.id.favMovieRecyclerView);
        favMovRecView.setLayoutManager(new LinearLayoutManager(FavouriteMovie.this));
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        FavMovieAdapter Adapter = new FavMovieAdapter(FavouriteMovie.this);
        MovieDB mb = MovieDB.getInstance(FavouriteMovie.this);
        List<FavMovie> favMovieList = mb.movieDao().getFavMovies(mUser.getEmail());
        Adapter.setFavList(favMovieList);
        favMovRecView.setAdapter(Adapter);

        btmNavBar = findViewById(R.id.bottom);
        btmNavBar.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                if(i == R.id.navbar_home){
                startActivity(new Intent(FavouriteMovie.this,MainActivity.class));
                }else if(i == R.id.navbar_profile){
                startActivity(new Intent(FavouriteMovie.this,ProfileActivity.class));
                }
            }
        });
        getSupportActionBar().setTitle("Favourites");
    }
}
