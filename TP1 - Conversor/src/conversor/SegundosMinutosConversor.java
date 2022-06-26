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
public class SegundosMinutosConversor extends Conversor{
    private static final Double SEGUNDOS_EN_MINUTO = 60.0;
    @Override
    public String getLabelValor1() {
        return "Segundos";
    }

    @Override
    public String getLabelValor2() {
        return "Minutos";
    }
    
    @Override
    public String toString()
    {
        return "Segundos y Minutos";
    }

    @Override
    public Double convertirValor1Valor2(Double s) {
        return s / SEGUNDOS_EN_MINUTO;
    }

    @Override
    public Double convertirValor2Valor1(Double m) {
        return m * SEGUNDOS_EN_MINUTO;
    }
    
}
