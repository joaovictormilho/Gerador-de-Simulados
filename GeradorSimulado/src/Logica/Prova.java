package Logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
            if (!this.contains(e) && !get(i).equals(e)) {
                if (get(i).getAtual() <= e.getQuantidade()) {
                    get(i).setAssunto(e.getNome(), e.getQuantidade());
                    return get(i);
                }
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
            if (!super.contains(e) && e.getAssunto().getAtivo()) {
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

    public List<Questao> listaQuestoes(String questao) {
        ArrayList<Questao> busca = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getPergunta().equals(questao))).forEachOrdered(busca::add);
        return busca;
    }

    public List<Questao> listaQuestoesAssunto(Assunto assunto) {
        ArrayList<Questao> porAssunto = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getAssunto().equals(assunto))).forEachOrdered(porAssunto::add);
        return porAssunto;
    }

    public String[] geraSimulado(Assunto assunto, int tipo) {
        String[] prova = new String[assunto.getAtual()];
        int i = 0;
        for (Questao temp : listaQuestoesAssunto(assunto)) {
            prova[i++] = Integer.toString(i) + ") " + temp.imprimeQuestao(tipo);
        }
        return prova;
    }

    public boolean geraProvaDoc(Assunto assunto, int qtdQuestoes) {
        if (assunto.getAtual() < qtdQuestoes) {
            return false;
        }
        int i = 0;
        boolean igual = false;
        ArrayList<Questao> questaoProva = new ArrayList<>();
        for (Questao o : listaQuestoesAssunto(assunto)) {
            if (listaQuestoes(o.getPergunta()).size() > 1) {
                for (Questao k : questaoProva) {
                    if (k.isEqualsPergunta(o)) {
                        igual = true;
                        break;
                    }
                }
                if (!igual) {
                    questaoProva.add(o);
                } else {
                    i--;
                }
            } else {
                questaoProva.add(o);
            }
            i++;
            if (i == qtdQuestoes) {
                break;
            }
        }
        if (i < qtdQuestoes) {
            return false;
        }
        String[] prova = new String[i];
        i = 0;
        for (Questao temp : listaQuestoesAssunto(assunto)) {
            prova[i++] = Integer.toString(i) + ") " + temp.imprimeQuestao(0);
        }
        return true;
    }

    public void geraTXT(Assunto assunto, boolean tipo, String arquivo) throws IOException {

        FileWriter arq = new FileWriter("teste.txt");
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
                gravarArq.println("Questões do assunto " + assunto.getNome() + ", com as respostas.");
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
                gravarArq.println(o.getNome() + "," + (o.getAtivo() ? "Ativo" : "Excluído") + "," + o.getQuantidade() + "," + o.getAtual() + "," + o.getData().toLocaleString());
            });
        }
    }
}
