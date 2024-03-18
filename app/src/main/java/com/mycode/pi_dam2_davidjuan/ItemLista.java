package com.mycode.pi_dam2_davidjuan;

public class ItemLista {
    private String imagen;
    private String textoNombre;
    private String textoPie;

    public ItemLista(String imagen, String textoSup, String textoInf) {
        this.imagen = imagen;
        this.textoNombre = textoSup;
        this.textoPie = textoInf;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(String textoNombre) {
        this.textoNombre = textoNombre;
    }

    public String getTextoPie() {
        return textoPie;
    }

    public void setTextoPie(String textoPie) {
        this.textoPie = textoPie;
    }
}

