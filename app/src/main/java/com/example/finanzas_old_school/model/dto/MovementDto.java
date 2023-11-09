package com.example.finanzas_old_school.model.dto;

public class MovementDto {
    private String clase ;
    private String concepto;
    private String valor;
    private String fecha;

    public MovementDto() {
        this.clase = "";
        this.concepto = "";
        this.valor = "";
        this.fecha = "";
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
