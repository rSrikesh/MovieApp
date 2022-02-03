package android.example.movieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.example.movieapp.Credentials.Creds;
import android.example.movieapp.Models.Movies;
import android.example.movieapp.MovieDetailActivity;
import android.example.movieapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private List<Movies>mList;

    public MovieAdapter(Context context){
        this.context = context;
    }

    public void setList(List<Movies>mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        v = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movies mv = mList.get(position);
        holder.Title.setText(mv.getTitle());
        Picasso.get().load(Creds.POSTER_URL+mv.getPosterPath()).into(holder.Image);
        String rating = "Vote Average: "+"\t"+ mv.getVoteAverage();
        holder.Rating.setText(rating);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("title", mv.getTitle());
                b.putString("date", mv.getReleaseDate());
                b.putString("overview", mv.getOverview());
                b.putString("url", Creds.POSTER_URL+mv.getBackdropPath());
                b.putString("original_title", mv.getOriginalTitle());
                b.putString("language_code", mv.getOriginalLanguage());
                b.putInt("id", mv.getId());
                Intent i = new Intent(context, MovieDetailActivity.class);
                i.putExtras(b);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        private TextView Title,Rating;
        private ImageView Image;
        private CardView parent;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.movieTitle);
            Image = itemView.findViewById(R.id.moviePoster);
            parent = itemView.findViewById(R.id.parent);
            Rating = itemView.findViewById(R.id.movieRating);
        }
    }
}
