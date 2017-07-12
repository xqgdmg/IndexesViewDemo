package com.example.qhsj.indexesviewdemo.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chris on 2017/7/12.
 * 联系人数据库
 */
public class WalletDataBase extends SQLiteOpenHelper {

    public WalletDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "contct.db", null, version);
    }

    public WalletDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS  " + "" + " (" +
                "contactid INTEGER primary key autoincrement, " +
                "address text, " +
                "createAt INTEGER, " +
                "data text, " +
                "id INTEGER UNIQUE, " +
                "imgUrl text, " +
                "message text, " +
                "messageType INTEGER, " +
                "sessionId INTEGER," +
                "beRead INTEGER," +
                "fireSeconds INTEGER," +    //阅后即焚消息的秒数
                "messageFlag INTEGER," +    //消息标识  默认0:普通消息,1:阅后即焚消息
                "state INTEGER,"+   //数据库由4升到5添加的字段　状态 1:已发送 2:已阅读 3:删除 4,发送中,5发送失败
                "clientFlag text,"+ //数据库由4升到5添加的字段　发送消息携带的唯一标识
                "businessId text"+
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
