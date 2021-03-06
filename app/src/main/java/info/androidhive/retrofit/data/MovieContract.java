package info.androidhive.retrofit.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by emanu on 01/11/2016.
 */
public class MovieContract {
    public static final String CONTENT_AUTHORITY = "info.androidhive.retrofit";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_MOVIE = "movie";

    public static final class MovieEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;

        public static final String TABLE_NAME = "movie";

        public static final String COLUMN_MOVIE_ID = "movie_id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_RELEASED = "released";
        public static final String COLUMN_GENRE = "genre";
        public static final String COLUMN_DIRECTOR = "director";
        public static final String COLUMN_ACTORS = "actors";
        public static final String COLUMN_PLOT = "plot";
        public static final String COLUMN_POSTER = "poster";
        public static final String COLUMN_IMDBRATING = "imdbRating";


        public static Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

