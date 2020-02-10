package com.example.examen_10_02_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tiempo extends AppCompatActivity {

    public String url;

    private Temporal temporal;

    private Button vitoria,bilbao,donosti;

    private TextView fecha,cielo,min,max;

    private boolean primerclick;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        view =findViewById(android.R.id.content).getRootView();

        vitoria = findViewById(R.id.btnVitoria);
        bilbao = findViewById(R.id.btnBilbao);
        donosti = findViewById(R.id.btnDonostia);

        vitoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "https://xml.tutiempo.net/xml/8043.xml";
                Tiempo.CargarXmlTask tarea = new Tiempo.CargarXmlTask();
                tarea.execute(url);

            }
        });

        bilbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050";
                Tiempo.CargarXmlTask tarea = new Tiempo.CargarXmlTask();
                tarea.execute(url);
            }
        });

        donosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917";
                Tiempo.CargarXmlTask tarea = new Tiempo.CargarXmlTask();
                tarea.execute(url);
            }
        });

        fecha = findViewById(R.id.tvFecha);
        cielo = findViewById(R.id.tvCielo);
        min = findViewById(R.id.tvMin);
        max = findViewById(R.id.tvMax);



        primerclick = true;



    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String... params) {
            Parseador domParser = new Parseador(params[0]);
            if(url.equals("https://xml.tutiempo.net/xml/8043.xml"))
                temporal = domParser.parseVitoria();
            else{
                temporal = domParser.parse();
            }
            return true;
        }

        protected void onPostExecute(Boolean result) {
            cargarDatos(view);
        }
    }

    public void cargarDatos(View view) {
        if (primerclick) {

            fecha.setVisibility(View.VISIBLE);
            cielo.setVisibility(View.VISIBLE);
            min.setVisibility(View.VISIBLE);
            max.setVisibility(View.VISIBLE);

            primerclick = false;
        }


        fecha.setText("Fecha "+temporal.getFecha());
        cielo.setText("Cielo: "+temporal.getEstadocielo());;
        min.setText("temperatura mínima "+temporal.getTempmin());
        max.setText("temperatura máxima "+temporal.getTempmax());

    }
}
