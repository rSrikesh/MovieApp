package android.example.movieapp.Models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movies>results;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;

    public MovieResponse(int page, List<Movies> results, int totalPages, int totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movies> getResults() {
        return results;
    }

    public void setResults(List<Movies> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
