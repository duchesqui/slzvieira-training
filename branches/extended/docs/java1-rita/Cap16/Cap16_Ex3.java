
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Cap16_Ex3 extends Applet
{
	Button b1, b2;
	TextField txt = new TextField(25);

	public void init()
	{

		setBackground(Color.green);
		setLayout( new FlowLayout() );

		add( b1 = new Button("Botão 1"));
		add( b2 = new Button("Botão 2"));

		b1.addActionListener(alist);
		b2.addActionListener(alist);

		add(b1);
		add(b2);
		add(txt);
	}

	ActionListener alist = new ActionListener()
	{
		public void actionPerformed( ActionEvent e)
		{
			if (e.getActionCommand() == "Botão 1")
				txt.setText("Você pressionou o botão 1");

			else if (e.getActionCommand() == "Botão 2")
				txt.setText("Agora foi pressionado o botão 2");
		}
	};
}

