import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class Cap16_Ex5 extends Applet
{
	Button b1;

	URL u;

	public void init()
	{

		setLayout(new FlowLayout());

		add(b1 = new Button("Mudar"));

		b1.addActionListener(alist);

		add(b1);
		try
		{
			u = new URL(getDocumentBase(),"Cap16_Ex5.htm");
		}
		catch(Exception e)
		{
			showStatus("Erro na URL !...");
		}
	}

	ActionListener alist = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getActionCommand() == "Mudar")
				getAppletContext().showDocument(u);

		}
	};
}
