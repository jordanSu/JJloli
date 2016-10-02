package com.example.jj.jjloli;

/**
 * Created by user on 2016/10/2.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDb extends SQLiteOpenHelper {

    // 資料庫名稱
    public static final String DATABASE_NAME = "mydata.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 1;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;

    // 建構子，在一般的應用都不需要修改
    public LocalDb(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    // 需要資料庫的元件呼叫這個方法，這個方法在一般的應用都不需要修改
    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new LocalDb(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }

        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ChargeTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 刪除原有的表格
        db.execSQL("DROP TABLE IF EXISTS " + ChargeTable.TABLE_NAME);
        // 呼叫onCreate建立新版的表格
        onCreate(db);
    }

}
