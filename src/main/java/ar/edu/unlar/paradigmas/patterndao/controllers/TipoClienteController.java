/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

import ar.edu.unlar.paradigmas.patterndao.objects.TipoCliente;
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
public class TipoClienteController implements ICrud<TipoCliente> {

    private Connection conn;

    public TipoClienteController() throws SQLException, ClassNotFoundException {
        this.conn = ConnectionDB.obtenerConexion();
    }

    @Override
    public boolean insertObject(TipoCliente entity) {
        String SQL_INSERT = "INSERT INTO tipo_clientes (id, nombre, descripcion) VALUES (?,?,?)";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setInt(1, entity.getId());
            prepareStatement.setString(2, entity.getNombre());
            prepareStatement.setString(3, entity.getDescripcion());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoClienteController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String SQL_DELETE = "DELETE FROM tipo_clientes WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoClienteController.class.getName()).log(Level.SEVERE, "no se puedo eliminar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public Optional<TipoCliente> getObject(int id) {
        String SQL_QUERY_OBJECT = "SELECT * FROM tipo_clientes WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY_OBJECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(rs.getInt("id"));
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));
                return Optional.of(tipoCliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoClienteController.class.getName()).log(Level.SEVERE, "no se puedo obtener los datos", ex);
        }
        return Optional.empty();
    }

    @Override
    public boolean modifiedObject(TipoCliente entity) {
        String SQL_UPDATE = "UPDATE tipo_clientes SET nombre=?, descripcion=? WHERE id=?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, entity.getNombre());
            prepareStatement.setString(2, entity.getDescripcion());
            prepareStatement.setInt(3, entity.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoClienteController.class.getName()).log(Level.SEVERE, "no se puedo modificar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public List<TipoCliente> getAllObjects() {
        String SQL_LIST = "SELECT * FROM tipo_clientes";
        List<TipoCliente> listaTiposClientes = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_LIST);

            while (rs.next()) {
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(rs.getInt("id"));
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));
                listaTiposClientes.add(tipoCliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoClienteController.class.getName()).log(Level.SEVERE, "no se puedo listar los datos", ex);
        }
        return listaTiposClientes;
    }

}
