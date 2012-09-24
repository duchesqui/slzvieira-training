import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap15_Ex16 extends JFrame
{
	private JRadioButton normal, negrito, italico, itaNeg;

	private ButtonGroup radioGrupo;

	private JTextField texto;

	private Font normalF, negritoF, italicoF, itaNegF;

	private Container c;

	private RadioButtonTratar tratarRB;

	public Cap15_Ex16()
	{
		super("RadioButton exemplo");

		c = getContentPane();
		c.setLayout(new FlowLayout());

		texto = new JTextField("Clique nos botões para ver o resultado", 25);
		c.add(texto);

		tratarRB = new RadioButtonTratar();

		radioGrupo = new ButtonGroup();

		//criação dos JRadioBox

		normal = adicRadio("Normal", true);
		negrito = adicRadio("Negrito", false);
		italico = adicRadio("Itálico", false);
		itaNeg = adicRadio("Negrito+Itálico", false);

		//criação das fontes

		normalF = new Font("TimesRoman", Font.PLAIN, 14);
		negritoF = new Font("TimesRoman", Font.BOLD, 14);
		italicoF = new Font("TimesRoman", Font.ITALIC, 14);
		itaNegF = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 14);

		texto.setFont(normalF);

		setSize(330,100);
		show();
	}

		public static void main(String args[])
		{
			Cap15_Ex16 aplic = new Cap15_Ex16();

			aplic.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}

//definição do método para adicionar componentes

		private JRadioButton
		adicRadio(String nome, boolean b)
		{
			JRadioButton radioBot = new JRadioButton(nome, b);

			radioBot.addItemListener(tratarRB);
			c.add(radioBot);

			radioGrupo.add(radioBot);

			return radioBot;
		}

			private class RadioButtonTratar implements ItemListener
			{
				public void itemStateChanged(ItemEvent e)
				{
					if(e.getSource() == normal)
						texto.setFont(normalF);

					else if(e.getSource() == negrito)
						texto.setFont(negritoF);

					else if(e.getSource() == italico)
						texto.setFont(italicoF);

					else if(e.getSource() == itaNeg)
					texto.setFont(itaNegF);

					texto.repaint();
				}
			}
}
