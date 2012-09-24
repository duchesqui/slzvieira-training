package br.com.impacta.projetofinal.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class NumberDescriptionFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlRaiz = null;
	private JTextField txtNumero = null;
	private JLabel lblNumero = null;
	private JScrollPane scrDescricao = null;
	private JTextArea txtDescricao = null;
	
	private JPanel pnlTopo = null;

	/**
	 * This is the default constructor
	 */
	public NumberDescriptionFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 300);
		this.setResizable(true);
		this.setMaximizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getPnlRaiz());
		this.setTitle("Descrição numérica");
	}

	/**
	 * This method initializes pnlRaiz
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlRaiz() {
		if (pnlRaiz == null) {
			lblNumero = new JLabel();
			lblNumero.setText("Número");
			pnlRaiz = new JPanel();
			pnlRaiz.setLayout(new BorderLayout());
			pnlRaiz.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			pnlRaiz.add(getScrDescricao(), BorderLayout.CENTER);
			pnlRaiz.add(getPnlTopo(), BorderLayout.NORTH);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes txtNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
		}
		return txtNumero;
	}

	/**
	 * This method initializes scrDescricao	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrDescricao() {
		if (scrDescricao == null) {
			scrDescricao = new JScrollPane();
			scrDescricao.setViewportView(getTxtDescricao());
		}
		return scrDescricao;
	}

	/**
	 * This method initializes txtDescricao	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxtDescricao() {
		if (txtDescricao == null) {
			txtDescricao = new JTextArea();
			txtDescricao.setLineWrap(true);
			txtDescricao.setWrapStyleWord(true);
		}
		return txtDescricao;
	}

	/**
	 * This method initializes pnlTopo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlTopo() {
		if (pnlTopo == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnlTopo = new JPanel();
			pnlTopo.setLayout(gridLayout);
			pnlTopo.add(lblNumero, null);
			pnlTopo.add(getTxtNumero(), null);
		}
		return pnlTopo;
	}

	public static void main(String[] args) {
		new NumberDescriptionFrame().setVisible(true);
	}
}
