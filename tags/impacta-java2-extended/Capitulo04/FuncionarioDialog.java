package br.com.impacta.funcionario;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Uma simples caixa de dialogo utilizada para a entrada de dados de um funcionario.
 * @author sandro.vieira
 * @version 1.0, 14/05/2012 - sandro.vieira - Implementacao.
 */
public class FuncionarioDialog extends JDialog {

    private JPanel pnlRaiz = (JPanel) getContentPane();
    private JLabel lblNome = new JLabel("Nome:");
    private JLabel lblIdade = new JLabel("Idade:");
    private JLabel lblSalario = new JLabel("Salario:");
    private JTextField txtNome = new JTextField();
    private JTextField txtIdade = new JTextField();
    private JTextField txtSalario = new JTextField();
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancelar = new JButton("Cancelar");
    
    private Funcionario funcionario;
    private static final long serialVersionUID = 1L;

    /**
     * Exibe uma janela para entrada de dados de um funcionario.
     * @return Instancia de {@link Funcionario} com seus atributos preenchidos ou
     *         <b><code>null</code></b> quando usuario clicar em Cancelar ou Fechar.
     */
    public static Funcionario showInputFuncionario() {
        FuncionarioDialog frame = new FuncionarioDialog();
        Funcionario funcionario = frame.funcionario;
        frame.dispose();
        return funcionario;
    }

    /**
     * Construtor privado. Esta classe nao pode ser instanciada a partir de sua aplicacao.
     * Para usar esta classe, utilize o metodo estatico {@link #showInputFuncionario()}. 
     */
    private FuncionarioDialog() {

        /* Assinala as caracteristicas da janela (titulo, tamanho, etc) */
        setTitle("Funcionario");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        centralizeMe();

        /* Prepara o tamanho e posicao dos labels. */
        lblNome.setBounds(20, 20, 50, 20);
        lblIdade.setBounds(20, 50, 50, 20);
        lblSalario.setBounds(20, 80, 50, 20);

        /* Prepara o tamanho e posicao das caixas de texto.. */
        txtNome.setBounds(70, 20, 200, 20);
        txtIdade.setBounds(70, 50, 200, 20);
        txtSalario.setBounds(70, 80, 200, 20);

        /* Prepara o tamanho e posicao dos botoes. */
        btnOk.setBounds(50, 120, 90, 30);
        btnCancelar.setBounds(160, 120, 90, 30);

        /* Assinala a acao do botao Ok com uma classe interna anonima (veja capitulo 1). */
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    String nome = txtNome.getText();
                    int idade = Integer.parseInt(txtIdade.getText());
                    double salario = Double.parseDouble(txtSalario.getText());

                    funcionario = new Funcionario();
                    funcionario.setNome(nome);
                    funcionario.setIdade(idade);
                    funcionario.setSalario(salario);
                    
                    setVisible(false);

                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite os dados corretamente.", "Dados invalidos",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /* Assinala a acao do botao Cancelar com uma classe interna anonima (veja capitulo 1). */
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        /* 
         * Eliminta o layout manager da janela, permitindo que cada
         * componente tenha tamanho e posicionamento livre.
         */
        pnlRaiz.setLayout(null);

        /* Adiciona os componentes na tela conforme tamanho e posicao ja definidos. */
        pnlRaiz.add(lblNome);
        pnlRaiz.add(lblIdade);
        pnlRaiz.add(lblSalario);
        pnlRaiz.add(txtNome);
        pnlRaiz.add(txtIdade);
        pnlRaiz.add(txtSalario);
        pnlRaiz.add(btnOk);
        pnlRaiz.add(btnCancelar);

        /* Finalmente... Mostra a janela  :-)  */
        setVisible(true);
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
}
