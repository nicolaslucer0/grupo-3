/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.AlumnoDAOException;
import dao.AlumnoDAOTXT;
import dao.DAO;
import dao.DAOAlumnoFactory;
import dao.DAOAlumnoFactoryException;
import dao.DAOException;
import fecha.MiCalendario;
import fecha.MiCalendarioException;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            DAOAlumnoFactory daf = DAOAlumnoFactory.getInstance();

            Map<String, String> config = new HashMap();

            config.put(DAOAlumnoFactory.TIPO_DAO, DAOAlumnoFactory.TIPO_DAO_SQL);
            config.put(DAOAlumnoFactory.URL_DB, "jdbc:mysql://127.0.0.1:3306/efc?serverTimezone=UTC");
            config.put(DAOAlumnoFactory.USER, "root");
            config.put(DAOAlumnoFactory.PASSWORD, "1234");
            
            DAO<Alumno, Integer> dao = daf.getDAO(config);
            
            System.out.println("CONNECTION OK");
            
            
            //Caso 1 - Lee y muestra con dao.read y dao.existe------------------
                 
            final MiCalendario fechaNac = new MiCalendario(23, 8, 1987);
            final MiCalendario fechaIng = new MiCalendario(15, 9, 2004);
            Alumno alu = new Alumno(8.0, 14, 24004603, "GIMENEZ Jonathan", 'F', fechaNac, fechaIng);
            /*
            Alumno aluRead = dao.read(28947563);
            //dao.Read
            if (aluRead==null) {
                System.err.println("Alunmo no encontrado");
            }
            else {
                System.out.println("OK Encontrado ==> "+aluRead);
            }
            //dao.existe
            if (dao.existe(28947563)) {
                System.out.println("OK Encontrado ==> "+aluRead);
            }
            else {
                System.err.println("Alunmo no encontrado");
            }
            */
            //------------------Caso 1 - Lee y muestra con dao.read y dao.existe
            
            
            //Caso 2 - Crea Alumno----------------------------------------  
            /*
            Alumno aluC = new Alumno();
            aluC.setApyNom("Maximo Roberto");
            aluC.setPromedio(9.3);
            aluC.setDni(32114976);
            aluC.setSexo('m');
            aluC.setCantMatAprob(30);
            aluC.setFechaNac(new MiCalendario(16, 3, 1987));
            aluC.setFechaIngreso(new MiCalendario(24, 01, 2007));
            aluC.setEstado('A');
            
            dao.create(aluC);
            */
            //----------------------------------------Caso 2 - Crea Alumno
            
            //Caso 2 - Validamos nombre <= 20 caracteres-------------------------  
            /*
            Alumno aluNO = new Alumno();
            aluNO.setApyNom("Nombre Muy Muy largooo"); //21 caracteres
            aluNO.setPromedio(8.4);
            aluNO.setDni(1122121222);
            aluNO.setSexo('m');
            aluNO.setCantMatAprob(19);
            aluNO.setFechaNac(new MiCalendario(11, 9, 1998));
            aluNO.setFechaIngreso(new MiCalendario(19, 5, 2012));
            aluNO.setEstado('A');
            
            dao.create(aluNO);
            */
            //------------------------Caso 2 - Validamos nombre <= 20 caracteres
            
            
                        
            //Caso 3 - Actualizar Alumno----------------------------------------  
            /*
            Alumno aluM = new Alumno();
            aluM.setApyNom("Pereyra Roberto");
            aluM.setPromedio(7.2);
            aluM.setDni(28947563);
            aluM.setSexo('m');
            aluM.setCantMatAprob(22);
            aluM.setFechaNac(new MiCalendario(11, 3, 1991));
            aluM.setFechaIngreso(new MiCalendario(19, 6, 2005));
            aluM.setEstado('M');
            dao.update(aluM);
            */
            //----------------------------------------Caso 3 - Actualizar Alumno
            
            //Caso 4.1 - Borrado Fisico Alumno---------------------------------------- 
            // dao.delete(24367890); //Susana Gimenez           
            //----------------------------------------4.1 - Borrado Fisico Alumno
            
            //Caso 4.2 - Borrado Logico Alumno---------------------------------------- 
            
            Alumno aluDL = dao.read(32114976); //Rufa -> A -> B
            aluDL.setEstado('B');
            aluDL.setDni(null);            
            dao.update(aluDL);            
            
            //----------------------------------------4.2 - Borrado Logico Alumno
            
            
            
            //Caso 5 - Find ALL-------------------------------------------------
            
            List<Alumno> alumnos = dao.findAll();
            if (alumnos==null) {
                System.err.println("No hay datos");
            }
            else{
                alumnos.forEach((al) -> {
                    System.out.println(al.toString());
                });
            }
            
            //-------------------------------------------------Caso 5 - Find ALL
            
            //Caso 6 - Find ALL (con parametro TRUE)---------------------------------
            
            List<Alumno> alumnos2 = dao.findAll(true);
            if (alumnos2==null) {
                System.err.println("No hay datos");
            }
            else{
                for(Alumno al2 : alumnos2)
                    {System.out.println(al2.toString());}
            }
            
            //---------------------------------Caso 6 - Find ALL (con parametro TRUE)
            
            //Caso 7 - Find ALL (con parametro False)---------------------------------
            /*
            List<Alumno> alumnos7 = dao.findAll(false);
            if (alumnos7==null) {
                System.err.println("No hay datos");
            }
            else{
                for(Alumno al7 : alumnos7)
                    {System.out.println(al7.toString());}
            }
            */
            //---------------------------------Caso 6 - Find ALL (con  parametro False)            
            
            dao.close();
        } catch (DAOException | MiCalendarioException | PersonaException | DAOAlumnoFactoryException | AlumnoException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
