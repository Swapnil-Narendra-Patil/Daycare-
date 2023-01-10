/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ClassroomController;
import Controller.VaccinationController;
import Utils.Icon;
import Controller.StudentMainController;

import models.Daycare;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends javax.swing.JPanel {

    private JPanel mainContainer;
    private Daycare daycare;

    private Map<JButton, String> buttonIconMap = new HashMap<>();

    public Home(JPanel mainContainer, Daycare daycare) {
        initComponents();

        buttonIconMap.put(studentsButton, "/icons/student.png");
        buttonIconMap.put(teachersButton, "/icons/teacher.png");
        buttonIconMap.put(classroomsButton1, "/icons/classroom.png");
        buttonIconMap.put(immunizationButton, "/icons/vaccine.png");

        

        Icon image = new Icon();

        
        for (Map.Entry<JButton, String> button : buttonIconMap.entrySet()) {
            image.setIcon(button.getValue(), button.getKey());
        }
        this.mainContainer = mainContainer;
        this.daycare = daycare;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        daycareLabel = new javax.swing.JLabel();
        dashboardContainer = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        studentsTile = new javax.swing.JPanel();
        studentsButton = new javax.swing.JButton();
        teachersButton = new javax.swing.JButton();
        immunizationButton = new javax.swing.JButton();
        classroomsButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1100, 800));
        setPreferredSize(new java.awt.Dimension(1100, 800));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        daycareLabel.setBackground(new java.awt.Color(204, 255, 255));
        daycareLabel.setFont(new java.awt.Font("Krub", 1, 18)); // NOI18N
        daycareLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        daycareLabel.setText("Play School");
        daycareLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(daycareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(daycareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        dashboardContainer.setForeground(new java.awt.Color(255, 255, 255));
        dashboardContainer.setLayout(new java.awt.CardLayout(10, 10));

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        studentsTile.setForeground(new java.awt.Color(255, 255, 255));

        studentsButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentsButton.setText("Students");
        studentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsButtonActionPerformed(evt);
            }
        });

        teachersButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        teachersButton.setText("Teachers");
        teachersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teachersButtonActionPerformed(evt);
            }
        });

        immunizationButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        immunizationButton.setText("Immunization");
        immunizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                immunizationButtonActionPerformed(evt);
            }
        });

        classroomsButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        classroomsButton1.setText("Classrooms");
        classroomsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classroomsButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentsTileLayout = new javax.swing.GroupLayout(studentsTile);
        studentsTile.setLayout(studentsTileLayout);
        studentsTileLayout.setHorizontalGroup(
            studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentsTileLayout.createSequentialGroup()
                .addGap(0, 213, Short.MAX_VALUE)
                .addGroup(studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classroomsButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(studentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(immunizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(teachersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(279, 279, 279))
        );
        studentsTileLayout.setVerticalGroup(
            studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsTileLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teachersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(studentsTileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classroomsButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(immunizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        homePanel.add(studentsTile);

        dashboardContainer.add(homePanel, "card2");

        jSplitPane1.setRightComponent(dashboardContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void classroomsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classroomsButton1ActionPerformed
        // TODO add your handling code here:
        ClassroomController cpc = new ClassroomController(dashboardContainer, daycare);
        CardLayout layout = (CardLayout) dashboardContainer.getLayout();
        dashboardContainer.add(cpc.getClassroomsPanel());
        layout.next(dashboardContainer);
    }//GEN-LAST:event_classroomsButton1ActionPerformed

    private void immunizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_immunizationButtonActionPerformed
        // TODO add your handling code here:
        VaccinationController imf = new VaccinationController(dashboardContainer, daycare);
        CardLayout layout = (CardLayout) dashboardContainer.getLayout();
        dashboardContainer.add(imf.getImmunizationPanel());
        layout.next(dashboardContainer);
    }//GEN-LAST:event_immunizationButtonActionPerformed

    private void teachersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teachersButtonActionPerformed
        // TODO add your handling code here:
        TeacherRecords tp = new TeacherRecords(dashboardContainer, daycare);
        CardLayout layout = (CardLayout) dashboardContainer.getLayout();
        dashboardContainer.add(tp);
        layout.next(dashboardContainer);
    }//GEN-LAST:event_teachersButtonActionPerformed

    private void studentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsButtonActionPerformed
        // TODO add your handling code here:

        StudentMainController spc = new StudentMainController(dashboardContainer, daycare);
        CardLayout layout = (CardLayout) dashboardContainer.getLayout();
        dashboardContainer.add(spc.getStudentPanel());
        layout.next(dashboardContainer);
    }//GEN-LAST:event_studentsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classroomsButton1;
    private javax.swing.JPanel dashboardContainer;
    private javax.swing.JLabel daycareLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton immunizationButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton studentsButton;
    private javax.swing.JPanel studentsTile;
    private javax.swing.JButton teachersButton;
    // End of variables declaration//GEN-END:variables
}
