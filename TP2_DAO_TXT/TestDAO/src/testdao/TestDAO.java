/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import dao.AlumnoDAOException;
import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOException;
import fecha.MiCalendario;
import fecha.MiCalendarioException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeArray;
import persona.Alumno;
import persona.PersonaException;
import persona.AlumnoException;

/**
 *
 * @author Gabriel
 */
public class TestDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //DAO<Alumno, Integer> dao = new AlumnoDAOTXT(new File("alumno.txt"));
            AlumnoDAOTXT dao = new AlumnoDAOTXT(new File("alumno.txt"));
            
            //Creo un alumno para usarlo en los casos de prueba
            final MiCalendario fechaNac = new MiCalendario(15,12, 1977);
            final MiCalendario fechaIng = new MiCalendario(23,03, 2001);
            Alumno alu = new Alumno(8.7, 31, 32556778, "Jonas Dark", 'M', fechaNac, fechaIng);
            
            //Se comentó cada caso con /**/            
            
            //Caso 1 - Crear Alumno y listar <> 'B'//-------------------
                     /*   
            dao.create(alu);            
            dao.ListAllTXT();
            */
            //--------------------Caso 1 - Crear Alumno y listar <> 'B'
                  
            
            //Caso 2 - Actualizo y Listo <> 'B'--------------------------
            /*
            final MiCalendario fechaNac2 = new MiCalendario(02,04,1810);
            final MiCalendario fecIng = new MiCalendario(02,04,1810);
            Alumno alu2 = new Alumno(7.7, 78, 27478333, "Torres Cristiano", 'F', fechaNac2, fecIng);
            dao.update(alu2);
            dao.ListAllTXT();
            */
            //--------------------------Caso 2 - Actualizo y Listo <> 'B'
              
            
            //Caso 3 - Baja Logica y Listo <> 'B'---------------
            /*
            dao.delete(31478510);
            dao.ListAllTXT();
            */
            //'---------------Caso 3 - Baja Logica y Listo <> 'B
            
            
            //Caso 4 - Leer un alumno-----------------------------      
            /*
            Alumno aluRead = dao.read(24004600);
            if (aluRead==null) {
                System.err.println("Alunmo no encontrado");
            }
            else {
                System.out.println("OK Encontrado ==> "+aluRead);
            }
            */
            //-----------------------------Caso 4 - Leer un alumno
            
            
            //Caso 5 - Uso del FindAll-----------------
            
            List<Alumno> alumnos = dao.findAll(); 
            alumnos.forEach((alumno) -> {
                System.out.println(alumno.toString());
            });
            
            //-----------------Caso 5 - Uso del FindAll            
            
        } catch (DAOException | MiCalendarioException | PersonaException | AlumnoException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
