package br.com.impacta.io.stream.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Uma janela utilizada para copiar arquivos.
 * @author Sandro
 * @version 1.0, 20/05/2012 - Sandro - Implementacao.
 */
public class FileCopyFrame extends JFrame implements ActionListener {

    /* Componentes de tela. */
    private JPanel pnlRaiz = (JPanel) getContentPane();
    private JLabel lblOrigem = new JLabel("Arquivo origem:");
    private JLabel lblDestino = new JLabel("Arquivo destino:");
    private JTextField txtOrigem = new JTextField();
    private JTextField txtDestino = new JTextField();
    private JButton btnOrigem = new JButton("...");
    private JButton btnDestino = new JButton("...");
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancelar = new JButton("Cancelar");

    /** Versao desta classe. */
    private static final long serialVersionUID = 1L;

    /**
     * Construtor.
     * Inicializa a tela organizando o tamanho e posicao de cada elemento.
     */
    public FileCopyFrame() {

        /* Atributos da janela */
        setTitle("Copiar arquivo");
        setSize(570, 200);
        centralizeMe();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        /* Tamanho e posicao de cada componente. */
        lblOrigem.setBounds(20, 20, 100, 20);
        txtOrigem.setBounds(120, 20, 350, 20);
        lblDestino.setBounds(20, 50, 100, 20);
        txtDestino.setBounds(120, 50, 350, 20);
        btnOrigem.setBounds(480, 20, 50, 20);
        btnDestino.setBounds(480, 50, 50, 20);
        btnOk.setBounds(100, 100, 150, 30);
        btnCancelar.setBounds(300, 100, 150, 30);

        /* Ao clicar nestes botoes, o Java executara o metodo actionPerformed() */
        btnOrigem.addActionListener(this);
        btnDestino.addActionListener(this);
        btnOk.addActionListener(this);
        btnCancelar.addActionListener(this);

        /* Adiciona os componentes de tela em suas posicoes pre-definidas. */
        pnlRaiz.setLayout(null);
        pnlRaiz.add(lblOrigem);
        pnlRaiz.add(lblDestino);
        pnlRaiz.add(txtOrigem);
        pnlRaiz.add(txtDestino);
        pnlRaiz.add(btnOrigem);
        pnlRaiz.add(btnDestino);
        pnlRaiz.add(btnOk);
        pnlRaiz.add(btnCancelar);

        /* Finalmente, exibe a janela. */
        setVisible(true);
    }

    /**
     * Metodo executado quando o usuario clica sobre qualquer botao.
     * Desvia o fluxo para um dos metodos abaixo, conforme botao clicado:
     * <ul>
     *     <li><b>btnOrigemActionPerformed()</b> - Quando o usuario clica no botao de arquivo de origem;</li>
     *     <li><b>btnDestinoActionPerformed()</b> - Quando o usuario clica no botao de arquivo de destino;</li>
     *     <li><b>btnOkActionPerformed()</b> - Quando o usuario clica no botao Ok;</li>
     *     <li><b>btnCancelarActionPerformed()</b> - Quando o usuario clica no botao Cancelar.</li>
     * </ul>
     * 
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnOrigem) {
            btnOrigemActionPerformed();
        } else if (event.getSource() == btnDestino) {
            btnDestinoActionPerformed();
        } else if (event.getSource() == btnOk) {
            btnOkActionPerformed();
        } else if (event.getSource() == btnCancelar) {
            btnCancelarActionPerformed();
        }
    }
    
    /**
     * Posiciona a janela bem no meio da tela.
     */
    private void centralizeMe() {

        /* Obtem o tamanho da tela. */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        /* Obtem o tamanho da janela. */
        Dimension frameSize = getSize();

        /* Calcula a posicao horizontal. */
        int horizontal = (screenSize.width - frameSize.width) / 2;

        /* Calcula a posicao horizontal. */
        int vertical = (screenSize.height - frameSize.height) / 2;

        /* Centraliza. */
        setLocation(horizontal, vertical);
    }

    /**
     * Executado ao clicar no botao do arquivo de origem.
     */
    public void btnOrigemActionPerformed() {

        /* Cria uma instancia de caixa de dialogo para escolha de arquivo. */
        JFileChooser dialog = new JFileChooser();

        /* Exibe a caixa de dialogo para escolha de arquivo. */
        dialog.showOpenDialog(this);

        /* Captura o arquivo selecionado. */
        File file = dialog.getSelectedFile();

        /* Se o usuario selecionou um arquivo, coloca o seu nome absoluto na caixa de texto. */
        if (file != null) {
            txtOrigem.setText(file.getAbsolutePath());
        }
    }

    /**
     * Executado ao clicar no botao do arquivo de destino.
     */
    public void btnDestinoActionPerformed() {

        /* Cria uma instancia de caixa de dialogo para escolha de arquivo. */
        JFileChooser dialog = new JFileChooser();

        /* Exibe a caixa de dialogo para escolha de arquivo. */
        dialog.showSaveDialog(this);

        /* Captura o arquivo selecionado. */
        File file = dialog.getSelectedFile();

        /* Se o usuario selecionou um arquivo, coloca o seu nome absoluto na caixa de texto. */
        if (file != null) {
            txtDestino.setText(file.getAbsolutePath());
        }
    }

    /**
     * Executado ao clicar no botao OK.
     */
    public void btnOkActionPerformed() {
        // TODO IMPLEMENT ME!
    }

    /**
     * Executado ao clicar no botao Cancelar.
     */
    public void btnCancelarActionPerformed() {
        /* Fecha a janela descarregando-a da memoria. */
        dispose();
    }
    
    /**
     * Inicia a aplicacao.
     * @param args
     */
    public static void main(String[] args) {
        new FileCopyFrame();
    }
}
