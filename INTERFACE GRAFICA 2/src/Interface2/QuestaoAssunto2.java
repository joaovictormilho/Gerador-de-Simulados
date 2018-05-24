package Interface2;

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

public class QuestaoAssunto2 extends JPanel {
	private JPanel painel1;
    private JButton Botaomenu, Botaovolt;
    private JLabel assunto, listaquest,tipoass;
    private JTable tabela;
    private JScrollPane jScrollPane1;
		QuestaoAssunto2(QuestaoAssunto a){
			
			jScrollPane1 = new JScrollPane();
			tabela = new JTable() {
				@Override
				public boolean isCellEditable(int a, int b) {
					return false;
				}
			};
	        tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
	        listaquest = new JLabel();
	        Botaomenu = new JButton();
	        Botaovolt = new JButton();
	        assunto = new JLabel();
	        assunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        tipoass = new JLabel();
	        tipoass.setFont(new Font("Tahoma", Font.PLAIN, 20));;
	        setBorder(new LineBorder(new Color(0,0,0),2));
	       setBounds(110, 50, 650, 600);
			setLayout(null);
			setVisible(false);
      
	        tabela.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{" ", " "},
	        		{null, null},
	        	},
	        	new String[] {
	        		"QUESTOES", "Quantidade de Alternativas"
	        	}
	        ));
	        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
	        jScrollPane1.setViewportView(tabela);

	        add(jScrollPane1);
	        jScrollPane1.setBounds(30, 110, 567, 400);

	        listaquest.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
	        listaquest.setText("LISTA DE QUESTOES");
	        listaquest.setToolTipText("");
	        listaquest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        add(listaquest);
	        listaquest.setBounds(145, 26, 330, 40);

	        Botaomenu.setText("MENU");
	        add(Botaomenu);
	        Botaomenu.setBounds(48, 540, 100, 30);

	        Botaovolt.setText("VOLTAR");
	        add(Botaovolt);
	        Botaovolt.setBounds(489, 540, 90, 30);

	        assunto.setText("Assunto:");
	        add(assunto);
	        assunto.setBounds(49, 70, 81, 40);

	        tipoass.setText("Escravo");
	        tipoass.setToolTipText("");
	        add(tipoass);
	        tipoass.setBounds(151, 75, 381, 30);
	        
	        Botaomenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//tabela.removeAll();
						APainelinterface.ativarmenu();
	   	        	  setVisible(false);
				}	});
	        Botaovolt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//tabela.removeAll();
					a.setVisible(true);
	   	        	 setVisible(false);
				}	});
		}
}
