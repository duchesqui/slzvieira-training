import java.io.*;

public abstract class ExibidorNoArquivo {
	
	private static final String FILE_PATH = "calc.txt";

	public void imprimeNoArquivo(double valor) {

		try {		
			PrintWriter writer = new PrintWriter(FILE_PATH);
			writer.println(valor);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
