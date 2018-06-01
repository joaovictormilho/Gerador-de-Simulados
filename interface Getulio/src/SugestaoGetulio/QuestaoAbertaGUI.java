/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public final class QuestaoAbertaGUI extends JPanel {

    private final JButton cadastrar;
    private final JButton cancelar;
    private final JTextArea resposta;
    private final JTextArea pergunta;
    private final JScrollPane barraRolagemc;
    private final JScrollPane barraRolagem;
    private boolean i;
    private Assunto assunto;

    QuestaoAbertaGUI(JButton menu,ArrayList<Questao> questoes,Assunto assunto) {
        GroupLayout layout = new GroupLayout(this);
        this.setVisible(false);
        this.setPreferredSize(new Dimension(610,510));
        this.setLayout(layout);
        cadastrar = new JButton("CADASTRAR");
        menu = new JButton("MENU");
        cancelar = new JButton("CANCELAR");
        JLabel labelTipoQuestao = new JLabel("QUESTÃO ABERTA");
        labelTipoQuestao.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel labelPergunta = new JLabel("PERGUNTA");
        JLabel labelResposta = new JLabel("RESPOSTA");
        resposta = new JTextArea();
        resposta.setLineWrap(true);
        resposta.setWrapStyleWord(true);
        resposta.setPreferredSize(new Dimension(400, 75));
        barraRolagem = new JScrollPane(resposta);
        pergunta = new JTextArea();
        barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pergunta.setPreferredSize(new Dimension(400, 75));
        barraRolagemc = new JScrollPane(pergunta);
        barraRolagemc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTipoQuestao)
                .addGroup(layout.createSequentialGroup()
                        .addGap(67)
                        .addComponent(labelPergunta)
                        .addGap(10)
                        .addComponent(barraRolagemc)
                       .addGap(68)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(67)
                        .addComponent(labelResposta)
                        .addGap(10)
                        .addComponent(barraRolagem)
                        .addGap(68)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(this.menu)
                        .addGap(10)
                        .addComponent(cancelar)
                        .addGap(10)
                        .addComponent(cadastrar)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(32)
                .addComponent(labelTipoQuestao)
                .addGap(45)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelPergunta)
                        .addComponent(barraRolagemc)
                )
                .addGap(39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelResposta)
                        .addComponent(barraRolagem)
                )
                .addGap(90)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.menu)
                        .addComponent(cancelar)
                        .addComponent(cadastrar)
                )
                .addGap(38)
        );
        this.menu.addActionListener((ActionEvent ae) -> {
            cancelar.doClick();
            menu.doClick();
        });
        this.cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pergunta.setText("");
                resposta.setText("");
                QuestaoAbertaGUI.this.setVisible(false);
            }
        });
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!pergunta.getText().equals("") && !resposta.getText().equals("")) {
                    i = questoes.add(new QuestaoAberta(pergunta.getText(), resposta.getText(), assunto));
                    pergunta.setText("");
                    resposta.setText("");
                } else
                    i = false;
                if(!i){
                    JOptionPane.showMessageDialog(null,null,"Erro",JOptionPane.ERROR_MESSAGE);
                }
                if(!assunto.isCadastravel()){
                    cancelar.doClick();
                    JOptionPane.showMessageDialog(null,"Assunto no limite de questões\n Por favor exclua questões nesse assunto para continuar cadastrando");
                }
            }
        });
    }
    void init(Assunto assunto){
        this.setVisible(true);
        this.assunto=assunto;
    }
}
