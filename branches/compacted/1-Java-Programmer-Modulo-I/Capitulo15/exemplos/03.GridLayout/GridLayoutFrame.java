import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutFrame extends JFrame {

    JButton btn1 = new JButton("Bot�o 1");
    JButton btn2 = new JButton("Bot�o 2");
    JButton btn3 = new JButton("Bot�o 3");
    JButton btn4 = new JButton("Bot�o 4");
    JButton btn5 = new JButton("Bot�o 5");
    JButton btn6 = new JButton("Bot�o 6");

    public GridLayoutFrame() {
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutFrame();
    }
}
