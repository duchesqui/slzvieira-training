package br.com.impacta.io.exercicio;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class TabajaraEditorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel pnlRaiz = null;

	private JScrollPane scrEditor = null;

	private JTextArea txtEditor = null;

	private JMenuBar mnuRaiz = null;

	private JMenu mnuArquivo = null;

	private JMenuItem mnuNovo = null;

	private JMenuItem mnuAbrir = null;

	private JMenuItem mnuSalvar = null;

	private JSeparator mnuSeparador = null;

	private JMenuItem mnuSair = null;

	/** Adicionado manualmente para abertura e salvamento de arquivos. */
	private JFileChooser jfcArquivo = new JFileChooser();

	/** Lembra se o texto ja foi salvo ou nao. */
	boolean saved = true;
	
	/**
	 * This is the default constructor
	 */
	public TabajaraEditorFrame() {
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
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setJMenuBar(getMnuRaiz());
		this.setTitle("Tabajara Editor");
		this.setVisible(true);
		this.setContentPane(getPnlRaiz());
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				mnuSairActionPerformed();
			}
		});
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
			pnlRaiz.add(getScrEditor(), BorderLayout.CENTER);
		}
		return pnlRaiz;
	}

	/**
	 * This method initializes scrEditor
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getScrEditor() {
		if (scrEditor == null) {
			scrEditor = new JScrollPane();
			scrEditor.setViewportView(getTxtEditor());
		}
		return scrEditor;
	}

	/**
	 * This method initializes txtEditor
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTxtEditor() {
		if (txtEditor == null) {
			txtEditor = new JTextArea();
			txtEditor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					/* Ao digitar qualquer coisa, troca o estado do texto para "nao-salvo" */
					saved = false;
				}
			});
		}
		return txtEditor;
	}

	/**
	 * This method initializes mnuRaiz
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMnuRaiz() {
		if (mnuRaiz == null) {
			mnuRaiz = new JMenuBar();
			mnuRaiz.add(getMnuArquivo());
		}
		return mnuRaiz;
	}

	/**
	 * This method initializes mnuArquivo
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnuArquivo() {
		if (mnuArquivo == null) {
			mnuArquivo = new JMenu();
			mnuArquivo.setText("Arquivo");
			mnuArquivo.setMnemonic(KeyEvent.VK_A);
			mnuArquivo.add(getMnuNovo());
			mnuArquivo.add(getMnuAbrir());
			mnuArquivo.add(getMnuSalvar());
			mnuArquivo.add(getMnuSeparador());
			mnuArquivo.add(getMnuSair());
		}
		return mnuArquivo;
	}

	/**
	 * This method initializes mnuNovo
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMnuNovo() {
		if (mnuNovo == null) {
			mnuNovo = new JMenuItem();
			mnuNovo.setText("Novo");
			mnuNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
					Event.CTRL_MASK, false));
			mnuNovo.setMnemonic(KeyEvent.VK_N);
			mnuNovo.addActionListener(this);
		}
		return mnuNovo;
	}

	/**
	 * This method initializes mnuAbrir
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMnuAbrir() {
		if (mnuAbrir == null) {
			mnuAbrir = new JMenuItem();
			mnuAbrir.setText("Abrir");
			mnuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
					Event.CTRL_MASK, false));
			mnuAbrir.setMnemonic(KeyEvent.VK_A);
			mnuAbrir.addActionListener(this);
		}
		return mnuAbrir;
	}

	/**
	 * This method initializes mnuSalvar
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMnuSalvar() {
		if (mnuSalvar == null) {
			mnuSalvar = new JMenuItem();
			mnuSalvar.setText("Salvar");
			mnuSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, false));
			mnuSalvar.setMnemonic(KeyEvent.VK_S);
			mnuSalvar.addActionListener(this);
		}
		return mnuSalvar;
	}

	/**
	 * This method initializes mnuSeparador
	 * 
	 * @return javax.swing.JSeparator
	 */
	private JSeparator getMnuSeparador() {
		if (mnuSeparador == null) {
			mnuSeparador = new JSeparator();
		}
		return mnuSeparador;
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
			mnuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					Event.CTRL_MASK, false));
			mnuSair.setMnemonic(KeyEvent.VK_R);
			mnuSair.addActionListener(this);
		}
		return mnuSair;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getMnuNovo()) {
			mnuNovoActionPerformed();
		} else if (e.getSource() == getMnuAbrir()) {
			mnuAbrirActionPerformed();
		} else if (e.getSource() == getMnuSalvar()) {
			mnuSalvarActionPerformed();
		} else if (e.getSource() == getMnuSair()) {
			mnuSairActionPerformed();
		}
	}

	/**
	 * Limpa a janela do editor.
	 */
	private void mnuNovoActionPerformed() {
		getTxtEditor().setText("");
		jfcArquivo.setSelectedFile(null);
		saved = true;
	}

	/**
	 * Abre um documento texto exibindo seu conteúdo.
	 */
	private void mnuAbrirActionPerformed() {

		/* Antes de abrir um novo texto, verifica se o texto atual esta salvo. */
		if (!saved) {
			int result = JOptionPane.showConfirmDialog(TabajaraEditorFrame.this, "Deseja salvar o texto digitado?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
				/* Se usuario cancela, nao faz nada, mantendo a janela aberta. */
				return;
			} else if (result == JOptionPane.YES_OPTION && !mnuSalvarActionPerformed()) {
				return;
			}
		}
		
		/* Solicita que o usuario selecione um arquivo qualquer. */
		int result = jfcArquivo.showOpenDialog(this);

		/* Se o usuario selecionou o arquivo, abre e exibe seu conteudo. */
		if (result == JFileChooser.APPROVE_OPTION) {

			/* Referencia ao arquivo selecionado pelo usuario. */
			File arquivo = jfcArquivo.getSelectedFile();

			try {
				/* Abre o arquivo para leitura. */
				FileReader reader = new FileReader(arquivo);

				/* Vamos juntar aqui o conteudo do arquivo antes de coloca-lo na caixa de texto. */
				StringBuilder builder = new StringBuilder();

				/* Vamos ler o arquivo de 1024 em 1024 caracteres. */
				char[] charArray = new char[1024];
				int size = 0;

				while ((size = reader.read(charArray)) > 0) {
					builder.append(charArray, 0, size);
				}

				/* Fecha o arquivo. */
				reader.close();

				/* Coloca o conteudo lido na caixa de texto. */
				getTxtEditor().setText(builder.toString());
				saved = true;
				
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(this, "Não foi possível abrir o arquivo selecionado.\n" + ioe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Salva todo o texto em um arquivo.
	 * @return true quando o arquivo foi salvo, false caso contrario.
	 */
	private boolean mnuSalvarActionPerformed() {

		File arquivo = jfcArquivo.getSelectedFile();
		
		/* Verifica se ja houve algum arquivo selecionado. */
		if (arquivo == null) {

			/* Se nao houve arquivo selecionado, exibe janela de salvamento. */
			int result = jfcArquivo.showSaveDialog(this);

			/* Se o usuario cancelou a tela de salvamento, aborta tudo. */
			if (result != JFileChooser.APPROVE_OPTION) {
				return false;
			}

			/* Obtem o arquivo digitado ou selecionado. */
			arquivo = jfcArquivo.getSelectedFile();;
			
			/* Verifica se o arquivo ja existe. */
			if (arquivo.exists()) {
				
				/* Pergunta ao usuario se deseja sobrepor o arquivo selecionado. */
				result = JOptionPane.showConfirmDialog(this, "Deseja sobrepor o arquivo selecionado?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				/* Se o usuario nao quer sobrepor, anula o arquivo selecionado e aborta tudo. */
				if (result != JOptionPane.YES_OPTION) {
					jfcArquivo.setSelectedFile(null);
					return false;
				}
			}
		}
		
		try {

			/* Abre ou cria o arquivo para gravacao. */
			PrintWriter writer = new PrintWriter(arquivo);

			/* Grava o conteudo da caixa de texto no arquivo especificado. */
			writer.print(getTxtEditor().getText());
			
			/* Fecha o arquivo. */
			writer.close();

			saved = true;
			return true;
			
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, "Não foi possível salvar o texto.\n" + ioe.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Fecha a janela do editor.
	 */
	private void mnuSairActionPerformed() {
		if (saved) {
			/* Se o texto esta salvo, simplesmente fecha a janela. */
			dispose();
			return;
		}
		
		int result = JOptionPane.showConfirmDialog(TabajaraEditorFrame.this, "Deseja salvar o texto digitado?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
			/* Se usuario cancela, nao faz nada, mantendo a janela aberta. */
			return;
		} else if (result == JOptionPane.NO_OPTION) {
			/* Se usuario clica em "nao", fecha sem salvar. */
			dispose();
			return;
		}
		
		/* Dispara o metodo de salvamento */
		if (mnuSalvarActionPerformed()) {
			/* Se o salvamento foi realizado, fecha a janela. */
			dispose();
		}
	}

	/**
	 * Inicia a aplicacao.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TabajaraEditorFrame().setVisible(true);
	}
}
