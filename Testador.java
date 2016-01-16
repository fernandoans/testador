import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testador extends PreJanela {
    
    private ButtonGroup selecao = new ButtonGroup();
    private JRadioButton opcao1 = new JRadioButton("Opção 01");
    private JRadioButton opcao2 = new JRadioButton("Opção 02");
    private JRadioButton opcao3 = new JRadioButton("Opção 03");
    private JRadioButton opcao4 = new JRadioButton("Opção 04");
    private JTextArea taQuestao;
    private Arquivo arq = new Arquivo();
    private ObjQuestao objQuestao;
    
    public Testador() {
        super();
        this.setSize(450,400);
        
        // Area Central
        JPanel pnCentral = new JPanel();
        pnCentral.setLayout(new GridLayout(2,1));
        taQuestao = new JTextArea();
        taQuestao.setEditable(false);
        pnCentral.add(new JScrollPane(taQuestao));

        // Opções
        JPanel pnOpcao = new JPanel();
        pnOpcao.setLayout(new GridLayout(4,1));
        pnOpcao.add(montarOpcao(opcao1));
        selecao.add(opcao1);
        pnOpcao.add(montarOpcao(opcao2));
        selecao.add(opcao2);
        pnOpcao.add(montarOpcao(opcao3));
        selecao.add(opcao3);
        pnOpcao.add(montarOpcao(opcao4));
        selecao.add(opcao4);
        pnCentral.add(pnOpcao);
        
        // Area dos Botões
        JButton btVerificar = new JButton("Verificar");
        btVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificar();
            }
        });   
        JButton btCarregar = new JButton("Carregar");
        btCarregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carregar();
            }
        });   

        JPanel pnBut = new JPanel();
        pnBut.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pnBut.add(btVerificar);
        pnBut.add(btCarregar);
        
        this.add(pnCentral);
        this.add(pnBut, BorderLayout.SOUTH);
        carregar();
        
        this.setVisible(true);
    }
    
    private void carregar() {
        objQuestao = arq.carregar();
        taQuestao.setText(linhaQuebrada(objQuestao.getQuestao()));
        opcao1.setText(objQuestao.getOpcao()[0]);
        opcao2.setText(objQuestao.getOpcao()[1]);
        opcao3.setText(objQuestao.getOpcao()[2]);
        opcao4.setText(objQuestao.getOpcao()[3]);
    }
    
    private void verificar() {
        if (opcao1.isSelected()) {
            testar((byte)0);
        } else if (opcao2.isSelected()) {
            testar((byte)1);
        } else if (opcao3.isSelected()) {
            testar((byte)2);
        } else if (opcao4.isSelected()) {
            testar((byte)3);
        }
    }

    private String linhaQuebrada(String linha) {
        if (linha.length() > 60) {
            for (int p = 60; p > 0; p--) {
                if (linha.charAt(p) == ' ') {
                    linha = linha.substring(0, p) + '\n' + 
                        linhaQuebrada(linha.substring(p+1));
                    break;
                }
            }
        }
        return linha;
    }
    
    private void testar(byte escolhida) {
        if (objQuestao.getCorreta() == escolhida) {
            JOptionPane.showMessageDialog(this, "Parabéns. Você acertou!");
            carregar();
        } else {
            JOptionPane.showMessageDialog(this, "Que pena. Você errou!");
        }
    }
    
    public static void main(String [] args) {
        new Testador();
    }
}