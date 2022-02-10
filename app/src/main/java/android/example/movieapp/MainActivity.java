package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.example.movieapp.Adapters.MovieAdapter;
import android.example.movieapp.Credentials.Creds;
import android.example.movieapp.Models.MovieResponse;
import android.example.movieapp.Models.Movies;
import android.example.movieapp.Retrofit.Client;
import android.example.movieapp.Retrofit.Service;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BubbleTabBar btmNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btmNav = findViewById(R.id.bottomNavBar);
        MovieAdapter adapter = new MovieAdapter(MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Client client = new Client();
        Service service = client.getClient().create(Service.class);
        Call<MovieResponse> call = service.movieResponse(Creds.API_KEY,9);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movies>mList = response.body().getResults();
                Collections.sort(mList,new SortByName());
                adapter.setList(mList);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.i("error", t.getMessage());
            }
        });

        btmNav.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                if(i == R.id.navbar_fav){
                    startActivity(new Intent(MainActivity.this,FavouriteMovie.class));
                }else if(i == R.id.navbar_profile){
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    static class SortByName implements Comparator<Movies>{
        public int compare(Movies a,Movies b){
            return a.getTitle().compareTo(b.getTitle());
        }
    }
}
