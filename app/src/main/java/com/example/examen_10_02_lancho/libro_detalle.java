package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class libro_detalle extends AppCompatActivity {

    private TextView tituloLibro, autorLibro, isbnLibro, editorialLibro, numPaginasLibro, libroLeido;
    private int codigo;

    private SQLiteControlador controlador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro_detalle);

        controlador = new SQLiteControlador(this);

        tituloLibro = findViewById(R.id.tituloLibro);
        autorLibro = findViewById(R.id.autorLibro);
        isbnLibro = findViewById(R.id.isbnLibro);
        editorialLibro = findViewById(R.id.editorialLibro);
        numPaginasLibro = findViewById(R.id.numPaginasLibro);
        libroLeido = findViewById(R.id.libroLeido);

        Bundle extras = getIntent().getExtras();
        codigo = extras.getInt("codigo");
        tituloLibro.setText(extras.getString("titulo"));
        autorLibro.setText(extras.getString("autor"));
        isbnLibro.setText(extras.getString("isbn"));
        editorialLibro.setText(extras.getString("editorial"));
        numPaginasLibro.setText(extras.getInt("paginas")+"");
        libroLeido.setText(extras.getInt("leido")==0 ? R.string.libro_no_leido : R.string.libro_leido);

    }

    public void eliminar(View v){
        controlador.delete(codigo);
    }

    public void cancelar(View v){
        finish();
    }
}
