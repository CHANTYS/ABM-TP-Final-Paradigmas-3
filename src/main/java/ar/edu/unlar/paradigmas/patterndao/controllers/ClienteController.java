/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

import ar.edu.unlar.paradigmas.patterndao.objects.Cliente;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumEstadoCivil;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumSexo;
import ar.edu.unlar.paradigmas.patterndao.utils.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hchanampe
 */
public class ClienteController implements ICrud<Cliente>{
    
    private Connection conn;

    public ClienteController() throws SQLException, ClassNotFoundException {
        this.conn = ConnectionDB.obtenerConexion();
    }

            
          
    @Override
    public boolean insertObject(Cliente entity) {
        
        String SQL_INSERT = "insert into clientes (nombre, apellido, sexo, estado_civil, documento) values (?,?,?,?,?);";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, entity.getNombre());
            prepareStatement.setString(2, entity.getApellido());
            prepareStatement.setString(3, entity.getSexo().toString());
            prepareStatement.setString(4, entity.getEstadoCivil().toString());
            prepareStatement.setString(5, entity.getDocumento());
            prepareStatement.executeUpdate();
                        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
        }
        
        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Cliente> getObject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modifiedObject(Cliente entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> getAllObjects() {
        String SQL_LIST = "select * from clientes;";
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_LIST);
            
            List<Cliente> listadoClientes= new ArrayList<>();
            
            while(rs.next()){
            
                Cliente filaCliente = new Cliente();
                
                filaCliente.setApellido(rs.getString("apellido"));
                filaCliente.setNombre(rs.getString("nombre"));
                filaCliente.setDocumento(rs.getString("Documento"));

                filaCliente.setEstadoCivil(rs.getString("estado_civil"));
                
                listadoClientes.add(filaCliente);
            
            }
            return listadoClientes;
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }



}