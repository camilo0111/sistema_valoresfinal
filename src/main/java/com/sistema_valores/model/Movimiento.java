package com.sistema_valores.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nit_entidad", nullable = false)
    @JsonProperty("nit_entidad") // si también lo usas en el cliente
    private String nitEntidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false)
    @JsonProperty("tipo_movimiento")
    private TipoMovimiento tipoMovimiento;

    @Column(name = "fecha_movimiento", nullable = false)
    @JsonProperty("fecha_movimiento")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMovimiento;

    @Column(name = "hora_movimiento", nullable = false)
    @JsonProperty("hora_movimiento")
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaMovimiento;

    @Column(nullable = false)
    private BigDecimal monto; // Jackson serializa BigDecimal a número

    private String descripcion;
    private String ubicacion;

    public enum TipoMovimiento {
        ENTREGAR,
        RECOGER
    }

    // getters y setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNitEntidad() {
        return nitEntidad;
    }

    public void setNitEntidad(String nitEntidad) {
        this.nitEntidad = nitEntidad;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public LocalTime getHoraMovimiento() {
        return horaMovimiento;
    }

    public void setHoraMovimiento(LocalTime horaMovimiento) {
        this.horaMovimiento = horaMovimiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
