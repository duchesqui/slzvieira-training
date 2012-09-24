package br.com.impacta.io.exercicio;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(getMnuRaiz());
        this.setTitle("Tabajara Editor");
        this.setVisible(true);
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
            mnuNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK, false));
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
            mnuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK, false));
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
            mnuSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK, false));
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
            mnuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK, false));
            mnuSair.setMnemonic(KeyEvent.VK_R);
            mnuSair.addActionListener(this);
        }
        return mnuSair;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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
        // TODO Clique no menu "Novo"
    }

    /**
     * Abre um documento texto exibindo seu conteúdo.
     */
    private void mnuAbrirActionPerformed() {
        // TODO Clique no menu "Abrir"
    }

    /**
     * Salva todo o texto em um arquivo.
     */
    private void mnuSalvarActionPerformed() {
        // TODO Clique no menu "Salvar"
    }

    /**
     * Fecha a janela do editor.
     */
    private void mnuSairActionPerformed() {
        // TODO Clique no menu "Sair"
    }

    /**
     * Inicia a aplicacao.
     * @param args
     */
    public static void main(String[] args) {
        new TabajaraEditorFrame().setVisible(true);
    }
}
