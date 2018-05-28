package Logica;

public class QuestaoMultiplaEscolhaSem extends Questao{
    String []alternativa;
    String resposta;
    public QuestaoMultiplaEscolhaSem(String pergunta,String resposta,String []alternativa,Assunto assunto) {
        super(pergunta,assunto);
        this.resposta=resposta;
        this.alternativa=alternativa;
    }

    @Override
    public String imprimeResposta() {
        return (getItemCerto()+65)+resposta+"\n";
    }

    @Override
    public String imprimeAlternativa(){
        String temp="";
        for(int i=0;i<alternativa.length;i++){
           temp=temp+(i+65)+") "+alternativa[i]+"\n"; 
        }
        return temp;
    }
    public int getItemCerto(){
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
    public String getResposta(){
        return resposta;
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoMultiplaEscolhaSem){
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
        return "Questao multipla escolha com uma unica resposta"; 
    }

    @Override
    public void setAlternativa(String[] alternativas) {
        this.alternativa=alternativas; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResposta(String[] resposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResposta(String resposta) {
        this.resposta=resposta; 
    }
}
