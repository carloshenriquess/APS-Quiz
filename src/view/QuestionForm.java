package view;

import javax.swing.JFrame;
import model.Question;
import storage.Storage;
import util.Util;

public class QuestionForm extends javax.swing.JFrame {

    private byte currentQuestion;
    private Question question;
    private int points;
    private int pulos;
    private int tips;
    
    private boolean tipUsed = false;

    public QuestionForm() {
        initComponents();
        txtQuestion.setWrapStyleWord(true);
        txtQuestion.setLineWrap(true);
        tipDialog.setLocationRelativeTo(null);
        
        question = Storage.QUESTIONS[currentQuestion];
        pulos = Storage.PULOS;
        tips = Storage.TIPS;
        refreshForm();
    }

    private void refreshForm() {
        if (pulos <= 0) {
            btnPular.setEnabled(false);
        }
        if (tips <= 0) {
            btnTip.setEnabled(false);
        }

        btnReply.setEnabled(false);
        txtQuestion.setText(question.getQuestion());
        resetRadios();
        rdAlt1.setText(question.getAlternatives()[0]);
        rdAlt2.setText(question.getAlternatives()[1]);
        rdAlt3.setText(question.getAlternatives()[2]);
        rdAlt4.setText(question.getAlternatives()[3]);
        lbCurrentQuestion.setText(String.valueOf(currentQuestion + 1));
        lbTip.setText(question.getTip());
        lbPoints.setText(String.valueOf(points));
        
        lbQuestionPoints.setText(String.valueOf(question.getPoints()));
        lbPulos.setText(String.valueOf(pulos));
        lbTips.setText(String.valueOf(tips));
        lbDefeatPoints.setText(String.valueOf(getDefeatPoints()));
        lbStopPoints.setText(String.valueOf(points));
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
    
    private int getDefeatPoints() {
        if ((int) (points / 2) < 5000) {
            return (int) (points / 2);
        } else {
            return 5000;
        }
    }
    
    private void toNextQuestion() {
        currentQuestion++;
        tipUsed = false;
        if (Storage.QUESTIONS.length > currentQuestion) {
            question = Storage.QUESTIONS[currentQuestion];
            refreshForm();
        } else {
            WinForm winForm = new WinForm(points, pulos, tips);
            toFrame(winForm);
        }
    }
    
    private void toFrame(JFrame jFrame) {
        Util.toFrame(this, jFrame);
    }

    // Events
    private void onReply() {
        Question.Alternative alternative = getSelectedAlternative();
        if (question.reply(alternative))  {
            points += question.getPoints();
            toNextQuestion();
        } else {
            DefeatForm defeatForm = new DefeatForm((int) (points / 2), pulos, tips);
            toFrame(defeatForm);
        }
    }
    private void onClickTip() {
        if (!tipUsed) {
            tipUsed = true;
            lbTips.setText(String.valueOf(--tips));
            if (tips <= 0) {
                btnTip.setEnabled(false);
            }
        }
        tipDialog.setVisible(true);
    }
    private void onClickPular() {
        pulos--;
        toNextQuestion();
    }
    private void onStop() {
        StopForm stopForm = new StopForm((int) (points / 2), pulos, tips);
        toFrame(stopForm);
    }
    private void onSelectRadio(javax.swing.JRadioButton radio) {
        resetRadios();
        radio.setSelected(true);
        if (!btnReply.isEnabled()) {
            btnReply.setEnabled(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipDialog = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        lbTip = new javax.swing.JLabel();
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
        btnStop = new javax.swing.JButton();
        btnTip = new javax.swing.JButton();
        btnPular = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbQuestionPoints = new javax.swing.JLabel();
        lbDefeatPoints = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbPulos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTips = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbStopPoints = new javax.swing.JLabel();

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

        btnStop.setText("Parar");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnTip.setText("Dica");
        btnTip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipActionPerformed(evt);
            }
        });

        btnPular.setText("Pular");
        btnPular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPularActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(220, 220, 220));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Valendo:");

        lbQuestionPoints.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbQuestionPoints.setText("0");

        lbDefeatPoints.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDefeatPoints.setText("0");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Errar:");

        lbPulos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbPulos.setText("0");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Pulos:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Dicas:");

        lbTips.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbTips.setText("0");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Parar:");

        lbStopPoints.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbStopPoints.setText("0");

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
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDefeatPoints))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPulos))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTips))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStopPoints)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbQuestionPoints))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDefeatPoints))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbStopPoints))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbPulos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTips))
                .addContainerGap(118, Short.MAX_VALUE))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnReply)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(rdAlt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdAlt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdAlt1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rdAlt4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReply)
                    .addComponent(btnStop)
                    .addComponent(btnTip)
                    .addComponent(btnPular))
                .addContainerGap())
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
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        onStop();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnTipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipActionPerformed
        onClickTip();
    }//GEN-LAST:event_btnTipActionPerformed

    private void btnPularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPularActionPerformed
        onClickPular();
    }//GEN-LAST:event_btnPularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPular;
    private javax.swing.JButton btnReply;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCurrentQuestion;
    private javax.swing.JLabel lbDefeatPoints;
    private javax.swing.JLabel lbPoints;
    private javax.swing.JLabel lbPoints1;
    private javax.swing.JLabel lbPulos;
    private javax.swing.JLabel lbQuestionPoints;
    private javax.swing.JLabel lbStopPoints;
    private javax.swing.JLabel lbTip;
    private javax.swing.JLabel lbTips;
    private javax.swing.JRadioButton rdAlt1;
    private javax.swing.JRadioButton rdAlt2;
    private javax.swing.JRadioButton rdAlt3;
    private javax.swing.JRadioButton rdAlt4;
    private javax.swing.JDialog tipDialog;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
