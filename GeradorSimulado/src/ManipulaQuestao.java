
import java.util.ArrayList;
import java.util.Iterator;

public class ManipulaQuestao {
    private ArrayList<Questao> questoes=new ArrayList<>();
    public boolean cadastraQuestao(Questao questao){
        if(questao.getAssunto().getAtivo()&&questao.getAssunto().addQuestao()){
                questoes.add(questao);
                return true;
        }
        return false;
    }
    public boolean excluirQuestao(Questao questao){
        if(questao.getAssunto().getAtivo()){
            questoes.remove(questao);
            questao.getAssunto().removeQuestao();
            return true;
        }
        return false;
    }   
    public ArrayList<Questao> listaPerguntasAssunto(Assunto assunto){
        ArrayList<Questao> porAssunto=new ArrayList<>();
        Iterator itr=questoes.iterator();
        Questao k;
        while(itr.hasNext()){
            k=(Questao) itr.next();
            if(k.getAssunto().equals(assunto)){
                porAssunto.add(k);
            }
        }
        return porAssunto;
    }
    public ArrayList<Questao> listaPerguntas(){
        return questoes;
    }
    public boolean editarQuestao(Questao atual,Questao questao){
            if(atual.getAssunto().getAtivo()&&!questoes.contains(questao)){
                excluirQuestao(atual);
                cadastraQuestao(questao);
                return true;
            }
            return false;
    }
    public ArrayList<Questao> buscaQuestao(String questao){
        ArrayList<Questao> busca=new ArrayList<>();
        Iterator itr=questoes.iterator();
        while(itr.hasNext()){
            Questao k=(Questao) itr.next();
            if(k.getPergunta().equals(questao)){
                busca.add(k);
            }
        }
        return busca;
    }
}
