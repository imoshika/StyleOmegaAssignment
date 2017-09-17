package com.example.imoshikasewwandi.styleomegaassignment.SQL_DATABASE;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.ListView;

import com.example.imoshikasewwandi.styleomegaassignment.MODEL_item.Item;
import com.example.imoshikasewwandi.styleomegaassignment.MODEL_user.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imoshika Sewwandi on 8/28/2017.
 */

public class HelperDatabase extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "Management.db";
    private static final String TABLE_CUSTOMER = "customer";
    private static final String TABLE_PRODUCTS = "product_items";

    //column names for the table customer
    private static final String COLUMN_ID = "cust_id";
    private static final String COLUMN_FNAME = "cust_fname";
    private static final String COLUMN_LNAME = "cust_lname";
    private static final String COLUMN_USERNAME = "cust_username";
    private static final String COLUMN_EMAIL = "cust_email";
    private static final String COLUMN_PASSWORD = "cust_password";
    private static final String COLUMN_CONTACT  = "cust_contactnumber";
    SQLiteDatabase db;

    //column names for the table product items
    private static final String PRODUCT_ID = "p_id";
    private static final String PRODUCT_NAME = "p_name";
    public static final String PRODUCT_DESC = "p_desc";
    private static final String PRODUCT_PRICE = "p_price";
    private static final String PRODUCT_QTY = "p_qty";
    private static final String PRODUCT_IMAGE = "p_img";

    //creating the customer table
    private String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_FNAME +" TEXT,"
            + COLUMN_LNAME +" TEXT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT,"
            +COLUMN_EMAIL + " TEXT,"
            + COLUMN_CONTACT + " TEXT"+ ")";

    //creating the product item table
    private String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
            + PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + PRODUCT_NAME +" TEXT,"
            + PRODUCT_DESC + " TEXT,"
            + PRODUCT_PRICE + " DOUBLE,"
            + PRODUCT_QTY + " DOUBLE,"
            + PRODUCT_IMAGE + " TEXT" + ")";

    private String DROP_CUSTOMER_TABLE = "DROP TABLE IF EXISTS " + TABLE_CUSTOMER;
    private String DROP_PRODUCTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_PRODUCTS;

    public HelperDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CUSTOMER_TABLE);
        db.execSQL(CREATE_PRODUCTS_TABLE);
        //this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //db.execSQL(DROP_CUSTOMER_TABLE);
        //db.execSQL(DROP_PRODUCTS_TABLE);

       // onCreate(db);
    }

    public void addCustomer(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, user.getID());
        values.put(COLUMN_FNAME, user.getU_fname());
        values.put(COLUMN_LNAME, user.getU_lname());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getU_password());
        values.put(COLUMN_EMAIL, user.getU_email());
        values.put(COLUMN_CONTACT, user.getContact());

        db.insert(TABLE_CUSTOMER, null, values);
        db.close();
    }

    public void updateCustomer(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FNAME, user.getU_fname());
        values.put(COLUMN_LNAME, user.getU_lname());
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getU_password());
        values.put(COLUMN_EMAIL, user.getU_email());
        values.put(COLUMN_CONTACT, user.getContact());

        db.update(TABLE_CUSTOMER, values, COLUMN_ID + " = ?", new String[]{String.valueOf(user.getID())});
        db.close();
    }

    public List<Item> getAllProductItems(){
        String [] tableColumns = {PRODUCT_ID,PRODUCT_NAME, PRODUCT_DESC, PRODUCT_PRICE, PRODUCT_QTY, PRODUCT_IMAGE};

        String sortOrder = PRODUCT_NAME + " ASC";
        List<Item> productlist = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_PRODUCTS, tableColumns, null,null,null,null,sortOrder);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Item item = new Item();
            item.setPID(Integer.parseInt(c.getString(c.getColumnIndex(PRODUCT_ID))));
            item.setP_name(c.getString(c.getColumnIndex(PRODUCT_NAME)));
            item.setP_desc(c.getString(c.getColumnIndex(PRODUCT_DESC)));
            item.setP_price(Double.parseDouble(c.getString(c.getColumnIndex(PRODUCT_PRICE))));
            item.setP_qty(Integer.parseInt(c.getString(c.getColumnIndex(PRODUCT_QTY))));
            item.setImage(c.getString(c.getColumnIndex(PRODUCT_IMAGE)));
            productlist.add(item);
        }
        c.close();
        db.close();
        return productlist;
    }

    public List<User> getAllCustomers(){
        String [] tableColumns = {COLUMN_ID, COLUMN_FNAME,COLUMN_LNAME, COLUMN_EMAIL, COLUMN_USERNAME, COLUMN_PASSWORD};

        String sortOrder = COLUMN_FNAME + "ASC";
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

    public Item getItem(String desc){

        SQLiteDatabase db = getReadableDatabase();
        Item item = null;

        String selectItem = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + PRODUCT_DESC + "='" + desc+ "'";

        Cursor c = db.rawQuery(selectItem, null);
        if (c.moveToFirst()) {
            item = new Item();
            //item.setPID(c.getInt(c.getColumnIndex(PRODUCT_ID)));
            item.setP_desc(c.getString(c.getColumnIndex(PRODUCT_DESC)));
            item.setP_price(c.getDouble(c.getColumnIndex(PRODUCT_PRICE)));
            item.setImage(c.getString(c.getColumnIndex(PRODUCT_IMAGE)));

        }

        return item;
    }

}
