/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import fecha.MiCalendario;

/**
 *
 * @author Gabriel
 */
public class Persona {
    
    private static final int APYNOM_MAXLENGHT = 20;

    public static final String DELIM = "\t";
    
    private Integer dni;
    
    private String apyNom;
    
    private Character sexo;
    
    private MiCalendario fechaNac;

    public Persona() {
    }

    public Persona(Integer dni) throws PersonaException {
        this.setDni(dni);
    }

    public Persona(Integer dni, String apyNom, Character sexo, MiCalendario fechaNac) throws PersonaException {
        this.setDni(dni);
        this.setApyNom(apyNom);
        this.setSexo(sexo);
        this.setFechaNac(fechaNac);
    }

    public Integer getDni() {
        return dni;
    }    

    public final void setDni(Integer dni) throws PersonaException {
        if (dni==null || dni<=0) {
            // Error
            throw new PersonaException("Error al setear el DNI (solo se permiten valores positivos)");
        }
        this.dni = dni;
    }

    public String getApyNom() {
        return apyNom;
    }

    public final void setApyNom(String apyNom) throws PersonaException {
        if (apyNom == null || apyNom.trim().isEmpty()) {
            throw new PersonaException("Error al setear el Nombre y Apellido (debe tener contenido)");
        }
        if(apyNom.trim().length() > 20){
            throw new PersonaException("Error al setear el Nombre y Apellido (debe tener como máximo 20 caracteres)");
        }
            
        this.apyNom = apyNom.trim();
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) throws PersonaException {
        Character sexoLowerCase = Character.toLowerCase(sexo);
        if (!sexoLowerCase.equals('f') && !sexoLowerCase.equals('m')) {
            throw new PersonaException("Error al setear el sexo (debe contener f/m/F/M)");
        }
        this.sexo = sexoLowerCase;
    }

    public MiCalendario getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(MiCalendario fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        String apyn = apyNom.length()>APYNOM_MAXLENGHT?apyNom.substring(0, APYNOM_MAXLENGHT):apyNom;

        return String.format("%08d", dni)+DELIM+String.format("%"+APYNOM_MAXLENGHT+"s", apyn)+DELIM+
                sexo+DELIM+fechaNac;
    }

    
}
