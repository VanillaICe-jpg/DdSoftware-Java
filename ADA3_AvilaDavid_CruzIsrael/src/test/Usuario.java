/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author userhp
 */
public class Usuario {
    private String nombre;
    private String matricula;
    private String apellido1;
    private String apellido2;
     private String asignatura;
    private int calificacion;
    
    public Usuario(String matricula,String apellido1,String apellido2,String nombre,String asignatura,int calificacion) {
        this.nombre = nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.matricula=matricula;
        this.asignatura=asignatura;
        this.calificacion=calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion=calificacion;
    }
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura=asignatura;
    }
     public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
     public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
}
