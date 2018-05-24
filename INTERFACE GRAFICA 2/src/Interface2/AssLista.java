package Interface2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
public class AssLista extends JPanel{
	JButton Botaomenu, Botaovolt, editar;
	JLabel listaquest;
	JTable tabela;
	JScrollPane jScrollPane1;
	AssLista(APainelinterface e){
		setLayout(null);
		setBounds(59, 86, 624, 595);
		setBorder(new LineBorder(new Color(0,0,0),2));
		setVisible(false);
		
		jScrollPane1 = new JScrollPane();
        tabela = new JTable();
        tabela.setBorder(new LineBorder(new Color(0, 0, 0)));
        listaquest = new JLabel();
        Botaomenu = new JButton();
        Botaovolt = new JButton();
        editar = new JButton();
  
        tabela.setModel(new DefaultTableModel(
        	new Object[][] {
        		{" ", " ", null},
        		{null, null, null},
        	},
        	new String[] {
        		"QUESTOES", "DATA", "QTD. DE ALTERNATIVAS"
        	}
        ));
        tabela.getColumnModel().getColumn(0).setPreferredWidth(230);
        jScrollPane1.setViewportView(tabela);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 75, 588, 400);

        listaquest.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        listaquest.setText("LISTA DE ASSUNTOS");
        listaquest.setToolTipText("");
        listaquest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(listaquest);
        listaquest.setBounds(151, 23, 378, 40);

        Botaomenu.setText("MENU");
        add(Botaomenu);
        Botaomenu.setBounds(50, 515, 100, 30);

        Botaovolt.setText("EXCLUIR");
        add(Botaovolt);
        Botaovolt.setBounds(261, 515, 90, 30);
          
        editar.setText("EDITAR");
        editar.setBounds(475, 515, 90, 30);
        add(editar);
        
        Botaomenu.addActionListener(new ActionListener() {
   				public void actionPerformed(ActionEvent e) {
   					//tabela.removeAll();
   					APainelinterface.ativarmenu();
   	   	        	  setVisible(false);
   				}	});
        
	}
}
