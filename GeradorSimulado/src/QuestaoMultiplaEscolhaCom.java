public class QuestaoMultiplaEscolhaCom extends Questao{
    String []alternativa;
    String []resposta;
    public QuestaoMultiplaEscolhaCom(String pergunta,String []resposta,String []alternativa,Assunto assunto) {
        super(pergunta,assunto);
        this.alternativa=alternativa;
        this.resposta=resposta;
    }

    @Override
    public String imprimeResposta() {
        if(resposta[0].equalsIgnoreCase("nenhuma resposta correta")){
            return resposta[0];
        }
        String temp="";
        for(int i=0;i<resposta.length;i++){
           temp=temp+(getItemCerto(resposta[i])+65)+") "+alternativa[i]+"\n"; 
        }
        return temp;
    }

    @Override
    public String imprimeAlternativa() {
        String temp="";
        for(int i=0;i<alternativa.length;i++){
           temp=temp+(i+65)+") "+alternativa[i]+"\n"; 
        }
        return temp;    
    }
    public int getItemCerto(String resposta){
        for(int i=0;i<alternativa.length;i++){
            if(alternativa[i].equals(resposta)){
                return i;
            }
        }
        return -1;
    }
    public String[] getAlternativa(){
        return alternativa;
    }
    public String[] getResposta(){
        return resposta;
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(super.pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoMultiplaEscolhaCom){
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
        return "Questao multipla escolha com varias resposta"; 
    }

    @Override
    public void setAlternativa(String[] alternativas) {
        this.alternativa=alternativas;
    }

    @Override
    public void setResposta(String[] resposta) {
        this.resposta=resposta;
    }

    @Override
    public void setResposta(String resposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
