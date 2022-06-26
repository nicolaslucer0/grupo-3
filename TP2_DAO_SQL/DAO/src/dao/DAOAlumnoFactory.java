/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.util.Map;

/**
 *
 * @author Gabriel
 */
public class DAOAlumnoFactory {
    
    private static DAOAlumnoFactory instance;
    
    public static final String TIPO_DAO = "TIPO_DAO";
    public static final String TIPO_DAO_TXT = "TIPO_DAO_TXT";
    public static final String FILE_NAME = "FILE_NAME";

    public static final String TIPO_DAO_SQL = "TIPO_DAO_SQL";
    public static final String URL_DB = "URL_DB";
    public static final String USER = "USER";
    public static final String PASSWORD = "PASSWORD";

    private DAOAlumnoFactory() {
    }
    
    public static DAOAlumnoFactory getInstance() {
        if (instance==null) {
            instance = new DAOAlumnoFactory();
        }
        
        return instance;
    }
    
    /**
     * getDAO
     * @param config Mapa para setear el tipo de DAO y los parámetros relacionados a cada tipo
     * @return DAO (AlumnoDAOTXT o AlumnoDAOSQL)
     * @throws DAOAlumnoFactoryException 
     */
    public DAO getDAO(Map<String, String> config) throws DAOAlumnoFactoryException {
        String tipo = config.get(TIPO_DAO);
        
        switch (tipo) {
            case TIPO_DAO_TXT:
            {
                try {
                    return new AlumnoDAOTXT(new File(config.get(FILE_NAME)), "rws");
                } catch (AlumnoDAOException ex) {
                    throw new DAOAlumnoFactoryException("No se pudo crear una instancia del DAO TXT ==> "+ex.getMessage());
                }
            }
            case TIPO_DAO_SQL:
            {
                String url = config.get(URL_DB);
                String user = config.get(USER);
                String pass = config.get(PASSWORD);
                try {
                return new AlumnoDAOSQL(url, user, pass);
                } catch (AlumnoDAOException ex) {
                    throw new DAOAlumnoFactoryException("No se pudo crear una instancia del DAO SQL ==> "+ex.getMessage());
                }
            }
            default:
                throw new DAOAlumnoFactoryException("Aún no implementado");
        }
    }
    
}
