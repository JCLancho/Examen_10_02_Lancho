package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class nuevo_libro extends AppCompatActivity {

    private EditText inputTitulo, inputAutor, inputIsbn, inputEditorial, inputNumPaginas;
    private CheckBox checkLeido;

    private SQLiteControlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_libro);

        inputTitulo = findViewById(R.id.inputTitulo);
        inputAutor = findViewById(R.id.inputAutor);
        inputIsbn = findViewById(R.id.inputIsbn);
        inputEditorial = findViewById(R.id.inputEditorial);
        inputNumPaginas = findViewById(R.id.inputNumPaginas);
        checkLeido = findViewById(R.id.checkLeido);

        controlador = new SQLiteControlador(this);
    }

    public void insertar(View v){
        Libro libro = new Libro();
        libro.setTitulo(inputTitulo.getText().toString());
        libro.setAutor(inputAutor.getText().toString());
        libro.setIsbn(inputIsbn.getText().toString());
        libro.setEditorial(inputEditorial.getText().toString());
        libro.setPaginas(Integer.parseInt(inputNumPaginas.getText().toString()));
        libro.setLeido(checkLeido.isChecked() ? 1 : 0);
        controlador.add(libro);
        limpiar(v);
    }

    public void limpiar(View v){
        inputTitulo.setText("");
        inputAutor.setText("");
        inputIsbn.setText("");
        inputEditorial.setText("");
        inputNumPaginas.setText("");
        checkLeido.setChecked(false);
    }

    public void volver(View v){
        finish();
    }
}
