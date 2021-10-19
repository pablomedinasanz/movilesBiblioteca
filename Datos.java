package com.example.biblioteca;

public class Datos {
    static public String lista[][] = {
            {"Libro1","Autor1"},
            {"Libro2","Autor2"},
            {"Libro3","Autor3"},
            {"Libro4","Autor4"},
            {"Libro5","Autor5"},
            {"Libro6","Autor6"},
            {"Libro7","Autor7"},
            {"Libro8","Autor8"},
            {"Libro9","Autor9"}
    };
    static public String[] getNombres(){
        String ret[] = new String[9];
        for (int i = 0; i < ret.length; i++)
            ret[i] = lista[i][0];
        return ret;
    }
}
