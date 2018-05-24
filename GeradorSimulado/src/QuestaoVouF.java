public class QuestaoVouF extends Questao{
    boolean resposta;
    public QuestaoVouF(String pergunta, boolean resposta,Assunto assunto) {
        super(pergunta,assunto);
        this.resposta=resposta;
    }
    @Override
    public String imprimeResposta() {
        return resposta?"Verdadeiro":"Falso";
    }
    @Override
    public String imprimeAlternativa() {
     return "Verdadeiro\nFalso";
    }
    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(super.pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoVouF){
                if(temp.imprimeResposta().equalsIgnoreCase(imprimeResposta())){
                     if(temp.imprimeAlternativa().equalsIgnoreCase(imprimeAlternativa())){
                        if(temp.getAssunto().equals(getAssunto()))
                            return true;
                    }
                }
            }
        }
        return false;
    }
        @Override
    public String getTipo() {
        return "Questao verdadeiro ou falso"; 
    }

    @Override
    public void setAlternativa(String[] alternativas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResposta(String[] resposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResposta(String resposta) {
        Boolean.parseBoolean(resposta);
    }
    
}
