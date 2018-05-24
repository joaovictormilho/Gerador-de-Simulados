
public class QuestaoAberta extends Questao {
    
    String resposta;
    public QuestaoAberta(String pergunta, String resposta,Assunto assunto) {
        super(pergunta,assunto);
        this.resposta=resposta;
    }
    @Override
    public String imprimeResposta() {
        return resposta;
    }

    @Override
    public String imprimeAlternativa() {
        return "R: " ;
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(super.pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoMultiplaEscolhaCom){
                if(temp.imprimeResposta().equalsIgnoreCase(imprimeResposta())){
                    if(temp.getAssunto().equals(getAssunto()))
                        return true;
                }
            }
        }
        return false;
    }
        @Override
    public String getTipo() {
        return "Questao aberta"; 
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
        this.resposta=resposta;//To change body of generated methods, choose Tools | Templates.
    }
    
}
