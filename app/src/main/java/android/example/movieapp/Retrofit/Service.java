package android.example.movieapp.Retrofit;

import android.example.movieapp.Models.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("movie/top_rated")
    Call<MovieResponse> movieResponse(@Query("api_key") String apiKey,@Query("page") int pageNo);
}
