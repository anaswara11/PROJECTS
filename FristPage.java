package project;

public class FristPage extends javax.swing.JFrame {

    public FristPage() {
        initComponents();
        setTitle("Opening Page");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FristPage = new javax.swing.JPanel();
        Return = new javax.swing.JButton();
        Reg = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        Summary = new javax.swing.JButton();
        Quote = new javax.swing.JLabel();
        Credits = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FristPage.setBackground(new java.awt.Color(255, 255, 255));
        FristPage.setPreferredSize(new java.awt.Dimension(766, 630));
        FristPage.setLayout(null);

        Return.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        FristPage.add(Return);
        Return.setBounds(581, 550, 140, 40);

        Reg.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Reg.setText("New Donor Registration");
        Reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegActionPerformed(evt);
            }
        });
        FristPage.add(Reg);
        Reg.setBounds(190, 150, 320, 50);

        Search.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        FristPage.add(Search);
        Search.setBounds(190, 246, 320, 50);

        Summary.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Summary.setText("Blood bank Summary");
        Summary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SummaryActionPerformed(evt);
            }
        });
        FristPage.add(Summary);
        Summary.setBounds(190, 350, 320, 50);

        Quote.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Quote.setForeground(new java.awt.Color(255, 255, 255));
        Quote.setText("Be a Blood Donor , Be a Hero - a Real One");
        FristPage.add(Quote);
        Quote.setBounds(180, 10, 420, 54);

        Credits.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Credits.setText("Credits");
        Credits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditsActionPerformed(evt);
            }
        });
        FristPage.add(Credits);
        Credits.setBounds(40, 550, 150, 48);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/first_page.jpg"))); // NOI18N
        FristPage.add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(FristPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(FristPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        // TODO add your handling code here:
        MainPage Main = new MainPage();
        Main.setVisible(true);
        FristPage.setVisible(false);
        dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    private void RegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegActionPerformed

        RegPage First = new RegPage();
        FristPage.setVisible(false);
        First.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        Search first = new Search();
        FristPage.setVisible(false);
        first.setVisible(true);
        dispose();
    }//GEN-LAST:event_SearchActionPerformed

    private void CreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsActionPerformed

        Credits one = new Credits();
        FristPage.setVisible(false);
        one.setVisible(true);
        dispose();
    }//GEN-LAST:event_CreditsActionPerformed

    private void SummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SummaryActionPerformed
           
        Summary one = new Summary();
        one.setVisible(true);
        dispose();
    }//GEN-LAST:event_SummaryActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FristPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FristPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FristPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FristPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FristPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Credits;
    private javax.swing.JPanel FristPage;
    private javax.swing.JLabel Quote;
    private javax.swing.JButton Reg;
    private javax.swing.JButton Return;
    private javax.swing.JButton Search;
    private javax.swing.JButton Summary;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
