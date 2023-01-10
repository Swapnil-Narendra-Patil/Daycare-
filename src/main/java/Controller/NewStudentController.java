
package Controller;

import models.Daycare;
import models.Student;
import models.StudentLazySingletonFactory;
import View.NewStudent;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;
import java.text.SimpleDateFormat;


public class NewStudentController {

    JPanel container;
    private Daycare daycare;
    private StudentMainController prevController;

    private NewStudent panel;
    
    public javax.swing.JTextField id;
    public javax.swing.JTextField lastName;
    public javax.swing.JTextField firstName;
    public javax.swing.JButton addStudentButton;
    public javax.swing.JTextField age;
    public javax.swing.JButton backButton;
    public javax.swing.JTextField fatherName;
    public javax.swing.JTextField motherName;
    public javax.swing.JTextField registrationDate;
    public javax.swing.JTextField address;
    public javax.swing.JTextField phoneNumber;
    public javax.swing.JComboBox ageGroupAssigned;
    


    public NewStudentController(JPanel container, Daycare daycare, StudentMainController prevController) {
        this.container = container;
        this.daycare = daycare;
        this.prevController = prevController;

        this.panel = new NewStudent(); //here the panel has access to all the text fields

        this.addStudentButton = panel.addStudentButton;
        this.phoneNumber = panel.phoneNumberValue;
        this.age = panel.ageValue;
        this.backButton = panel.backButton;
        this.address = panel.addressValue;
        this.firstName = panel.studentLastNameValue;
        this.lastName = panel.studentFirstNameValue;
        this.fatherName = panel.fatherNameValue;
        this.ageGroupAssigned = panel.ageGroupAssignedValue;
        this.motherName = panel.motherNameValue;
        this.id = panel.idValue;
        this.registrationDate = panel.enrolledOn;
        
        

        backButton.addActionListener(l -> {
            goBackHandler();
        });

        addStudentButton.addActionListener(l -> {
            addStudentToSchool();
        });

    }
    
    private void goBackHandler() {
         container.remove(panel); 
        CardLayout layout = (CardLayout) container.getLayout();
       
        layout.previous(container);
        
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        prevController.populateTable();
    }

    public NewStudent fetchStudentPanel() {
        panel.idValue.setText(String.valueOf(daycare.getStudentList().size()+1));
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        panel.enrolledOn.setText(date);
        return panel;
    }

    

    private void addStudentToSchool() {
        String idField = id.getText();
        String lastNameField = lastName.getText();
        String enrolledOnField = registrationDate.getText();
        String ageField = age.getText();
        String firstNameField = firstName.getText();
        String fatherNameField = fatherName.getText();
        String motherNameField = motherName.getText();
        String ageGroupAssigedField =  ageGroupAssigned.getSelectedItem().toString();
        String addressField = address.getText();
        String phoneNumberField = phoneNumber.getText();
        

//1,6,Mike,John,2022-11-20,John Snow,Rihanna,90 Parker Street,1234567890,false,6-12months
        if (firstNameField.equals("") || lastNameField.equals("") || idField.equals("") || ageField.equals("") || enrolledOnField.equals("") 
                || addressField.equals("")|| phoneNumberField.equals("") || fatherNameField.equals("")|| motherNameField.equals("")) {
            JOptionPane.showMessageDialog(panel,
                    "Please fill all the required fields",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String stringObject = idField + "," + ageField + "," + firstNameField + "," + lastNameField + "," + enrolledOnField + "," + fatherNameField + "," + motherNameField + "," + addressField +  "," + phoneNumberField + ",false," + ageGroupAssigedField ;

        try {
            Student studentObj = StudentLazySingletonFactory.getInstance().getObject(stringObject);
            daycare.addToDaycare(studentObj);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel,
                    "Error. Unable to create the student",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(panel, "Student successfully added.");
    }

}
