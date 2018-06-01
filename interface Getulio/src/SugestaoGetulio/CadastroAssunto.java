/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author raykson santos
 */
public class CadastroAssunto extends JPanel {

    private final JPanel painel=new JPanel();
    private final JTextArea nomeAssunto;
    private final JButton botaoCadastrar;
    private final JButton menu;
    private final JTextArea quantidadeAssunto;
    public CadastroAssunto(ArrayList<Assunto> assuntos){
        GroupLayout layout=new GroupLayout(painel);
        painel.setLayout(layout);
        JLabel labelCadastro = new JLabel("CADASTRAR ASSUNTO");
        labelCadastro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelQuantidade = new JLabel("QUANTIDADE DE QUESTÃO :");
        JLabel labelAssunto = new JLabel("ASSUNTO :");
        nomeAssunto = new JTextArea();
        nomeAssunto.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        nomeAssunto.setLineWrap(true);
        nomeAssunto.setWrapStyleWord(true);
        nomeAssunto.setPreferredSize(new Dimension(200, 20));
        quantidadeAssunto = new JTextArea();
        quantidadeAssunto.setLineWrap(true);
        quantidadeAssunto.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        quantidadeAssunto.setWrapStyleWord(true);
        quantidadeAssunto.setPreferredSize(new Dimension(60, 20));
        botaoCadastrar=new JButton("Cadastrar");
        menu=new JButton("MENU");
                
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelCadastro)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto)
                        .addGap(10)
                        .addComponent(nomeAssunto)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelQuantidade)
                        .addGap(50)
                        .addComponent(quantidadeAssunto)
                        .addGap(10)

                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(botaoCadastrar)
                )  
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelCadastro)
                .addGap(60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelAssunto)
                        .addComponent(nomeAssunto))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        
                        .addComponent(labelQuantidade)
                        .addComponent(quantidadeAssunto)
                )
                .addGap(100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(botaoCadastrar)
                )
                .addGap(10)
        );
        botaoCadastrar.addActionListener((ActionEvent ae) -> {
            try{
                if(!quantidadeAssunto.getText().equals("")&&!nomeAssunto.getText().equals("")){
                    if(!assuntos.add(new Assunto(nomeAssunto.getText()))){
                        JOptionPane.showMessageDialog(null, "Assunto já esta cadastrado\n Tente novamente");
                    }else{
                        quantidadeAssunto.setText("");
                    }   nomeAssunto.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
                }
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Quantidade Invalida\n Tente novamente");
            }
        });
        menu.addActionListener((ActionEvent ae) -> {
            this.setVisible(false);
        });
        this.add(painel);
    }
    void inicia() {
        this.setVisible(true);
    }
}
