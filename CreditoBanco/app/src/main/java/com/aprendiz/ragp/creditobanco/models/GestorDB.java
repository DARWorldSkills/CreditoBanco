package com.aprendiz.ragp.creditobanco.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class GestorDB extends SQLiteOpenHelper {
    public GestorDB(Context context) {
        super(context, Constants.DATABASE_NAME,null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.TABLE_MODULO);
        db.execSQL(Constants.TABLE_TIPO_CLIENTE);
        db.execSQL(Constants.TABLE_TIPO_SOLICITUD);
        db.execSQL(Constants.TABLE_TAPIZAR);
        db.execSQL(Constants.TABLE_TASA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
