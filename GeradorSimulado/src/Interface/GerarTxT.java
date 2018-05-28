package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GerarTxT extends JPanel {

    JPanel painelgerartxt;
    JToggleButton Cadastrobot1;
    JButton botaogerar5, menu;
    JLabel labelgerartxt;
    JComboBox boxassunto11, boxquestcs;

    GerarTxT(APainelinterface a) {
        setLayout(null);
        setBounds(59, 86, 750, 500);
        setVisible(false);

        painelgerartxt = new JPanel();
        painelgerartxt.setBounds(0, 0, 542, 205);
        painelgerartxt.setLayout(null);
        add(painelgerartxt);
        painelgerartxt.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        Cadastrobot1 = new JToggleButton("Gerar Txt");
        Cadastrobot1.setFont(new Font("Tahoma", Font.BOLD, 15));
        Cadastrobot1.setBackground(Color.YELLOW);
        Cadastrobot1.setForeground(new Color(255, 255, 255));
        Cadastrobot1.setBounds(0, 0, 542, 23);
        painelgerartxt.add(Cadastrobot1);

        botaogerar5 = new JButton("Gerar");
        botaogerar5.setBounds(427, 98, 89, 23);
        painelgerartxt.add(botaogerar5);

        labelgerartxt = new JLabel("Gerar TxT");
        labelgerartxt.setHorizontalAlignment(SwingConstants.CENTER);
        labelgerartxt.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelgerartxt.setBounds(99, 34, 358, 45);
        painelgerartxt.add(labelgerartxt);

        boxassunto11 = new JComboBox();
        boxassunto11.setBounds(42, 98, 177, 22);
        painelgerartxt.add(boxassunto11);

        boxquestcs = new JComboBox();
        boxquestcs.setModel(new DefaultComboBoxModel(new String[]{"Questoes com resposta", "Questoes sem resposta"}));
        boxquestcs.setBounds(244, 98, 169, 22);
        painelgerartxt.add(boxquestcs);

        menu = new JButton("MENU");
        menu.setBounds(40, 150, 89, 23);
        painelgerartxt.add(menu);
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                APainelinterface.ativarmenu();
                setVisible(false);
            }
        });
        botaogerar5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painelgerartxt.setVisible(false);
                JPanel painel1 = new JPanel();
                painel1.setLayout(null);
                add(painel1);
                painel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                painel1.setBounds(0, 0, 500, 200);
                //(59, 86, 550, 295);
                JLabel prova = new JLabel("PROVA CRIADA COM SUCESSO");
                prova.setFont(new Font("Arial", Font.PLAIN, 30));
                prova.setBounds(42, 11, 482, 73);
                painel1.add(prova);
                JLabel inserir = new JLabel("INSERIR IMAGEM AKI");
                inserir.setBounds(154, 55, 217, 79);
                painel1.add(inserir);
                JButton okk = new JButton("OK");
                okk.setBounds(232, 139, 89, 23);
                painel1.add(okk);
                okk.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        painel1.setVisible(false);
                        painelgerartxt.setVisible(true);
                    }
                });
            }
        });
    }
}
