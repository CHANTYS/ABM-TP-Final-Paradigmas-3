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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String SQL_INSERT = "INSERT INTO ventas (id, descripcion, cliente_id, fecha_venta, precio_total) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setInt(1, entity.getId());
            prepareStatement.setString(2, entity.getDescripcion());
            prepareStatement.setInt(3, entity.getCliente().getId());
            prepareStatement.setDate(4, new java.sql.Date(entity.getFecha_venta().getTime()));
            prepareStatement.setFloat(5, entity.getPrecio_total());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String SQL_DELETE = "DELETE FROM ventas WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, "no se puedo eliminar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public Optional<Venta> getObject(int id) {
        String SQL_QUERY_OBJECT = "SELECT * FROM ventas WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY_OBJECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setDescripcion(rs.getString("descripcion"));
                venta.setFecha_venta(rs.getDate("fecha_venta"));
                venta.setPrecio_total(rs.getFloat("precio_total"));

// Obtener el ArrayList<ItemVenta> usando el método getListadoItems()
                venta.setListadoItems(venta.getListadoItems());
                return Optional.of(venta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, "no se puedo obtener los datos", ex);
        }
        return Optional.empty();
    }

    @Override
    public boolean modifiedObject(Venta entity) {
        String SQL_UPDATE = "UPDATE ventas SET descripcion=?, cliente_id=?, fecha_venta=?, precio_total=? WHERE id=?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, entity.getDescripcion());
            prepareStatement.setInt(2, entity.getCliente().getId());
            prepareStatement.setDate(3, new java.sql.Date(entity.getFecha_venta().getTime()));
            prepareStatement.setFloat(4, entity.getPrecio_total());
            prepareStatement.setInt(5, entity.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, "no se puedo modificar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Venta> getAllObjects() {
        String SQL_LIST = "SELECT * FROM ventas";
        List<Venta> listaVentas = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_LIST);

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setDescripcion(rs.getString("descripcion"));

                venta.setFecha_venta(rs.getDate("fecha_venta"));
                venta.setPrecio_total(rs.getFloat("precio_total"));
                // Obtener el ArrayList<ItemVenta> usando el método getListadoItems()
                venta.setListadoItems(venta.getListadoItems());
                listaVentas.add(venta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaController.class.getName()).log(Level.SEVERE, "no se puedo listar los datos", ex);
        }
        return listaVentas;
    }

}
