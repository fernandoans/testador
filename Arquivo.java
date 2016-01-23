import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    private int totQuestao;
    private final String nomeArquivo = "materias/FigurasDeSintaxe.qst";
    private ObjQuestao objQuestao;
    // Para evitar de carregar respostas duplicadas
    private int sort1 = -1, sort2 = -1, sort3 = -1;

    public Arquivo() {
        contar();
    }
    
    private void contar() {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(nomeArquivo));
            String linha = "";
            totQuestao = 0;
            while ((linha = br.readLine()) != null) {
                totQuestao++;
            }
            br.close();
        } catch (IOException e) {
        }
    }

    private String linhaSel(int valor) {
        String retorno = "";
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(nomeArquivo));
            String linha = "";
            int numLinha = 0;
            while ((linha = br.readLine()) != null) {
                if (++numLinha == valor) {
                    retorno = linha;
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
        }
        return retorno;
    }

    private void adicionarOpcaoNoObj(String linha, byte pos) {
        objQuestao.addOpcao(
            linha.substring(0, linha.indexOf(';')), pos);
    }
    
    private void carregarOpcao(byte pos) {
        // Sortear
        int obter;
        do {
            obter = (int)(Math.random()*totQuestao+1);
        } while (obter == sort1 || obter == sort2 || obter == sort3);
        // Marcar para não selecionar novamente
        if (sort2 == -1) {
            sort2 = obter;     
        } else if (sort3 == -1) {
            sort3 = obter;
        }
        // Adicionar a opção no objeto
        this.adicionarOpcaoNoObj(this.linhaSel(obter), pos);
    }
        
    private void carregarOutrasOpcoes() {
        for (byte b = 0; b < 4; b++) {
            if (b != objQuestao.getCorreta()) {
                this.carregarOpcao(b);
            }
        }
    }
    
    private void carregarCorreta() {
        // Selecionar uma questão qualquer
        sort1 = (int)(Math.random()*totQuestao+1);
        objQuestao.setCorreta((byte)(Math.random()*4));
        // Obter a questão e a opção correta
        String linha = this.linhaSel(sort1);
        this.adicionarOpcaoNoObj(linha, objQuestao.getCorreta());
        objQuestao.setQuestao(
            linha.substring(linha.indexOf(';')+1));
    }
    
    public ObjQuestao carregar() {
        sort2 = -1; sort3 = -1;
        objQuestao = new ObjQuestao();
        this.carregarCorreta();
        this.carregarOutrasOpcoes();
        return objQuestao;
    }
}