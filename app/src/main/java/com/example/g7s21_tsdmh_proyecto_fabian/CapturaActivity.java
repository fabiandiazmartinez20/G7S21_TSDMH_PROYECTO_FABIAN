package com.example.g7s21_tsdmh_proyecto_fabian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CapturaActivity extends AppCompatActivity {
    private EditText txtnombre, txtedad, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);

        Button btnregresarc = findViewById(R.id.btnregresarc);


        btnregresarc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos el objeto DatosP
                String nombre = txtnombre.getText().toString();
                int edad = Integer.parseInt(txtedad.getText().toString());
                String correo = txtcorreo.getText().toString();

                DatosP datosP = new DatosP(nombre, edad, correo);

                // Regresamos a la actividad principal con los datos
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Datos", datosP);
                setResult(RESULT_OK, resultIntent);
                finish(); // Volvemos al al menú
            }
        });
    }
}
