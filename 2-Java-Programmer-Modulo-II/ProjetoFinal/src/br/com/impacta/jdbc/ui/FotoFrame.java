/**
 * 
 */
package br.com.impacta.jdbc.ui;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

import br.com.impacta.jdbc.model.Foto;
import br.com.impacta.jdbc.persistence.DAOException;
import br.com.impacta.jdbc.persistence.FotoDAO;

/**
 * @author Sandro
 *
 */
public class FotoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlRaiz = null;
	private JLabel lblFoto = null;
	private JPanel pnlNavegador = null;
	private JButton btnAnterior = null;
	private JButton btnProximo = null;

	/**
	 * This is the default constructor
	 */
	public FotoFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getPnlRaiz());
		this.setTitle("JFrame");
		this.setVisible(true);
	}

	/**
	 * This method initializes pnlRaiz
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlRaiz() {
		if (pnlRaiz == null) {
			lblFoto = new JLabel();
			pnlRaiz = new JPanel();
			pnlRaiz.setLayout(new BorderLayout());
			pnlRaiz.add(lblFoto, BorderLayout.CENTER);
			pnlRaiz.add(getPnlNavegador(), BorderLayout.SOUTH);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes pnlNavegador	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlNavegador() {
		if (pnlNavegador == null) {
			pnlNavegador = new JPanel();
			pnlNavegador.setLayout(new FlowLayout());
			pnlNavegador.add(getBtnAnterior(), null);
			pnlNavegador.add(getBtnProximo(), null);
		}
		return pnlNavegador;
	}

	/**
	 * This method initializes btnAnterior	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnAnterior() {
		if (btnAnterior == null) {
			btnAnterior = new JButton();
			btnAnterior.setText("<");
		}
		return btnAnterior;
	}

	/**
	 * This method initializes btnProximo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnProximo() {
		if (btnProximo == null) {
			btnProximo = new JButton();
			btnProximo.setText(">");
			btnProximo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						FotoDAO dao = new FotoDAO();
						Foto foto = dao.findByPk(1);
						lblFoto.setIcon(new ImageIcon(foto.getFoto()));
						FotoFrame.this.setTitle(foto.getNomeArquivo());
					} catch (DAOException daoe) {
						JOptionPane.showMessageDialog(FotoFrame.this, daoe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnProximo;
	}

	public static void main(String[] args) {
		new FotoFrame().setVisible(true);
	}
}
