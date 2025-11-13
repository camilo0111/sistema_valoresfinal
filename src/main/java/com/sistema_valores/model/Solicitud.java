package com.sistema_valores.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @Column(name = "nit_entidad")
    private String nitEntidad;

    @Column(name = "valor")
    private double valor;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.pendiente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_solicitud")
    private TipoSolicitud tipoSolicitud;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud = LocalDateTime.now();

    @Column(name = "fecha_realizado")
    private LocalDate fechaRealizado = LocalDate.now();

    @Column(name = "nombre_conductor")
    private String nombreConductor;

    public enum Estado {
        pendiente, en_proceso, completada, cancelada
    }

    public enum TipoSolicitud {
        RECOGER, ENTREGAR
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNitEntidad() {
        return nitEntidad;
    }

    public void setNitEntidad(String nitEntidad) {
        this.nitEntidad = nitEntidad;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(LocalDate fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }
}
