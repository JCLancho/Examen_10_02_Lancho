package com.example.examen_10_02_lancho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorLibros extends ArrayAdapter<Libro> {

    private Libro[] libros;

    public AdaptadorLibros(@NonNull Context context, Libro[] libros) {
        super(context, R.layout.adaptador_libros);
        this.libros = libros;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.adaptador_libros, null);

        TextView titulo, autor;

        titulo = item.findViewById(R.id.titulo_adapter);
        autor = item.findViewById(R.id.autor_adapter);

        titulo.setText(libros[position].getTitulo());
        autor.setText(libros[position].getAutor());

        return (item);
    }
}
