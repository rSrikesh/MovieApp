package android.example.movieapp.Fragments;

import android.example.movieapp.Models.FavMovie;
import android.example.movieapp.Operations.DeleteMovie;
import android.example.movieapp.Operations.InsertMovie;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.example.movieapp.R;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import java.util.Locale;

public class FavMovieFragment extends Fragment {
    TextView detailTitle,detailOriginalTitle,detailLanguage,detailOverview,detailDate;
    ImageView detailPoster;
    FirebaseUser mUser;
    ImageButton addFavMovBtn,delFavMovBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_movie_detail, container, false);
        detailTitle = v.findViewById(R.id.detailTitle);
        detailOriginalTitle = v.findViewById(R.id.detailOriginalTitle);
        detailPoster = v.findViewById(R.id.detailPoster);
        detailLanguage = v.findViewById(R.id.detailLanguage);
        detailOverview = v.findViewById(R.id.detailOverview);
        detailDate = v.findViewById(R.id.detailDate);
        addFavMovBtn = v.findViewById(R.id.addFavMovBtn);
        delFavMovBtn = v.findViewById(R.id.remFavMovBtn);
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        Bundle b = this.getArguments();
        int id = b.getInt("id");
        String title = b.getString("title");
        String date = "Release Date: "+"\t"+b.getString("date");
        String overview = b.getString("overview");
        String url = b.getString("url");
        String Original_Title = b.getString("original_title");
        String Language_Code = b.getString("language_code");

        Locale l = new Locale(Language_Code);
        String L = l.getDisplayLanguage();
        String Language = "Language: "+"\t"+L.substring(0,1).toUpperCase() + L.substring(1);

        FavMovie m = new FavMovie();
        m.favID = id;
        m.favTitle = title;
        m.favUrl = url;
        m.userEmail = mUser.getEmail();

        detailTitle.setText(title);
        Picasso.get().load(url).into(detailPoster);
        detailDate.setText(date);
        detailOverview.setText(overview);
        detailOverview.setMovementMethod(new ScrollingMovementMethod());
        detailOriginalTitle.setText(Original_Title);
        detailLanguage.setText(Language);

        addFavMovBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertMovie(m,getActivity()).execute();
            }
        });

        delFavMovBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteMovie(m,getActivity()).execute();
            }
        });

        return v;
    }

}