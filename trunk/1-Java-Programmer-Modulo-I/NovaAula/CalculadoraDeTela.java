package br.com.cpaconsulting.interf;

public class CalculadoraDeTela extends ImpressorDeTela implements Calculadora {

    public void exibeSoma(Integer valor1, Integer valor2) {
        imprimeNaTela(String.valueOf(valor1 + valor2));
    }

    public void exibeSubtracao(Integer valor1, Integer valor2) {
        imprimeNaTela(String.valueOf(valor1 - valor2));
    }

    public void exibeMultiplicacao(Integer valor1, Integer valor2) {
        imprimeNaTela(String.valueOf(valor1 * valor2));
    }

    public void exibeDivisao(Integer valor1, Integer valor2) {
        imprimeNaTela(String.valueOf(valor1 / valor2));
    }
}
