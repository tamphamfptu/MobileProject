package database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import model.Car;

public class Database extends SQLiteOpenHelper {
    Car Car;


    public Database(@Nullable Context context) {
        super(context, "DetailDatabase", null, 1);
    }

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public Database(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Car
        //Create table
        String sql ="CREATE TABLE Car(CarID, Brand, Color, Price)";
        sqLiteDatabase.execSQL(sql);
        //Insert data to created table
        sqLiteDatabase.execSQL("INSERT INTO Car values('BM21', 'BMW', 'Matte black', 29999.9)");

        //Customer
        //Create table
        sql = "CREATE TABLE Customer(FullName  not null, password )";
        sqLiteDatabase.execSQL(sql);
        //Insert data to created table
        sqLiteDatabase.execSQL("INSERT INTO Customer values('tampvn', '123456')");
    } 
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Delete table if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Car");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Customer");

    }
}
