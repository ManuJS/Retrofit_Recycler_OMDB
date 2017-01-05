package info.androidhive.retrofit.model;

import com.google.gson.annotations.SerializedName;


public class OmdbMovieDetail {

    //1
    @SerializedName("Title")
    private String title;

    //2
    @SerializedName("Released")
    private String releaseDate;

    @SerializedName("Genre")
    private String genre;


    @SerializedName("Director")
    private String director;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Poster")
    private String posterPath;

    @SerializedName("imdbRating")
    private String rating;

    public OmdbMovieDetail(String title, String releaseDate, String genre, String director, String actors, String plot, String posterPath, String rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterPath = posterPath;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
