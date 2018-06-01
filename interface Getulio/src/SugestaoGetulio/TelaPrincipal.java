/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import Logica.Prova;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TelaPrincipal extends JFrame {

    private final JMenuBar menuBar;
    private final JMenu questao,
            assunto,
            gerarDoc,
            configuracoes,
            enviarEmail;
    private final JMenuItem listarQuestoes,
            cadastrarQuestoes,
            listarQuestoesAssunto,
            buscarQuestoes,
            listarAssunto,
            cadastrarAssunto,
            gerarProvaPdf,
            gerarTXT,
            modificarLocal,
            salvar,
            gerarPlanilha;
    private CadastroQuestao cadastroQuestao; 
    private ListaAssunto listaAssunto;
   // private final CardLayout layout;
    private final JPanel painelPrincipal;
    private CadastroAssunto cadastroAssunto;
    public TelaPrincipal(Prova prova){
        //layout=new CardLayout();
        painelPrincipal=new JPanel();
        //setLayout(layout);
        this.add(painelPrincipal);
        menuBar = new JMenuBar();
        questao = new JMenu("Questão");
        assunto = new JMenu("Assunto");
        gerarDoc = new JMenu("Gerar Documento");
        configuracoes = new JMenu("Configurações");
        
        questao.add(cadastrarQuestoes = new JMenuItem("Cadastrar Questão"));
        questao.add(listarQuestoes = new JMenuItem("Listar Questão"));
        questao.add(listarQuestoesAssunto = new JMenuItem("Listar questões por assunto"));
        questao.add(buscarQuestoes = new JMenuItem("Buscar Questão"));
        buscarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));

        assunto.add(cadastrarAssunto = new JMenuItem("Cadastrar Assunto"));
        assunto.add(listarAssunto = new JMenuItem("Listar Assunto"));

        gerarDoc.add(gerarPlanilha = new JMenuItem("Gerar planilha (.csv)"));
        gerarDoc.add(gerarProvaPdf = new JMenuItem("Gerar prova (.pdf)"));
        gerarDoc.add(gerarTXT = new JMenuItem(("Exportar questoes (.txt)")));

        configuracoes.add(salvar = new JMenuItem("Salvar"));
        configuracoes.add(modificarLocal = new JMenuItem("Configurar diretorios"));
        
        //Adiciona os menus á barra de menu 
        menuBar.setBackground(Color.white);
        menuBar.add(questao);
        menuBar.add(assunto);
        menuBar.add(gerarDoc);
        menuBar.add(enviarEmail = new JMenu("Enviar email"));
        menuBar.add(configuracoes);

        //ALTERA A FONTE DE CADA MENU
        questao.setFont(new Font("Arial", Font.PLAIN, 12));
        assunto.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarDoc.setFont(new Font("Arial", Font.PLAIN, 12));
        configuracoes.setFont(new Font("Arial", Font.PLAIN, 12));
        enviarEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        
        //ALTERA A FONTE DE CADA MENUITEM DE QUESTAO
        listarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));
        cadastrarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));
        listarQuestoesAssunto.setFont(new Font("Arial", Font.PLAIN, 12));
        buscarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));
        
        //ALTERA A FONTE DE CADA MENUITEM DE ASSUNTO
        listarAssunto.setFont(new Font("Arial", Font.PLAIN, 12));
        cadastrarAssunto.setFont(new Font("Arial", Font.PLAIN, 12));
       
        //ALTERA A FONTE DE CADA MENUITEM DE GERAR DOCUMENTO
        gerarProvaPdf.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarTXT.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarPlanilha.setFont(new Font("Arial", Font.PLAIN, 12));
        
        //ALTERA A FONTE DE CADA MENUITEM DE CONFIGURAÇÕES
        modificarLocal.setFont(new Font("Arial", Font.PLAIN, 12));
        salvar.setFont(new Font("Arial", Font.PLAIN, 12));
        
        initialize(prova);
        menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cadastrarQuestoes.addActionListener((ActionEvent ae) -> {
            cadastroQuestao.inicia();
        });
       listarAssunto.addActionListener((ActionEvent ae) -> {
           listaAssunto.inicia();
       });
        cadastrarAssunto.addActionListener((ActionEvent ae) -> {
            cadastroAssunto.inicia();
        } );
        this.setMinimumSize(new Dimension(610, 510));
        this.setPreferredSize(new Dimension(610, 510));
        this.setJMenuBar(menuBar);
    }
    public static void main(String[] argv){
        Prova prova=new Prova();
        prova.getAssuntos().add(new Assunto("dskj"));
        TelaPrincipal telaPrincipal = new TelaPrincipal(prova);
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaPrincipal.setVisible(true);
        telaPrincipal.pack();
    }

    private void initialize(Prova prova) {
        (cadastroQuestao=new CadastroQuestao(prova.getAssuntos(),prova.getQuestoes())).setVisible(false);
        (listaAssunto=new ListaAssunto(prova.getAssuntos())).setVisible(false);    
        (cadastroAssunto=new CadastroAssunto(prova.getAssuntos())).setVisible(false);
        this.painelPrincipal.add(cadastroQuestao);
        this.painelPrincipal.add(listaAssunto);
        this.painelPrincipal.add(cadastroAssunto);
    }


}
