package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_bbdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bbdd);
    }

    public void nuevoLibro(View v){
        Intent i = new Intent(menu_bbdd.this, nuevo_libro.class);
        startActivity(i);
    }

    public void buscarLibros(View v){
        Intent i = new Intent(menu_bbdd.this, buscar_libros.class);
        startActivity(i);
    }

    public void listadoLibros(View v){
        Intent i = new Intent(menu_bbdd.this, listado_libros.class);
        startActivity(i);
    }

    public void salir(View v){
        finish();
    }
}
