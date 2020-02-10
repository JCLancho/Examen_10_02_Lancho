package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class listado_libros extends AppCompatActivity implements AdapterView.OnItemLongClickListener{

    private ListView lista;

    private RadioGroup grupo;
    private RadioButton radioLeidos, radioNoleidos, radioTodos;

    private SQLiteControlador controlador;

    private Libro[] libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_libros);

        grupo = findViewById(R.id.grupoLeidos);
        radioLeidos = findViewById(R.id.radioLeidos);
        radioNoleidos = findViewById(R.id.radioNoLeidos);
        radioTodos = findViewById(R.id.radioTodos);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == radioLeidos.getId()){
                    libros = controlador.getLibrosLeidos();
                    AdaptadorLibros al = new AdaptadorLibros(getApplicationContext(), libros);
                    lista.setAdapter(al);
                }else if(checkedId == radioNoleidos.getId()){
                    libros = controlador.getLibrosNoLeidos();
                    AdaptadorLibros al = new AdaptadorLibros(getApplicationContext(), libros);
                    lista.setAdapter(al);
                }else if(checkedId == radioTodos.getId()){
                    libros = controlador.getLibros();
                    AdaptadorLibros al = new AdaptadorLibros(getApplicationContext(), libros);
                    lista.setAdapter(al);
                }
            }
        });

        controlador = new SQLiteControlador(this);
        libros = controlador.getLibros();

        lista = findViewById(R.id.lista);
        AdaptadorLibros al = new AdaptadorLibros(listado_libros.this, libros);
        lista.setAdapter(al);

        if ((String)getIntent().getStringExtra("autor")!=null){
            String autor= (String)getIntent().getStringExtra("autor");
            libros = controlador.getLibroAutor((String)getIntent().getStringExtra("autor"));
            grupo.setVisibility(View.INVISIBLE);

            AdaptadorLibros adaptadorLibros = new AdaptadorLibros(listado_libros.this, libros);
            lista.setAdapter(adaptadorLibros);
            lista.setOnItemLongClickListener(listado_libros.this);
        }
        if ((String)getIntent().getStringExtra("editorial")!=null){
            String editorial = (String)getIntent().getStringExtra("editorial");
            libros = controlador.getLibroEditorial((String)getIntent().getStringExtra("editorial"));
            grupo.setVisibility(View.INVISIBLE);

            AdaptadorLibros adaptadorLibros = new AdaptadorLibros(listado_libros.this, libros);
            lista.setAdapter(adaptadorLibros);
            lista.setOnItemLongClickListener(listado_libros.this);
        }


    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Libro libro = (Libro)parent.getItemAtPosition(position);
        Intent intent = new Intent(listado_libros.this, libro_detalle.class);
        intent.putExtra("codigo", libro.getCodigo());
        intent.putExtra("titulo", libro.getTitulo());
        intent.putExtra("autor", libro.getAutor());
        intent.putExtra("editorial", libro.getEditorial());
        intent.putExtra("isbn", libro.getIsbn());
        intent.putExtra("paginas", libro.getPaginas());
        intent.putExtra("leido", libro.getLeido());
        startActivity(intent);

        return false;
    }

    public void volver(View v){
        finish();
    }
}
