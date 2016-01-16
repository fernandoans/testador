public class ObjQuestao {
    
    private String questao;
    private String [] opcao = new String[4];
    private byte correta;
    
    public void setQuestao(String questao) {
        this.questao = questao;
    }
    public String getQuestao() {
        return questao;
    }
    
    public void addOpcao(String conteudo, int pos) {
        this.opcao[pos] = conteudo;
    }
    public String[] getOpcao() {
        return opcao;
    }
    
    public void setCorreta(byte correta) {
        this.correta = correta;
    }
    public byte getCorreta() {
        return correta;
    }
}