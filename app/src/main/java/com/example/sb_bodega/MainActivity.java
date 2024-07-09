package com.example.sb_bodega;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.sb_bodega.databinding.ActivityMainBinding;

import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseManager dbManager;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar rootView con la vista raíz de la actividad
        rootView = binding.getRoot();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Inicializar DatabaseManager (asegúrate de tener esta clase y su configuración)
        dbManager = new DatabaseManager(this);

        // Llamar a insertarEjemploDeDatos() para insertar datos de ejemplo
        insertarEjemploDeDatos();
    }

    private void insertarEjemploDeDatos() {
        // Ejemplo de inserción en la tabla Usuarios
        long idUsuario = dbManager.insertUsuario("Admin", "VERANOS2024");

        // Ejemplo de inserción en la tabla OSE
        long idOSE = dbManager.insertOSE("ose-24-001", "Luis Esteban Vega Gomez", "123456789", "estebanVega@fime.edu.mx",
                "Bascula", "Torrey", "987654321",
                "Reparacion", "A01", "cancelado", idUsuario);

        // Ejemplo de inserción en la tabla Bodega
        long idBodega = dbManager.insertBodega("A", "20");

        // Mostrar Snackbar para indicar éxito o fracaso de la inserción
        if (idUsuario != -1 && idOSE != -1 && idBodega != -1) {
            mostrarSnackbar("Datos insertados correctamente");
        } else {
            mostrarSnackbar("Error al insertar datos");
        }
    }

    private void mostrarSnackbar(String mensaje) {
        Snackbar.make(rootView, mensaje, Snackbar.LENGTH_SHORT).show();
    }
}
