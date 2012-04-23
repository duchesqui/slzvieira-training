import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap15_Ex13 extends JFrame
{
	private JButton		txtBotao,				//botão simples com texto
						imgBotao;				//botão com imagem

	public Cap15_Ex13()
	{
		super("Testando Jbuttons");    			//chamando a super classe

		Container c = getContentPane();    		//criação de um objeto do tipo content pane
		c.setLayout(new FlowLayout());

		txtBotao = new JButton("Botão simples");
		c.add(txtBotao);

		Icon img1 = new ImageIcon("smallimg.gif"); //salvar o .gif na mesma pasta da classe
		Icon img2 = new ImageIcon("UNDERCON.gif");

		imgBotao = new JButton("Botão com imagem", img1);
		imgBotao.setRolloverIcon(img2);

		imgBotao.setHorizontalTextPosition(SwingConstants.CENTER);
		imgBotao.setVerticalTextPosition(SwingConstants.BOTTOM);

		c.add(imgBotao);
		c.add(txtBotao);

		ButtonTratar tratarB = new ButtonTratar();

		imgBotao.addActionListener(tratarB);
		txtBotao.addActionListener(tratarB);

		setSize(300,150);
		show();
	}

	public static void main(String args[])
	{
		Cap15_Ex13 aplic = new Cap15_Ex13();

	//classe anônima para tratamento de janela

		aplic.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	//classe interna para handle event

	private class ButtonTratar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null,"Você pressionou: " + e.getActionCommand()); //retorna o rótulo do botão
		}
	}
}
