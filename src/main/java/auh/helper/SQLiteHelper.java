package auh.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import auh.data.KeyVal;

public class SQLiteHelper extends SQLiteOpenHelper
{
        public static final String  DB_NAME = "data.db";
        public static final Integer DB_VERSION = 1;

        private
        SQLiteDatabase _db;

        private
        KeyVal _kv;

        public SQLiteHelper(Context context)
        {
                super(context, SQLiteHelper.DB_NAME, null, SQLiteHelper.DB_VERSION);

                this._db = this.getWritableDatabase();
                this._kv = new KeyVal(this._db);
        }

        @Override
        public
        void onCreate(SQLiteDatabase db)
        {
                this._kv.create();
        }

        @Override
        public
        void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {}

        public
        KeyVal gtKeyValStore()
        {
                return this._kv;
        }
}
