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
public class CelciusFahrenheitConversor extends Conversor{
    private static final Double CONSTANTE_FORMULA = 32.0;
    
    @Override
    public String getLabelValor1() {
        return "Celcius";
    }

    @Override
    public String getLabelValor2() {
        return "Fahrenheit";
    }
    
    @Override
    public String toString() {
        return "Celcius y Fahrenheit";
    }

    @Override
    public Double convertirValor1Valor2(Double c) {
        return ( c * 9/5) + CONSTANTE_FORMULA;
    }

    @Override
    public Double convertirValor2Valor1(Double f) {
        return (f - CONSTANTE_FORMULA) * 5/9;
    }
    
}
