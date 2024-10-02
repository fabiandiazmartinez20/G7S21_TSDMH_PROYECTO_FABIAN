package com.example.g7s21_tsdmh_proyecto_fabian;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosP implements Parcelable {
    private String nombre;
    private int edad;
    private String correo;

    // Constructor
    public DatosP(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }


    protected DatosP(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        correo = in.readString();
    }

    public static final Creator<DatosP> CREATOR = new Creator<DatosP>() {
        @Override
        public DatosP createFromParcel(Parcel in) {
            return new DatosP(in);
        }

        @Override
        public DatosP[] newArray(int size) {
            return new DatosP[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeString(correo);
    }
}
