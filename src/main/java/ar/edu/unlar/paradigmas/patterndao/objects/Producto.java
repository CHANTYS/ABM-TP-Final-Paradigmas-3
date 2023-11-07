/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.objects;

/**
 *
 * @author hchanampe
 */
public class Producto {
    private Integer id;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private Float precio;
    private Float cantidad;
    private UnidadEnum unidad;

    public Producto() {
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadEnum getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadEnum unidad) {
        this.unidad = unidad;
    }
    
    
    
    
    
    
}
