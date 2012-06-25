import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {

    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");

    public FlowLayoutFrame() {
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);

        setVisible(true);
    }

    public static void main(String[] args) {
        FlowLayoutFrame janela = new FlowLayoutFrame();
    }
}
