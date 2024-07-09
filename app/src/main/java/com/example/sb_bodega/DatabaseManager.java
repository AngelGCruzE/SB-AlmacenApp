package com.example.sb_bodega;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase(); // Obtener una instancia de la base de datos
    }

    public void closeDatabase() {
        dbHelper.close(); // Cerrar la base de datos cuando ya no sea necesaria
    }

    public long insertUsuario(String usuario, String contraseña) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.UsuarioEntry.COLUMN_USUARIO, usuario);
        values.put(DatabaseContract.UsuarioEntry.COLUMN_CONTRASEÑA, contraseña);
        return db.insert(DatabaseContract.UsuarioEntry.TABLE_NAME, null, values);
    }

    public long insertOSE(String  osename, String nombre, String tel, String email, String equipo,
                          String marca, String noSerie, String servicio, String espacio,
                          String estado, long userId) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.OSEEntry.COLUMN_NOMBRE, nombre);
        values.put(DatabaseContract.OSEEntry.COLUMN_TEL, tel);
        values.put(DatabaseContract.OSEEntry.COLUMN_EMAIL, email);
        values.put(DatabaseContract.OSEEntry.COLUMN_EQUIPO, equipo);
        values.put(DatabaseContract.OSEEntry.COLUMN_MARCA, marca);
        values.put(DatabaseContract.OSEEntry.COLUMN_NO_SERIE, noSerie);
        values.put(DatabaseContract.OSEEntry.COLUMN_SERVICIO, servicio);
        values.put(DatabaseContract.OSEEntry.COLUMN_ESPACIO, espacio);
        values.put(DatabaseContract.OSEEntry.COLUMN_ESTADO, estado);
        values.put(DatabaseContract.OSEEntry.COLUMN_USER_ID, userId);
        return db.insert(DatabaseContract.OSEEntry.TABLE_NAME, null, values);
    }

    public long insertBodega(String nombre, String rango) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.BodegaEntry.COLUMN_NOMBRE, nombre);
        values.put(DatabaseContract.BodegaEntry.COLUMN_RANGO, rango);
        return db.insert(DatabaseContract.BodegaEntry.TABLE_NAME, null, values);
    }
}
