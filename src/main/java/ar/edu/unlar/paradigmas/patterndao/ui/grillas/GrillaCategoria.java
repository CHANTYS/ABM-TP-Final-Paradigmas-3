/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui.grillas;

import ar.edu.unlar.paradigmas.patterndao.controllers.CategoriaController;
import ar.edu.unlar.paradigmas.patterndao.objects.Categoria;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class GrillaCategoria extends AbstractTableModel {
  
  private ArrayList<Categoria> categorias = new ArrayList<>();
  
  public GrillaCategoria( ArrayList<Categoria> categoria){
      this.categorias = categoria;
  }

  

  @Override
  public int getRowCount() {
      return this.categorias.size();
  }

  @Override
  public int getColumnCount() {
      return 3;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
      Categoria categoria = categorias.get(rowIndex);
      
      switch (columnIndex) {
          case 0: return categoria.getId();
          case 1: return categoria.getNombre();
          case 2: return categoria.getDescripcion();
          default: return "";
      }  
  }
  
  @Override
  public String getColumnName(int column){
      switch (column) {
          case 0: return "ID";
          case 1: return "Nombre";
          case 2: return "Descripcion";
          default: return "";
      }
  }

    public Categoria getCategoriaFromRow(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
