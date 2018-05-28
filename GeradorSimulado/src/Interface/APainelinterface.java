package Interface;

import Logica.Prova;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class APainelinterface extends JFrame {

    protected static JPanel painelcentral;
    private JMenuBar menuprincipal;
    private static JMenu menu1;
    private static JMenu menu2;
    private static JMenu menu3;
    private static JMenu menu4;
    private final JMenuItem iten1, iten2, iten3, iten4, iten5, iten6, iten7, iten8, iten9, iten10;
    private QuestaoQcadastro q;
    private QuestaoLista a;
    private QuestaoAssunto g;
    private QuestaoBuscar b;
    private AssCad x;
    private AssLista y;
    private Gerarprova z;
    private GerarTxT w;
    private EnviarEmail u;
    Prova prova = new Prova();

    APainelinterface() {
        super("Projeto  de POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setIcone();
        //setResizable(false);
        //Painel Central
        setBackground(new Color(100, 50, 100));
        //this.setOpacity(0.5f);
        setBounds(10, 10, 1200, 750);
        painelcentral = new JPanel();
        //Configura o painel como opaco
        painelcentral.setOpaque(false);
        add(painelcentral, BorderLayout.CENTER);
        painelcentral.setLayout(new BorderLayout());
        //pack();
        //Fim

        //JMenuBar
        MenuBar n = new MenuBar();
        Menu kl = new Menu();
        Menu jk = new Menu();
        Menu hj = new Menu();
        n.add(kl);
        n.add(jk);
        n.add(hj);
        //kl.
        //kl.setEnabled(true);
        menuprincipal = new JMenuBar();
        menuprincipal.setBounds(0, 2, 1600, 30);
        menuprincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //painelcentral.add(menuprincipal);
        super.setJMenuBar(menuprincipal);
        //super.set;

        //Fim
        //JMenu
        menu1 = new JMenu("Questões");
        menuprincipal.add(menu1);

        menu2 = new JMenu("Assuntos");
        menuprincipal.add(menu2);

        menu3 = new JMenu("Gerar Prova");
        menuprincipal.add(menu3);

        menu4 = new JMenu("Enviar e-mail");
        menuprincipal.add(menu4);
        //Fim

        //Adicionando os itens
        iten1 = new JMenuItem("Cadastrar");
        //iten1.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\mais2.png"));
        menu1.add(iten1);
        iten2 = new JMenuItem("Listar");
        //iten2.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\lista1.png"));
        menu1.add(iten2);
        iten3 = new JMenuItem("Listar Questoes de um assunto");
        //iten3.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\lista3.png"));
        menu1.add(iten3);
        iten4 = new JMenuItem("Buscar");
        //iten4.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\pesquisa2.png"));
        menu1.add(iten4);
        iten5 = new JMenuItem("Cadastrar");
        menu2.add(iten5);
        //iten5.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\mais2.png"));
        iten6 = new JMenuItem("Listar");
        //iten6.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\lista1.png"));
        menu2.add(iten6);
        iten7 = new JMenuItem("Gerar Formulario");
        //iten7.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\prova1.png"));
        menu3.add(iten7);
        iten8 = new JMenuItem("Gerar Prova");
        //iten8.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\formulario.png"));
        menu3.add(iten8);
        iten9 = new JMenuItem("Gerar TxT");
        //iten9.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\txt.png"));
        menu3.add(iten9);
        iten10 = new JMenuItem("Enviar via e-mail");
        //iten10.setIcon(new ImageIcon("C:\\\\Users\\\\Usuario\\\\Desktop\\\\INTEFACE GRAFICA\\\\bin\\\\interface1\\\\pesq.png"));
        menu4.add(iten10);
        //q = new QuestaoQcadastro(this,prova.getAssuntos().listaAssunto());
        APainelinterface h = this;

        ActionListener Cad = (ActionEvent e) -> {
            desativarmenu();
            String c = e.getActionCommand();
            switch (c) {
                case "Cadastrar":
                    q = new QuestaoQcadastro(h, prova.getAssuntos());
                    menuprincipal.setNextFocusableComponent(q);
                    painelcentral.add(q);
                    q.setVisible(true);
                    break;
                case "Listar Questoes de um assunto":
                    g = new QuestaoAssunto(h);
                    painelcentral.add(g);
                    g.setVisible(true);
                    break;
                case "Listar":
                    a = new QuestaoLista(h);
                    painelcentral.add(a);
                    a.setVisible(true);
                    break;
                default:
                    b = new QuestaoBuscar(h);
                    painelcentral.add(b);
                    b.setVisible(true);
                    break;
            }
        };
        ActionListener Cad2 = (ActionEvent e) -> {
            desativarmenu();
            String c = e.getActionCommand();
            if (c.equals("Cadastrar")) {
                x = new AssCad(h, prova.getAssuntos());
                painelcentral.add(x);
                x.setVisible(true);
            } else{
                y = new AssLista(h);
                painelcentral.add(y);
                y.setVisible(true);
            }
        };
        ActionListener Cad3= (ActionEvent e) -> {
            desativarmenu();
            String c = e.getActionCommand();
            switch (c) {
                case "Gerar Prova":
                    z = new Gerarprova(h);
                    painelcentral.add(z);
                    z.setVisible(true);
                    break;
                case "Gerar TxT":
                    w = new GerarTxT(h);
                    painelcentral.add(w);
                    w.setVisible(true);
                    break;
                case "Gerar Formulario":
                    JPanel painel1 = new JPanel();
                    painel1.setLayout(null);
                    add(painel1);
                    painel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                    painel1.setBounds(50, 50, 550, 200);
                    //(59, 86, 550, 295);
                    JLabel prova1 = new JLabel("FORMULARIO CRIADO COM SUCESSO");
                    prova1.setFont(new Font("Arial", Font.PLAIN, 25));
                    prova1.setBounds(42, 11, 500, 73);
                    painel1.add(prova1);
                    JLabel inserir = new JLabel("INSERIR IMAGEM AKI");
                    inserir.setBounds(154, 55, 217, 79);
                    painel1.add(inserir);
                    JButton okk = new JButton("OK");
                    okk.setBounds(232, 139, 89, 23);
                    painel1.add(okk);
                    okk.addActionListener((ActionEvent e1) -> {
                        painel1.setVisible(false);
                        ativarmenu();
            }); break;
                default:
                    u = new EnviarEmail(h);
                    painelcentral.add(u);
                    u.setVisible(true);
                    break;
            }
        };
        iten1.addActionListener(Cad);
        iten2.addActionListener(Cad);
        iten3.addActionListener(Cad);
        iten4.addActionListener(Cad);
        iten5.addActionListener(Cad2);
        iten6.addActionListener(Cad2);
        iten7.addActionListener(Cad3);
        iten8.addActionListener(Cad3);
        iten9.addActionListener(Cad3);
        iten10.addActionListener(Cad3);

    }

    static void desativarmenu() {
        menu1.enable(false);
        menu2.enable(false);
        menu3.enable(false);
        menu4.enable(false);
    }

    static void ativarmenu() {
        menu1.enable(true);
        menu2.enable(true);
        menu3.enable(true);
        menu4.enable(true);
    }

    void adc(QuqCadAberta c) {
        painelcentral.add(c);
    }

    void adc(QuqCadMulti d) {
        painelcentral.add(d);
    }

    void adc(QuqCadMultiU e) {
        painelcentral.add(e);
    }

    void adc(QuqCadVF f) {
        painelcentral.add(f);
    }

    void adc(QuestaoAssunto2 g) {
        painelcentral.add(g);
    }

    void adc(QuestaoBuscado h) {
        painelcentral.add(h);
    }
}
