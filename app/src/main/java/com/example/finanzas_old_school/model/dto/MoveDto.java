package com.example.finanzas_old_school.model.dto;

public class MoveDto {
    private String clase ;
    private String concepto;
    private String valor;
    private String fecha;

    public MoveDto(String clase, String concepto, String valor, String fecha) {
        this.clase = clase;
        this.concepto = concepto;
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
