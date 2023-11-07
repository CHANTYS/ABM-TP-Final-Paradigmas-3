/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.objects;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author hchanampe
 */
public class Venta {
    private Integer id;
    private String descripcion;
    private Cliente cliente;
    private Date fecha_venta;
    private Float precio_total;
    private ArrayList<ItemVenta> listadoItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public ArrayList<ItemVenta> getListadoItems() {
        return listadoItems;
    }

    public void setListadoItems(ArrayList<ItemVenta> listadoItems) {
        this.listadoItems = listadoItems;
    }
    
    
}
