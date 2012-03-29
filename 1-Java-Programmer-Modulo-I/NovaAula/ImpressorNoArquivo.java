package br.com.cpaconsulting.interf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class ImpressorNoArquivo {

    private static String FILE_NAME = "calc.txt";

    protected void imprimeNoArquivo(String valor) {
        try {
            PrintWriter writer = new PrintWriter(FILE_NAME);
            writer.println(valor);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
