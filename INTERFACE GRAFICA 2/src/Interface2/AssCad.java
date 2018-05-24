package Interface2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class AssCad extends JPanel{
	private JToggleButton  Cadastrobot;
	private JLabel labeldigite,labelCadassunto;
	private JButton botaomenu5,ok;
	private JTextArea textArea;
	
	AssCad(APainelinterface e){
		setBounds(59, 86, 542, 244);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setVisible(false);
				
				Cadastrobot = new JToggleButton("Cadastro de Assunto");
				Cadastrobot.setFont(new Font("Tahoma", Font.BOLD, 15));
				Cadastrobot.setBackground(Color.BLACK);
				Cadastrobot.setForeground(new Color(255, 255, 255));
				Cadastrobot.setBounds(0, 0, 550, 23);
				add(Cadastrobot);
				
				labeldigite = new JLabel("Digite o nome do assunto:");
				labeldigite.setBounds(10, 90, 155, 23);
				add(labeldigite);
				
				botaomenu5 = new JButton("MENU");
				botaomenu5.setBounds(55, 171, 89, 23);
				add(botaomenu5);
				
				ok = new JButton("OK");
				ok.setBounds(368, 171, 89, 23);
				add(ok);
				
				labelCadassunto = new JLabel("CADASTRAR ASSUNTO");
				labelCadassunto.setFont(new Font("Times New Roman", Font.PLAIN, 30));
				labelCadassunto.setBounds(99, 34, 358, 45);
				add(labelCadassunto);
				
				textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBackground(Color.WHITE);
				textArea.setBounds(165, 89, 340, 51);
				add(textArea);
				
				ok.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
					}
				});
				botaomenu5.addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
						setVisible(false);
						APainelinterface.ativarmenu();
					}
				});
				
	}
}
