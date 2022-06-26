/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import fecha.MiCalendario;
import fecha.MiCalendarioException;
/**
 *
 * @author Gabriel
 */
public class Alumno extends Persona {

    private Double promedio;
    
    private Integer cantMatAprob;
    
    private Character estado;
    
    private MiCalendario fechaingreso;

    public Alumno() {
        super();
    }

    public Alumno(Double promedio, Integer cantMatAprob, Integer dni, String apyNom, Character sexo, 
            MiCalendario fechaNac, MiCalendario fechaIng) throws PersonaException, AlumnoException {
        super(dni, apyNom, sexo, fechaNac);
        this.setPromedio(promedio);        
        this.setCantMatAprob(cantMatAprob);
        this.setFechaIngreso(fechaIng);
        this.setEstado('A');        
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Integer getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(Integer cantMatAprob) {
        this.cantMatAprob = cantMatAprob;
    }
    
    public void setFechaIngreso(MiCalendario fechaIng){
        this.fechaingreso = fechaIng;
    }
    
    public MiCalendario getFechaIngreso() {
        return fechaingreso;
    }
    
        public Character getEstado() {
        return estado;
    }


    public void setEstado(Character estado) throws AlumnoException {   
        estado = Character.toUpperCase(estado);
        if (!estado.equals('A') && !estado.equals('B') && !estado.equals('M')) {
            throw new AlumnoException("Error al setear el Estado (debe contener a/b/m)");
        }
        this.estado = estado;        
    } 
    
    @Override
    public String toString() {
        return super.toString()+DELIM+cantMatAprob+DELIM+fechaingreso+DELIM+promedio+DELIM+estado;        
    }
    
    public static Alumno string2Alumno(String[] campos) throws PersonaException, MiCalendarioException, AlumnoException {
        Alumno alu = new Alumno();
        int index = 0;
        alu.setDni(Integer.valueOf(campos[index++]));
        alu.setApyNom(campos[index++]);
        alu.setSexo(campos[index++].charAt(0));
        
        // 23/08/1974
        String[] fechaNac = campos[index++].split("/");
        int dia = Integer.valueOf(fechaNac[0]);
        int mes = Integer.valueOf(fechaNac[1]);
        int anio = Integer.valueOf(fechaNac[2]);
        alu.setFechaNac(new MiCalendario(dia, mes, anio));
        
        alu.setCantMatAprob(Integer.valueOf(campos[index++]));        
        
        String[] fechaIng = campos[index++].split("/");
        int diaIng = Integer.valueOf(fechaIng[0]);
        int mesIng = Integer.valueOf(fechaIng[1]);
        int anioIng = Integer.valueOf(fechaIng[2]);
        alu.setFechaIngreso(new MiCalendario(diaIng, mesIng, anioIng));
        
        alu.setPromedio(Double.valueOf(campos[index++]));        
        
        alu.setEstado(campos[index++].charAt(0));
        
        return alu;
    }


   
}