import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap15_Ex14 extends JFrame
{
	String texto;

	private JTextField TField1, TField2, TField3;
	private JLabel lbl1, lbl2, lbl3;

	public Cap15_Ex14()
	{
		super("Utilizando JTextField");

		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2));    //3 colunas, 2 linhas

		//JLabel (títulos) para campos de textos

		lbl1 = new JLabel("Digite um texto aqui: ", SwingConstants.RIGHT);
		lbl2 = new JLabel("Este já vem com texto ", SwingConstants.RIGHT);
		lbl3 = new JLabel("Este não pode ser editado ", SwingConstants.RIGHT);

		TField1 = new JTextField(20);

		TField2 = new JTextField("Campo texto preenchido e editável", 20);

		TField3 = new JTextField("Campo texto não editável", 20);
		TField3.setEditable(false);

		c.add(lbl1);
		c.add(TField1);

		c.add(lbl2);
		c.add(TField2);

		c.add(lbl3);
		c.add(TField3);

		TextFieldTratar tratarTF = new TextFieldTratar();

		TField1.addActionListener(tratarTF);
		TField2.addActionListener(tratarTF);
		TField3.addActionListener(tratarTF);

		setSize(420,120);
		show();
	}

	public static void main(String args[])
	{
	Cap15_Ex14 app = new Cap15_Ex14();

	app.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	});
}

	//classe interna (inner class) para o event handling

	private class TextFieldTratar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			texto = "";

			if(e.getSource() == TField1)
				texto = "Conteúdo de TField1 = " + TField1.getText();    //retorna o texto
			else if(e.getSource() == TField2)
				texto = "Conteúdo de TField2 = " + TField2.getText();
			else if(e.getSource() == TField3)
				texto = "Conteúdo de TField3 = " + TField3.getText();

			JOptionPane.showMessageDialog(null, texto, "Texto digitado",
			JOptionPane.WARNING_MESSAGE);
		}
	}
}
