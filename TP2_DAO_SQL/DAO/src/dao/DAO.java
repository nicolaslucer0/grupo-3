/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public abstract class DAO<T,K> {
    
    // CRUD
    public abstract void create(T entidad) throws DAOException;
    public abstract T read(K id) throws DAOException;
    public abstract void update(T entidad) throws DAOException;
    public abstract void delete(K id) throws DAOException;
    
    public abstract List<T> findAll() throws DAOException;
    
    /**
     * Método que devuelve todos las entidades
     * @param all true: recupera todos (A/B/M) false: solo los activos (A/M)
     * @return
     * @throws DAOException 
     */
    public abstract List<T> findAll(boolean all) throws DAOException;
    public abstract boolean existe(K id) throws DAOException;
    
    public abstract void close() throws DAOException;
}
