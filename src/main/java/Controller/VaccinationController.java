
package Controller;

import models.AbstractIndividual;
import models.Daycare;
import models.Student;
import View.VaccinationDetails;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class VaccinationController {

    private JPanel container;
    private Daycare daycare;

    private VaccinationDetails panel;

    private javax.swing.JButton backButton;
    public javax.swing.JTable vaxTable;

    public VaccinationController(JPanel container, Daycare daycare) {
        this.container = container;
        this.daycare = daycare;

        this.panel = new VaccinationDetails();
        this.backButton = panel.backButton;
//        this.immuTable = panel.immuTable;
        this.vaxTable = panel.StudentVaxTable;

        backButton.addActionListener(l -> {
            goBack();
        });

    }

    public VaccinationDetails getImmunizationPanel() {
        setTable();
        return panel;
    }

    public void setTable() {


        vaxTable.setAutoCreateRowSorter(true);
        DefaultTableModel vaxTableModel = (DefaultTableModel) vaxTable.getModel();
        vaxTableModel.setRowCount(0);
        for (AbstractIndividual student : daycare.getStudentList()) {
            Object[] row = new Object[9];
            Student s = (Student) student;
            row[0] = s.getId();
            row[1] = student.getFirstName() + " " + s.getLastName();
            row[2] = student.getAge();
            List<String> VaxCount = ((Student) student).getVaxCount();
            // ["Hib", "DTaP", "Polio", "Hepatitis B", "MMR", "Varicella"]
            row[3] = VaxCount.get(0); // "Hib"
            row[4] = VaxCount.get(1); // "DTaP"
            row[5] = VaxCount.get(2); // "Polio"
            row[6] = VaxCount.get(3); // "Hepatitis B"
            row[7] = VaxCount.get(4); // "MMR"
            row[8] = VaxCount.get(5); // "Varicella"
            vaxTableModel.addRow(row);
        }
        
    
    }

    private void goBack() {
        container.remove(panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }

}
