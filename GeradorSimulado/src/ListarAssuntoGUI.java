


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import javafx.scene.layout.Border;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ListarAssuntoGUI extends JPanel {
    ArrayList<Assunto> lista;
    JTable tabela;
    final String []cabecalho={"NOME","QUANTIDADE","DATA DE CADASTRO","ESTADO"};
    private final JLabel labelAssunto;
    public ListarAssuntoGUI(JButton voltar,ManipulaAssunto assuntos){
        setLayout(new BorderLayout());
        this.setSize(new Dimension(800,600));
        labelAssunto=new JLabel("LISTAR ASSUNTO");
        labelAssunto.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelAssunto, BorderLayout.NORTH);
        //layout.setAlignment(1);
        labelAssunto.setHorizontalAlignment(JLabel.CENTER);
        ArrayList<Assunto> lista=assuntos.listaAssunto();
        ordenaAssunto(new Comparator() {
            @Override
            public int compare(Object t, Object t1) {
                return 1;
            }
        },assuntos.listaAssunto());
        JScrollPane sp=new JScrollPane(tabela);    
        //add(sp);
        //J/Frame l=new JFrame ();
        //l.setDefaultCloseOperation(WIDTH);
        //tabela.setLayout(new BoxLayout (tabela, BoxLayout.Y_AXIS));
        //tabela.setAutoCreateRowSorter(false);
        tabela.setRowSelectionAllowed(false);
        tabela.setMinimumSize(new Dimension(500,100));
        tabela.setMaximumSize(new Dimension(1000,200));
        //tabela.setPreferredScrollableViewportSize(new Dimension(400,100));
        //boxN.add(sp);
        //sp.setBounds(new Rectangle());
        add(sp, BorderLayout.CENTER);
        //add(p2,BorderLayout.CENTER);
    }
    private void atualizaTabela(){
        tabela.removeRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());
    }
    private void ordenaAssunto(Comparator comparar, ArrayList<Assunto> listaAssunto){
        Collections.sort(listaAssunto, comparar);
        String [][]a=new String[listaAssunto.size()][4];
        for(int i=0;i<listaAssunto.size();i++){
                a[i][0]=listaAssunto.get(i).getNome();
                a[i][1]=listaAssunto.get(i).getAtivo()?"ATIVO":"EXCLUIDO";
                a[i][2]=Integer.toString(listaAssunto.get(i).getQuantidade());
                a[i][3]=listaAssunto.get(i).getData().toLocaleString();
        }
        tabela=new JTable(a,cabecalho){
              @Override
              public boolean isCellEditable(int row, int col) 
              { 
                     return false; 
              }
        
        };
        //System.out.println(tabela.getse);


        //tabela.setVisible(true);
    }
    /*Comparator comparar, */
    }
