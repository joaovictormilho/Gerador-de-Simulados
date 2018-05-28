package Logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class Assunto {

    private String nome;
    Date data = new Date() {

        @Override
        public String toString() {
            String o = super.toLocaleString();
            o = o.substring(0, 16);
            return o; //To change body of generated methods, choose Tools | Templates.
        }

    };
    boolean ativo;
    int quantidade;
    int atual = 0;
    public boolean isCadastravel(){
        return quantidade>atual&&ativo;
    }
    public Assunto(String assunto, int quantQuestoes) {
        this.nome = assunto;
        ativo = true;
        this.quantidade = quantQuestoes;
    }

    public boolean getAtivo() {
        return ativo;
    }

    void setAtivo(boolean b) {
        ativo = b;
    }

    //public void cadastraQuestao
//    public boolean equals(String assunto){
//        return nome.equals(assunto);
//    }
    @Override
    public boolean equals(Object o) {
        return ((Assunto)o).getNome().equals(nome);
    }

    public void setAssunto(String assunto, int quantidade) {
        this.nome = assunto;
        this.quantidade = quantidade;
    }

    public boolean addQuestao() {
        if (quantidade > atual && ativo) {
            atual++;
            return true;
        }
        return false;
    }

    public boolean removeQuestao() {
        if (atual > 0 && ativo){
            atual = atual - 1;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public int getAtual() {
        return atual; //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getQuantidade() {
        return quantidade; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return nome;
    }

    public Date getData() {
        return data; //To change body of generated methods, choose Tools | Templates.
    }
}
