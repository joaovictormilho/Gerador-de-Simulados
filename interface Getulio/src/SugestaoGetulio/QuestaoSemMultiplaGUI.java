package SugestaoGetulio;

import Logica.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public final class QuestaoSemMultiplaGUI extends JPanel {

    private final JButton cadastrar = new JButton("CADASTRAR");
    private final JButton menu = new JButton("MENU");
    private final JButton cancelar = new JButton("CANCELAR");
    private final JButton botaoOK = new JButton("OK");
    private final JPanel resposta;

    private final JTextArea pergunta = new JTextArea();
    private final JScrollPane barraRolagemc, barraRolagem;
    private Assunto assunto;
    JComboBox<Integer> boxQuantidade = new JComboBox<>();
    private ButtonGroup grupoBotoes;
    private String respostaQuestao = null;
    private Vector<String> alternativasQuestao = new Vector<>();
    private final JPanel painelOpcoes;
    
    QuestaoSemMultiplaGUI(JButton menue,ArrayList<Questao> questoes) {
        GroupLayout layout = new GroupLayout(this);
        this.setVisible(false);
        this.setPreferredSize(new Dimension(610, 510));
        this.setLayout(layout);
        JLabel labelTipoQuestao = new JLabel("QUESTÃO DE MULTIPLA ESCOLHA E VARIAS RESPOSTA");
        labelTipoQuestao.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel labelPergunta = new JLabel("PERGUNTA");
        JLabel labelQTDPergunta = new JLabel("QUANTIDADE QUESTÕES");
        JPanel painelCadastro = new JPanel();
        painelOpcoes = new JPanel();
        
        maxQuetoesPorAssunto(10);
        resposta = new JPanel();
        barraRolagem = new JScrollPane(resposta);
        barraRolagem.setPreferredSize(new Dimension(570, 200));
        resposta.setLayout(new GridBagLayout());
        boxQuantidade.setPreferredSize(new Dimension(40, 20));
        barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pergunta.setWrapStyleWord(true);
        pergunta.setLineWrap(true);
        barraRolagemc = new JScrollPane(pergunta);
        barraRolagemc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        barraRolagemc.setPreferredSize(new Dimension(400, 75));
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTipoQuestao)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPergunta)
                        .addGap(10)
                        .addComponent(barraRolagemc, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQTDPergunta)
                        .addGap(10)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(botaoOK)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(barraRolagem)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(painelOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(labelTipoQuestao)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelPergunta)
                        .addComponent(barraRolagemc, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelQTDPergunta)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoOK)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barraRolagem, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(painelOpcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
        );
        botaoOK.addActionListener((ActionEvent e) -> {

            barraRolagem.setViewportView(resposta);
        });
        this.cancelar.addActionListener((ActionEvent ae) ->{
            limpa();
            this.setVisible(false);
        });
        this.cadastrar.addActionListener((ActionEvent ae) -> {
            if (!((Integer) boxQuantidade.getSelectedItem()).equals(0)) {
                if (isValido()) {
                    if (questoes.add(new QuestaoMultiplaEscolhaSem(pergunta.getText(), respostaQuestao, alternativasQuestao.toArray(new String[alternativasQuestao.size()]), assunto))) {
                        limpa();
                    } else {
                        JOptionPane.showMessageDialog(null, "Questão já cadastrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Impossivel cadastrar\nDigite os dados corretamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Impossivel cadastrar\nDigite os dados corretamente");
            }
        });
    }

    void limpa() {
        respostaQuestao = null;
        alternativasQuestao.removeAllElements();
        pergunta.setText("");
        resposta.removeAll();
        barraRolagem.setViewportView(resposta);
        boxQuantidade.setSelectedItem(0);
        grupoBotoes = null;
    }
    void inicializaResposta(){
            resposta.removeAll();
            int a = (int) boxQuantidade.getSelectedItem();
            JTextArea edt;
            JRadioButton radioButtonAlternativa;
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            int i1;
            JScrollPane scroll;
            grupoBotoes = new ButtonGroup();
            grupoBotoes.
            for (i1 = 0; i1 < a; i1++) {
                radioButtonAlternativa = new JRadioButton();
                grupoBotoes.add(radioButtonAlternativa);
                edt = new JTextArea();
                edt.setLineWrap(true);
                edt.setWrapStyleWord(true);
                scroll = new JScrollPane(edt);
                scroll.setPreferredSize(new Dimension(500, 50));
                c.gridwidth = 1;
                c.gridx = 0;
                c.gridy = i1;
                resposta.add(radioButtonAlternativa, c);
                c.gridwidth = 6;
                c.gridx = 1;
                c.gridy = i1;
                resposta.add(scroll, c);
            }
    
    }
    void init(Assunto assunto) {
        this.setVisible(true);
        this.assunto = assunto;
    }

    void maxQuetoesPorAssunto(int max) {
        for (int il = 0; il <= max; il++) {
            boxQuantidade.addItem(il);
        }
    }

    private boolean isValido() {
        respostaQuestao = null;
        alternativasQuestao.removeAllElements();
        int al = (int) boxQuantidade.getSelectedItem();
        resposta.getComponentAt(0, al);
        for (int a = 0; a < al; a++) {
            alternativasQuestao.add(((JTextArea) resposta.getComponentAt(1, al)).getText());
            if (alternativasQuestao.lastElement().equals("")) {
                return false;
            }
            if (((JRadioButton) resposta.getComponentAt(0, al)).isSelected()) {
                respostaQuestao = alternativasQuestao.lastElement();
            }
        }
        return respostaQuestao != null;
    }
}
