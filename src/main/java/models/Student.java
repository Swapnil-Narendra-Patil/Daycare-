package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Student extends AbstractIndividual {
    private int age;
    private int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private LocalDate LastRegDate;
    private String motherName;
    private int teacherId;
    private boolean NeedRenew;
    private String parentPhoneNumber;
    private String ageGroupAssigned;
    private String address;
    private LocalDate ExpectReNewDate;
    private int ClassId;
    private String parentEmail;
    private String parentName;
    
    private List<Vaccination> VaxList = new ArrayList<>();


    public Student(String csv) {
        
        //new student
        String[] item = csv.split(",");
        this.id = Integer.parseInt(item[0]);
        this.age = Integer.parseInt(item[1]);
        this.firstName = item[2];
        this.lastName = item[3];
        this.LastRegDate = LocalDate.parse(item[4]);
        this.ExpectReNewDate = LastRegDate.plusYears(1L);
        this.fatherName = item[5];
        this.motherName = item[6];
        this.address = item[7];
        this.parentPhoneNumber = item[8];
        this.NeedRenew = Boolean.parseBoolean(item[9]);
        this.ageGroupAssigned = item[10];

    }

    public Student() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return this.age;
    }


    public void setClassId(int cid) {
        this.ClassId = cid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }
    
    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setTid(int tid) {
        this.teacherId = tid;
    }

    public void addVax(Vaccination v) {
        VaxList.add(v);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public LocalDate getLastRegDate() {
        return LastRegDate;
    }

    public void setLastRegDate(LocalDate LastRegDate) {
        this.LastRegDate = LastRegDate;
    }

    public LocalDate getExpectReNewDate() {
        return ExpectReNewDate;
    }

    public void setExpectReNewDate(LocalDate ExpectReNewDate) {
        this.ExpectReNewDate = ExpectReNewDate;
    }

    public boolean isNeedRenew() {
        return NeedRenew;
    }

    public void setNeedRenew(boolean NeedRenew) {
        this.NeedRenew = NeedRenew;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }
    
    
    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }
    

    public List <String> getVaxCount() {
        // Initiate a list of 6 elements
        // ["Hib", "DTaP", "Polio", "Hepatitis B", "MMR", "Varicella"]
        List<Integer> vaxCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (Vaccination v : VaxList) {
            switch (v.getName()) {
                case "Hib":
                    vaxCount.set(0, vaxCount.get(0) + v.getNoOfDoses());
                    break;
                case "DTaP":
                    vaxCount.set(1, vaxCount.get(1) + v.getNoOfDoses());
                    break;
                case "Polio":
                    vaxCount.set(2, vaxCount.get(2) + v.getNoOfDoses());
                    break;
                case "Hepatitis B":
                    vaxCount.set(3, vaxCount.get(3) + v.getNoOfDoses());
                    break;
                case "MMR":
                    vaxCount.set(4, vaxCount.get(4) + v.getNoOfDoses());
                    break;
                case "Varicella":
                    vaxCount.set(5, vaxCount.get(5) + v.getNoOfDoses());
                    break;
            }
        }
        List <String> vaxCountString = new ArrayList<>();
        // if age less than 24 months, HIB 4 doses, DTaP 4 doses, Polio 3 doses, Hepatitis B 3 doses, MMR 1 doses, Varicella 1 doses
        // if age greater than 24 months, HIB 3 doses, DTaP 4 doses, Polio 4 doses, Hepatitis B 3 doses, MMR 1 doses, Varicella 2 doses
        if (this.age < 24) {
            vaxCountString.add( String.valueOf(vaxCount.get(0)) + "/4");  // "HIB: "
            vaxCountString.add( String.valueOf(vaxCount.get(1)) + "/4");  // "DTaP: "
            vaxCountString.add( String.valueOf(vaxCount.get(2)) + "/3");  // "Polio: "
            vaxCountString.add( String.valueOf(vaxCount.get(3)) + "/3");  // "Hepatitis B:"
            vaxCountString.add( String.valueOf(vaxCount.get(4)) + "/1");  // "MMR: "
            vaxCountString.add( String.valueOf(vaxCount.get(5)) + "/1");  // "Varicella: "
        } else {
            vaxCountString.add( String.valueOf(vaxCount.get(0)) + "/4");  // "HIB: "
            vaxCountString.add( String.valueOf(vaxCount.get(1)) + "/4");  // "DTaP: "
            vaxCountString.add( String.valueOf(vaxCount.get(2)) + "/4");  // "Polio: "
            vaxCountString.add( String.valueOf(vaxCount.get(3)) + "/3");  // "Hepatitis B: "
            vaxCountString.add( String.valueOf(vaxCount.get(4)) + "/2");  // "MMR: "
            vaxCountString.add( String.valueOf(vaxCount.get(5)) + "/2");  // "Varicella: "
        }
        return vaxCountString;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", LastRegDate=" + LastRegDate +
                ", motherName='" + motherName + '\'' +
                ", teacherId=" + teacherId +
                ", NeedRenew=" + NeedRenew +
                ", parentPhoneNumber='" + parentPhoneNumber + '\'' +
                ", ageGroupAssigned='" + ageGroupAssigned + '\'' +
                ", address='" + address + '\'' +
                ", ExpectReNewDate=" + ExpectReNewDate +
                ", ClassId=" + ClassId +
                ", parentEmail='" + parentEmail + '\'' +
                ", parentName='" + parentName + '\'' +
                ", VaxList=" + VaxList +
                '}';
    }

    public String toCSV(){
        return id + "," +
                age + "," +
                firstName + "," +
                lastName + "," +
                LastRegDate.toString() ;
    }


}
