
package Controller;

import Utils.Icon;
import models.AbstractIndividual;
import models.Classroom;
import models.Daycare;
import models.Student;
import models.Instructor;
import View.StudentRecords;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class StudentMainController {

    private JPanel container;
    private Daycare daycare;
    public JButton backButton;   
    private StudentRecords panel;

    public JButton addStudentButton;
    
    public JButton deleteButton1;
    public JButton registrationButton;
    public JButton viewStudentButton;
    private JTable studentsTable;
    
    

    private Map<JButton, String> buttonIconMap = new HashMap<>();

    public StudentMainController(JPanel container, Daycare daycare) {
        this.container = container;
        this.daycare = daycare;

        this.panel = new StudentRecords();
        
        this.addStudentButton = panel.addStudentButton;
        this.backButton = panel.backButton;
        this.deleteButton1 = panel.deleteButton1;

        this.registrationButton = panel.registrationButton;
        this.viewStudentButton = panel.viewStudentButton;

        this.studentsTable = panel.studentsTable;

        backButton.addActionListener(l -> {
            goBackToPreviousScreen();
        });

        viewStudentButton.addActionListener(l -> {
            fetchStudentInformation();
        });

        registrationButton.addActionListener(l -> {
            fetchStudentEnrollmentInformation();
        });

        deleteButton1.addActionListener(l -> {
            removeStudents();
        });

        addStudentButton.addActionListener(l -> {
            addNewStudent();
        });

    }

    public JPanel getStudentPanel() {
        setIcons();
        populateTable();
        return panel;
    }

    private void setIcons() {
        Icon imageHelper = new Icon();

        buttonIconMap.put(registrationButton, "/icons/renewal.png");
        buttonIconMap.put(addStudentButton, "/icons/add-user.png");
        buttonIconMap.put(backButton, "/icons/previous.png");
        buttonIconMap.put(deleteButton1, "/icons/delete.png");
        buttonIconMap.put(viewStudentButton, "/icons/update.png");

        for (Map.Entry<JButton, String> button : buttonIconMap.entrySet()) {
            imageHelper.setIcon(button.getValue(), button.getKey());
        }
    }

    public void populateTable() {
        studentsTable.setAutoCreateRowSorter(true);
        DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
        model.setRowCount(0);

        for (AbstractIndividual student : daycare.getStudentList()) {
            Object[] row = new Object[12];
            Student s = (Student) student;
            row[0] = s.getId();
            row[1] = s.getAge();
            row[2] = s.getFirstName();
            row[3] = s.getLastName();
            row[4] = s.getFatherName();
            row[5] = s.getMotherName();
            row[6] = s.getAddress();
            row[7] = s.getParentPhoneNumber();
            row[8] = String.valueOf(s.isNeedRenew());
            row[9] = s.getLastRegDate();
            row[10] = s.getExpectReNewDate();
            row[11] = s.getTeacherId();
            model.addRow(row);
        }
    }

    private void goBackToPreviousScreen() {
        container.remove(panel);
        CardLayout layout = (CardLayout) container.getLayout();
        
        layout.previous(container);
        
    }

    private void fetchStudentInformation() {
        int selectedRow = studentsTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }

        int studentId = (int) studentsTable.getValueAt(selectedRow, 0);
        AbstractIndividual selectedStudent = daycare.getStudentObjById(studentId);
        if (selectedStudent != null) {
            StudentDetailsController sdc = new StudentDetailsController(container, selectedStudent, daycare, this);
            CardLayout layout = (CardLayout) container.getLayout();
            container.add(sdc.fetchStudentDetailsPanel());
            layout.next(container);
        }
    }

    private void fetchStudentEnrollmentInformation() {
        RenewalTrackingController rsc = new RenewalTrackingController(container, daycare, this);
       
        CardLayout layout = (CardLayout) container.getLayout();
         container.add(rsc.getRenewalTrackingPanel());
        layout.next(container);
    }


    private void removeStudents() {
        int selectedRow = studentsTable.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }

        int studentId = (int) studentsTable.getValueAt(selectedRow, 0);
        int teacherId = (int) studentsTable.getValueAt(selectedRow, 11);

        try {
            daycare.deleteStudentObjById(studentId);

            for (Classroom room : daycare.getClassroomList()) {
                for (Instructor t : room.getTeacherList()) {
                    if (t.getId() == teacherId) {
                        t.deleteStudentById(studentId);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        populateTable();
        JOptionPane.showMessageDialog(panel,
                "Student deleted.");
    }

    private void addNewStudent() {
        NewStudentController asc = new NewStudentController(container, daycare, this);
       
        CardLayout layout = (CardLayout) container.getLayout();
         container.add(asc.fetchStudentPanel());
        layout.next(container);
    }
}
