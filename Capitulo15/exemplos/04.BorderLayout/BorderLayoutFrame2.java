import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame2 extends JFrame {
    
    JButton btn1 = new JButton("Botão 1");
    JButton btn2 = new JButton("Botão 2");
    
    public BorderLayoutFrame2() {
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        add(btn1, BorderLayout.CENTER);
        add(btn2, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BorderLayoutFrame2();
    }
}
