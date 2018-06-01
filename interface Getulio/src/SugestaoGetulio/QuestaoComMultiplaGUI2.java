/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SugestaoGetulio;

import Logica.Assunto;
import Logica.Questao;
import Logica.QuestaoMultiplaEscolhaCom;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author raykson santos
 */
public class QuestaoComMultiplaGUI2 extends AbstractCadastroQuestoes {

    private JButton cadastrar;
    private JButton menu;
    protected final JPanel resposta = new JPanel();
    private JScrollPane barraRolagem;
    private ArrayList<String> respostaQuestao;
    private ArrayList<String> alternativasQuestao;
    private JButton botaoOK;
    private JComboBox<Integer> boxQuantidade;
    JButton buttonRemover;

    public QuestaoComMultiplaGUI2(ArrayList<Questao> questao, JButton menu) {
        super(questao, menu);
        this.setSize(550, 510);

    }

    @Override
    JPanel painelResposta() {

        this.boxQuantidade = new JComboBox<>();
        maxQuetoesPorAssunto(10);
        botaoOK = new JButton("OK");
        menu = new JButton("MENU");

        JLabel labelQTDPergunta = new JLabel("QUANTIDADE QUESTÕES");

        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        barraRolagem = new JScrollPane(resposta);
        barraRolagem.setPreferredSize(new Dimension(500, 240));
        boxQuantidade.setPreferredSize(new Dimension(40, 20));
        barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQTDPergunta)
                        .addGap(10)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(botaoOK)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(barraRolagem)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelQTDPergunta)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoOK)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barraRolagem, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );
        botaoOK.addActionListener((ActionEvent e) -> {
            if (boxQuantidade.getSelectedIndex() != 0) {
                atualizaAlternativa();
                barraRolagem.setViewportView(resposta);
            } else {
                resposta.removeAll();

            }
        });
        this.menu.addActionListener((ActionEvent ae) -> {
            cancelar.doClick();
            menu.doClick();
        });

        return painel;
    }

    @Override
    void newButtons(JPanel panel) {
        cadastrar = new JButton("CADASTRAR");
        respostaQuestao = new ArrayList<>();
        alternativasQuestao = new ArrayList<>();
        panel.add(cadastrar);
        cadastrar.addActionListener((ActionEvent ae) -> {
            if (!((Integer) boxQuantidade.getSelectedItem()).equals(0)) {
                if (isValido()) {
                    if (questoes.add(new QuestaoMultiplaEscolhaCom(pergunta.getText(), (String[]) respostaQuestao.toArray(new String[respostaQuestao.size()]), (String[]) alternativasQuestao.toArray(new String[alternativasQuestao.size()]), assunto))) {
                        limpa();
                    } else {
                        JOptionPane.showMessageDialog(null, "Questão já cadastrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Impossivel cadastrar\nDigite TODOS os dados corretamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Impossivel cadastrar\nSelecione uma quantidade de questoes");
            }
        });
    }

    @Override
    JLabel titulo() {
        return new JLabel("MULTIPLA ESCOLHA COM VARIAS RESPOSTAS");
    }

    @Override
    void initialize(Assunto assunto) {
        this.labelAssunto.setText("Assunto: " + assunto.toString());
        this.setVisible(true);
    }

    private void limpa() {
        respostaQuestao.removeAll(respostaQuestao);
        alternativasQuestao.removeAll(alternativasQuestao);
        pergunta.setText("");
        resposta.removeAll();
        barraRolagem.setViewportView(resposta);
        boxQuantidade.setSelectedItem(0);
    }

    void maxQuetoesPorAssunto(int max) {
        for (int il = 0; il <= max; il++) {
            this.boxQuantidade.addItem(il);
        }
    }

    private boolean isValido() {
        respostaQuestao.removeAll(respostaQuestao);
        alternativasQuestao.removeAll(alternativasQuestao);
        int al = (int) boxQuantidade.getSelectedItem();
        resposta.getComponentAt(0, al);
        for (int a = 0; a < al; a++) {
            alternativasQuestao.add(((JTextArea) resposta.getComponentAt(1, al)).getText());
            if (alternativasQuestao.get(a).equals("")) {
                return false;
            }
            if (((JRadioButton) resposta.getComponentAt(0, al)).isSelected()) {
                respostaQuestao.add(alternativasQuestao.get(a));
            }
        }
        return !respostaQuestao.isEmpty() && !alternativasQuestao.isEmpty();
    }

    protected JPanel atualizaAlternativa() {
        resposta.removeAll();
        int a = (int) boxQuantidade.getSelectedItem();

        return resposta;
    }

    private void diminuiQuantidadeDeAlternativas(int a) {
        int e = resposta.getComponentCount();
        int removidos = e / 2;
        for (int i = 0; i < e / 2 && removidos > a; i++) {
            if (((JLabel) resposta.getComponentAt(i, 1)).getText().equals("")) {
                resposta.remove(resposta.getComponentAt(i, 1));
                resposta.remove(resposta.getComponentAt(removidos - 1, 0));
                removidos--;
            }
        }
        if (removidos == a) {
            return;
        }
        for (int i = e / 2 - 1; i >= 0 && removidos > a; i--) {
            resposta.remove(resposta.getComponentAt(i, 1));
            resposta.remove(resposta.getComponentAt(i, 0));
            removidos--;
        }
        JDialog remocao = new JDialog();
        remocao.setModal(true);
        remocao.pack();
        remocao.show();
        remocao.setLayout(new BoxLayout(remocao, BoxLayout.Y_AXIS));
        JLabel informacao = new JLabel("Selecione nas alternativa a remover");
        Integer h = removidos - a;
        JLabel restanteRemover = new JLabel(Integer.toString(removidos - a));
        JPanel remover = new JPanel(new GridLayout(removidos, 2));
        JTextArea edt;
        JScrollPane scroll;
        remocao.add(informacao);
        remocao.add(restanteRemover);
        remocao.add(remocao);
        JButton cancelarRemocao = new JButton("Cancelar");
        cancelarRemocao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                remocao.dispose();
                remover.removeAll();
            }
        });
                JButton buttonRestante = new JButton("Restante("+(removidos-a)+")");
                buttonRestante.setEnabled(false);
                Box opcoes=Box.createHorizontalBox();
                opcoes.add(cancelarRemocao);
                opcoes.add(buttonRestante);

        int r = 0;
        for (int i = 0; i < removidos; i++) {
            buttonRemover = new JButton();
            buttonRemover.addItemListener(remover(buttonRestante));
            edt = new JTextArea();
            edt.setLineWrap(true);
            edt.setWrapStyleWord(true);
            scroll = new JScrollPane(edt);
            scroll.setPreferredSize(new Dimension(500, 50));
            edt.setText(((JLabel) resposta.getComponentAt(i, 1)).getText());
            remover.add(buttonRemover);
            remover.add(edt);
        }
        resposta.setLayout(new GridLayout(a, 2));
    }

    private void aumentaQuantidadeDeAlternativas(int a) {
        resposta.setLayout(new GridLayout(a, 2));
        JTextArea edt;
        JRadioButton radioButtonAlternativa;
        int i = (resposta.getComponentCount() / 2);
        JScrollPane scroll;
        for (; i < a; i++) {
            radioButtonAlternativa = new JRadioButton();
            radioButtonAlternativa.setText("Alternativa " + (i + 1));
            edt = new JTextArea();
            edt.setLineWrap(true);
            edt.setWrapStyleWord(true);
            scroll = new JScrollPane(edt);
            scroll.setPreferredSize(new Dimension(500, 50));
            resposta.add(radioButtonAlternativa);
            resposta.add(scroll);
        }
    }

    @Override
    void fecharJDiaolg() {
        limpa();
        this.dispose();
    }

    private ItemListener remover(JButton buttonRestante){
        return (new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                int k = Integer.parseInt(buttonRestante.getText().replace("Restante (", "").replace(")", ""));
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    buttonRestante.setText("Restante (" + (k + 1) + ")");
                } else {
                    if (ie.getStateChange() == ItemEvent.SELECTED) {
                        buttonRestante.setText("Restante (" + (k - 1) + ")");
                    }
                }
                if (buttonRestante.getText().equals("Restante (0)")) {
                    buttonRestante.setText("Remover");
                    buttonRestante.setEnabled(true);
                }
            }
        });
    }
}
