package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Imoshika Sewwandi on 8/23/2017.
 */

public class Database extends SQLiteOpenHelper{
    //actually creates and manages the provider's data

    Database(Context context){
        super(context,content_provider.DATABASE_NAME,null, content_provider.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(content_provider.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + content_provider.CUSTOMER_TABLE_NAME);
        onCreate(db);
    }
}
