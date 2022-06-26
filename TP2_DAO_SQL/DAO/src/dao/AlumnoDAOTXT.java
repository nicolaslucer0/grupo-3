/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fecha.MiCalendarioException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.Persona;
import persona.PersonaException;
import persona.AlumnoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class AlumnoDAOTXT extends DAO<Alumno, Integer>{

    private RandomAccessFile raf;
    
    AlumnoDAOTXT(File archivo, String mode) throws AlumnoDAOException {
        try {
            raf = new RandomAccessFile(archivo, mode);
        } catch (FileNotFoundException ex) {
            throw new AlumnoDAOException("Archivo no encontrado ==> "+ex.getMessage());
        }
    }
    
    @Override
    public void create(Alumno alu) throws AlumnoDAOException {
        if (existe(alu.getDni())) {
            throw new AlumnoDAOException("El alumno con DNI "+alu.getDni()+" ya existe");
        }
        
        try {
            
            raf.seek(raf.length());
            
            raf.writeBytes(alu+System.lineSeparator());
            
        } catch (IOException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        }
    }

    @Override
    public Alumno read(Integer dni) throws AlumnoDAOException {
        try {
            // Posicionar al inicio
            raf.seek(0);
            String linea;
            String[] campos;
            while ((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                if (Integer.valueOf(campos[0]).equals(dni)) {
                    Alumno alu = Alumno.string2Alumno(campos);
                    if (alu.getEstado()!='B') {
                        return alu;
                    }
                    return null;
                }
            }
        } catch (IOException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        } catch (PersonaException | MiCalendarioException ex) {
            throw new AlumnoDAOException("Error al formar el alumno ==> "+ex.getMessage());
        }
        return null;
    }
    
    @Override
    public void update(Alumno alu) throws AlumnoDAOException {
        try {                        
            raf.seek(0);    // Posicionar al inicio   
            String linea;   
            String[] campos;            
            linea = null;
            long posActual = 0L;
            char nuevoEstado = alu.getEstado() != 'B' ? 'M' : 'B';//Si es modificacion, 'M', si 
            //Leo la línea y pregunto si "hay linea para leer", mientras haya.. sigo
            while ((linea = raf.readLine())!= null) {
                campos = linea.split(Persona.DELIM); //leo la linea actual y se la asigno al array de string "campos"
                if (Integer.valueOf(campos[0]).equals(alu.getDni())) { //pregunto si la primer columna del indice que corresponde con el "dni" coincide con el dni del objeto que le estoy enviando
                    Alumno alu2 = Alumno.string2Alumno(campos); //mapeo la linea a un objeto Alumno llamado alu2
                    if (alu2.getEstado()!='B') { //Si no esta dado de baja.. lo actualizo
                        raf.seek(posActual); //me posciono en la posicion a actualizar
                        alu.setEstado(nuevoEstado);
                        raf.writeBytes(alu+System.lineSeparator());        //Piso la linea actual                
                    }                
                }
                posActual = raf.getFilePointer(); //Obtengo la posicion antes de leer la proxima linea
            }        
        } catch (IOException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        }  
        catch (PersonaException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        }  
        catch (MiCalendarioException ex) {
            throw new AlumnoDAOException("Error ==> "+ex.getMessage());
        }  
        catch (AlumnoException ex) {
            throw new AlumnoDAOException("Error ==> "+ex.getMessage());
        } 
    }
    

    @Override
    public void delete(Integer dni) throws AlumnoDAOException {
    try{        
        Alumno alu = read(dni);
        alu.setEstado('B');                
        update(alu);    
        }catch (AlumnoException ex) {
            throw new AlumnoDAOException("Error ==> "+ex.getMessage());        
        }catch (NullPointerException ex) {
            throw new AlumnoDAOException("Error ==> El dni ingresado no corresponde a ningun alumno");
        } 
    }

    @Override
    public boolean existe(Integer dni) throws AlumnoDAOException {
        try {
            raf.seek(0);
            String linea;
            while ((linea = raf.readLine())!=null) {
                if (Integer.valueOf(linea.substring(0, 8)).equals(dni)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        }
        
        return false;
    }

    @Override
    public List<Alumno> findAll() throws DAOException {
        return findAll(false);
    }
    
    @Override
    public List<Alumno> findAll(boolean all) throws DAOException {
      try {
            raf.seek(0);
            String linea;
            String[] campos;     
            List<Alumno> alumnos;
            alumnos = new ArrayList<>();
            while ((linea = raf.readLine())!=null) {
                campos = linea.split(Persona.DELIM);
                Alumno alu = Alumno.string2Alumno(campos);
                if (all || alu.getEstado()!='B') {
                    alumnos.add(alu);
                }  
            }
            return alumnos;
        } catch (IOException ex) {
            throw new AlumnoDAOException("Error E/S ==> "+ex.getMessage());
        } 
        catch (PersonaException | MiCalendarioException ex) {
            throw new AlumnoDAOException("Error al formar el alumno ==> "+ex.getMessage());
        }
    }

    @Override
    public void close() throws DAOException {
        try {
            if (raf!=null) {
                raf.close();
            }
        } catch (IOException ex) {
            throw new DAOException("Error al cerrar archivo ==> "+ex.getMessage());
        }
    }
    
}
