import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Krusty extends JFrame {

	private JButton btnOk = new JButton();

	public Krusty() {

		setSize(200, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		btnOk.setBounds(30, 50, 140, 40);
		btnOk.setText("Clique aqui!");
		btnOk.setMnemonic('C');
		btnOk.setIcon(new ImageIcon("krusty1.png"));
		btnOk.setPressedIcon(new ImageIcon("krusty2.png"));

		add(btnOk);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Krusty();
	}
}
