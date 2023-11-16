/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui.grillas;

/**
 *
 * @author nerv
 */
import ar.edu.unlar.paradigmas.patterndao.objects.Producto;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class GrillaProducto extends AbstractTableModel {
   
   private ArrayList<Producto> productos = new ArrayList<>();
   
   public GrillaProducto(ArrayList<Producto> datos){
       this.productos = datos;
   }

   @Override
   public int getRowCount() {
       return this.productos.size();
   }

   @Override
   public int getColumnCount() {
       return 6;
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
       Producto producto = productos.get(rowIndex);
       
       switch (columnIndex) {
           case 0: return producto.getId();
           case 1: return producto.getNombre();
           case 2: return producto.getDescripcion();
           case 3: return producto.getPrecio();
           case 4: return producto.getCantidad();
           case 5: return producto.getUnidad().name();
           default: return "";
       }   
   }
   
   @Override
   public String getColumnName(int column){
       switch (column) {
           case 0: return "ID";
           case 1: return "Nombre";
           case 2: return "Descripcion";
           case 3: return "Precio";
           case 4: return "Cantidad";
           case 5: return "Unidad";
           default: return "";
       }
   }
}
