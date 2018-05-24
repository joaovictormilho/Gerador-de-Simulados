package Interface2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class QuqCadAberta extends JPanel {
	JLabel labelqa,labelpeg,labelresp,labelassu,labelassunt;
	JEditorPane editorperg,editorresp;
	JButton botaov,botaom,ok ;
	QuqCadAberta(QuestaoQcadastro q){

		//Painel de pergunta aberta
		setLayout(null);
		setBounds(150, 50, 500, 350);
		setBorder(new LineBorder(new Color(0,0,0),2));
		setVisible(false);
		//Texto da pergunta
		labelqa = new JLabel("Questão Aberta");
		labelqa.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelqa.setBounds(150, 20, 250, 40);
		add(labelqa);
		//Pergunta
		labelpeg = new JLabel("Pergunta:");
		labelpeg.setBounds(20,70,80,40);
		add(labelpeg);
		//Caixa da pergunta
		editorperg = new JEditorPane();
		editorperg.setBounds(110,70,320,90);
		add(editorperg);
		editorperg.setBorder(new LineBorder(new Color(0,0,0),2));
		//Resposta
		labelresp = new JLabel("Resposta:");
		labelresp.setBounds(20,180,80,40);
		add(labelresp);
		//Caixa da resposta
		editorresp = new JEditorPane();
		editorresp.setBounds(110,195,320,90);
		add(editorresp);
		editorresp.setBorder(new LineBorder(new Color(0,0,0),2));
		//Assunto
		labelassu = new JLabel("Assunto: ");
		labelassu.setBounds(20,160,80,40);
		add(labelassu);
		//Resposta do assunto
		labelassunt = new JLabel("Escravo");
		labelassunt.setBounds(75,160,80,40);
		add(labelassunt);
		//Botao voltar
		botaov = new JButton("Voltar");
		botaov.setBounds(170,320,90,20);
		add(botaov);

		//Botao Menu
		botaom = new JButton("Menu");
		botaom.setBounds(270,320,90,20);
		add(botaom);

		//Botao OK
		ok = new JButton(" OK");
		ok.setBounds(370,320,90,20);
		add(ok);

		//Fim
		botaov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	 setVisible(false);
	        	 q.setVisible(true);
	        	 editorperg.setText("");
	        	 editorresp.setText("");				
			}
		});
		botaom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APainelinterface.ativarmenu();
				q.setVisible(false);
	        	 setVisible(false);
	        	 editorperg.setText("");
	        	 editorresp.setText("");				
			}
		});
		
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				 q.setVisible(true);
				 setVisible(false);
	        	 editorperg.setText("");
	        	 editorresp.setText("");
			}
		});
		
	}
	
	}
	