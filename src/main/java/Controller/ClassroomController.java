
package Controller;

import models.Classroom;
import models.Daycare;
import View.DaycareClassrooms;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Instructor;

public class ClassroomController {

    private JPanel container;
    private Daycare daycare;

    private DaycareClassrooms panel;

    private JButton backButton;
    private JTable classroomsTable;

    
    private PanelInfo p1;
    private PanelInfo p2;
    private PanelInfo p3;
    private PanelInfo p4;
    private PanelInfo p5;
    private PanelInfo p6;
    
    public static class PanelInfo{
        private JTable table;
        
        
        public PanelInfo(JTable t){
            table = t;
        }
        
        public void fillClassroomIntoPanel(Classroom classRoomObj){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            Object[] row1 = new Object[2];
            Object[] row2 = new Object[2];
            Object[] row3 = new Object[2];
            Object[] row4 = new Object[2];
            row1[0] = "Max No. of Groups";
            row1[1] = classRoomObj.getNumber();
            int[] rangeArr = classRoomObj.getAgeRange();
            row2[0] = "Range";
            row2[1] = rangeArr[0] + " - " + rangeArr[1];
            row3[0] = "Size of Group";
            row3[1] = classRoomObj.getNumber();
            row4[0] = "Number of Students";
            int count = 0;
            for(Instructor teacher
                    : classRoomObj.getTeacherList()){
                count += teacher.getCount();
            }
            row4[1] = count;
            model.addRow(row1);
            model.addRow(row2);
            model.addRow(row3);
            model.addRow(row4);
        }
        
    }
    

    public ClassroomController(JPanel container, Daycare daycare) {
        this.container = container;
        this.daycare = daycare;

        this.panel = new DaycareClassrooms();

        this.backButton = panel.backButton;


        backButton.addActionListener(l -> {
            goBack();
        });



    }

    public DaycareClassrooms getClassroomsPanel() {

        displayClassrooms();
        return panel;
    }
    
    
    
    public void displayClassrooms(){
        List<Classroom> classRoomList = daycare.getClassroomList();
        p1 = new PanelInfo(panel.jTable1);
        p1.fillClassroomIntoPanel(classRoomList.get(0));
        
        p2 = new PanelInfo(panel.jTable2);
        p2.fillClassroomIntoPanel(classRoomList.get(1));
        
        p3 = new PanelInfo(panel.jTable3);
        p3.fillClassroomIntoPanel(classRoomList.get(2));
        
        p4 = new PanelInfo(panel.jTable4);
        p4.fillClassroomIntoPanel(classRoomList.get(3));
        
        p5 = new PanelInfo(panel.jTable5);
        p5.fillClassroomIntoPanel(classRoomList.get(4));
//        
        p6 = new PanelInfo(panel.jTable6);
        p6.fillClassroomIntoPanel(classRoomList.get(5));

    }

    private void goBack() {
        container.remove(panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }

}
