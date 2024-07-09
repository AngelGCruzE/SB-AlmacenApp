package com.example.sb_bodega;

public class DatabaseContract {
    private DatabaseContract() {}

    public static class UsuarioEntry {
        public static final String TABLE_NAME = "Usuarios";
        public static final String COLUMN_ID = "Pk";
        public static final String COLUMN_USUARIO = "Usuario";
        public static final String COLUMN_CONTRASEÑA = "Contraseña";
    }

    public static class OSEEntry {
        public static final String TABLE_NAME = "OSE";
        public static final String COLUMN_ID = "Pk";
        public static final String COLUMN_OSENAME = "osename";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_TEL = "tel";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_EQUIPO = "equipo";
        public static final String COLUMN_MARCA = "marca";
        public static final String COLUMN_NO_SERIE = "noSerie";
        public static final String COLUMN_SERVICIO = "servicio";
        public static final String COLUMN_ESPACIO = "espacio";
        public static final String COLUMN_ESTADO = "estado";
        public static final String COLUMN_USER_ID = "user"; // FK to Usuarios
    }

    public static class BodegaEntry {
        public static final String TABLE_NAME = "Bodega";
        public static final String COLUMN_ID = "Pk";
        public static final String COLUMN_NOMBRE = "Nombre";
        public static final String COLUMN_RANGO = "Rango";
    }
}
