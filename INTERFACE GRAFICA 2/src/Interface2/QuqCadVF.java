package Interface2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class QuqCadVF extends JPanel {
		private JLabel vf,labelass,labelasss,labelperg3;
		private JEditorPane editorperg3;
		private JButton botaov, botaom, ok;
		private JRadioButton M6,M5;
		private ButtonGroup bg;
	QuqCadVF(QuestaoQcadastro q) {
		setBounds(80, 80, 637, 315);
		setLayout(null);
		setBorder(new LineBorder(new Color(0,0,0),2));
		setVisible(false);
		//Texto do verdadeiro ou falso
		vf = new JLabel("Questão Verdadeiro ou Falso");
		vf.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		vf.setBounds(165, 30, 350, 47);
		add(vf);
		//Texto do assunto
		labelass = new JLabel("Assunto:");
		labelass.setBounds(57, 88, 59, 14);
		add(labelass);
		//Texto do assunto
		labelasss = new JLabel("Escravo");
		labelasss.setBounds(113, 88, 46, 14);
		add(labelasss);
		//Texto da pergunta
		labelperg3 = new JLabel("Pergunta:");
		labelperg3.setBounds(57, 113, 59, 14);
		add(labelperg3);
		//Tela para edição
		editorperg3 = new JEditorPane();
		editorperg3.setBounds(123, 113, 404, 121);
		add(editorperg3);
		editorperg3.setBorder(new LineBorder(new Color(0,0,0),2));
		//Botao Voltar
		botaov = new JButton("Voltar");
		botaov.setBounds(288, 260, 89, 23);
		add(botaov);
		//Botao Menu
		botaom = new JButton("Menu");
		botaom.setBounds(401, 260, 89, 23);
		add(botaom);
		//Botao Ok
		ok = new JButton("OK");
		ok.setBounds(519, 260, 89, 23);
		add(ok);
		//Falso
		M6 = new JRadioButton("F");
		M6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		M6.setBounds(545, 170, 38, 23);
		add(M6);
		//Verdadeiro
		M5 = new JRadioButton("V");
		M5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		M5.setBounds(545, 129, 38, 23);
		add(M5);
		bg = new ButtonGroup();
		bg.add(M5);
		bg.add(M6);
		
		botaov.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				apaga();
				q.setVisible(true);
			}
		});
		botaom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				apaga();
				APainelinterface.ativarmenu();
				
			}
		});
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				apaga();
				q.setVisible(true);
			}
		});
	}
	void apaga() {
		setVisible(false);	  	
		editorperg3.setText("");
	}
}
