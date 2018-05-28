package Interface;

import Logica.Assunto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class QuestaoQcadastro extends JPanel {
    //private JPanel painelc;

    private JLabel labelcad, labelassunto, labeltipo;
    private JComboBox<String> boxassunto = new JComboBox<String>(), boxtipoq = new JComboBox<String>();
    private JButton ok, sair;
    private QuqCadAberta ca;
    private QuqCadMulti mm;
    private QuqCadMultiU mu;
    private QuqCadVF vf;
    private QuestaoLista lista;

    QuestaoQcadastro(APainelinterface a, ArrayList<Assunto> assunto) {
        //Painelcentral
        //painelc = new JPanel();
        setBounds(150, 50, 600, 250);
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        //painelcentral.add(painelc);
        setLayout(null);
        setVisible(false);
        //Fim

        //Texto Cadastrar Questao
        labelcad = new JLabel("Cadastrar Quest�o");
        labelcad.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelcad.setBounds(150, 20, 250, 40);
        add(labelcad);

        //Texto Assunto
        labelassunto = new JLabel("Assunto");
        labelassunto.setBounds(20, 70, 50, 40);
        add(labelassunto);
        //Texto tipo questao
        labeltipo = new JLabel("Tipo de Quest�o");
        labeltipo.setBounds(250, 70, 150, 40);
        //painelc.add(labeltipo);
        //Box do assunto
        //boxassunto ;
        boxassunto.setBounds(20, 100, 200, 20);
        add(boxassunto);
        adicionaAsssunto(assunto);
        //Box do tipo
        boxtipoq = new JComboBox<String>();
        boxtipoq.addItem("Aberta");
        boxtipoq.addItem("Multipla escolha com uma unica resposta");
        boxtipoq.addItem("Multipla escolha com varias respostas");
        boxtipoq.addItem("Verdadeiro ou falso");
        boxtipoq.setBounds(250, 100, 240, 20);
        add(boxtipoq);

        //Botao ok
        ok = new JButton(" OK");
        ok.setBounds(500, 100, 90, 20);
        add(ok);
        //botaook.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\ok.jpg"));
        //Botao sair
        sair = new JButton();
        sair.setBounds(250, 200, 90, 20);
        sair.setText(" Sair ");
        add(sair);
        ca = new QuqCadAberta(this);
        mm = new QuqCadMulti(this);
        mu = new QuqCadMultiU(this);
        vf = new QuqCadVF(this);

        //ok.addActionListener(new BotaoCadastro());
        sair.addActionListener((ActionEvent e) -> {
            APainelinterface.ativarmenu();
            setVisible(false);
        });

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String d = (String) boxtipoq.getSelectedItem();
                System.out.println(" " + d);
                if (d.equals("Aberta")) {
                    // APainelinterface.desativarmenu();
                    a.adc(ca);
                    ca.setVisible(true);
                    setVisible(false);
                } else if (d.equals("Multipla escolha com varias respostas")) {
                    //APainelinterface.desativarmenu();
                    a.adc(mm);
                    mm.setVisible(true);
                    setVisible(false);
                } else if (d.equals("Multipla escolha com uma unica resposta")) {
                    setVisible(false);
                    //APainelinterface.desativarmenu();
                    a.adc(mu);
                    mu.setVisible(true);

                } else {

                    // APainelinterface.desativarmenu();
                    setVisible(false);
                    a.adc(vf);
                    vf.setVisible(true);
                }
            }
        });

    }

    private void adicionaAsssunto(ArrayList<Assunto> assunto) {
        for (Assunto o : assunto) {
            boxassunto.addItem(o.getNome());
        }
    }

}
