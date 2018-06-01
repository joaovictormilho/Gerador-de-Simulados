/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author raykson santos
 */
public class InformacoesAssunto extends JDialog {

    JPanel painel1 = new JPanel();
    JLabel quantidade = new JLabel();
    private final JLabel Data = new JLabel();
    private final JLabel atual = new JLabel();
    private final JLabel nome = new JLabel();
    private final JButton voltar = new JButton("VOLTAR");
    private JButton menu = new JButton("MENU");
    private final JButton excluir = new JButton("EXCLUIR");
    private final JButton editar = new JButton("EDITAR");
    Assunto assunto;
    private final JLabel Estado = new JLabel();
    JScrollPane b;
    private JPanel painel = new JPanel();

    InformacoesAssunto(JButton menu1, ArrayList<Assunto> assuntos) {
        this.setModal(true);
        EditarAssunto editorAssunto = new EditarAssunto(assuntos);
        editorAssunto.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {}

            @Override
            public void windowClosed(WindowEvent we) {
                InformacoesAssunto.this.init(assunto);
            }

            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}
        });
        JPanel painelSuper = new JPanel();
        painelSuper.add(painel, BorderLayout.CENTER);
        this.add(painelSuper);
        this.setMaximumSize(new Dimension(610, 510));
        this.setMinimumSize(new Dimension(610, 510));
        this.setPreferredSize(new Dimension(610, 510));
        this.setResizable(false);
        layoutJPanelInformacoes();
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel1.add(nome);
        painel1.add(quantidade);
        painel1.add(atual);
        painel1.add(Data);
        painel1.add(Estado);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {}

            @Override
            public void windowClosing(WindowEvent we) {
               acoesSair();
            }

            @Override
            public void windowClosed(WindowEvent we) {}

            @Override
            public void windowIconified(WindowEvent we) {}

            @Override
            public void windowDeiconified(WindowEvent we) {}

            @Override
            public void windowActivated(WindowEvent we) {}

            @Override
            public void windowDeactivated(WindowEvent we) {}
        });
        menu.addActionListener((ActionEvent ae) -> {
            acoesSair();
            menu1.doClick();
        });
        voltar.addActionListener((ActionEvent ae) -> {
            acoesSair();
        });
        excluir.addActionListener((ActionEvent ae) -> {
            if (assunto.getAtivo()) {
                assuntos.remove(assunto);
                init(assunto);
            }
        });
        editar.addActionListener((ActionEvent ae) -> {
            editorAssunto.init(assunto);
        });
    }
    private void acoesSair(){
        assunto=null;
        this.dispose();
    
    }

    private void layoutJPanelInformacoes() {
        JLabel titulo = new JLabel("DADOS DO ASSUNTO");
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
       this.setVisible(false);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(titulo)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(painel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(10)
                        .addComponent(voltar)
                        .addGap(10)
                        .addComponent(excluir)
                        .addGap(10)
                        .addComponent(editar)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(30)
                .addComponent(titulo)
                .addGap(10)
                .addComponent(painel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(voltar)
                        .addComponent(excluir)
                        .addComponent(editar)
                )
                .addGap(10)
        );
    }

    public void init(Assunto assunto){
        nome.setText("Nome: " + assunto.getNome());
        quantidade.setText("Quantidade: " + Integer.toString(assunto.getQuantidade()));
        atual.setText("Questões Cadastrada: " + Integer.toString(assunto.getQuantidade()));
        Data.setText("Data de Criação: " + assunto.getData().toString());
        Estado.setText("Estado: " + (assunto.getAtivo() ? "Ativo" : "Excluido"));
        if (this.assunto == null) {
            this.assunto = assunto;
            this.show();
        } else {
            System.out.println("sdkjl");
            excluir.setEnabled(true);
            editar.setEnabled(true);
            if (!this.assunto.getAtivo()) {
                excluir.setEnabled(false);
                editar.setEnabled(false);
            }
        }
    }
}
