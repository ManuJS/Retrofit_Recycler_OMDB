package info.androidhive.retrofit.rest;

import info.androidhive.retrofit.model.OmdbMoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterfaceOmdb {
    @GET("/")
    Call<OmdbMoviesResponse> search(@Query("s") String q, @Query("r") String format);


}
