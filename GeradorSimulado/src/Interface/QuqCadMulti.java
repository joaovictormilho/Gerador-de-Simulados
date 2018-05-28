package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class QuqCadMulti extends JPanel {

    private JLabel labelmu, labelassun, labelassuntos, labelperg, Marque, labelalt, Alt;
    private JEditorPane editorperg2;
    private JComboBox<String> boxalt;
    private JButton botaov2, ok, botaom2, botaocad2;
    private JScrollPane[] sc;
    private JEditorPane[] edt;
    private JPanel painelb;
    private JRadioButton[] rd;
    protected JPanel painelGrid;

    public QuqCadMulti(QuestaoQcadastro q) {

        setBounds(100, 50, 800, 650);
        setLayout(null);
        setBorder(new LineBorder(new Color(0, 0, 0), 2));
        setVisible(false);
        //Texto de Multipla Escolha
        labelmu = new JLabel("           Multipla escolha com Multipla resposta");
        labelmu.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelmu.setBounds(22, 30, 649, 47);
        add(labelmu);

        //Testo de assunto
        labelassun = new JLabel("Assunto:");
        labelassun.setBounds(99, 88, 59, 14);
        add(labelassun);
        //Texto do assunto 
        labelassuntos = new JLabel("Escravo\r\n");
        labelassuntos.setBounds(153, 88, 46, 14);
        add(labelassuntos);
        //Texto Pergunta
        labelperg = new JLabel("Pergunta:");
        labelperg.setBounds(99, 114, 59, 14);
        add(labelperg);
        //Captor de texto pergunta
        editorperg2 = new JEditorPane();
        editorperg2.setBounds(163, 113, 404, 121);
        add(editorperg2);
        editorperg2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        //Texto de alternativas
        labelalt = new JLabel("Quantidade de alternativas:");
        labelalt.setBounds(99, 251, 163, 14);
        add(labelalt);
        //Combobox para receber os numero
        boxalt = new JComboBox<String>();
        boxalt.setModel(new DefaultComboBoxModel<String>(new String[]{"0", "1", "2", "3", "4", "5", "6"}));
        boxalt.setBounds(260, 248, 37, 20);
        add(boxalt);

        painelb = new JPanel();
        painelb.setBounds(50, 280, 700, 330);
        painelb.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        add(painelb);

        //Marque
        Marque = new JLabel("Marque as alternativas verdadeiras");
        Marque.setBounds(470, 250, 210, 20);
        add(Marque);
        Marque.setVisible(false);

        ok = new JButton("OK");
        ok.setBounds(333, 250, 52, 20);
        add(ok);
        //Botao voltar
        botaov2 = new JButton("Voltar");
        botaov2.setBounds(69, 620, 89, 23);
        add(botaov2);
        //Botao Menu
        botaom2 = new JButton("Menu");
        botaom2.setBounds(310, 620, 89, 23);
        add(botaom2);
        //Botao cadastrar
        botaocad2 = new JButton("Cadastrar");
        botaocad2.setBounds(545, 620, 95, 26);
        add(botaocad2);
        painelb.setLayout(new GridLayout(2, 2));
        painelb.setVisible(true);
        edt = new JEditorPane[6];
        sc = new JScrollPane[6];
        rd = new JRadioButton[6];
        painelb.setVisible(false);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painelb.removeAll();
                int a = (int) boxalt.getSelectedIndex();
                for (int i = 0; i < a; i++) {
                    painelGrid = new JPanel();
                    painelGrid.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                    painelGrid.setLayout(new BoxLayout(painelGrid,BoxLayout.X_AXIS));
                    rd[i] = new JRadioButton();
                    sc[i] = new JScrollPane();
                    edt[i] = new JEditorPane();
                    rd[i].setBounds(5, 5, 100, 30);
                    sc[i].setBounds(20, 50, 180, 100);
                    sc[i].setViewportView(edt[i]);
                    painelGrid.add(sc[i]);
                    rd[i].setText("Alternativa " + i);
                    painelGrid.add(rd[i]);
                    painelb.add(painelGrid);

                }
                painelb.setVisible(true);
                Marque.setVisible(true);
            }
        });
        botaov2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                q.setVisible(true);
                apaga();
            }
        });
        botaom2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                APainelinterface.ativarmenu();
                q.setVisible(false);
                apaga();
            }
        });
        botaocad2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                q.setVisible(true);
                apaga();
            }
        });
    }

    void apaga() {
        setVisible(false);
        painelb.removeAll();
        painelb.setVisible(false);
        Marque.setVisible(false);
        editorperg2.setText("");
        boxalt.setSelectedIndex(0);
    }

}
