/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fecha.MiCalendario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.PersonaException;
import persona.AlumnoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class AlumnoDAOSQL extends DAO<Alumno, Integer>{

    private Connection conn;
    private PreparedStatement selectPS;
    private PreparedStatement insertPS;
    private PreparedStatement updatePS;
    private PreparedStatement deletePS;
    private PreparedStatement selectCountPS;
    private PreparedStatement findAllPS;
    
    AlumnoDAOSQL(String url, String password) {
        // jdbc:mysql://localhost:3306/?user=root        
    }

    AlumnoDAOSQL(String url, String user, String password) throws AlumnoDAOException {
        try {
            // jdbc:mysql://localhost:3306/?user=root
            
            conn = DriverManager.getConnection(url, user, password);
            
            // Read
            String sqlSelect = "SELECT * FROM alumnos WHERE DNI = ?;";
            selectPS = conn.prepareStatement(sqlSelect);
            
            // Count
            String sqlSelectCount = "SELECT COUNT(*) FROM alumnos WHERE DNI = ?;";
            selectCountPS = conn.prepareStatement(sqlSelectCount);
            
            // Insert
            String sqlInsert = "INSERT INTO alumnos\n" +
                "(DNI,\n" +
                "APY_NOM,\n" +
                "FEC_NAC,\n" +
                "CANT_MAT_APROB,\n" +
                "PROMEDIO,\n" +
                "FEC_ING,\n" +
                "SEXO,\n" +
                "ESTADO)\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?,?,?);";
            
            insertPS = conn.prepareStatement(sqlInsert);
            
            // update
            String sqlUpdate = "UPDATE alumnos\n" +
                    "SET APY_NOM = ?,\n" +
                    "FEC_NAC = ?, \n" +
                    "CANT_MAT_APROB = ?, \n" +
                    "PROMEDIO = ?, \n" +
                    "FEC_ING = ?, \n" +
                    "SEXO = ?, \n" +
                    "ESTADO = ? \n" +
                    "WHERE DNI = ? ;";
            
            updatePS = conn.prepareStatement(sqlUpdate);
            
            // delete
            String sqlDelete2 = "DELETE FROM alumnos WHERE DNI = ? ;";            
            deletePS = conn.prepareStatement(sqlDelete2);
            
            // FindAll
            String sqlFindAll = "SELECT * FROM alumnos;";
            findAllPS = conn.prepareStatement(sqlFindAll);
            
        } catch (SQLException ex) {
            throw new AlumnoDAOException("Error Sql ==>"+ex.getMessage());
        }
    }
    
    @Override
    public void create(Alumno alu) throws AlumnoDAOException {
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getApyNom());
            insertPS.setDate(index++, alu.getFechaNac().getSqlDate());
            insertPS.setInt(index++, alu.getCantMatAprob());
            insertPS.setDouble(index++, alu.getPromedio());
            insertPS.setDate(index++, alu.getFechaIngreso().getSqlDate());
            insertPS.setString(index++, alu.getSexo().toString());
            insertPS.setString(index++, alu.getEstado().toString());
       
            insertPS.executeUpdate();
            
        } catch (SQLException ex) {
            throw new AlumnoDAOException("Error Sql al intentar insertar un alumno ==>"+ex.getMessage());
        }
    }
    
    @Override
    public void update(Alumno alu) throws AlumnoDAOException {
        try{
            int index = 1;            
            updatePS.setString(index++, alu.getApyNom());
            updatePS.setDate(index++, alu.getFechaNac().getSqlDate());
            updatePS.setInt(index++, alu.getCantMatAprob());
            updatePS.setDouble(index++, alu.getPromedio());
            updatePS.setDate(index++, alu.getFechaIngreso().getSqlDate());
            updatePS.setString(index++, alu.getSexo().toString());
            updatePS.setString(index++, alu.getEstado().toString());
            updatePS.setInt(index++, alu.getDni());
            updatePS.executeUpdate();
            
        } catch (SQLException ex) {
            throw new AlumnoDAOException("Error Sql al intentar insertar un alumno ==>"+ex.getMessage());
        }
        
    }

    @Override
    public Alumno read(Integer dni) throws AlumnoDAOException {
        Alumno alu = null;
        try {
            selectPS.setInt(1, dni);
            ResultSet rs = selectPS.executeQuery();
            if(rs.next()) {
                alu = new Alumno();
                alu.setDni(rs.getInt("DNI"));
                alu.setApyNom(rs.getString("APY_NOM"));
                alu.setFechaNac(new MiCalendario(rs.getDate("FEC_NAC")));
                alu.setCantMatAprob(rs.getInt("CANT_MAT_APROB"));
                alu.setPromedio(rs.getDouble("PROMEDIO"));
                alu.setFechaIngreso(new MiCalendario(rs.getDate("FEC_ING")));
                alu.setSexo(rs.getString("SEXO").charAt(0));
                alu.setEstado(rs.getString("ESTADO").charAt(0));
            }
        } catch (SQLException | PersonaException | AlumnoException ex) {
            throw new AlumnoDAOException("Error Sql al intentar leer un alumno ==>"+ex.getMessage());
        }
        
        return alu;
    }

    @Override
    public void delete(Integer dni) throws AlumnoDAOException {
        try{
            deletePS.setInt(1, dni);
            deletePS.executeUpdate();
        } catch (SQLException ex) {
            throw new AlumnoDAOException("Error Sql al intentar leer un alumno ==>"+ex.getMessage());
        }
    }  

    @Override
    public boolean existe(Integer dni) throws AlumnoDAOException {
        try {
            selectCountPS.setInt(1, dni);
            ResultSet rs = selectCountPS.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException ex) {
            throw new AlumnoDAOException("Error Sql al intentar leer un alumno ==>"+ex.getMessage());
        }
    }

    @Override
    public List<Alumno> findAll(boolean all) throws AlumnoDAOException {
        Alumno alu;
        List<Alumno> alumnos = new ArrayList<>();        
        try {
           
            ResultSet rs = findAllPS.executeQuery();
            while(rs.next()) {
                if(all || rs.getString("ESTADO").charAt(0) != 'B'){
                    alu = new Alumno();
                    alu.setDni(rs.getInt("DNI"));
                    alu.setApyNom(rs.getString("APY_NOM"));
                    alu.setFechaNac(new MiCalendario(rs.getDate("FEC_NAC")));
                    alu.setCantMatAprob(rs.getInt("CANT_MAT_APROB"));
                    alu.setPromedio(rs.getDouble("PROMEDIO"));
                    alu.setFechaIngreso(new MiCalendario(rs.getDate("FEC_ING")));
                    alu.setSexo(rs.getString("SEXO").charAt(0));
                    alu.setEstado(rs.getString("ESTADO").charAt(0));
                    alumnos.add(alu);     
                }
            }
        } catch (SQLException | PersonaException | AlumnoException ex) {
            throw new AlumnoDAOException("Error Sql al intentar leer un alumno ==>"+ex.getMessage());
        }
        
        return alumnos;
    }    
    
    @Override
    public List<Alumno> findAll() throws AlumnoDAOException {
        return findAll(false); 
    } 

    @Override
    public void close() throws DAOException {
        try {
            if (conn!=null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new DAOException("Error al cerrar DB ==> "+ex.getMessage());
        }
    }
    
}
