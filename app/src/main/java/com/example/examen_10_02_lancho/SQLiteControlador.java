package com.example.examen_10_02_lancho;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SQLiteControlador {

    private String nombrebd;
    private Context context;

    public SQLiteControlador(Context context) {
        this.context = context;
        nombrebd = "examen";
    }

    public SQLiteControlador(Context context, String nombrebd) {
        this.context = context;
        this.nombrebd = nombrebd;
    }

    private SQLiteHelper getSQLiteHelper() {
        return new SQLiteHelper(context, nombrebd, null, 2);
    }



    public Libro[] getLibros() {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];

        c = db.rawQuery("SELECT * FROM Libros",null);
        int x = 0;
        while (c.moveToNext()) {
            Libro libro = new Libro(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)
            );
            libros[x]=libro;
            x++;
        }
        c.close();
        db.close();

        return libros;
    }

    public Libro[] getLibrosLeidos() {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];

        c = db.rawQuery("SELECT * FROM Libros WHERE leido = 1",null);
        int x = 0;
        while (c.moveToNext()) {
            Libro libro = new Libro(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)
            );
            libros[x]=libro;
            x++;
        }
        c.close();
        db.close();

        return libros;
    }

    public Libro[] getLibrosNoLeidos() {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];

        c = db.rawQuery("SELECT * FROM Libros WHERE leido = 1",null);
        int x = 0;
        while (c.moveToNext()) {
            Libro libro = new Libro(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)
            );
            libros[x]=libro;
            x++;
        }
        c.close();
        db.close();

        return libros;
    }

    public Libro getLibroTitulo(String titulo) {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros WHERE titulo = '"+titulo+"'",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];
        if(libros.length != 0) {
            c = db.rawQuery("SELECT * FROM Libros WHERE titulo ='" + titulo + "'", null);
            int x = 0;
            while (c.moveToNext()) {

                Libro libro = new Libro(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getInt(5),
                        c.getInt(6)
                );
                libros[x] = libro;
                x++;
            }
            c.close();
            db.close();

            return libros[0];
        }else{
            return null;
        }
    }

    public Libro[] getLibroAutor(String autor) {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros WHERE autor = '"+autor+"'",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];

        c = db.rawQuery("SELECT * FROM Libros WHERE autor ='"+autor+"'",null);
        int x = 0;
        while (c.moveToNext()) {

            Libro libro = new Libro(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)
            );
            libros[x]=libro;
            x++;
        }
        c.close();
        db.close();

        return libros;
    }

    public Libro[] getLibroEditorial(String editorial) {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT COUNT(1) FROM Libros WHERE editorial = '"+editorial+"'",null);
        c.moveToFirst();
        Libro[] libros = new Libro[c.getInt(0)];

        c = db.rawQuery("SELECT * FROM Libros WHERE editorial ='"+editorial+"'",null);
        int x = 0;
        while (c.moveToNext()) {

            Libro libro = new Libro(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)
            );
            libros[x]=libro;
            x++;
        }
        c.close();
        db.close();

        return libros;
    }

    public void add(Libro libro) {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        db.execSQL("INSERT INTO Libros(titulo,autor,isbn,editorial,paginas,leido) VALUES('"
                +libro.getTitulo()+"','"
                +libro.getAutor()+"','"
                +libro.getIsbn()+"','"
                +libro.getEditorial()+"','"
                +libro.getPaginas()+"','"
                +libro.getLeido()+"')");

        db.close();
        Toast.makeText(context, "Libro añadido", Toast.LENGTH_SHORT).show();
    }


    public void delete(int codigo) {
        SQLiteHelper sqlh = getSQLiteHelper();
        SQLiteDatabase db = sqlh.getWritableDatabase();

        db.execSQL("DELETE FROM Libros WHERE codigo="+codigo);

        db.close();
        Toast.makeText(context, "Libro eliminado", Toast.LENGTH_SHORT).show();

    }

}
