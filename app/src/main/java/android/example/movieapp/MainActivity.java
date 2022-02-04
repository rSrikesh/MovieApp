package android.example.movieapp;

import androidx.annotation.NonNull;
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
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BottomNavigationView btmNav;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        mAuth = FirebaseAuth.getInstance();
        btmNav = findViewById(R.id.bottomNavBar);
        MovieAdapter adapter = new MovieAdapter(MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Client client = new Client();
        Service service = client.getClient().create(Service.class);
        Call<MovieResponse> call = service.movieResponse(Creds.API_KEY,1);
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
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btmNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.navbar_fav){
                    startActivity(new Intent(MainActivity.this,FavouriteMovie.class));
                    return true;
                }else if(item.getItemId() == R.id.navbar_profile){
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    return true;
                }
                return false;
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
