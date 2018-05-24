
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;


public class Assunto {
    String nome;
    Date data;
    boolean ativo;
    int quantidade;
    int atual=0;
    Object getData;
    public Assunto(String assunto,int quantQuestoes){
        this.nome=assunto;
        this.data=new Date();
        ativo=true;
        this.quantidade=quantQuestoes;
    }

    boolean getAtivo(){
        return ativo; 
    }
    void setAtivo(boolean b){
        ativo=b; 
    }
    //public void cadastraQuestao
//    public boolean equals(String assunto){
//        return nome.equals(assunto);
//    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Assunto){
            Assunto temp=(Assunto)o;
            if(temp.nome.equals(this.nome))
            	if((!temp.ativo||ativo)&&(!ativo||temp.ativo))
            		if(data.compareTo(temp.data)==0)
            			return true;
        }else{
            String temp=(String) o;
            return temp.equals(nome)&&ativo;
        }
        return false;
    }
    public void setAssunto(String assunto){
        this.nome=assunto;
    }
    public boolean addQuestao(){
        if(quantidade>atual){
            atual++;
            return true;
        }
        return false;
    }
    public boolean removeQuestao(){
        if(atual>0){
        	System.out.println("Atual "+atual);
            atual=atual-1;
            return true;
        }
        return false;
    }

    String getNome() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    int getAtual() {
        return atual; //To change body of generated methods, choose Tools | Templates.
    }

    int getQuantidade() {
        return quantidade; //To change body of generated methods, choose Tools | Templates.
    }

    Date getData() {
        return data; //To change body of generated methods, choose Tools | Templates.
    }
}
