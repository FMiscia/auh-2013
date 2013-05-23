package auh.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import auh.data.KeyVal;

public class SQLiteHelper
{
        public static final String  DB_NAME = "data.db";
        public static final Integer DB_VERSION = 1;

        private
        SQLiteOpenHelper _helper;

        private
        SQLiteDatabase _db;

        private
        KeyVal _kv;

        public SQLiteHelper(Context context)
        {
                this._helper = new SQLiteOpenHelper(context, SQLiteHelper.DB_NAME, null, SQLiteHelper.DB_VERSION) {
                        @Override
                        public
                        void onCreate(SQLiteDatabase db)
                        {
                                new KeyVal(db).create();
                        }

                        @Override
                        public
                        void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
                        {}
                };

                this._db = this._helper.getWritableDatabase();
                this._kv = new KeyVal(this._db);
        }

        public
        KeyVal getKeyValStore()
        {
                return this._kv;
        }
}
