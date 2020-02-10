package com.example.examen_10_02_lancho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL("CREATE TABLE Libros (codigo INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, autor TEXT, isbn TEXT, editorial TEXT, paginas INTEGER, leido INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Libros");
        db.execSQL("CREATE TABLE Libros (codigo INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, autor TEXT, isbn TEXT, editorial TEXT, paginas INTEGER, leido INTEGER)");
    }
}
