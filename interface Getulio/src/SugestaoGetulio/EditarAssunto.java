/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditarAssunto extends JDialog {
    protected JTextArea textoAssunto = new JTextArea();
    private Assunto assunto;

    EditarAssunto(ArrayList<Assunto> assuntos){
        JLabel tituloPanel = new JLabel("EDITAR QUESTÃO");
        JLabel nomeAssunto = new JLabel("ASSUNTO");
        JLabel quantidadeQuestao = new JLabel("QUANTIDADE");
        this.setModal(true);
        JButton confirmar = new JButton("CONFIRMAR");
        tituloPanel.setFont(new Font("Arial", 0, 30));
//        painel.setMaximumSize(new Dimension(610, 510));
//        painel.setMinimumSize(new Dimension(610, 510));
//        painel.setPreferredSize(new Dimension(610, 510));
        this.setMaximumSize(new Dimension(400, 300));
        this.setMinimumSize(new Dimension(400, 300));

        textoAssunto.setWrapStyleWord(true);
        textoAssunto.setLineWrap(true);
        textoAssunto.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        JScrollPane scroll2 = new JScrollPane(textoAssunto);
        scroll2.setPreferredSize(new Dimension(300,50));
        JButton cancelar=new JButton("CANCELAR");
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {
                fecharJDialog();
            }
            
            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {}
        });
        cancelar.addActionListener((ActionEvent ae) -> {
            fecharJDialog();
        });

        confirmar.addActionListener( /*acaoConfirmar(textoAssunto.getText(),quantidadeQuestao.getText())*/ (ActionEvent ae) -> {
                if (assuntos.set(assuntos.indexOf(EditarAssunto.this.assunto), new Assunto(EditarAssunto.this.textoAssunto.getText())) == null) {
                    JOptionPane.showMessageDialog(null, "Assunto não alterado");
                } else {
                    fecharJDialog();
                }
        });
        JPanel painel2 = new JPanel();
        this.add(painel2,BorderLayout.CENTER);
        
        GroupLayout layout = new GroupLayout(painel2);
        painel2.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloPanel)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeAssunto)
                        .addGap(20)
                        .addComponent(scroll2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addGap(15)
                        .addComponent(confirmar))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20)
                        .addComponent(tituloPanel)
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(nomeAssunto,  GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scroll2 , GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(confirmar)
                                .addComponent(cancelar)
                        )
                        .addGap(10)
        );
    } 
    
    void init(Assunto assunto){
        textoAssunto.setText(assunto.toString());
        this.assunto=assunto;
        this.show();
    }
    
    private void fecharJDialog(){
            textoAssunto.setText("");
            this.dispose();
    } 
}