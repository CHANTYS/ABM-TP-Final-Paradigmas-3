/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

import ar.edu.unlar.paradigmas.patterndao.objects.Categoria;
import ar.edu.unlar.paradigmas.patterndao.objects.Producto;
import ar.edu.unlar.paradigmas.patterndao.objects.UnidadEnum;
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
public class ProductoController implements ICrud<Producto> {

    private Connection conn;
    private Statement statementmt;
    private String query;
    private ResultSet resultSet;
    private CategoriaController categoriaControlador;

    public ProductoController() throws SQLException, ClassNotFoundException {
        this.conn = ConnectionDB.obtenerConexion();
    }

    @Override
    public boolean insertObject(Producto entity) {
        String SQL_INSERT = "INSERT INTO productos (id, categoria, nombre, descripcion, precio, cantidad, unidad) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_INSERT);
            prepareStatement.setInt(1, entity.getId());
            prepareStatement.setString(2, entity.getCategoria().getNombre());
            prepareStatement.setString(3, entity.getNombre());
            prepareStatement.setString(4, entity.getDescripcion());
            prepareStatement.setFloat(5, entity.getPrecio());
            prepareStatement.setFloat(6, entity.getCantidad());
            prepareStatement.setString(7, entity.getUnidad().name());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteObject(int id) {
        String SQL_DELETE = "DELETE FROM productos WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, "no se puedo eliminar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public Optional<Producto> getObject(int id) {
        String SQL_QUERY_OBJECT = "SELECT * FROM productos WHERE id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY_OBJECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setCantidad(rs.getFloat("cantidad"));
                producto.setUnidad(UnidadEnum.valueOf(rs.getString("unidad")));

                return Optional.of(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, "no se puedo obtener los datos", ex);
        }
        return Optional.empty();
    }

    @Override
    public boolean modifiedObject(Producto entity) {
        String SQL_UPDATE = "UPDATE productos SET categoria=?, nombre=?, descripcion=?, precio=?, cantidad=?, unidad=? WHERE id=?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(SQL_UPDATE);
            prepareStatement.setInt(1, entity.getCategoria().getId());
            prepareStatement.setString(2, entity.getNombre());
            prepareStatement.setString(3, entity.getDescripcion());
            prepareStatement.setFloat(4, entity.getPrecio());
            prepareStatement.setFloat(5, entity.getCantidad());
            prepareStatement.setString(6, entity.getUnidad().name());
            prepareStatement.setInt(7, entity.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, "no se puedo modificar los datos", ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Producto> getAllObjects() {
        ArrayList productos = new ArrayList();
        return null;
    }

    public ArrayList<Producto> listar() throws Exception {
        conn = ConnectionDB.obtenerConexion();
        try {

            this.statementmt = conn.createStatement();
            this.query = "SELECT * FROM productos";
            this.resultSet = statementmt.executeQuery(query);
            conn.close();

            ArrayList<Producto> productos = new ArrayList();

            while (resultSet.next()) {

                Producto producto = new Producto();

                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setPrecio(resultSet.getFloat("precio"));
                producto.setCantidad(resultSet.getFloat("cantidad"));
                producto.setUnidad(UnidadEnum.valueOf(resultSet.getString("unidad")));
                producto.setCategoria(getCategoria(resultSet.getInt("categoria_id")));
                //System.out.println(cliente);

                productos.add(producto);

            }
            //System.out.println(cont);
            return productos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Categoria getCategoria(Integer id) throws Exception {
        this.categoriaControlador = new CategoriaController();
        Optional<Categoria> categoriaOptional = categoriaControlador.getObject(id);
        if (categoriaOptional.isPresent()) {
            return categoriaOptional.get();
        } else {
            throw new Exception("Categoria no encontrada");
        }
    }

}
