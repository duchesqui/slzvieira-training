import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Cap16_Ex4 extends Applet
{

	String imagem, som;

	Image img;

	AudioClip s;

	Button b1, b2, b3;

	public void init()
	{

		imagem = getParameter("par1");
		som       = getParameter("par2");

		img = getImage (getDocumentBase(), imagem);
		s     = getAudioClip(getDocumentBase(), som);

		setLayout( new FlowLayout() );

		add( b1 = new Button("Play"));
		add( b2 = new Button("Stop"));
		add( b3 = new Button("Loop"));

		b1.addActionListener( alist );
		b2.addActionListener( alist );
		b3.addActionListener( alist );

		add(b1);
		add(b2);
		add(b3);
	}

	ActionListener alist = new ActionListener()
	{
		public void actionPerformed( ActionEvent e )
		{
			if (e.getActionCommand() == "Play")
				s.play();

			else if (e.getActionCommand() == "Stop")
				s.stop();

			else if (e.getActionCommand() == "Loop")
				s.loop();
		}
};

public void paint(Graphics g)
{
		g.drawImage(img,0,0,this);
}

public void stop()
{
		s.stop();
}
}
