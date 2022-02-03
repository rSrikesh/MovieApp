package android.example.movieapp.Models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Movies {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("id")
    private int id;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private Float voteAverage;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("genre_ids")
    private List<Integer>genreIds = new ArrayList<>();
    @SerializedName("overview")
    private String overview;

    public Movies(String posterPath, boolean adult, String backdropPath, int id,
                  String originalLanguage, String originalTitle, Double popularity, String releaseDate, String title, boolean video, Float voteAverage,
                  int voteCount, List<Integer> genreIds, String overview) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.id = id;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.genreIds = genreIds;
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
