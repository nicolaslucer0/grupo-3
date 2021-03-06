/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author Gabriel
 */
public class CentimetrosPulgadasConversor extends Conversor {

    private static final double UNA_PULGADA = 2.54;
    private static final double UN_CENTIMETRO = 0.393701;

    @Override
    public String getLabelValor1() {
        
        return "Centímetros";
    }
    
    @Override
    public String getLabelValor2() {
        
        return "Pulgadas";
    }

    @Override
    public String toString() {
        return "Centimetros y Pulgadas";
    }

    @Override
    public Double convertirValor1Valor2(Double cent) {
        
        return cent / UNA_PULGADA;
    }
    
    @Override
    public Double convertirValor2Valor1(Double pulg) {
        
        return pulg / UN_CENTIMETRO;
    }
    
}
