package info.androidhive.retrofit.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClientOmdb {

    public static final String BASE_URL = "http://www.omdbapi.com/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterfaceOmdb api = retrofit.create(ApiInterfaceOmdb.class);
        return retrofit;
    }
}
