package com.example.g7s21_tsdmh_proyecto_fabian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    private DatosP datosP; // aqui almacenamos el objeto Parcelable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btncaptura = findViewById(R.id.btncaptura);
        Button btnmostrar = findViewById(R.id.btnmostrar);
        Button btnterminar = findViewById(R.id.btnterminar);


        btncaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CapturaActivity.class);
                startActivityForResult(intent, 1); // Se espera que tengamos un resultado de CapturaActivity
            }
        });


        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (datosP != null) {
                    intent = new Intent(MenuActivity.this, MostrarActivity.class);
                    intent.putExtra("Datos", datosP);
                } else {
                    intent = new Intent(MenuActivity.this, NoexisteActivity.class); // Si no hay datos va a  mostrar un mensaje o imagen de nuestra noexiste activity
                }
                startActivity(intent);
            }
        });


        btnterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la aplicación
            }
        });
    }

    // Recibimos los datos de la CapturaActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            datosP = data.getParcelableExtra("Datos");
        }
    }
}
