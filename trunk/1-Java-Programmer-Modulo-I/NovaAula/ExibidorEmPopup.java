package br.com.cpaconsulting.interf;

import javax.swing.JOptionPane;

public abstract class ExibidorEmPopup {

    protected void exibeEmPopup(String valor) {
        JOptionPane.showMessageDialog(null, valor);
    }
}
