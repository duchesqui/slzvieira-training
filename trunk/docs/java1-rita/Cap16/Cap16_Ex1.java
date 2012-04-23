import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Cap16_Ex1 extends Applet
{
	Label lb;

	public void init()
	{
		lb = new Label("Hello Applet!");
		add(lb);
	}
}