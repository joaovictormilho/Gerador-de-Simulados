/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class ListaAssunto extends JPanel {

    JTable tabela;
    private final JButton menu = new JButton("MENU");
    InformacoesAssunto info;
    private ModeloTabela modelo;
    private final JPanel painel=new JPanel();
    protected CardLayout layout2;

    public ListaAssunto(ArrayList<Assunto> assuntos){
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        this.add(painel,BorderLayout.CENTER);
        info=new InformacoesAssunto(menu,assuntos);

        this.setPreferredSize(new Dimension(610, 500));
        JLabel cabecalho = new JLabel("Lista Assunto", JLabel.CENTER);
        cabecalho.setFont(new Font("Arial", Font.BOLD, 28));
        tabela = new JTable();
        tabela.setToolTipText("fdioujdfi");
        modelo=new ModeloTabela(assuntos);
        tabela.setModel(modelo);
        tabela.getTableHeader().setBackground(Color.yellow);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.setDragEnabled(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane b = new JScrollPane(tabela);
        b.setPreferredSize(new Dimension(610, 395));
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(cabecalho)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(b)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(menu)
                        .addGap(10)
                )
                
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addComponent(cabecalho)
                .addGap(10)
                .addComponent(b)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                )
                .addGap(10)
        );
        //MUDAR COR DO HEADER DA TABELA
        tabela.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                info.init(assuntos.get(tabela.getSelectedRow()));
                ListaAssunto.this.modelo.fireTableDataChanged();
            }
            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        });
        this.menu.addActionListener((ActionEvent ae) -> {ListaAssunto.this.setVisible(false); });
    }

    public static void main(String[] argvs) {
        JFrame o=new JFrame("dsds");
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<Assunto>a=new ArrayList<>();
        a.add(new Assunto(""));
        a.add(new Assunto("fserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
                a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
                a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        a.add(new Assunto("dfsasfoikçjmokijmlokijsdfferfserfresgtresgdrg"));
        ListaAssunto l=new ListaAssunto(a);
        o.add(l);
        o.setVisible(true);
        o.pack();
    }
    
    void inicia() {
        modelo.fireTableDataChanged();
        this.setVisible(true);
    }
     
}


