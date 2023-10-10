/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author zurisaddairj
 */
@Named(value = "beanIndex")
@SessionScoped
public class beanIndex implements Serializable{

    /**
     * Creates a new instance of BeanIndex
     */
    private String clave;
    private int claveInt=0;
    private String nombre;
    private String direccion;
    private String telefono;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    public beanIndex() {
    }
    
    public boolean guardar(){
        return true;
    }

    public int getClaveInt() {
        return claveInt;
    }

    public void setClaveInt(int claveInt) {
        this.claveInt = claveInt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void incrementar(){
        claveInt++;
        clave=String.valueOf(claveInt);
    }
}
