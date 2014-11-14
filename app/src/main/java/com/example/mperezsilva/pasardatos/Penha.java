package com.example.mperezsilva.pasardatos;

import java.io.Serializable;

/**
 * Created by mperezsilva on 7/11/14.
 */
public class Penha implements Serializable{
    private String nombre;
    private int tel;

    public Penha() {
    }

    public Penha(String nombre, int tel) {
        this.nombre = nombre;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

}
