package Interface2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Gerarprova extends JPanel{
	JPanel painel2;
	JToggleButton geradorprova;
	JLabel labelassunto10,labelCadassunto1,labelquatidadequest;
	JButton botaomenu7,botaocriar2;
	JComboBox Boxassuntoprova,Boxquatquest;
	Gerarprova(APainelinterface a){
		setLayout(null);
		setBounds(59, 86, 750, 500);
		setVisible(false);
		
		painel2 = new JPanel();
		painel2.setLayout(null);
		painel2.setBounds(59, 86, 550, 295);
		painel2.setBorder(new LineBorder(new Color(0,0,0),2));
		painel2.setVisible(true);
		add(painel2);
		geradorprova = new JToggleButton("Gerar Prova");
		geradorprova.setFont(new Font("Tahoma", Font.BOLD, 15));
		geradorprova.setBackground(Color.GREEN);
		geradorprova.setForeground(new Color(255, 255, 255));
		geradorprova.setBounds(0, 0, 550, 23);
		painel2.add(geradorprova);
		
		labelassunto10 = new JLabel("Assunto:");
		labelassunto10.setBounds(42, 86, 121, 23);
		painel2.add(labelassunto10);
		
		botaomenu7 = new JButton("Menu");
		botaomenu7.setBounds(236, 199, 89, 23);
		painel2.add(botaomenu7);
		
		botaocriar2 = new JButton("Criar");
		botaocriar2.setBounds(428, 114, 89, 23);
		painel2.add(botaocriar2);
		
		labelCadassunto1 = new JLabel("Gerar Prova");
		labelCadassunto1.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadassunto1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		labelCadassunto1.setBounds(99, 34, 358, 45);
		painel2.add(labelCadassunto1);
		
		labelquatidadequest = new JLabel("Quantidade de Questoes:");
		labelquatidadequest.setBounds(263, 86, 177, 23);
		painel2.add(labelquatidadequest);
		
		Boxassuntoprova = new JComboBox();
		Boxassuntoprova.setBounds(42, 114, 177, 22);
		painel2.add(Boxassuntoprova);
		
		Boxquatquest = new JComboBox();
		Boxquatquest.setBounds(297, 114, 28, 22);
		painel2.add(Boxquatquest);
		
		botaomenu7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					APainelinterface.ativarmenu();
	   	        	  setVisible(false);
				}	});
		botaocriar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel2.setVisible(false);
				JPanel painel1 = new JPanel();
				painel1.setLayout(null);
				add(painel1);
				painel1.setBorder(new LineBorder(new Color(0,0,0),2));
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
						painel2.setVisible(true);
					}});
			}	});
	}
}
