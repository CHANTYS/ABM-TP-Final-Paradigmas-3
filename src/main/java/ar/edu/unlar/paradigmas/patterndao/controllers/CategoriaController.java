/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.controllers;

/**
 *
 * @author nerv
 */


import ar.edu.unlar.paradigmas.patterndao.objects.Categoria;
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

public class CategoriaController implements ICrud<Categoria> {

   private Connection conn;
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
   
    public ArrayList<Categoria> listar() throws SQLException, Exception{
    
    
     conn = ConnectionDB.obtenerConexion ();
        try{
            
            this.stmt = conn.createStatement();
            this.sql = "SELECT * FROM categorias";
            this.rs   = stmt.executeQuery(sql);
            conn.close();
            
            ArrayList<Categoria> categorias = new ArrayList();
            
            while(rs.next()){
                
                Categoria categoria = new Categoria();
                
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setId(rs.getInt("id"));
                
                        //System.out.println(cliente);
                
                
                categorias.add(categoria);
                
            }
            //System.out.println(cont);
            //connection.close();
            return categorias;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }


   public CategoriaController() throws SQLException, ClassNotFoundException {
       this.conn = ConnectionDB.obtenerConexion();
   }

   @Override
   public boolean insertObject(Categoria entity) {
       String SQL_INSERT = "insert into categorias (nombre, descripcion) values (?,?);";
       try {
           PreparedStatement prepareStatement = conn.prepareStatement(SQL_INSERT);
           prepareStatement.setString(1, entity.getNombre());
           prepareStatement.setString(2, entity.getDescripcion());
           prepareStatement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
       }
       return true;
   }

   @Override
   public boolean deleteObject(int id) {
       String SQL_DELETE = "DELETE * FROM categorias WHERE id=?";
       try {
           PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
           preparedStatement.setInt(1, id);
           preparedStatement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
           return false;
       }
       return true;
   }

   @Override
   public Optional<Categoria> getObject(int id) {
       String SQL_QUERY_OBJECT = "SELECT * FROM categorias WHERE id=?";
       try {
           PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY_OBJECT);
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()) {
               Categoria categoria = new Categoria();
               categoria.setNombre(rs.getString("nombre"));
               categoria.setDescripcion(rs.getString("descripcion"));
               categoria.setId(rs.getInt("id"));
               return Optional.of(categoria);
           }
       } catch (SQLException ex) {
           Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, "no se puedo guardar los datos", ex);
       }
       return null;
   }

   @Override
   public boolean modifiedObject(Categoria entity) {
       String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=? WHERE id=?";
       try {
           PreparedStatement prepareStatement = conn.prepareStatement(SQL_UPDATE);
           prepareStatement.setString(1, entity.getNombre());
           prepareStatement.setString(2, entity.getDescripcion());
           prepareStatement.setInt(3, entity.getId());
           
           prepareStatement.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, "no se puedo modificar los datos", ex);
           return false;
       }
       return true;
   }

   @Override
   public List<Categoria> getAllObjects() {
       String SQL_LIST = "select * from categorias;";
       try {
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(SQL_LIST);

           List<Categoria> listadoCategorias = new ArrayList<>();

           while (rs.next()) {
               Categoria filaCategoria = new Categoria();
               filaCategoria.setNombre(rs.getString("nombre"));
               filaCategoria.setDescripcion(rs.getString("descripcion"));
               filaCategoria.setId(rs.getInt("id"));
               listadoCategorias.add(filaCategoria);
           }
           return listadoCategorias;
       } catch (SQLException ex) {
           Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

  
}
