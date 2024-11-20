package com.example.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView lbltexto;
    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        setSupportActionBar(findViewById(R.id.menutop));
        registerForContextMenu(lbltexto);
    }

    public void init(){
        lbltexto = findViewById(R.id.lbltexto);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setTitle("Salir del programa")
                .setMessage("¿Desea salir del programa?")
                .setNegativeButton("No", null)
                .setPositiveButton("Si", (dialog, which) -> finish());

        alert = builder.create();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mitemrojo){
            lbltexto.setTextColor(getResources().getColor(R.color.rojo));
        } else if (item.getItemId() == R.id.mitemverde) {
            lbltexto.setTextColor(getResources().getColor(R.color.verde));
        }else if(item.getItemId() == R.id.mitemazul){
            lbltexto.setTextColor(getResources().getColor(R.color.azul));
        } else if (item.getItemId() == R.id.mitemsalir) {
            alert.show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mitemrojo){
            lbltexto.setTextColor(getResources().getColor(R.color.rojo));
        } else if (item.getItemId() == R.id.mitemverde) {
            lbltexto.setTextColor(getResources().getColor(R.color.verde));
        } else if(item.getItemId() == R.id.mitemazul){
            lbltexto.setTextColor(getResources().getColor(R.color.azul));
        } else if (item.getItemId() == R.id.mitemsalir) {
            alert.show();
        }
        return false;
    }
}