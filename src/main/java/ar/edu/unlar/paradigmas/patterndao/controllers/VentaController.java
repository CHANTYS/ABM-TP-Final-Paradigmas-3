/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

import ar.edu.unlar.paradigmas.patterndao.objects.Cliente;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumEstadoCivil;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumSexo;
import ar.edu.unlar.paradigmas.patterndao.objects.Venta;
import ar.edu.unlar.paradigmas.patterndao.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
        /**
 *
 * @author sebas
 */
public class VentaController implements ICrud<Venta> {
    private Connection conn;

    
    public VentaController() throws SQLException, ClassNotFoundException {
            this.conn = ConnectionDB.obtenerConexion();

    }
    
    

    @Override
    public boolean insertObject(Venta entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteObject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Venta> getObject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modifiedObject(Venta entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> getAllObjects() {
         ArrayList<Venta> ventas=new ArrayList<>();
         Cliente c = new Cliente("Sebastian", "Torralba", "28403003", EnumSexo.MASCULINO, EnumEstadoCivil.CASADO);
         Venta v=new Venta();
         v.setCliente(c);
         v.setId(1);
         v.setDescripcion("Venta Manual");
         v.setPrecio_total(1000f);
         //v.setFecha(Calendar.getInstance().getTime());
         ventas.add(v);
         return ventas;
    }

}
