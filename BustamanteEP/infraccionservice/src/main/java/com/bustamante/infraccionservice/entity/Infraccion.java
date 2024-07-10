package com.bustamante.infraccionservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "infracciones")


public class Infraccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 8, nullable = false)
    private String dni;
    
    @Column(nullable = false)
    private LocalDateTime fecha;
    
    @Column(length = 20, nullable = false)
    private String tipo_infraccion;
    
    @Column(length = 200, nullable = false)
    private String ubicacion;
    
    @Column(length = 255, nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private double monto_multa;
    
    @Column(length = 20, nullable = false)
    private String estado;
    
    // Getters and setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public String getTipo_infraccion() {
        return tipo_infraccion;
    }
    
    public void setTipo_infraccion(String tipo_infraccion) {
        this.tipo_infraccion = tipo_infraccion;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getMonto_multa() {
        return monto_multa;
    }
    
    public void setMonto_multa(double monto_multa) {
        this.monto_multa = monto_multa;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
