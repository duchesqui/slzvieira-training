import javax.swing.*;

public abstract class ExibidorEmPopup {
	
	protected void imprimeEmPopup(double valor) {
		JOptionPane.showMessageDialog(null, valor);
	}
}
