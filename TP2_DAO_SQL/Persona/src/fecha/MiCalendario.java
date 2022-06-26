/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Gabriel
 */
public class MiCalendario extends GregorianCalendar {

    public MiCalendario(int dia, int mes, int anio) throws MiCalendarioException {
        super(anio, mes-1, dia);
        
        // Apagamos la permisividad
        setLenient(false);
        
        // Lanzar una exception
        try {
            get(YEAR);
        }
        catch (IllegalArgumentException ex) {
            throw new MiCalendarioException("Error al formar fecha ==> "+ ex.getMessage());
        }
    }

    public MiCalendario(Date date) {
        
        this.setTimeInMillis(date.getTime());
    }

    public int getDia() {
        
        return get(DAY_OF_MONTH);
    }
            
    public int getMes() {
        
        return get(MONTH)+1;
    }

    public int getAnio() {
        
        return get(YEAR);
    }
    
    @Override
    public String toString() {
        
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAnio());
    }

    public Date getSqlDate() {

        return new Date(this.getTimeInMillis());
    }
    
}
