package android.example.movieapp.Adapters;

import android.content.Context;
import android.example.movieapp.Credentials.Creds;
import android.example.movieapp.Models.FavMovie;
import android.example.movieapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FavMovieAdapter extends RecyclerView.Adapter<FavMovieAdapter.FavMovieViewHolder> {

    private Context context;
    private List<FavMovie> favList;

    public FavMovieAdapter(Context context){
        this.context = context;
    }

    public void setFavList(List<FavMovie>favList){
        this.favList=favList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_movie_item, parent, false);
        return new FavMovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavMovieViewHolder holder, int position) {
        FavMovie favMov = favList.get(position);
        holder.favMovieTitle.setText(favMov.favTitle);
        Picasso.get().load(Creds.POSTER_URL+favMov.favUrl).into(holder.favMoviePoster);
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    public static class FavMovieViewHolder extends RecyclerView.ViewHolder{
        TextView favMovieTitle,favMovieVotes;
        ImageView favMoviePoster;
        public FavMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            favMovieTitle = itemView.findViewById(R.id.favMovieTitle);
            favMoviePoster = itemView.findViewById(R.id.favMoviePoster);
        }
    }
}
