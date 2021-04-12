package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;
@JacksonXmlRootElement(localName = "discos")

public class Disco {
    @JacksonXmlProperty(isAttribute = true)
    private int codigo;
    @JacksonXmlProperty(isAttribute = true)
    private String cantante;
    @JacksonXmlProperty(isAttribute = true)
    private String titulo;
    @JacksonXmlProperty(isAttribute = true)
    private String fecha;

    public Disco(){
    }

    public Disco(int codigo, String cantante, String titulo, String fecha) {
        this.codigo = codigo;
        this.cantante = cantante;
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCantante() {
        return cantante;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }
}
