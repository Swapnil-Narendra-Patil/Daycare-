
package View;

import models.Daycare;

import java.awt.CardLayout;

public class Login extends javax.swing.JFrame {

    
    private Daycare daycare;
    
    public Login(Daycare daycare) {
        initComponents();
        this.daycare = daycare;

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        heading = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        userdetails = new javax.swing.JTextField();
        passwordDetails = new javax.swing.JPasswordField();
        loginImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setMinimumSize(new java.awt.Dimension(1100, 800));
        mainContainer.setLayout(new java.awt.CardLayout());

        jLayeredPane1.setLayout(new javax.swing.BoxLayout(jLayeredPane1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jLayeredPane1.add(jPanel1);

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        loginButton.setBackground(new java.awt.Color(0, 0, 0));
        loginButton.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(249, 245, 245));
        loginButton.setText("Login");
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        heading.setFont(new java.awt.Font("Krub", 1, 14)); // NOI18N
        heading.setText("                       WELCOME, PLEASE LOG IN");

        user.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        user.setText("USERNAME:");

        password.setFont(new java.awt.Font("Krub", 1, 13)); // NOI18N
        password.setText("PASSOWORD:");

        userdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdetailsActionPerformed(evt);
            }
        });

        passwordDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(userdetails))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(password)
                                .addGap(30, 30, 30)
                                .addComponent(passwordDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)))
                .addComponent(loginImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(351, 351, 351))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user)
                            .addComponent(userdetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password)
                            .addComponent(passwordDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(loginImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addGap(328, 328, 328))))
        );

        jLayeredPane1.add(loginPanel);

        mainContainer.add(jLayeredPane1, "card2");

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Home dashBoardPanel = new Home(mainContainer, daycare);
        CardLayout layout = (CardLayout) mainContainer.getLayout();
        mainContainer.add(dashBoardPanel);
        layout.next(mainContainer);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void userdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userdetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userdetailsActionPerformed

    private void passwordDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordDetailsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel heading;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton loginButton;
    public javax.swing.JButton loginImageButton;
    private javax.swing.JPanel loginPanel;
    public javax.swing.JPanel mainContainer;
    public javax.swing.JLabel password;
    public javax.swing.JPasswordField passwordDetails;
    public javax.swing.JLabel user;
    public javax.swing.JTextField userdetails;
    // End of variables declaration//GEN-END:variables

    
}
