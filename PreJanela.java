import javax.swing.*;
import java.awt.*;

public abstract class PreJanela extends JFrame {

    public PreJanela() {
        super("Testador para Concursos");
        JPanel bordaJanela = new JPanel();
        bordaJanela.setLayout(new BorderLayout());
        bordaJanela.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setContentPane(bordaJanela);        
    }
    
    protected JPanel montarOpcao(JRadioButton rd) {
        JPanel pn = new JPanel();
        pn.setLayout(new FlowLayout(FlowLayout.LEADING));
        pn.add(rd);
        return pn;
    }
}