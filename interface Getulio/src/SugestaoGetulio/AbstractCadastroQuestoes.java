/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import Logica.Questao;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author raykson santos
 */
public abstract class AbstractCadastroQuestoes extends JDialog{
    protected final JTextArea pergunta=new JTextArea();
    protected final JScrollPane barraRolagem;
    protected final JButton cancelar=new JButton("CANCELAR");
    Assunto assunto;
            JLabel labelAssunto=new JLabel("");
    protected ArrayList<Questao> questoes;
    AbstractCadastroQuestoes(ArrayList<Questao>questao, JButton menu){
        this.questoes=questao;
        this.setResizable(false);
        this.setModal(true);
        JPanel resposta=painelResposta();
        JPanel opcoes=new JPanel();
        JLabel labelTipoQuestao = titulo();
        labelTipoQuestao.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel labelPergunta = new JLabel("PERGUNTA");
        pergunta.setWrapStyleWord(true);
        pergunta.setLineWrap(true);
        barraRolagem = new JScrollPane(pergunta);
        barraRolagem.setPreferredSize(new Dimension(400, 50));
        opcoes.setLayout(new FlowLayout());
        JButton menu1=new JButton("MENU");
        opcoes.setPreferredSize(new Dimension(570, 50));
        opcoes.add(menu1);
        opcoes.add(cancelar);
        newButtons(opcoes);
        JPanel painel=new JPanel();
        this.add(painel,BorderLayout.CENTER);
        GroupLayout layout=new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTipoQuestao)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPergunta)
                        .addGap(10)
                        .addComponent(barraRolagem,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(labelAssunto)
                .addComponent(resposta,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(opcoes,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(labelTipoQuestao)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelPergunta)
                        .addComponent(barraRolagem,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                    .addComponent(labelAssunto)
                .addGap(10)
                .addComponent(resposta,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(opcoes,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
        );
        menu1.addActionListener((ActionEvent ae) -> {
            fecharJDiaolg();
            menu.doClick();
        });
        cancelar.addActionListener((ActionEvent ae) -> {
            fecharJDiaolg(); 
        });
        
    }
    abstract JPanel painelResposta();
    abstract void newButtons(JPanel panel);
    abstract JLabel titulo();
    abstract void initialize(Assunto assunto);
    abstract void fecharJDiaolg();
}
