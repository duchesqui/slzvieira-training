import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cap15_Ex5
{
	public static void main(String args[])
	{
		int resp;
		do
		{
			DialogExs(); // executa v�rios exemplos de caixa de di�logo

		// confirmar sa�da sim ou n�o

			resp = JOptionPane.showConfirmDialog(null,
					"Deseja finalizar a execu��o?", "Sa�da",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
		}

		while (resp == 1); // bot�o YES = 0, bot�o NO = 1
		System.exit(0);
	}

		static void DialogExs()
		{
			// mensagem normal, sem �cone

			JOptionPane.showMessageDialog(null,
			"Utilizando di�logo PLAIN_MESSAGE no Swing sem �cone",
			"Leia",
			JOptionPane.PLAIN_MESSAGE);

			// mensagem normal, �cone informa��o

			JOptionPane.showMessageDialog(null,
			"Utilizando di�logo INFORMATION_MESSAGE no Swing com �cone",
			"Aviso",
			JOptionPane.INFORMATION_MESSAGE);

			// mensagem normal, �cone pergunta

			JOptionPane.showMessageDialog(null,
			"Utilizando di�logo QUESTION_MESSAGE no Swing",
			"Pergunta",
			JOptionPane.QUESTION_MESSAGE);

			// mensagem normal, �cone aviso

			JOptionPane.showMessageDialog(null,
			"Utilizando di�logo WARNING_MESSAGE no Swing",
			"Aviso",
			JOptionPane.WARNING_MESSAGE);

			// mensagem normal, �cone erro

			JOptionPane.showMessageDialog(null,
			"Utilizando di�logo ERROR_MESSAGE no Swing",
			"Erro",
			JOptionPane.ERROR_MESSAGE);


			// mensagem normal para entrada de dados

			String num1=JOptionPane.showInputDialog(null,
			"Digite o primeiro n�mero: ",
			"Entrada de dados 1",
			JOptionPane.QUESTION_MESSAGE);

			String num2=JOptionPane.showInputDialog(null,
			"Digite o segundo n�mero: ",
			"Entrada de dados 2",
			JOptionPane.QUESTION_MESSAGE);

			int result = Integer.parseInt(num1) + Integer.parseInt(num2);

			JOptionPane.showMessageDialog(null,
			"Resultado da soma = " + result,
			"Resultado", JOptionPane.WARNING_MESSAGE);
	}
  }
