package br.com.cpaconsulting.interf;

public class CalculadoraDeArquivo extends ImpressorNoArquivo implements Calculadora {

    public void exibeSoma(Integer valor1, Integer valor2) {
        imprimeNoArquivo(String.valueOf(valor1 + valor2));
    }

    public void exibeSubtracao(Integer valor1, Integer valor2) {
        imprimeNoArquivo(String.valueOf(valor1 - valor2));
    }

    public void exibeMultiplicacao(Integer valor1, Integer valor2) {
        imprimeNoArquivo(String.valueOf(valor1 * valor2));
    }

    public void exibeDivisao(Integer valor1, Integer valor2) {
        imprimeNoArquivo(String.valueOf(valor1 / valor2));
    }
}
