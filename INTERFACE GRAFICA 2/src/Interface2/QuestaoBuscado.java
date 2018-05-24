package Interface2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class QuestaoBuscado extends JPanel{
	JLabel encontrada, tipo,resptipo,resp;
	JButton botaosair,botaov;
	JPanel painel;
	QuestaoBuscado(QuestaoBuscar b){
		JPanel painel = new JPanel();
		setBounds(40, 40, 1000,650);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setVisible(false);
		
		painel.setBounds(2, 2, 580,635);
		//painel.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel.setLayout(null);
		add(painel);
		
		encontrada = new JLabel("Pergunta Encontrada");
		encontrada.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		encontrada.setBounds(183, 3, 393, 56);
		painel.add(encontrada);
		
		botaosair = new JButton("SAIR");
		botaosair.setBounds(100, 610, 89, 23);
		painel.add(botaosair);
		
		botaov = new JButton("VOLTAR");
		botaov.setBounds(440, 610, 89, 23);
		painel.add(botaov);
		
		JPanel painel1 = new JPanel();
		painel1.setBounds(600, 5, 387,247);
		painel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel1.setLayout(null);
		add(painel1);
		painel1.setVisible(true);
		JLabel erro = new JLabel("SIMBOLO DE ERRO.");
		erro.setBounds(121, 51, 172, 40);
		painel1.add(erro);
		
		JLabel not = new JLabel("PERGUNTA NAO ENCONTRADA");
		not.setFont(new Font("Tahoma", Font.PLAIN, 22));
		not.setBounds(45, 102, 316, 60);
		painel1.add(not);
		
		botaosair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				APainelinterface.ativarmenu();		
			}
		});
		botaov.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				b.setVisible(true);		
			}
		});
	}
}
