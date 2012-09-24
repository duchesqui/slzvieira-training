import javax.swing.*;

public abstract class ExibidorEmPopup {
	
	public void imprimeEmPopup(double valor) {
		JOptionPane.showMessageDialog(null, valor);
	}
}
