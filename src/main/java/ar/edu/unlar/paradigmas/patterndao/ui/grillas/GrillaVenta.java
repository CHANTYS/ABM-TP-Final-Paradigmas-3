/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui.grillas;

import ar.edu.unlar.paradigmas.patterndao.objects.Venta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sebas
 */
public class GrillaVenta extends AbstractTableModel{
    
    private ArrayList<Venta> data = new ArrayList<>();
    
    private String columns[]={"ID","Descripcion","Cliente","Fecha","Precio"}; 

    public GrillaVenta() {
    }
    
    public GrillaVenta(ArrayList data){
        this.data=data;
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
        Venta elemento=data.get(rowIndex);
        switch(columnIndex){
                case 0: return elemento.getId();
                case 1: return elemento.getDescripcion();
                case 2: return elemento.getCliente().getApellido();
                case 3: return elemento.getFecha_venta();
                case 4: return elemento.getPrecio_total();
                default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
