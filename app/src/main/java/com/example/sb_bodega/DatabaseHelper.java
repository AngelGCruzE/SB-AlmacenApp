package com.example.sb_bodega;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_USUARIOS =
            "CREATE TABLE " + DatabaseContract.UsuarioEntry.TABLE_NAME + " (" +
                    DatabaseContract.UsuarioEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DatabaseContract.UsuarioEntry.COLUMN_USUARIO + " TEXT," +
                    DatabaseContract.UsuarioEntry.COLUMN_CONTRASEÑA + " TEXT)";

    private static final String SQL_CREATE_OSE =
            "CREATE TABLE " + DatabaseContract.OSEEntry.TABLE_NAME + " (" +
                    DatabaseContract.OSEEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DatabaseContract.OSEEntry.COLUMN_OSENAME + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_NOMBRE + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_TEL + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_EMAIL + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_EQUIPO + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_MARCA + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_NO_SERIE + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_SERVICIO + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_ESPACIO + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_ESTADO + " TEXT," +
                    DatabaseContract.OSEEntry.COLUMN_USER_ID + " INTEGER," +
                    "FOREIGN KEY(" + DatabaseContract.OSEEntry.COLUMN_USER_ID + ") REFERENCES " +
                    DatabaseContract.UsuarioEntry.TABLE_NAME + "(" + DatabaseContract.UsuarioEntry.COLUMN_ID + "))";

    private static final String SQL_CREATE_BODEGA =
            "CREATE TABLE " + DatabaseContract.BodegaEntry.TABLE_NAME + " (" +
                    DatabaseContract.BodegaEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DatabaseContract.BodegaEntry.COLUMN_NOMBRE + " TEXT," +
                    DatabaseContract.BodegaEntry.COLUMN_RANGO + " TEXT)";

    private static final String SQL_DELETE_USUARIOS =
            "DROP TABLE IF EXISTS " + DatabaseContract.UsuarioEntry.TABLE_NAME;

    private static final String SQL_DELETE_OSE =
            "DROP TABLE IF EXISTS " + DatabaseContract.OSEEntry.TABLE_NAME;

    private static final String SQL_DELETE_BODEGA =
            "DROP TABLE IF EXISTS " + DatabaseContract.BodegaEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USUARIOS);
        db.execSQL(SQL_CREATE_OSE);
        db.execSQL(SQL_CREATE_BODEGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_USUARIOS);
        db.execSQL(SQL_DELETE_OSE);
        db.execSQL(SQL_DELETE_BODEGA);
        onCreate(db);
    }
}