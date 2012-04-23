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
			DialogExs(); // executa vários exemplos de caixa de diálogo

		// confirmar saída sim ou não

			resp = JOptionPane.showConfirmDialog(null,
					"Deseja finalizar a execução?", "Saída",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
		}

		while (resp == 1); // botão YES = 0, botão NO = 1
		System.exit(0);
	}

		static void DialogExs()
		{
			// mensagem normal, sem ícone

			JOptionPane.showMessageDialog(null,
			"Utilizando diálogo PLAIN_MESSAGE no Swing sem ícone",
			"Leia",
			JOptionPane.PLAIN_MESSAGE);

			// mensagem normal, ícone informação

			JOptionPane.showMessageDialog(null,
			"Utilizando diálogo INFORMATION_MESSAGE no Swing com ícone",
			"Aviso",
			JOptionPane.INFORMATION_MESSAGE);

			// mensagem normal, ícone pergunta

			JOptionPane.showMessageDialog(null,
			"Utilizando diálogo QUESTION_MESSAGE no Swing",
			"Pergunta",
			JOptionPane.QUESTION_MESSAGE);

			// mensagem normal, ícone aviso

			JOptionPane.showMessageDialog(null,
			"Utilizando diálogo WARNING_MESSAGE no Swing",
			"Aviso",
			JOptionPane.WARNING_MESSAGE);

			// mensagem normal, ícone erro

			JOptionPane.showMessageDialog(null,
			"Utilizando diálogo ERROR_MESSAGE no Swing",
			"Erro",
			JOptionPane.ERROR_MESSAGE);


			// mensagem normal para entrada de dados

			String num1=JOptionPane.showInputDialog(null,
			"Digite o primeiro número: ",
			"Entrada de dados 1",
			JOptionPane.QUESTION_MESSAGE);

			String num2=JOptionPane.showInputDialog(null,
			"Digite o segundo número: ",
			"Entrada de dados 2",
			JOptionPane.QUESTION_MESSAGE);

			int result = Integer.parseInt(num1) + Integer.parseInt(num2);

			JOptionPane.showMessageDialog(null,
			"Resultado da soma = " + result,
			"Resultado", JOptionPane.WARNING_MESSAGE);
	}
  }
