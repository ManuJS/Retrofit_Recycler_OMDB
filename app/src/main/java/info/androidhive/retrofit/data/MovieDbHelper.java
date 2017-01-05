package info.androidhive.retrofit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by emanu on 01/11/2016.
 */
public class MovieDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "movie.db";

    public MovieDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + " (" +
                MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                MovieContract.MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                MovieContract.MovieEntry.COLUMN_RELEASED + " TEXT, " +
                MovieContract.MovieEntry.COLUMN_GENRE + " TEXT, " +
                MovieContract.MovieEntry.COLUMN_DIRECTOR + " TEXT, " +
                MovieContract.MovieEntry.COLUMN_ACTORS + " INTEGER, " +
                MovieContract.MovieEntry.COLUMN_PLOT + " INTEGER, " +
                MovieContract.MovieEntry.COLUMN_POSTER + " INTEGER, " +
                MovieContract.MovieEntry.COLUMN_IMDBRATING + " TEXT);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);

        //COLUMN_MOVIE_ID - é o id da tabela
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieContract.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}
