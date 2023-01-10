package models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private int size;
    private int id;
    private List<Instructor> TeacherList = new ArrayList<>();
    private int number;
    private int count;
    private int[] AgeRange = new int[2];

    public Classroom(int id, int low,int high,int size, int number){
        this.id = id;
        this.AgeRange[0] = low;
        this.AgeRange[1] = high;
        this.size = size;
        this.number=number;
    }

    public int getNumber() {
        return this.number;
    }
    
    public int getCount(){
        return this.count;
    }

    public int[] getAgeRange(){
        return this.AgeRange;
    }

    public int getSize(){
        return this.size;
    }
    public int getId(){
        return this.id;
    }

    public void addTeacher(Instructor t){
        TeacherList.add(t);
        count++;
    }
    
    public boolean inRange(int age){
        return this.AgeRange[0]<=age && age<this.AgeRange[1];
    }

    public boolean isEmpty(){
        return this.count < this.size;
    }

    public List<Instructor> getTeacherList(){
        return  this.TeacherList;
    }
    
     public void showTeachers(){
        if(!TeacherList.isEmpty()){
            for (Instructor teacherObj: TeacherList){
                teacherObj.showStudents();
                System.out.println(teacherObj.getId());
            }
        }

    }

    public void setAgeRange(int low, int high){
        AgeRange[0] = low;
        AgeRange[1] = high;
    }

}
