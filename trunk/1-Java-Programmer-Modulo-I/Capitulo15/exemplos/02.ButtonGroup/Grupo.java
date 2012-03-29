import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Grupo extends JFrame {

    ButtonGroup grpSexo = new ButtonGroup();
    JRadioButton optMasculino = new JRadioButton();
    JRadioButton optFeminino = new JRadioButton();

    ButtonGroup grpTime = new ButtonGroup();
    JRadioButton optCorinthians = new JRadioButton();
    JRadioButton optPalmeiras = new JRadioButton();
    JRadioButton optSaoPaulo = new JRadioButton();
    JRadioButton optSantos = new JRadioButton();

    public Grupo() {

        setSize(280, 200);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        optMasculino.setBounds(30, 50, 100, 40);
        optMasculino.setText("Masculino");
        optMasculino.setSelected(true);
        grpSexo.add(optMasculino);
        add(optMasculino);

        optFeminino.setBounds(30, 80, 100, 40);
        optFeminino.setText("Feminino");
        grpSexo.add(optFeminino);
        add(optFeminino);

        optCorinthians.setBounds(150, 20, 100, 40);
        optCorinthians.setText("Corinthians");
        optCorinthians.setSelected(true);
        grpTime.add(optCorinthians);
        add(optCorinthians);

        optPalmeiras.setBounds(150, 50, 100, 40);
        optPalmeiras.setText("Palmeiras");
        grpTime.add(optPalmeiras);
        add(optPalmeiras);

        optSaoPaulo.setBounds(150, 80, 100, 40);
        optSaoPaulo.setText("São Paulo");
        grpTime.add(optSaoPaulo);
        add(optSaoPaulo);

        optSantos.setBounds(150, 110, 100, 40);
        optSantos.setText("Santos");
        grpTime.add(optSantos);
        add(optSantos);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Grupo();
    }
}
