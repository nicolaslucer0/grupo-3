/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author PeTaR
 */
public class KilometrosMillasConversor extends Conversor {
    private static final Double UNA_MILLA = 1.60934;
    private static final Double UN_KM = 0.621371;
    
    
    @Override
    public String getLabelValor1() {
        return "Kilometros";
    }
    
    @Override
    public String getLabelValor2() {
        return "Millas";
    }
    
    @Override
    public String toString() {
        return "KM y Millas";
    }

    @Override
    public Double convertirValor1Valor2(Double km) {
        return km / UNA_MILLA;
    }
    
    @Override
    public Double convertirValor2Valor1(Double milla) {
        return milla / UN_KM;
    }
    
    
    
}
