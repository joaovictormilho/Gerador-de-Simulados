package Interface2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class APainelinterface extends JFrame {
	protected static JPanel painelcentral;
	private JMenuBar menuprincipal;
	private static JMenu menu1;
	private static JMenu menu2;
	private static JMenu menu3;
	private static JMenu menu4;
	private JMenuItem iten1,iten2,iten3,iten4,iten5,iten6,iten7,iten8,iten9,iten10;
	private QuestaoQcadastro q;
	private QuestaoLista a;
	private QuestaoAssunto g;
	private QuestaoBuscar b;
	private AssCad x;
	private AssLista y;
	private Gerarprova z;
	private GerarTxT w;
	private EnviarEmail u;
	APainelinterface(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setIcone();
			//setResizable(false);
			//Painel Central
			setTitle("                                                                                                  Projeto  de POO");
			setBounds(10,10,1200,750);
			painelcentral = new JPanel();
			setContentPane(painelcentral);
			painelcentral.setLayout(null);
			//pack();
			//Fim
			
			//JMenuBar
			menuprincipal = new JMenuBar();
			menuprincipal.setBounds(0, 2, 1600, 30);
			menuprincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			painelcentral.add(menuprincipal);
			//Fim
			
			//JMenu
			menu1 = new JMenu("Quest�es");
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
			iten1.addActionListener(new Cadastro());
			iten2.addActionListener(new Cadastro());
			iten3.addActionListener(new Cadastro());
			iten4.addActionListener(new Cadastro());
			iten5.addActionListener(new Cadastro2());
			iten6.addActionListener(new Cadastro2());
			iten7.addActionListener(new Cadastro3());
			iten8.addActionListener(new Cadastro3());
			iten9.addActionListener(new Cadastro3());
			iten10	.addActionListener(new Cadastro3());
			q=new QuestaoQcadastro(this);
			a = new QuestaoLista(this);
			g = new QuestaoAssunto(this);
			b = new QuestaoBuscar(this);
			x = new AssCad(this);
			y = new AssLista(this);
			z = new Gerarprova(this);
			w = new GerarTxT(this);
			u = new EnviarEmail(this);
			painelcentral.add(y);
			painelcentral.add(a);
			painelcentral.add(q);
			painelcentral.add(g);
			painelcentral.add(b);
			painelcentral.add(x);
			painelcentral.add(z);
			painelcentral.add(w);
			painelcentral.add(u);

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
	
		private void setIcone() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Prova.png")));
		}
		
		private class Cadastro implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		         desativarmenu();
		         String c = e.getActionCommand();  
		         if( c.equals( "Cadastrar" ))  {
		        	q.setVisible(true); 
		         } else if( c.equals("Listar Questoes de um assunto" ) )  {
		        	 g.setVisible(true);
		         } else if(c.equals("Listar")){
		        	 	a.setVisible(true);
		         }else {
		        	 b.setVisible(true);
		         }
		      }	    
		   }	
		private class Cadastro2 implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		         desativarmenu();
		         String c = e.getActionCommand();  
		         if( c.equals( "Cadastrar" ))  {
		        	x.setVisible(true);
		         } else{
		        	y.setVisible(true); 	
		         }	    
		   }	
}
		private class Cadastro3 implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		         desativarmenu();
		         String c = e.getActionCommand();  
		         if( c.equals( "Gerar Prova" ))  {
		        	z.setVisible(true);
		         } else if(c.equals("Gerar TxT")){
		        	w.setVisible(true); 	
		         }else if(c.equals("Gerar Formulario")){
		        	 		JPanel painel1 = new JPanel();
		 			painel1.setLayout(null);
		 			add(painel1);
		 			painel1.setBorder(new LineBorder(new Color(0,0,0),2));
		 			painel1.setBounds(50, 50, 550, 200);
		 			//(59, 86, 550, 295);
		 			JLabel prova = new JLabel("FORMULARIO CRIADO COM SUCESSO");
		 			prova.setFont(new Font("Arial", Font.PLAIN, 25));
		 			prova.setBounds(42, 11, 500, 73);
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
		 					ativarmenu();
		 				}});
		         }else {
		        	 u.setVisible(true);
		         }
		   }
}
}
