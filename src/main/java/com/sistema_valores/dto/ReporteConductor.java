package com.sistema_valores.dto;

public class ReporteConductor {

    private String codigoSolicitud;
    private String nitEntidad;
    private String nombreEntidad;
    private String nombreConductor;
    private String fechaYHoraSolicitud;
    private String fechaRealizado;
    private String valor;
    private String direccionEntidad;

    public ReporteConductor(String codigoSolicitud, String nitEntidad, String nombreEntidad, String nombreConductor,
            String fechaYHoraSolicitud, String fechaRealizado, String valor, String direccionEntidad) {
        this.codigoSolicitud = codigoSolicitud;
        this.nitEntidad = nitEntidad;
        this.nombreEntidad = nombreEntidad;
        this.nombreConductor = nombreConductor;
        this.fechaYHoraSolicitud = fechaYHoraSolicitud;
        this.fechaRealizado = fechaRealizado;
        this.valor = valor;
        this.direccionEntidad = direccionEntidad;
    }

    // Getters
    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public String getNitEntidad() {
        return nitEntidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public String getFechaYHoraSolicitud() {
        return fechaYHoraSolicitud;
    }

    public String getFechaRealizado() {
        return fechaRealizado;
    }

    public String getValor() {
        return valor;
    }

    public String getDireccionEntidad() {
        return direccionEntidad;
    }
}
