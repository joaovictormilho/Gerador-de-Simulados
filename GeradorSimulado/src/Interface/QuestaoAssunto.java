package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class QuestaoAssunto extends JPanel {

    private JToggleButton Assuntos;
    private JLabel labelesc;
    private JButton botasimbolo;
    private JComboBox BoxAsstt;
    private JButton BotaoCancelar, botaok;
    private QuestaoAssunto2 b;

    QuestaoAssunto(APainelinterface a) {

        setBounds(107, 82, 493, 193);
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setVisible(false);
        b = new QuestaoAssunto2(this);

        Assuntos = new JToggleButton("Assuntos");
        Assuntos.setFont(new Font("Tahoma", Font.BOLD, 15));
        Assuntos.setBackground(Color.DARK_GRAY);
        Assuntos.setForeground(Color.WHITE);
        Assuntos.setBounds(0, 0, 493, 23);
        add(Assuntos);

        labelesc = new JLabel("Escolha o Assunto:");
        labelesc.setBounds(93, 66, 127, 23);
        add(labelesc);

        botasimbolo = new JButton("New button");
        botasimbolo.setBounds(45, 66, 38, 36);
        add(botasimbolo);

        BoxAsstt = new JComboBox();
        BoxAsstt.setBounds(93, 88, 275, 22);
        add(BoxAsstt);

        botaok = new JButton("OK");
        botaok.setBounds(93, 150, 89, 23);
        add(botaok);

        BotaoCancelar = new JButton("Menu");
        BotaoCancelar.setBounds(289, 150, 89, 23);
        add(BotaoCancelar);

        botaok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                a.adc(b);
                b.setVisible(true);
                setVisible(false);
            }

        });
        BotaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                APainelinterface.ativarmenu();
            }
        });

    }
}
