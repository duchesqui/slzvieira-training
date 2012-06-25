package br.com.impacta.jdbc.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.impacta.jdbc.model.CargoVO;
import br.com.impacta.jdbc.model.FuncionarioVO;
import br.com.impacta.jdbc.persistence.CargoDAO;
import br.com.impacta.jdbc.persistence.FuncionarioDAO;

public class FuncionarioFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static final DecimalFormat SALARIO_MASK = new DecimalFormat("#,##0.00");  //  @jve:decl-index=0:

	private JPanel pnlRaiz = null;
	private JPanel pnlCentro = null;
	private JLabel lblNome = null;
	private JTextField txtNome = null;
	private JButton btnSalvar = null;
	private JButton btnLimpar = null;
	private JLabel lblCargo = null;
	private JComboBox cmbCargo = null;
	private JLabel lblSalario = null;
	private JTextField txtSalario = null;
	
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();  //  @jve:decl-index=0:
	private CargoDAO cargoDAO = new CargoDAO();  //  @jve:decl-index=0:
	
	/**
	 * This is the xxx default constructor
	 */
	public FuncionarioFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 260);
		this.setTitle("Cadastro de Funcionários");
		this.setClosable(true);
		this.setMaximizable(true);
		this.setResizable(true);
		this.setContentPane(getPnlRaiz());
		this.fillCmbCargo();
	}

	/**
	 * This method initializes pnlRaiz
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlRaiz() {
		if (pnlRaiz == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.ipadx = 289;
			gridBagConstraints1.ipady = 246;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.ipadx = 289;
			gridBagConstraints.ipady = 246;
			gridBagConstraints.gridy = 0;
			pnlRaiz = new JPanel();
			pnlRaiz.setLayout(new GridBagLayout());
			pnlRaiz.add(getPnlCentro(), gridBagConstraints1);
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
			lblSalario = new JLabel();
			lblSalario.setBounds(new Rectangle(15, 115, 256, 21));
			lblSalario.setText("Salário");
			lblCargo = new JLabel();
			lblCargo.setBounds(new Rectangle(15, 65, 256, 21));
			lblCargo.setText("CargoVO:");
			lblNome = new JLabel();
			lblNome.setBounds(new Rectangle(15, 15, 256, 21));
			lblNome.setText("Nome:");
			pnlCentro = new JPanel();
			pnlCentro.setLayout(null);
			pnlCentro.add(lblNome, null);
			pnlCentro.add(getTxtNome(), null);
			pnlCentro.add(getBtnSalvar(), null);
			pnlCentro.add(getBtnLimpar(), null);
			pnlCentro.add(lblCargo, null);
			pnlCentro.add(getCmbCargo(), null);
			pnlCentro.add(lblSalario, null);
			pnlCentro.add(getTxtSalario(), null);
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
			btnSalvar.setBounds(new Rectangle(15, 175, 121, 36));
			btnSalvar.setText("Salvar");
			btnSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					FuncionarioVO funcionario = new FuncionarioVO();
					funcionario.setNome(getTxtNome().getText());
					
					if (getCmbCargo().getSelectedIndex() > 0) {
						CargoVO cargo = (CargoVO) getCmbCargo().getSelectedItem();
						funcionario.setIdCargo(cargo.getId());
					}
					
					try {
						funcionario.setSalario(SALARIO_MASK.parse(getTxtSalario().getText()).doubleValue());
					} catch (ParseException e1) {
						funcionario.setSalario(0);
					}
					
					try {
						funcionarioDAO.save(funcionario);
						JOptionPane.showMessageDialog(FuncionarioFrame.this,
								"Funcionário salvo com sucesso", "Salvo",
								JOptionPane.INFORMATION_MESSAGE);
						cleanFields();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(FuncionarioFrame.this,
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
			btnLimpar.setBounds(new Rectangle(150, 175, 121, 36));
			btnLimpar.setText("Limpar");
			btnLimpar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cleanFields();
				}
			});
		}
		return btnLimpar;
	}

	/**
	 * This method initializes cmbCargo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbCargo() {
		if (cmbCargo == null) {
			cmbCargo = new JComboBox();
			cmbCargo.setBounds(new Rectangle(15, 85, 256, 21));
		}
		return cmbCargo;
	}

	/**
	 * This method initializes txtSalario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtSalario() {
		if (txtSalario == null) {
			txtSalario = new JTextField();
			txtSalario.setBounds(new Rectangle(15, 135, 256, 21));
			txtSalario.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusLost(java.awt.event.FocusEvent e) {
					try {
						Number salario = SALARIO_MASK.parse(getTxtSalario().getText());
						getTxtSalario().setText(SALARIO_MASK.format(salario.doubleValue()));
					} catch (ParseException e1) {
						getTxtSalario().setText("");
					}
				}
			});
		}
		return txtSalario;
	}

	private void fillCmbCargo() {
		try {
			List<CargoVO> cargoLista = cargoDAO.findAll();
			getCmbCargo().addItem(null);
			for (CargoVO cargo : cargoLista) {
				getCmbCargo().addItem(cargo);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void cleanFields() {
		getTxtNome().setText("");
		getCmbCargo().setSelectedIndex(0);
		getTxtSalario().setText("");
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
