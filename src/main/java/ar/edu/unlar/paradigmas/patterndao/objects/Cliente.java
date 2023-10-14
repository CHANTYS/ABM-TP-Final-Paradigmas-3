/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.unlar.paradigmas.patterndao.objects;

/**
 *
 * @author hchanampe
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private String documento;
    private EnumSexo sexo;
    private EnumEstadoCivil estadoCivil;

    public Cliente(String nombre, String apellido, String documento, EnumSexo sexo, EnumEstadoCivil estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public Cliente() {
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public void setSexo(EnumSexo sexo) {
        this.sexo = sexo;
    }

    public EnumEstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public void setEstadoCivil(String value){
        
        if(value != null){
            this.estadoCivil = EnumEstadoCivil.valueOf(value);
           
    }
       
        
    }
    
    
    
    
}
