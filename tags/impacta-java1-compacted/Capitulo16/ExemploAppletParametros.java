import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploAppletParametros extends Applet implements ActionListener {

    String nomeArquivoImagem;
    String nomeArquivoSom;
    Image imagem;
    AudioClip som;

    Button botaoPlay = new Button("Play");
    Button botaoStop = new Button("Stop");
    Button botaoLoop = new Button("Loop");

    public void init() {

        nomeArquivoImagem = getParameter("figura");
        nomeArquivoSom = getParameter("som");
        imagem = getImage(getDocumentBase(), nomeArquivoImagem);
        som = getAudioClip(getDocumentBase(), nomeArquivoSom);

        botaoPlay.addActionListener(this);
        botaoStop.addActionListener(this);
        botaoLoop.addActionListener(this);

        setLayout(new FlowLayout());
        setSize(300, 300);
        add(botaoPlay);
        add(botaoStop);
        add(botaoLoop);
    }
    
    public void paint(Graphics g) {
        g.drawImage(imagem, 0, 0, this);
    }
    
    public void stop() {
        som.stop();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoPlay) {
           	som.play();
        } else if (e.getSource() == botaoStop) {
            som.stop();
        } else {
            som.loop();
        }
    }
}
