package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void menuBBDD(View v){
        Intent i = new Intent(MainActivity.this, menu_bbdd.class);
        startActivity(i);
    }

    public void menuTiempo(View v){
        Intent i = new Intent(MainActivity.this, Tiempo.class);
        startActivity(i);
    }

    public void salir(View v){
        finish();
    }
}
