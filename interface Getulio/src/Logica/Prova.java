package Logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Prova {

   
    ArrayList<Assunto> assuntos = new ArrayList<Assunto>() {
        @Override
        public boolean add(Assunto e) {
            if (!super.contains(e)) {
                super.add(e);
                return true;
            }
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return super.contains(o); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean remove(Object o) {
            if (((Assunto) o).ativo) {
                ((Assunto) o).setAtivo(false);
                return true;
            }
            return false;
        }

        @Override
        public Assunto set(int i, Assunto e) {
            if (!this.contains(e)){
                    get(i).setAssunto(e.getNome());
                    return get(i);
            }
            return null;
        }
    };
    ArrayList<Questao> questoes = new ArrayList<Questao>() {
        @Override
        public boolean add(Questao e) {
            if (e.getAssunto().addQuestao()) {
                super.add(e);
                return true;
            }
            return false;
        }

        @Override
        public Questao set(int i, Questao e) {
            if (!this.contains(e) && e.getAssunto().getAtivo()) {
                return super.set(i, e);
            }
            return null;
        }

        @Override
        public boolean remove(Object o) {
            if (((Questao) o).getAssunto().removeQuestao()) {
                return super.remove(o);
            }
            return false;
        }
    };

    public ArrayList<Assunto> getAssuntos() {
        return assuntos;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public List<Questao> listaQuestoes(String pergunta) {
        ArrayList<Questao> busca = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getPergunta().equals(pergunta))).forEachOrdered(busca::add);
        return busca;
    }

    public List<Questao> listaQuestoesAssunto(Assunto assunto) {
        ArrayList<Questao> porAssunto = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getAssunto().equals(assunto))).forEachOrdered(porAssunto::add);
        return porAssunto;
    }

    public String[] geraSimulado(Assunto assunto, int tipo) {
        String[] prova = new String[assunto.getQuantidade()];
        int i = 0;
        for (Questao temp : listaQuestoesAssunto(assunto)) {
            prova[i++] = Integer.toString(i) + ") " + temp.imprimeQuestao(tipo);
        }
        return prova;
    }

    public boolean geraProvaDoc(Assunto assunto, int qtdQuestoes) {
        if (assunto.getQuantidade() < qtdQuestoes) {
            return false;
        }
        int i = 0;
        Random number = new Random();
        ArrayList<Questao> questaoProva = new ArrayList<>();
        ArrayList<Questao> questao = (ArrayList<Questao>) listaQuestoesAssunto(assunto);
        int k;
        k = assunto.getQuantidade();
        //ordena de acordo o metodo texto da pergunta
        questao.sort((Questao t, Questao t1) -> t.getPergunta().compareTo(t1.getPergunta()));
        //Usado para pegar os valores aletorio;
        HashSet<Integer> numeros = new HashSet<Integer>();
        for (int j = 0; j < qtdQuestoes; j++) {
            boolean isV = false;
            int l = number.nextInt(questao.size());
            Questao temp = questao.get(number.nextInt(questao.size()));
            for (Questao o : questaoProva) {
                if (temp.isEqualsPergunta(o)) {
                    isV = true;
                    break;
                }
            }
            numeros.add(l);
            if (!isV) {
                questaoProva.add(temp);
            } else {
                j--;
            }
            if (numeros.size() == questao.size()) {
                if (questaoProva.size() == qtdQuestoes) {
                    break;
                } else {
                    return false;
                }
            }
        }
        String[] prova = new String[i];
        i = 0;
        for (Questao temp : questaoProva) {
            prova[i++] = Integer.toString(i) + ") " + temp.imprimeQuestao(0);
        }
        
        
        /**
         * restante do codigo de gerar pdf
         */

        return true;
    }

    public void geraTXT(Assunto assunto, boolean tipo, String arquivo) throws IOException {

        FileWriter arq = new FileWriter(arquivo);
        try (PrintWriter gravarArq = new PrintWriter(arq)) {
            int j;
            if (tipo) {
                gravarArq.println("Questões do assunto " + assunto.getNome() + ", com as respostas.");
                gravarArq.println("");
                j = 1;
                for (Questao o : listaQuestoesAssunto(assunto)) {
                    gravarArq.println((j++) + ")" + o.getPergunta() + "\n");
                    gravarArq.println(o.imprimeAlternativa());
                    gravarArq.println(o.imprimeResposta());
                }
            } else {
                gravarArq.println("Questões do assunto " + assunto.getNome() + ", sem as respostas.");
                gravarArq.println("");
                j = 1;
                for (Questao o : listaQuestoesAssunto(assunto)) {
                    gravarArq.println((j++) + ")" + o.getPergunta() + "\n");
                    gravarArq.println(o.imprimeAlternativa());
                }
            }
        }
    }

    public void geraCSV() throws IOException {
        FileWriter arq = new FileWriter("teste.csv");
        try (PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.println("Assunto,Estado,Quantidade Máxima,Quantidade atual,Data");
            assuntos.forEach((Assunto o) -> {
                gravarArq.println(o.getNome() + "," + (o.getAtivo() ? "Ativo" : "Excluído") + "," + o.getQuantidade() + "," + o.getQuantidade() + "," + o.getData().toLocaleString());
            });
        }
    }
}
