/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import Logica.Questao;
import Logica.QuestaoAberta;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author raykson santos
 */
public class QuestaoAbertaGUI2 extends AbstractCadastroQuestoes{
    private  JTextArea t;
    private boolean i;
    public QuestaoAbertaGUI2(ArrayList<Questao> questao, JButton menu) {
        super(questao, menu);
    }
    @Override
    JPanel painelResposta() {
        t = new JTextArea();
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.setPreferredSize(new Dimension(400, 75));
        JScrollPane scroll = new JScrollPane(t);
        JPanel painel=new JPanel();
        painel.setLayout(new FlowLayout());
        painel.setPreferredSize(new Dimension(570, 200));
        painel.add(new JLabel("RESPOSTA"));
        painel.add(scroll);
        return painel;
    }

    @Override
    void newButtons(JPanel panel) {
        JButton cadastrar = new JButton("CADASTRAR");
        panel.add(cadastrar);
        cadastrar.addActionListener((ActionEvent ae) -> {
            if (!pergunta.getText().equals("") && !t.getText().equals("")) {
                if(!questoes.add(new QuestaoAberta(pergunta.getText(), t.getText(), assunto))){
                    JOptionPane.showMessageDialog(null,"Questao já cadastrada!");
                }
            } else{
                JOptionPane.showMessageDialog(null,"Digite os dados corretamente");
            }
        });
    }

    @Override
    JLabel titulo() {
       return new JLabel("CADASTRO QUESTÃO ABERTA"); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    void initialize(Assunto assunto) {
        this.assunto=assunto;
        this.show();
    }

    @Override
    void fecharJDiaolg() {
            this.dispose();
            pergunta.setText("");
            t.setText("");
    } 
}
