import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame1 extends JFrame {
    
    JButton btn1 = new JButton("Botão 1");
    JButton btn2 = new JButton("Botão 2");
    JButton btn3 = new JButton("Botão 3");
    JButton btn4 = new JButton("Botão 4");
    JButton btn5 = new JButton("Botão 5");
    
    public BorderLayoutFrame1() {
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        add(btn1, BorderLayout.NORTH);
        add(btn2, BorderLayout.SOUTH);
        add(btn3, BorderLayout.EAST);
        add(btn4, BorderLayout.WEST);
        add(btn5, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BorderLayoutFrame1();
    }
}
