package Interface2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class QuestaoLista extends JPanel {
	JButton botamenu,botaoeditar;
	JLabel lblListagem;
	JTable table;
	JScrollPane scrollPane;
	JTextField txtAssunto,txtTipo,txtPergunta,txtResposta, txtAlternativas;
	QuestaoLista(APainelinterface a){
		
				//Listar Assuntos

				setBounds(60, 70, 1090, 600);
				setLayout(null);
				setBorder(new LineBorder(new Color(0,0,0),2));
				setVisible(false);
				//Botao Menu
				JButton botaomenu = new JButton("Menu");
				botaomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
				botaomenu.setBounds(10, 560, 193, 34);
				add(botaomenu);
				//Botao Editar
				JButton botaoeditar = new JButton("Editar");
				botaoeditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
				botaoeditar.setBounds(869, 560, 193, 34);
				add(botaoeditar);
				JButton botaoexcluir = new JButton("Excluir");
				botaoexcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
				botaoexcluir.setBounds(450, 560, 193, 34);
				add(botaoexcluir);
				
				JLabel lblListagem = new JLabel("LISTAGEM DE QUESTÕES");
				lblListagem.setFont(new Font("Times New Roman", Font.PLAIN, 30));
				lblListagem.setBounds(367, 25, 390, 45);
				add(lblListagem);
				
				
				JTable table = new JTable() {
					@Override
					public boolean isCellEditable(int a, int b) {
						return false;
					}
				};
				table.setCellSelectionEnabled(true);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
				table.setModel(new DefaultTableModel(
					new Object[][] {{"1", "2", "3", "4", "5"},{null, null, null, null, null},},
					new String[] {"New column", "New column", "New column", "New column", "New column"}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(70);
				table.getColumnModel().getColumn(1).setPreferredWidth(78);
				table.getColumnModel().getColumn(2).setPreferredWidth(256);
				table.getColumnModel().getColumn(3).setPreferredWidth(265);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 2, 2);
				add(scrollPane);
				scrollPane.setViewportView(table);
				scrollPane.setBounds(10, 121, 1074, 60);
						
				txtAssunto = new JTextField();
				txtAssunto.setBorder(new LineBorder(Color.BLACK));
				txtAssunto.setEditable(false);
				txtAssunto.setText("               ASSUNTO");
				txtAssunto.setBackground(Color.LIGHT_GRAY);
				txtAssunto.setBounds(10, 87, 140, 33);
				add(txtAssunto);
				txtAssunto.setColumns(10);
				
				txtTipo = new JTextField();
				txtTipo.setBorder(new LineBorder(Color.BLACK));
				txtTipo.setEditable(false);
				txtTipo.setText("                    TIPO");
				txtTipo.setBackground(Color.LIGHT_GRAY);
				txtTipo.setColumns(10);
				txtTipo.setBounds(148, 87, 151, 33);
				add(txtTipo);
				
				txtPergunta = new JTextField();
				txtPergunta.setBorder(new LineBorder(Color.BLACK));
				txtPergunta.setEditable(false);
				txtPergunta.setText("                                              PERGUNTA");
				txtPergunta.setBackground(Color.LIGHT_GRAY);
				txtPergunta.setColumns(10);
				txtPergunta.setBounds(297, 87, 329, 33);
				add(txtPergunta);
				
				txtResposta = new JTextField();
				txtResposta.setBorder(new LineBorder(Color.BLACK));
				txtResposta.setEditable(false);
				txtResposta.setText("                                                 RESPOSTA");
				txtResposta.setBackground(Color.LIGHT_GRAY);
				txtResposta.setColumns(10);
				txtResposta.setBounds(626, 87, 338, 33);
				add(txtResposta);
				
				txtAlternativas = new JTextField();
				txtAlternativas.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtAlternativas.setEditable(false);
				txtAlternativas.setText("         ALTERNATIVAS");
				txtAlternativas.setBackground(Color.LIGHT_GRAY);
				txtAlternativas.setColumns(10);
				txtAlternativas.setBounds(962, 87, 122, 33);
				add(txtAlternativas);
				
				botaomenu.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						a.ativarmenu();
						setVisible(false);
					}
				});

	}
}
