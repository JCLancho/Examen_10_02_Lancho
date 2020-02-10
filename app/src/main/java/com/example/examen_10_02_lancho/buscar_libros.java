package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class buscar_libros extends AppCompatActivity {

    private RadioGroup grupoBuscar;
    private RadioButton radioTitulo, radioAutor, radioEditorial;

    private Button btnBuscar;
    private EditText inputBuscar;

    private SQLiteControlador controlador;

    private TextView opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_libros);

        grupoBuscar = findViewById(R.id.grupoBuscar);
        radioTitulo = findViewById(R.id.radioTitulo);
        radioAutor = findViewById(R.id.radioAutor);
        radioEditorial = findViewById(R.id.radioEditorial);
        opcion = findViewById(R.id.opcion);
        btnBuscar = findViewById(R.id.btnBuscar);
        inputBuscar = findViewById(R.id.inputBuscar);

        controlador = new SQLiteControlador(this);

        grupoBuscar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == radioTitulo.getId()){
                    opcion.setText(R.string.titulo);
                    opcion.setVisibility(View.VISIBLE);
                    inputBuscar.setVisibility(View.VISIBLE);
                    btnBuscar.setVisibility(View.VISIBLE);
                }else if(checkedId == radioAutor.getId()){
                    opcion.setText(R.string.editorial);
                    opcion.setVisibility(View.VISIBLE);
                    inputBuscar.setVisibility(View.VISIBLE);
                    btnBuscar.setVisibility(View.VISIBLE);
                }else if(checkedId == radioEditorial.getId()){
                    opcion.setText(R.string.autor);
                    opcion.setVisibility(View.VISIBLE);
                    inputBuscar.setVisibility(View.VISIBLE);
                    btnBuscar.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void buscar(View v){
        if(grupoBuscar.getCheckedRadioButtonId() == radioTitulo.getId()){
            Libro libro = controlador.getLibroTitulo(inputBuscar.getText().toString());
            if(libro != null) {
                Intent intent = new Intent(buscar_libros.this, libro_detalle.class);
                intent.putExtra("codigo", libro.getCodigo());
                intent.putExtra("titulo", libro.getTitulo());
                intent.putExtra("autor", libro.getAutor());
                intent.putExtra("editorial", libro.getEditorial());
                intent.putExtra("isbn", libro.getIsbn());
                intent.putExtra("paginas", libro.getPaginas());
                intent.putExtra("leido", libro.getLeido());
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Ningun libro encontrado con ese titulo", Toast.LENGTH_SHORT).show();
            }

        }else if(grupoBuscar.getCheckedRadioButtonId() == radioEditorial.getId()){
            String editorial = inputBuscar.getText().toString();
            Intent i = new Intent(buscar_libros.this, listado_libros.class);
            i.putExtra("editorial", editorial);
            startActivity(i);

        }else if(grupoBuscar.getCheckedRadioButtonId() == radioAutor.getId()){
            String autor = inputBuscar.getText().toString();
            Intent i = new Intent(buscar_libros.this, listado_libros.class);
            i.putExtra("autor", autor);
            startActivity(i);
        }
    }
}
