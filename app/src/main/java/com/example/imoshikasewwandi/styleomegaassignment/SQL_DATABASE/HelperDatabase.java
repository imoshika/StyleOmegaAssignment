package com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.ListView;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imoshika Sewwandi on 8/28/2017.
 */

public class HelperDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Management.db";
    private static final String TABLE_CUSTOMER = "customer";


    private static final String COLUMN_ID = "cust_id";
    private static final String COLUMN_FNAME = "cust_fname";
    private static final String COLUMN_LNAME = "cust_lname";
    private static final String COLUMN_USERNAME = "cust_username";
    private static final String COLUMN_EMAIL = "cust_email";
    private static final String COLUMN_PASSWORD = "cust_password";
    private static final String COLUMN_CONTACT  = "cust_contactnumber";
    SQLiteDatabase db;

    private String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FNAME +" TEXT,"
            + COLUMN_LNAME +" TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            +COLUMN_EMAIL + " TEXT,"
            + COLUMN_CONTACT + " TEXT"+ ")";

    private String DROP_CUSTOMER_TABLE = "DROP TABLE IF EXISTS " + TABLE_CUSTOMER;

    public HelperDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CUSTOMER_TABLE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_CUSTOMER_TABLE);
        onCreate(db);
    }

    public void addCustomer(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.getID());
        values.put(COLUMN_FNAME, user.getU_fname());
        values.put(COLUMN_LNAME, user.getU_lname());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getU_password());
        values.put(COLUMN_EMAIL, user.getU_email());
        values.put(COLUMN_CONTACT, user.getContact());

        db.insert(TABLE_CUSTOMER, null, values);
        db.close();
    }

    public List<User> getAllCustomers(){
            String [] tableColumns = {COLUMN_ID, COLUMN_FNAME,COLUMN_LNAME, COLUMN_EMAIL, COLUMN_USERNAME, COLUMN_PASSWORD};

        String sortOrder = COLUMN_FNAME + "AC";
        List<User> customerlist = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_CUSTOMER, tableColumns,null ,null, null, null,sortOrder);

        if(c.moveToFirst()){
            do{
                User u = new User();
                u.setID(Integer.parseInt(c.getString(c.getColumnIndex(COLUMN_ID))));
                u.setU_fname(c.getString(c.getColumnIndex(COLUMN_FNAME)));
                u.setU_lname(c.getString(c.getColumnIndex(COLUMN_LNAME)));
                u.setU_email(c.getString(c.getColumnIndex(COLUMN_EMAIL)));
                u.setUsername(c.getString(c.getColumnIndex(COLUMN_USERNAME)));
                u.setU_password(c.getString(c.getColumnIndex(COLUMN_PASSWORD)));

                customerlist.add(u);
            }while(c.moveToNext());
        }

        c.close();
        db.close();
        return customerlist;
    }

    public boolean CheckCustomer(String cust_username, String cust_password){
        String[] cols = {COLUMN_ID};

        SQLiteDatabase db  = this.getReadableDatabase();
        String selec = COLUMN_USERNAME + " =?" + " AND " + COLUMN_PASSWORD + " =?";

        String[]selectionArgs = {cust_username, cust_password};
        Cursor c = db.query(TABLE_CUSTOMER, cols, selec, selectionArgs, null, null, null);
        int cCount = c.getCount();
        c.close();
        db.close();

        if(cCount > 0){
            return true;
        }

        return false;
    }



}
