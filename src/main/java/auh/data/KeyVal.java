package auh.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class KeyVal implements TableInterface
{
        public static final String LOG_TAG = KeyVal.class.getName();

        public static final String TABLE = "keyval";
        public static final String ID = "_id";
        public static final String KEY = "key";
        public static final String VAL = "val";

        private
        SQLiteDatabase _db;

        public
        KeyVal(SQLiteDatabase db)
        {
                this._db = db;
        }

        @Override
        public
        KeyVal create()
        {
                String query = "" +
                        "CREATE TABLE '" + KeyVal.TABLE + "' (" +
                                "'" + KeyVal.ID + "'" + " INTEGER PRIMARY KEY," +
                                "'" + KeyVal.KEY + "'" + " text," +
                                "'" + KeyVal.VAL + "'" + " text" +
                        ")";

                Log.i(KeyVal.LOG_TAG, query);

                this._db.execSQL(query);

                return this;
        }

        public
        Boolean isFirstTimeAccess()
        {
                return false;
        }
}
