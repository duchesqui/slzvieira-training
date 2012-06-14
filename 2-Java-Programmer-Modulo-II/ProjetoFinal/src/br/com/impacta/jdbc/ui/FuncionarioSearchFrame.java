package br.com.impacta.jdbc.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.impacta.jdbc.model.Funcionario;
import br.com.impacta.jdbc.persistence.DAOException;
import br.com.impacta.jdbc.persistence.FuncionarioDAO;
import br.com.impacta.jdbc.ui.tablemodel.FuncionarioTableModel;

public class FuncionarioSearchFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnlRaiz = null;
	private JPanel pnlTopo = null;
	private JLabel lblNome = null;
	private JTextField txtNome = null;
	private JButton btnBusca = null;
	private JScrollPane scrResultado = null;
	private JTable tabResultado = null;

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	/**
	 * This is the xxx default constructor
	 */
	public FuncionarioSearchFrame() {
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
		this.setMaximizable(true);
		this.setTitle("Busca de Funcion�rios");
		this.setResizable(true);
		this.setClosable(true);
		this.setContentPane(getPnlRaiz());
	}

	/**
	 * This method initializes pnlRaiz
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlRaiz() {
		if (pnlRaiz == null) {
			pnlRaiz = new JPanel();
			pnlRaiz.setLayout(new BorderLayout());
			pnlRaiz.add(getPnlTopo(), BorderLayout.NORTH);
			pnlRaiz.add(getScrResultado(), BorderLayout.CENTER);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes pnlTopo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlTopo() {
		if (pnlTopo == null) {
			lblNome = new JLabel();
			lblNome.setText("Nome:");
			pnlTopo = new JPanel();
			pnlTopo.setLayout(new BorderLayout());
			pnlTopo.add(lblNome, BorderLayout.WEST);
			pnlTopo.add(getTxtNome(), BorderLayout.CENTER);
			pnlTopo.add(getBtnBusca(), BorderLayout.EAST);
		}
		return pnlTopo;
	}

	/**
	 * This method initializes txtNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
		}
		return txtNome;
	}

	/**
	 * This method initializes btnBusca	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnBusca() {
		if (btnBusca == null) {
			btnBusca = new JButton();
			btnBusca.setText("Procurar");
			btnBusca.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						List<Funcionario> funcionarioLista = funcionarioDAO.findByName(getTxtNome().getText());
						getTabResultado().setModel(new FuncionarioTableModel(funcionarioLista));
						
						if (funcionarioLista.isEmpty()) {
							JOptionPane
									.showMessageDialog(
											FuncionarioSearchFrame.this,
											"N�o foi encontrado nenhum funcion�rio com o nome especificado.",
											"Pesquisa",
											JOptionPane.WARNING_MESSAGE);
						}
						
					} catch (DAOException e1) {
						JOptionPane.showMessageDialog(
								FuncionarioSearchFrame.this, e1.getMessage(),
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnBusca;
	}

	/**
	 * This method initializes scrResultado	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrResultado() {
		if (scrResultado == null) {
			scrResultado = new JScrollPane();
			scrResultado.setViewportView(getTabResultado());
		}
		return scrResultado;
	}

	/**
	 * This method initializes tabResultado	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabResultado() {
		if (tabResultado == null) {
			tabResultado = new JTable();
			tabResultado.setModel(new FuncionarioTableModel());
			tabResultado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return tabResultado;
	}

}
