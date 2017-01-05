package info.androidhive.retrofit.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.adapter.MoviesAdapter;
import info.androidhive.retrofit.model.Movie;
import info.androidhive.retrofit.model.MoviesResponse;
import info.androidhive.retrofit.model.OmdbMovie;
import info.androidhive.retrofit.model.OmdbMoviesResponse;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiClientOmdb;
import info.androidhive.retrofit.rest.ApiInterface;
import info.androidhive.retrofit.rest.ApiInterfaceOmdb;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    MoviesAdapter adapter;

    RecyclerView recyclerView;
    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handleIntent(getIntent());

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            onQueryTextSubmit(query);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        String s = query;
        String format = "json";

        ApiInterfaceOmdb apiService =
                ApiClientOmdb.getClient().create(ApiInterfaceOmdb.class);


        Call<OmdbMoviesResponse> call = apiService.search(s, format);
        call.enqueue(new Callback<OmdbMoviesResponse>() {
            @Override
            public void onResponse(Call<OmdbMoviesResponse> call, Response<OmdbMoviesResponse> response) {
                int statusCode = response.code();
                List<OmdbMovie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<OmdbMoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    }

