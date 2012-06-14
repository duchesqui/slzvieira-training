package br.com.impacta.jdbc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.impacta.jdbc.model.Cargo;
import br.com.impacta.jdbc.persistence.CargoDAO;
import br.com.impacta.jdbc.persistence.DAOException;

public class CargoFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnlRaiz = null;
	private JPanel pnlCentro = null;
	private JLabel lblNome = null;
	private JTextField txtNome = null;
	private JButton btnSalvar = null;
	private JButton btnLimpar = null;

	private CargoDAO cargoDAO = new CargoDAO();  //  @jve:decl-index=0:
	
	/**
	 * This is the xxx default constructor
	 */
	public CargoFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 160);
		this.setTitle("Cadastro de Cargos");
		this.setClosable(true);
		this.setMaximizable(true);
		this.setResizable(true);
		this.setContentPane(getPnlRaiz());
	}

	/**
	 * This method initializes pnlRaiz
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlRaiz() {
		if (pnlRaiz == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.ipadx = 289;
			gridBagConstraints.ipady = 126;
			gridBagConstraints.gridy = 0;
			pnlRaiz = new JPanel();
			pnlRaiz.setLayout(new GridBagLayout());
			pnlRaiz.add(getPnlCentro(), gridBagConstraints);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes pnlCentro	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlCentro() {
		if (pnlCentro == null) {
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(15, 15, 256, 21));
			lblNome.setText("Nome:");
			pnlCentro = new JPanel();
			pnlCentro.setLayout(null);
			pnlCentro.add(lblNome, null);
			pnlCentro.add(getTxtNome(), null);
			pnlCentro.add(getBtnSalvar(), null);
			pnlCentro.add(getBtnLimpar(), null);
		}
		return pnlCentro;
	}

	/**
	 * This method initializes txtNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(new Rectangle(15, 35, 256, 21));
		}
		return txtNome;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setBounds(new Rectangle(15, 75, 121, 36));
			btnSalvar.setText("Salvar");
			btnSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Cargo cargo = new Cargo();
						cargo.setNome(getTxtNome().getText());
						cargoDAO.save(cargo);
						JOptionPane.showMessageDialog(CargoFrame.this,
								"Cargo salvo com sucesso", "Salvo",
								JOptionPane.INFORMATION_MESSAGE);
						cleanFields();
					} catch (DAOException e1) {
						JOptionPane.showMessageDialog(CargoFrame.this,
								e1.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnSalvar;
	}

	/**
	 * This method initializes btnLimpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnLimpar() {
		if (btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setBounds(new Rectangle(150, 75, 121, 36));
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cleanFields();
				}
			});
		}
		return btnLimpar;
	}

	private void cleanFields() {
		getTxtNome().setText("");
	}
}
