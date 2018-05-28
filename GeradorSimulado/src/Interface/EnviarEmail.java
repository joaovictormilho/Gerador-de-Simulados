package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class EnviarEmail extends JPanel {

    private JTextField textmail;
    private JPanel painelemail;
    private JToggleButton Cadastrobot1;
    private JButton enviar, menu;
    private JLabel labelenv;

    EnviarEmail(APainelinterface a) {
        setLayout(null);
        setBounds(59, 86, 750, 500);
        setVisible(false);

        JPanel painelemail = new JPanel();
        painelemail.setBounds(59, 86, 542, 205);
        painelemail.setLayout(null);
        add(painelemail);
        setVisible(false);
        painelemail.setBorder(new LineBorder(new Color(0, 0, 0), 2));

        JToggleButton Cadastrobot1 = new JToggleButton("Enviar E-mail");
        Cadastrobot1.setFont(new Font("Tahoma", Font.BOLD, 15));
        Cadastrobot1.setBackground(Color.YELLOW);
        Cadastrobot1.setForeground(new Color(255, 255, 255));
        Cadastrobot1.setBounds(0, 0, 540, 23);
        painelemail.add(Cadastrobot1);

        JButton enviar = new JButton("Enviar");
        enviar.setBounds(427, 98, 89, 23);
        painelemail.add(enviar);

        JLabel labelenv = new JLabel("Envio via E-mail");
        labelenv.setHorizontalAlignment(SwingConstants.CENTER);
        labelenv.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelenv.setBounds(99, 34, 358, 45);
        painelemail.add(labelenv);

        JButton menu = new JButton("MENU");
        menu.setBounds(216, 132, 89, 23);
        painelemail.add(menu);

        textmail = new JTextField();
        textmail.setBounds(28, 98, 364, 21);
        painelemail.add(textmail);
        textmail.setColumns(10);

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                APainelinterface.ativarmenu();
                setVisible(false);
            }
        });
        enviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painelemail.setVisible(false);
                JPanel painel1 = new JPanel();
                painel1.setLayout(null);
                add(painel1);
                painel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                painel1.setBounds(0, 0, 500, 200);
                //(59, 86, 550, 295);
                JLabel prova = new JLabel("Enviado com Sucesso");
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
                        painelemail.setVisible(true);
                    }
                });
            }
        });
    }
}
