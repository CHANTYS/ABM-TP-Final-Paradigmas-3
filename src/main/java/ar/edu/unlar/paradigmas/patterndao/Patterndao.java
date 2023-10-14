/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ar.edu.unlar.paradigmas.patterndao;

import ar.edu.unlar.paradigmas.patterndao.controllers.ClienteController;
import ar.edu.unlar.paradigmas.patterndao.objects.Cliente;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumEstadoCivil;
import ar.edu.unlar.paradigmas.patterndao.objects.EnumSexo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hchanampe
 */
public class Patterndao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        
        ClienteController controller = new ClienteController();

        
        cliente.setApellido("test");
        cliente.setNombre("test");
        cliente.setDocumento("12345678");
        cliente.setEstadoCivil(EnumEstadoCivil.CASADO);
        cliente.setSexo(EnumSexo.MASCULINO);
        
       controller.insertObject(cliente);
       
       ArrayList<Cliente> listado = (ArrayList<Cliente>) controller.getAllObjects();
       
       listado.forEach((c)->{
           System.out.println(c.getApellido());
           System.out.println(c.getNombre());
           System.out.println(c.getDocumento());
       
       });
       
        
    }
}
