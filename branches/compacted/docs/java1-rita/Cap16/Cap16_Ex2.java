import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Cap16_Ex2 extends Applet
{
	public void init()
	{
		setBackground(Color.yellow);

		add(new Label("Hello Applet!"));

		addMouseListener(new MouseAdapter()

		{
			public void mouseEntered(MouseEvent e)
			{
				setBackground(Color.red);
			}
			public void mouseExited(MouseEvent e)
			{
				setBackground(Color.blue);
			}
		});
	}
}