/*
 * @(#)ProgramaCalculadora.java 1.00 28/01/2011 Copyright 2011 CPA Consulting LTDA.
 * Todos os direitos reservados. CPA PROPRIETARY/CONFIDENTIAL.
 * Proibida a cópia e-ou a reprodução deste código.
 */
package br.com.cpaconsulting.interf;

/**
 * TODO DOCUMENT ME!
 * @author sandro.vieira
 * @version 1.0, 28/01/2011 - sandro.vieira - Implementacao.
 */
public class ProgramaCalculadora {

    /**
     * TODO DOCUMENT ME!
     * @param args
     */
    public static void main(String[] args) {
        
        if (args == null || args.length != 2) {
            System.out.println("Entre com dois valores inteiros");
            return;
        }

        int valor1 = Integer.parseInt(args[0]);
        int valor2 = Integer.parseInt(args[1]);

        Calculadora[] arrayCalc = {
                new CalculadoraDeTela(),
                new CalculadoraDeArquivo(),
                new CalculadoraDePopup() };

        for (Calculadora calc : arrayCalc) {
            calc.exibeSoma(valor1, valor2);
        }
    }
}
