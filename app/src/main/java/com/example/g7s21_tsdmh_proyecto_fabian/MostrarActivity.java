package com.example.g7s21_tsdmh_proyecto_fabian;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarActivity extends AppCompatActivity {
    private TextView lblnombre, lbledad, lblcorreo;
    private Button btnregresarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);


        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);
        lblcorreo = findViewById(R.id.lblcorreo);
        btnregresarm = findViewById(R.id.btnregresarm);

        // Obtenemos el objeto DatosP que se pasó con Parcelable
        DatosP datosP = getIntent().getParcelableExtra("Datos");

        // aqui verificamos si los datos existen
        if (datosP != null) {
            // Mostrar los datos
            lblnombre.setText(datosP.getNombre());
            lbledad.setText(String.valueOf(datosP.getEdad()));
            lblcorreo.setText(datosP.getCorreo());
        }


        btnregresarm.setOnClickListener(v -> finish());
    }
}
