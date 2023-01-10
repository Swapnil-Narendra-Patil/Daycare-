package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vaccination {

    private List<LocalDate> DoesDate = new ArrayList<>();
    private String Name;
    private LocalDate nextDoseDate;
    private LocalDate lastDoseDate;
    private int studentId;
    private int noOfDoses;

    public Vaccination(String csv) {

        String[] item = csv.split(",");

        try {
            this.studentId = Integer.parseInt(item[0]);
            this.Name = item[1];
            this.noOfDoses = Integer.parseInt(item[2]);
            this.lastDoseDate = LocalDate.parse(item[3]);
            this.nextDoseDate = LocalDate.parse(item[4]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Unable to parse vaccine info");
        }

        for (int i = 3; i < item.length; i++) {
            DoesDate.add(LocalDate.parse(item[i]));
        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<LocalDate> getDoesDate() {
        return DoesDate;
    }

    public void setDoesDate(List<LocalDate> DoesDate) {
        this.DoesDate = DoesDate;
    }

    public LocalDate getLastDoseDate() {
        return lastDoseDate;
    }

    public void setLastDoseDate(LocalDate lastDoseDate) {
        this.lastDoseDate = lastDoseDate;
    }

    public LocalDate getNextDoseDate() {
        return nextDoseDate;
    }

    public void setNextDoseDate(LocalDate nextDoseDate) {
        this.nextDoseDate = nextDoseDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNoOfDoses() {
        return noOfDoses;
    }

    public void setNoOfDoses(int noOfDoses) {
        this.noOfDoses = noOfDoses;
    }
    
    

    @Override
    public String toString() {
        return "Vax{" + Name
                + "DoesDate=" + DoesDate
                + '}';
    }
}
