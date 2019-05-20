package view;

import java.util.Random;
import javax.swing.JFrame;
import model.Question;
import storage.Storage;
import util.Util;

public class QuestionForm extends javax.swing.JFrame {

    private byte currentQuestion;
    private Question question;
    private int points;
    private int pulos;
    private int eliminations;
    private int tips;
    private int helps;
    
    private boolean tipUsed = false;
    private boolean helpUsed = false;

    public QuestionForm() {
        initComponents();
        txtQuestion.setWrapStyleWord(true);
        txtQuestion.setLineWrap(true);
        tipDialog.setLocationRelativeTo(null);
        helpDialog.setLocationRelativeTo(null);
        
        question = Storage.QUESTIONS[currentQuestion];
        pulos = Storage.PULOS;
        eliminations = Storage.ELIMINATIONS;
        tips = Storage.TIPS;
        helps = Storage.HELPS;
        refreshForm();
    }

    private void refreshForm() {
        btnPular.setEnabled(pulos > 0);
        btnElim.setEnabled(eliminations > 0);
        btnTip.setEnabled(tips > 0);
        btnHelp.setEnabled(helps > 0);
        
        rdAlt1.setVisible(true);
        rdAlt2.setVisible(true);
        rdAlt3.setVisible(true);
        rdAlt4.setVisible(true);

        btnReply.setEnabled(false);
        txtQuestion.setText(question.getQuestion());
        resetRadios();
        rdAlt1.setText(question.getAlternatives()[0]);
        rdAlt2.setText(question.getAlternatives()[1]);
        rdAlt3.setText(question.getAlternatives()[2]);
        rdAlt4.setText(question.getAlternatives()[3]);
        lbCurrentQuestion.setText(String.valueOf(currentQuestion + 1));

        lbPoints.setText(String.valueOf(points));
        
        lbQuestionPoints.setText(String.valueOf(question.getPoints()));
        lbPulos.setText(String.valueOf(pulos));
        lbElim.setText(String.valueOf(eliminations));
        lbTips.setText(String.valueOf(tips));
        lbHelps.setText(String.valueOf(helps));
   }
    
    private void resetRadios() {
        rdAlt1.setSelected(false);
        rdAlt2.setSelected(false);
        rdAlt3.setSelected(false);
        rdAlt4.setSelected(false);
    }

    private Question.Alternative getSelectedAlternative(){
        Question.Alternative alternative;
        if (rdAlt1.isSelected()) {
            alternative = Question.Alternative.A;
        } else if (rdAlt2.isSelected()) {
            alternative = Question.Alternative.B;
        } else if (rdAlt3.isSelected()) {
            alternative = Question.Alternative.C;
        } else {
            alternative = Question.Alternative.D;
        }
        return alternative;
    }
    
    private void toNextQuestion() {
        currentQuestion++;
        if (Storage.QUESTIONS.length > currentQuestion) {
            tipUsed = false;
            helpUsed = false;
            question = Storage.QUESTIONS[currentQuestion];
            refreshForm();
        } else {
            WinForm winForm = new WinForm(points, pulos, eliminations, tips, helps);
            toFrame(winForm);
        }
    }
    
    private void toFrame(JFrame jFrame) {
        Util.toFrame(this, jFrame);
    }
    
    private void eliminateAlternatives(int randomValue) {
        if (randomValue < 0 || randomValue > 100) {
            throw new IllegalArgumentException("[randomValue] deve estar entre 0 e 100");
        }
        
        if (randomValue < 33) {
            switch (question.getRightAlternative().getValue()) {
                case 1:
                case 2:
                    rdAlt3.setVisible(false);
                    rdAlt4.setVisible(false);
                    break;
                case 3:
                    rdAlt2.setVisible(false);
                    rdAlt4.setVisible(false);
                    break;
                case 4:
                    rdAlt2.setVisible(false);
                    rdAlt3.setVisible(false);
                    break;
            }
        } else if (randomValue < 66) {
            switch (question.getRightAlternative().getValue()) {
                case 1:
                    rdAlt2.setVisible(false);
                    rdAlt4.setVisible(false);
                    break;
                case 2:
                case 3:
                    rdAlt1.setVisible(false);
                    rdAlt4.setVisible(false);
                    break;
                case 4:
                    rdAlt1.setVisible(false);
                    rdAlt3.setVisible(false);
                    break;
            }
        } else {
            switch(question.getRightAlternative().getValue()) {
                case 1:
                    rdAlt2.setVisible(false);
                    rdAlt3.setVisible(false);
                    break;
                case 2:
                    rdAlt1.setVisible(false);
                    rdAlt3.setVisible(false);
                    break;
                case 3:
                case 4:
                    rdAlt1.setVisible(false);
                    rdAlt2.setVisible(false);
                    rdAlt1.setVisible(false);
                    rdAlt2.setVisible(false);
                    break;
            }
        }
    }

    private void setHelpLabels(){
        Random r = new Random();
        int rightAltValue = r.nextInt(65) + 36;
        int complementValue = 100 - rightAltValue;
        int wrongAlternative1 = r.nextInt(complementValue) + 1;
        complementValue -= wrongAlternative1;
        int wrongAlternative2 = (complementValue == 0 ? 0 : r.nextInt(complementValue) + 1);
        complementValue -= wrongAlternative2;
        byte wrong1Position = (byte) (r.nextInt(3) + 1);
        switch(question.getRightAlternative().getValue()) {
            case 1:
                lbPercentageA.setText(String.valueOf(rightAltValue));
                switch(wrong1Position) {
                    case 1:
                        lbPercentageB.setText(String.valueOf(wrongAlternative1));
                        lbPercentageC.setText(String.valueOf(wrongAlternative2));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 2:
                        lbPercentageB.setText(String.valueOf(wrongAlternative2));
                        lbPercentageC.setText(String.valueOf(wrongAlternative1));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 3:
                        lbPercentageB.setText(String.valueOf(wrongAlternative2));
                        lbPercentageC.setText(String.valueOf(complementValue));
                        lbPercentageD.setText(String.valueOf(wrongAlternative1));
                        break;
                }
                break;
            case 2:
                lbPercentageB.setText(String.valueOf(rightAltValue));
                switch(wrong1Position) {
                    case 1:
                        lbPercentageA.setText(String.valueOf(wrongAlternative1));
                        lbPercentageC.setText(String.valueOf(wrongAlternative2));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 2:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageC.setText(String.valueOf(wrongAlternative1));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 3:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageC.setText(String.valueOf(complementValue));
                        lbPercentageD.setText(String.valueOf(wrongAlternative1));
                        break;
                }
                break;
            case 3:
                lbPercentageC.setText(String.valueOf(rightAltValue));
                switch(wrong1Position) {
                    case 1:
                        lbPercentageA.setText(String.valueOf(wrongAlternative1));
                        lbPercentageB.setText(String.valueOf(wrongAlternative2));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 2:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageB.setText(String.valueOf(wrongAlternative1));
                        lbPercentageD.setText(String.valueOf(complementValue));
                        break;
                    case 3:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageB.setText(String.valueOf(complementValue));
                        lbPercentageD.setText(String.valueOf(wrongAlternative1));
                        break;
                }
                break;
            case 4:
                lbPercentageD.setText(String.valueOf(rightAltValue));
                switch(wrong1Position) {
                    case 1:
                        lbPercentageA.setText(String.valueOf(wrongAlternative1));
                        lbPercentageB.setText(String.valueOf(wrongAlternative2));
                        lbPercentageC.setText(String.valueOf(complementValue));
                        break;
                    case 2:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageB.setText(String.valueOf(wrongAlternative1));
                        lbPercentageC.setText(String.valueOf(complementValue));
                        break;
                    case 3:
                        lbPercentageA.setText(String.valueOf(wrongAlternative2));
                        lbPercentageB.setText(String.valueOf(complementValue));
                        lbPercentageC.setText(String.valueOf(wrongAlternative1));
                        break;
                }
                break;
        }
    }
    // Events
    private void onReply() {
        Question.Alternative alternative = getSelectedAlternative();
        if (question.reply(alternative))  {
            points += question.getPoints();
            toNextQuestion();
        } else {
            DefeatForm defeatForm = new DefeatForm(points, pulos, eliminations, tips, helps);
            toFrame(defeatForm);
        }
    }
    private void onTip() {
        btnPular.setEnabled(false);
        btnElim.setEnabled(false);
        btnHelp.setEnabled(false);
        if (!tipUsed) {
            tipUsed = true;
            lbTips.setText(String.valueOf(--tips));
        }
        lbTip.setText(question.getTip());
        tipDialog.setVisible(true);
    }

    private void onPular() {
        pulos--;
        points += 5;
        toNextQuestion();
    }
    
    private void onEliminate() {
        btnPular.setEnabled(false);
        btnElim.setEnabled(false);
        btnHelp.setEnabled(false);
        btnTip.setEnabled(false);

        lbElim.setText(String.valueOf(--eliminations));
        
        resetRadios();
        btnReply.setEnabled(false);

        int randomValue = new Random().nextInt(100);
        System.out.println("random: " + randomValue);
        eliminateAlternatives(randomValue);
    }
    
    private void onHelp() {
        if (!helpUsed) {
            helpUsed = true;
            btnPular.setEnabled(false);
            btnElim.setEnabled(false);
            btnTip.setEnabled(false);
            lbHelps.setText(String.valueOf(--helps));
            setHelpLabels();
        }
        helpDialog.setVisible(true);
    }
    
    private void onSelectRadio(javax.swing.JRadioButton radio) {
        resetRadios();
        radio.setSelected(true);
        btnReply.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        lbTip = new javax.swing.JLabel();
        helpDialog = new javax.swing.JDialog();
        lbHelp = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbPercentageA = new javax.swing.JLabel();
        lbPercentageB = new javax.swing.JLabel();
        lbPercentageC = new javax.swing.JLabel();
        lbPercentageD = new javax.swing.JLabel();
        feedbackDialog = new javax.swing.JDialog();
        pnFeedback = new javax.swing.JPanel();
        lbFeedback = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCurrentQuestion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPoints = new javax.swing.JLabel();
        lbPoints1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdAlt1 = new javax.swing.JRadioButton();
        rdAlt2 = new javax.swing.JRadioButton();
        rdAlt3 = new javax.swing.JRadioButton();
        rdAlt4 = new javax.swing.JRadioButton();
        btnReply = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        btnPular = new javax.swing.JButton();
        btnElim = new javax.swing.JButton();
        btnTip = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbQuestionPoints = new javax.swing.JLabel();
        lbPulos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTips = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbElim = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbHelps = new javax.swing.JLabel();

        tipDialog.setTitle("Dica");
        tipDialog.setMinimumSize(new java.awt.Dimension(415, 200));
        tipDialog.setResizable(false);
        tipDialog.setSize(new java.awt.Dimension(415, 200));

        lbTip.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTip.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbTip.setMinimumSize(new java.awt.Dimension(415, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTip, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTip, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tipDialogLayout = new javax.swing.GroupLayout(tipDialog.getContentPane());
        tipDialog.getContentPane().setLayout(tipDialogLayout);
        tipDialogLayout.setHorizontalGroup(
            tipDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tipDialogLayout.setVerticalGroup(
            tipDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        helpDialog.setResizable(false);
        helpDialog.setSize(new java.awt.Dimension(435, 300));

        lbHelp.setBackground(new java.awt.Color(112, 128, 144));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("A)");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("B)");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("C)");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("D)");

        lbPercentageA.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbPercentageA.setForeground(new java.awt.Color(255, 255, 255));

        lbPercentageB.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbPercentageB.setForeground(new java.awt.Color(255, 255, 255));

        lbPercentageC.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbPercentageC.setForeground(new java.awt.Color(255, 255, 255));

        lbPercentageD.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbPercentageD.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout lbHelpLayout = new javax.swing.GroupLayout(lbHelp);
        lbHelp.setLayout(lbHelpLayout);
        lbHelpLayout.setHorizontalGroup(
            lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbHelpLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbHelpLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPercentageA))
                    .addGroup(lbHelpLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPercentageB))
                    .addGroup(lbHelpLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPercentageC))
                    .addGroup(lbHelpLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPercentageD)))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        lbHelpLayout.setVerticalGroup(
            lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbHelpLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbPercentageA))
                .addGap(18, 18, 18)
                .addGroup(lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbPercentageB))
                .addGap(18, 18, 18)
                .addGroup(lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbPercentageC))
                .addGap(18, 18, 18)
                .addGroup(lbHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbPercentageD))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout helpDialogLayout = new javax.swing.GroupLayout(helpDialog.getContentPane());
        helpDialog.getContentPane().setLayout(helpDialogLayout);
        helpDialogLayout.setHorizontalGroup(
            helpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        helpDialogLayout.setVerticalGroup(
            helpDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        feedbackDialog.setSize(new java.awt.Dimension(400, 111));

        lbFeedback.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbFeedback.setForeground(new java.awt.Color(255, 255, 255));
        lbFeedback.setText("Resposta correta!");

        javax.swing.GroupLayout pnFeedbackLayout = new javax.swing.GroupLayout(pnFeedback);
        pnFeedback.setLayout(pnFeedbackLayout);
        pnFeedbackLayout.setHorizontalGroup(
            pnFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFeedbackLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(lbFeedback)
                .addGap(121, 121, 121))
        );
        pnFeedbackLayout.setVerticalGroup(
            pnFeedbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFeedbackLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lbFeedback)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout feedbackDialogLayout = new javax.swing.GroupLayout(feedbackDialog.getContentPane());
        feedbackDialog.getContentPane().setLayout(feedbackDialogLayout);
        feedbackDialogLayout.setHorizontalGroup(
            feedbackDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        feedbackDialogLayout.setVerticalGroup(
            feedbackDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz - FF");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(105, 105, 105));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pergunta:");

        lbCurrentQuestion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbCurrentQuestion.setForeground(new java.awt.Color(255, 255, 255));
        lbCurrentQuestion.setText("0");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("/50");

        lbPoints.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbPoints.setForeground(new java.awt.Color(255, 255, 255));
        lbPoints.setText("0");

        lbPoints1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbPoints1.setForeground(new java.awt.Color(255, 255, 255));
        lbPoints1.setText("Pontos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCurrentQuestion)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPoints1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPoints)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCurrentQuestion)
                    .addComponent(jLabel3)
                    .addComponent(lbPoints)
                    .addComponent(lbPoints1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(112, 128, 144));

        rdAlt1.setBackground(new java.awt.Color(112, 128, 144));
        rdAlt1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        rdAlt1.setForeground(new java.awt.Color(255, 255, 255));
        rdAlt1.setText("Alternativa errada");
        rdAlt1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdAlt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAlt1ActionPerformed(evt);
            }
        });

        rdAlt2.setBackground(new java.awt.Color(112, 128, 144));
        rdAlt2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        rdAlt2.setForeground(new java.awt.Color(255, 255, 255));
        rdAlt2.setText("Alternativa errada");
        rdAlt2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdAlt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAlt2ActionPerformed(evt);
            }
        });

        rdAlt3.setBackground(new java.awt.Color(112, 128, 144));
        rdAlt3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        rdAlt3.setForeground(new java.awt.Color(255, 255, 255));
        rdAlt3.setText("Alternativa errada");
        rdAlt3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdAlt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAlt3ActionPerformed(evt);
            }
        });

        rdAlt4.setBackground(new java.awt.Color(112, 128, 144));
        rdAlt4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        rdAlt4.setForeground(new java.awt.Color(255, 255, 255));
        rdAlt4.setText("Alternativa errada");
        rdAlt4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rdAlt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAlt4ActionPerformed(evt);
            }
        });

        btnReply.setText("Responder");
        btnReply.setEnabled(false);
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });

        txtQuestion.setEditable(false);
        txtQuestion.setBackground(new java.awt.Color(220, 220, 220));
        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQuestion.setRows(5);
        txtQuestion.setBorder(null);
        txtQuestion.setMaximumSize(new java.awt.Dimension(2147483647, 85));
        jScrollPane1.setViewportView(txtQuestion);

        btnPular.setText("Pular");
        btnPular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPularActionPerformed(evt);
            }
        });

        btnElim.setText("Eliminação");
        btnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimActionPerformed(evt);
            }
        });

        btnTip.setText("Dica");
        btnTip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipActionPerformed(evt);
            }
        });

        btnHelp.setText("Ajuda");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(220, 220, 220));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Valendo:");

        lbQuestionPoints.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbQuestionPoints.setText("0");

        lbPulos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbPulos.setText("0");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Pulos:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Dicas:");

        lbTips.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTips.setText("0");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Eliminações:");

        lbElim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbElim.setText("0");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Ajudas:");

        lbHelps.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbHelps.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbQuestionPoints))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPulos))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTips))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbElim))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHelps)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbQuestionPoints))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbPulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbElim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbHelps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTips))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdAlt4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdAlt3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdAlt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdAlt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnElim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReply))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdAlt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReply)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnElim)
                            .addComponent(btnPular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHelp)
                            .addComponent(btnTip))
                        .addGap(0, 144, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        onReply();
    }//GEN-LAST:event_btnReplyActionPerformed

    private void rdAlt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAlt1ActionPerformed
        onSelectRadio(rdAlt1);
    }//GEN-LAST:event_rdAlt1ActionPerformed

    private void rdAlt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAlt2ActionPerformed
        onSelectRadio(rdAlt2);
    }//GEN-LAST:event_rdAlt2ActionPerformed

    private void rdAlt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAlt3ActionPerformed
        onSelectRadio(rdAlt3);
    }//GEN-LAST:event_rdAlt3ActionPerformed

    private void rdAlt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAlt4ActionPerformed
        onSelectRadio(rdAlt4);
    }//GEN-LAST:event_rdAlt4ActionPerformed

    private void btnTipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipActionPerformed
        onTip();
    }//GEN-LAST:event_btnTipActionPerformed

    private void btnPularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPularActionPerformed
        onPular();
    }//GEN-LAST:event_btnPularActionPerformed

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
        onEliminate();
    }//GEN-LAST:event_btnElimActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        onHelp();
    }//GEN-LAST:event_btnHelpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnPular;
    private javax.swing.JButton btnReply;
    private javax.swing.JButton btnTip;
    private javax.swing.JDialog feedbackDialog;
    private javax.swing.JDialog helpDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCurrentQuestion;
    private javax.swing.JLabel lbElim;
    private javax.swing.JLabel lbFeedback;
    private javax.swing.JPanel lbHelp;
    private javax.swing.JLabel lbHelps;
    private javax.swing.JLabel lbPercentageA;
    private javax.swing.JLabel lbPercentageB;
    private javax.swing.JLabel lbPercentageC;
    private javax.swing.JLabel lbPercentageD;
    private javax.swing.JLabel lbPoints;
    private javax.swing.JLabel lbPoints1;
    private javax.swing.JLabel lbPulos;
    private javax.swing.JLabel lbQuestionPoints;
    private javax.swing.JLabel lbTip;
    private javax.swing.JLabel lbTips;
    private javax.swing.JPanel pnFeedback;
    private javax.swing.JRadioButton rdAlt1;
    private javax.swing.JRadioButton rdAlt2;
    private javax.swing.JRadioButton rdAlt3;
    private javax.swing.JRadioButton rdAlt4;
    private javax.swing.JDialog tipDialog;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
