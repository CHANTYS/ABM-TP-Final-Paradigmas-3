/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui.grillas;

import ar.edu.unlar.paradigmas.patterndao.objects.ItemVenta;
import ar.edu.unlar.paradigmas.patterndao.objects.Venta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sebas
 */
public class GrillaItemVenta extends AbstractTableModel {
    private ArrayList<ItemVenta> data = new ArrayList<>();
    
    private String columns[]={"Producto","Cantidad","Precio"}; 

    public GrillaItemVenta() {
    }
    
    public GrillaItemVenta(ArrayList data){
        this.data=data;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemVenta itemVenta = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return itemVenta.getProducto().getNombre();
            case 1:
                return itemVenta.getCantidad();
                
            default:
                throw new AssertionError();
        }
    }
}
