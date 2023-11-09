/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

import ar.edu.unlar.paradigmas.patterndao.objects.Producto;
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
public class ProductoController implements ICrud<Producto>{
    
    private Connection conn;

    public ProductoController() throws SQLException, ClassNotFoundException {
        this.conn = ConnectionDB.obtenerConexion();
    }

            
          
    @Override
    public boolean insertObject(Producto entity) {
        
        
        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String SQL_DELETE = "DELETE * FROM clientes WHERE id=?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
            return false;
        }
        
        return true;
    }

    @Override
    public Optional<Producto> getObject(int id) {
            return null;

    }
    

    @Override
    public boolean modifiedObject(Producto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public List<Producto> getAllObjects() {
        ArrayList productos = new ArrayList();
        return null;
    }



}