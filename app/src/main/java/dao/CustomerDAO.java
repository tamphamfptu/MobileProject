package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import database.Database;
import model.Customer;

public class CustomerDAO   {
    Database mydb;

    public CustomerDAO(Context context){
        mydb = new Database(context);
    }


    public boolean check(Customer customer){
        SQLiteDatabase db = mydb.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from Customer where fullname =? and password =?",
                new String[]{customer.getName(), customer.getPassword()});
        if(cs.getCount() <=0){
            return false;
        }
        return true;
    }
}
