package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class QuestaoBuscar extends JPanel {

    JToggleButton Pesquisa;
    JLabel labelpesq;
    JButton botasimbolo2, botaoko2, BotaoCancelar2;
    JTextField Caixadetexto;
    QuestaoBuscado b;

    QuestaoBuscar(APainelinterface d) {
        setBounds(108, 86, 493, 193);
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setVisible(false);
        Pesquisa = new JToggleButton("Pesquisa");
        Pesquisa.setFont(new Font("Tahoma", Font.BOLD, 15));
        Pesquisa.setBackground(Color.RED);
        Pesquisa.setForeground(Color.WHITE);
        Pesquisa.setBounds(0, 0, 493, 23);
        add(Pesquisa);
        JLabel labelpesq = new JLabel("Digite a pergunta da questa que deseja buscar:");
        labelpesq.setBounds(93, 66, 368, 23);
        add(labelpesq);
        JButton botasimbolo2 = new JButton("New button");
        botasimbolo2.setBounds(20, 59, 38, 36);
        add(botasimbolo2);
        JButton botaoko2 = new JButton("OK");
        botaoko2.setBounds(93, 164, 89, 23);
        add(botaoko2);
        JButton BotaoCancelar2 = new JButton("Menu");
        BotaoCancelar2.setBounds(347, 164, 89, 23);
        add(BotaoCancelar2);

        Caixadetexto = new JTextField();
        Caixadetexto.setBounds(96, 113, 340, 20);
        add(Caixadetexto);
        Caixadetexto.setColumns(10);
        b = new QuestaoBuscado(this);
        botaoko2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.adc(b);
                setVisible(false);
                b.setVisible(true);
                Caixadetexto.setText("");
            }
        });
        BotaoCancelar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                APainelinterface.ativarmenu();
                Caixadetexto.setText("");
            }
        });

    }
}
