/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import Logica.Questao;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import javax.swing.*;

/**
 *
 * @author raykson santos
 */
public class CadastroQuestao extends JPanel{

    private final JButton menu;

    private JComboBox<Assunto> boxAssunto;
    private final JComboBox<String> boxTipoQuestao;
    private final JButton botaoOK;
    private QuestaoAbertaGUI2 questaoAbertaGUI;
    private final JPanel painel;
    private QuestaoComMultiplaGUI2 questaoComMultiplaGUI;
    private final ArrayList<Assunto> assunto;
    private QuestaoSemMultiplaGUI questaoSemMultiplaGUI;
    ArrayList<Questao> questoes;
    CadastroQuestao(ArrayList<Assunto> assunto, ArrayList<Questao> questoes){
        this.assunto=assunto;
        painel=new JPanel();

        GroupLayout layout=new GroupLayout(painel);
        painel.setLayout(layout);
        JLabel labelCadastro = new JLabel("Cadastrar Questão");
        labelCadastro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelTipo = new JLabel("TIPO DE QUESTÃO ;");
        JLabel labelAssunto = new JLabel("ASSUNTO :");
        boxAssunto=new JComboBox<>(); 

        boxTipoQuestao=new JComboBox<>();
        boxTipoQuestao.addItem("");
        boxTipoQuestao.addItem("Questão Aberta");
        boxTipoQuestao.addItem("Questão Multipla Escolha com varias resposta");
        boxTipoQuestao.addItem("Questão Multipla Escolha com única resposta");
        boxTipoQuestao.addItem("Questão Verdadeiro ou Falso");
        botaoOK=new JButton("OK");
        menu=new JButton("MENU");
        questaoAbertaGUI=new QuestaoAbertaGUI2(questoes,menu);
        questaoComMultiplaGUI=new QuestaoComMultiplaGUI2(questoes,menu);
        questaoSemMultiplaGUI=new QuestaoSemMultiplaGUI(menu, questoes);
        this.add(questaoSemMultiplaGUI);
        
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelCadastro)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto)
                        .addGap(10)
                        .addComponent(boxAssunto)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelTipo)
                        .addGap(10)
                        .addComponent(boxTipoQuestao)
                        .addGap(10)

                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(botaoOK)
                )  
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelCadastro)
                .addGap(60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelAssunto)
                        .addComponent(boxAssunto)
                        
                )
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        
                        .addComponent(labelTipo)
                        .addComponent(boxTipoQuestao)
                )
                .addGap(100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(botaoOK)
                )  
        );

        menu.addActionListener((ActionEvent ae) -> {
            this.boxAssunto.setSelectedIndex(0);
            this.boxTipoQuestao.setSelectedIndex(0);
            CadastroQuestao.this.setVisible(false);
        });
        
        botaoOK.addActionListener((ActionEvent ae) -> {
            
            if(boxAssunto.getSelectedIndex()!=0&&boxTipoQuestao.getSelectedIndex()!=0){
                switch (boxTipoQuestao.getSelectedIndex()) {
                    case 1:
                        questaoAbertaGUI.initialize((Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 2:
                        questaoComMultiplaGUI.initialize((Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 3:
                        questaoSemMultiplaGUI.init((Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 4:
                        break;
                }
                atualizaAssuntoComboBox();
            this.boxAssunto.setSelectedIndex(0);
            this.boxTipoQuestao.setSelectedIndex(0);
            }
            
        });
    this.add(painel);
    this.setPreferredSize(new Dimension(610,500));
    }
/**
 * ADICIONA NO COMBO BOX SOMENTE OS ASSUNTOS CADASTRAVEIS,
 * ISTO É, AQUELES QUE NÃO ATINGIRAM A CAPACIDADE MAXIMA DE QUESTOES
 * OU ESTÃO EXCLUIDO.
 * FOI UTILIZADOS METODOS DA COLLECTIONS SORT VISANDO NOS APEGAR AO 
 * QUE A LINGUAGEM TEM A NOS DAR E ENXUGAR O CODIGO DESDE QUE ESTEJA COESO.
 * NESSE METODO ORDENAMOS OS ASSUNTOS COMO PRIORIDADE OS CADASTRAVEIS E DEPOIS COLOCAMOS SOMENTE OS CADASTRAVEIS 
 *  
 */
    private void atualizaAssuntoComboBox() {
    boxAssunto.removeAllItems();
        boxAssunto.addItem(new Assunto(""));
        Collections.sort(assunto, (Object t, Object t1) -> {
            if(((Assunto)t).getAtivo()){
                return 1;
            }
            return -1;
        });
        assunto.forEach((Assunto temp) -> {
            if (temp.getAtivo()) {
                boxAssunto.addItem(temp);
            }
    }); 
    }

    void inicia() {
        atualizaAssuntoComboBox();
        this.setVisible(true); 
    }
    
}


