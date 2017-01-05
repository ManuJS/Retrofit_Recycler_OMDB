package info.androidhive.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class OmdbMoviesResponseDetail {

    @SerializedName("")
    private List<OmdbMovieDetail> results;


    public List<OmdbMovieDetail> getResultsDetails() {
        return results;
    }

    public void setResultsdetails(List<OmdbMovieDetail> results) {
        this.results = results;
    }


}
