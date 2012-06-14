package br.com.impacta.jdbc.ui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane pnlRaiz = null;
	private JMenuBar mnuRaiz = null;
	private JMenu mnuCadastro = null;
	private JMenuItem mnuCargo = null;
	private JMenuItem mnuFuncionario = null;
	private JSeparator mnuSeparador1 = null;
	private JMenuItem mnuSair = null;
	private JMenu mnuFerramentas = null;
	private JMenuItem mnuNumeroExtenso = null;
	private JMenu mnuPesquisa = null;
	private JMenuItem mnuFuncionarioPesquisa = null;
	private JMenuItem mnuCargoPesquisa = null;

	/**
	 * This is the default constructor
	 */
	public PrincipalFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getMnuRaiz());
		this.setContentPane(getPnlRaiz());
		this.setTitle("Projeto Final");
	}

	/**
	 * This method initializes pnlRaiz	
	 * 	
	 * @return javax.swing.JDesktopPane	
	 */
	private JDesktopPane getPnlRaiz() {
		if (pnlRaiz == null) {
			pnlRaiz = new JDesktopPane();
			pnlRaiz.setBackground(SystemColor.controlShadow);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes mnuRaiz	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMnuRaiz() {
		if (mnuRaiz == null) {
			mnuRaiz = new JMenuBar();
			mnuRaiz.add(getMnuCadastro());
			mnuRaiz.add(getMnuPesquisa());
			mnuRaiz.add(getMnuFerramentas());
		}
		return mnuRaiz;
	}

	/**
	 * This method initializes mnuCadastro	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuCadastro() {
		if (mnuCadastro == null) {
			mnuCadastro = new JMenu();
			mnuCadastro.setText("Cadastro");
			mnuCadastro.add(getMnuCargo());
			mnuCadastro.add(getMnuFuncionario());
			mnuCadastro.add(getMnuSeparador1());
			mnuCadastro.add(getMnuSair());
		}
		return mnuCadastro;
	}

	/**
	 * This method initializes mnuCargo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuCargo() {
		if (mnuCargo == null) {
			mnuCargo = new JMenuItem();
			mnuCargo.setText("Cargo");
			mnuCargo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame janela = new CargoFrame();
					janela.setVisible(true);
					getPnlRaiz().add(janela);
				}
			});
		}
		return mnuCargo;
	}

	/**
	 * This method initializes mnuFuncionario	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuFuncionario() {
		if (mnuFuncionario == null) {
			mnuFuncionario = new JMenuItem();
			mnuFuncionario.setText("Funcionario");
			mnuFuncionario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame janela = new FuncionarioFrame();
					getPnlRaiz().add(janela);
					janela.setVisible(true);
				}
			});
		}
		return mnuFuncionario;
	}

	/**
	 * This method initializes mnuSeparador1	
	 * 	
	 * @return javax.swing.JSeparator	
	 */
	private JSeparator getMnuSeparador1() {
		if (mnuSeparador1 == null) {
			mnuSeparador1 = new JSeparator();
		}
		return mnuSeparador1;
	}

	/**
	 * This method initializes mnuSair	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuSair() {
		if (mnuSair == null) {
			mnuSair = new JMenuItem();
			mnuSair.setText("Sair");
			mnuSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PrincipalFrame.this.dispose();
				}
			});
		}
		return mnuSair;
	}

	/**
	 * This method initializes mnuFerramentas	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuFerramentas() {
		if (mnuFerramentas == null) {
			mnuFerramentas = new JMenu();
			mnuFerramentas.setText("Ferramentas");
			mnuFerramentas.add(getMnuNumeroExtenso());
		}
		return mnuFerramentas;
	}

	/**
	 * This method initializes mnuNumeroExtenso	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuNumeroExtenso() {
		if (mnuNumeroExtenso == null) {
			mnuNumeroExtenso = new JMenuItem();
			mnuNumeroExtenso.setText("Número por extenso");
			mnuNumeroExtenso.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame janela = new NumberDescriptionFrame();
					janela.setVisible(true);
					getPnlRaiz().add(janela);
				}
			});
		}
		return mnuNumeroExtenso;
	}

	/**
	 * This method initializes mnuPesquisa	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuPesquisa() {
		if (mnuPesquisa == null) {
			mnuPesquisa = new JMenu();
			mnuPesquisa.setText("Pesquisa");
			mnuPesquisa.add(getMnuFuncionarioPesquisa());
			mnuPesquisa.add(getMnuCargoPesquisa());
		}
		return mnuPesquisa;
	}

	/**
	 * This method initializes mnuFuncionarioPesquisa	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuFuncionarioPesquisa() {
		if (mnuFuncionarioPesquisa == null) {
			mnuFuncionarioPesquisa = new JMenuItem();
			mnuFuncionarioPesquisa.setText("Funcionário");
			mnuFuncionarioPesquisa.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame janela = new FuncionarioSearchFrame();
					janela.setVisible(true);
					getPnlRaiz().add(janela);
				}
			});
		}
		return mnuFuncionarioPesquisa;
	}

	/**
	 * This method initializes mnuCargoPesquisa	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuCargoPesquisa() {
		if (mnuCargoPesquisa == null) {
			mnuCargoPesquisa = new JMenuItem();
			mnuCargoPesquisa.setText("Cargo");
			mnuCargoPesquisa.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame janela = new CargoSearchFrame();
					getPnlRaiz().add(janela);
					janela.setVisible(true);
				}
			});
		}
		return mnuCargoPesquisa;
	}

	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new PrincipalFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
