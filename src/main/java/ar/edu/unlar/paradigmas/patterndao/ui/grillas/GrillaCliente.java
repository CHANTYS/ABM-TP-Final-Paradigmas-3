/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.ui.grillas;

import ar.edu.unlar.paradigmas.patterndao.objects.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hchanampe
 */
public class GrillaCliente extends AbstractTableModel {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    public GrillaCliente(ArrayList<Cliente> datos){
        this.clientes = datos;
    }

    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return cliente.getId();
            case 1: return cliente.getApellido();
            case 2: return cliente.getNombre(); 
            case 3: return cliente.getDocumento();
            case 4: return cliente.getSexo();
            case 5: return cliente.getEstadoCivil();
            case 6: return cliente.getTipoCliente();
            default: return "";
        }    
    }
    
    
    @Override
    public String getColumnName(int column){
    
            switch (column) {
            case 0: return "ID";
            case 1: return "Apellido";
            case 2: return "Nombre"; 
            case 3: return "Documento";
            case 4: return "Sexo";
            case 5: return "Estado Civil";
            case 6: return "Tipo Cliente";
            default: return "";
        }
    
    }
    
}