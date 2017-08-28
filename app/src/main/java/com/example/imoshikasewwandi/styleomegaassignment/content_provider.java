package com.example.imoshikasewwandi.styleomegaassignment;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

/**
 * Created by Imoshika Sewwandi on 8/23/2017.
 */

public class content_provider extends ContentProvider {

    static final String PROVIDER_NAME = "com.example.imoshikasewwandi.styleomegaassignment.content_provider";
    static final String URL1 = "content://"+PROVIDER_NAME + "/customer_details";
    static final String URL2 = "content://"+PROVIDER_NAME+"/product_details";
    static final Uri CONTENT_URI1 = Uri.parse(URL1);
    static final Uri CONTENT_URI2 = Uri.parse(URL2);
    static final String _ID = "_id";
    static final String FNAME = "fname";
    static final String LNAME = "lname";
    static final String AGE = "age";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    static final String PRODUCT_NAME ="product_name";
    static final String PRODUCT_ID="_pid";
    static final double PRICE= 0.0;
    static final int QUANTITY =0;
    static final String P_DESC = "product_description";
    static final String P_TYPE = "p_type";

    private static HashMap<String,String> CUSTOMERS_PROJECTION_MAP;
    private static HashMap<String,String> PRODUCTS_PROJECTION_MAP;

    static final int CUSTOMER = 1;
    static final int CUSTOMER_ID = 2;
    static final int PRODUCT = 1;
    static final int P_ID = 2;
    static final UriMatcher uriMatcher;
    static{
    uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"customer_details",CUSTOMER);
        uriMatcher.addURI(PROVIDER_NAME,"customer_details/#",CUSTOMER_ID);
}

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "CLOTHING_STORE";
    static final String CUSTOMER_TABLE_NAME = "customer_details";
    static final String PRODUCT_TABLE_NAME = "product_details";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE = "CREATE TABLE "+CUSTOMER_TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +"fname TEXT NOT NULL,"+ "lname TEXT NOT NULL,"+"age TEXT NOT NULL,"+"username TEXT NOT NULL,"+"password TEXT NOT NULL);";
    static final String CREATE_PRODUCT_TABLE = "CREATE TABLE"+PRODUCT_TABLE_NAME+"(_pid INTEGER PRIMARY KEY AUTOINCREMENT,"+"p_type TEXT NOT NULL,"+"product_name TEXT NOT NULL,"+"product_description TEXT NOT NULL,"+"price TEXT NOT NULL,"+"qty TEXT NOT NULL);";

    @Override
    public boolean onCreate() {
        //create a writable database if it doesnt already exist
        Context context = getContext();
        Database dbhelper = new Database(context);
        db = dbhelper.getWritableDatabase();
        return (db == null)? false:true;
    }

    @Nullable
    @Override
    public Cursor query( Uri uri,  String[] projection, String selection,  String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(CUSTOMER_TABLE_NAME);

        switch(uriMatcher.match(uri)){
            case CUSTOMER:
                queryBuilder.setProjectionMap(CUSTOMERS_PROJECTION_MAP);
            break;

            case CUSTOMER_ID:
                queryBuilder.appendWhere(PRODUCT_ID+"="+ uri.getPathSegments().get(1));
            break;

            default:
        }

        Cursor c = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        c.setNotificationUri(getContext().getContentResolver(),uri);
        return c;
    }

    public Cursor selectQueryForProduct( Uri uri,  String[] projection, String selection,  String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PRODUCT_TABLE_NAME);

        switch(uriMatcher.match(uri)){
            case PRODUCT:
                queryBuilder.setProjectionMap(PRODUCTS_PROJECTION_MAP);
                break;

            case P_ID:
                queryBuilder.appendWhere(_ID+"="+ uri.getPathSegments().get(1));
                break;

            default:
        }

        Cursor c = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        c.setNotificationUri(getContext().getContentResolver(),uri);
        return c;
    }



    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //add a new customer
        long rowid = db.insert(CUSTOMER_TABLE_NAME,"",values);

        //if the customer is being added successfully,
        if(rowid > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI1, rowid);//to retrieve the row
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        throw new SQLException("failed to add a record to into"+uri);
    }

    public Uri insertIntoProduct(Uri uri){
        ContentValues NewValue = new ContentValues();


        long rowid = db.insert(PRODUCT_TABLE_NAME,"",NewValue);
        if(rowid > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI2, rowid);//to retrieve the row
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        throw new SQLException("failed to add a record to into"+uri);



    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
