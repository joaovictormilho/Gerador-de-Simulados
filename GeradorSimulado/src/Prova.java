import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
//SUJEITO A ALTERA��O 
//ALGUNS METODOS EM PROCESSO DE DESENVOLVIMENTO
// COMO GERAR .doc E.txt
public class Prova {
    ManipulaQuestao questoes=new ManipulaQuestao();
    ManipulaAssunto assuntos=new ManipulaAssunto();
    public String[] geraSimulado(Assunto assunto, int tipo){
        Questao temp;
        String []prova=new String[assunto.getAtual()];
        int i = 0;
        Iterator itr=questoes.listaPerguntasAssunto(assunto).iterator();
        while(itr.hasNext()){
            temp=(Questao) itr.next();
            prova[i++]=Integer.toString(i)+") "+temp.imprimeQuestao(0);
        }
        return prova;
    }
    public ManipulaQuestao getQuestoes() {
        return questoes;
    }
    public ManipulaAssunto getAssuntos() {
        return assuntos;
    }
    public void geraProvaDoc(Assunto assunto, int qtdQuestoes){
        if(assunto.getAtivo()&&assunto.getAtual()>=qtdQuestoes){
            String []prova=geraSimulado(assunto, 0);    
        }
    }
public void geraTXT(Assunto assunto,boolean comRespostas,String arquivo) throws IOException{
    	
    	FileWriter arq = new FileWriter("teste.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    int j;
	    
	    
		if(comRespostas) {
			gravarArq.println("Questões do assunto "+assunto.getNome()+", com as respostas.");
			gravarArq.println("");
			j = 1;
		
			for(Iterator<Questao> i = questoes.listaPerguntasAssunto(assunto).iterator(); i.hasNext();) {
				Questao o = (Questao) i.next();
				gravarArq.println((j++)+")"+o.getPergunta()+"\n");
				gravarArq.println(o.imprimeAlternativa());
				gravarArq.println(o.imprimeResposta());
			}
		}
		else {
			gravarArq.println("Questões do assunto "+assunto.getNome()+", com as respostas.");
			gravarArq.println("");
			j = 1;
			
			for(Iterator<Questao> i = questoes.listaPerguntasAssunto(assunto).iterator(); i.hasNext();) {
				Questao o = (Questao) i.next();
				gravarArq.println((j++)+")"+o.getPergunta()+"\n");
				gravarArq.println(o.imprimeAlternativa());
			}
		}
		gravarArq.close();
	}
    
     public void geraCSV() throws IOException {
    	FileWriter arq = new FileWriter("teste.csv");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.println("Assunto,Estado,Quantidade Máxima,Quantidade atual,Data");
	    
	    for(Iterator<Assunto> i = assuntos.listaAssunto().iterator(); i.hasNext();) {
	    	Assunto o = (Assunto) i.next();
	    	gravarArq.println(o.nome+","+(o.getAtivo()?"Ativo":"Excluído")+","+o.getQuantidade()+","+o.getAtual()+","+o.getData().toLocaleString());
	    }
	    
	    gravarArq.close();
    }
    public void salvar(){
        PersistenciaDados.guardaDados(questoes.listaPerguntas(), assuntos.listaAssunto());
    }
    public void pegarDados(){
        PersistenciaDados.pegaDados(questoes.listaPerguntas(), assuntos.listaAssunto());
    }

}
