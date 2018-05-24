public abstract class Questao {
    String pergunta;
    Assunto assunto;
    public Questao(String pergunta,Assunto assunto) {
        this.pergunta = pergunta;
        this.assunto=assunto;
    }
    public void setPergunta(String pergunta){
        this.pergunta=pergunta;
    }
    public Assunto getAssunto(){
        return assunto;
    }
    public abstract void setAlternativa(String []alternativas);
    public abstract void setResposta(String []resposta);
    public abstract void setResposta(String resposta);
    public String imprimeQuestao(int i){
        if(i==0){
            return pergunta+"\n"+imprimeAlternativa();
        }else{
            if(i==1){
                return pergunta+"\n"+imprimeResposta();
            }
        }
        return null;
    }
    @Override
    public abstract boolean equals(Object questao);
    public abstract String imprimeResposta(); 
    public abstract String imprimeAlternativa(); 
    public abstract String getTipo();

    String getPergunta() {
        return pergunta; //To change body of generated methods, choose Tools | Templates.
    }
}
