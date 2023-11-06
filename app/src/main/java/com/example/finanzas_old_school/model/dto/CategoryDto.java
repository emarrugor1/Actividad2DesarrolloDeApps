package com.example.finanzas_old_school.model.dto;

import java.io.StringBufferInputStream;

public class CategoryDto {

    private String concepto ;
    private String tipo;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
