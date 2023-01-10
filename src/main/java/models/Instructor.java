package models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Instructor extends AbstractIndividual {

    private int id;
    private int age;
    //private String Name;
    private String LastName;
    private String FirstName;
    private int Wage;
    private int ClassroomId;
    private LocalDate ReviewDate;
    private long ReviewInDays;
    private LocalDate NextReviewDate;
    private int LastReviewScore = 0;
    private List<Student> StudentList = new ArrayList<>();
    private int count = 0;
    private int size;

    public Instructor(String TeacherCSVString, int tId, int size, int cId){
        this.id = tId;
        this.size = size;
        this.ClassroomId = cId;

        String[] item = TeacherCSVString.split(",");
        this.FirstName = item[0];
        this.LastName = item[1];
        this.age = Integer.parseInt(item[2]);
        this.ReviewDate = LocalDate.parse(item[3]);
        // Calculate Review in days based on current date
        this.Wage = Integer.parseInt(item[4]);
        this.LastReviewScore = Integer.parseInt(item[5]);
        this.NextReviewDate = ReviewDate.plusDays(365);
        this.ReviewInDays = Duration.between(LocalDate.now().atStartOfDay(), NextReviewDate.atStartOfDay()).toDays(); // another option
        
    }


    public Instructor(int id, int size, String firstName, String lastName, int age, int wage, int cid, String reviewDate ){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.NextReviewDate = ReviewDate.plusDays(365);
        this.id = id;
        this.size = size;
        this.age = age;
        //Random r = new Random();
        this.Wage = wage;
        this.ClassroomId = cid;
        this.ReviewInDays = Duration.between(LocalDate.now().atStartOfDay(), ReviewDate.atStartOfDay()).toDays();

        this.ReviewDate = LocalDate.parse(reviewDate);
        // Calculate Review in days based on current date
        
        // Duration.
//        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        // Print Review Date
        System.out.println(this.ReviewDate + " " + this.FirstName + " " + this.LastName + " " + reviewDate);

    }

    public long getReviewInDays() {
        return ReviewInDays;
    }
    
    public void setNextReviewDate(LocalDate nextReviewDate) {
        NextReviewDate = nextReviewDate;
    }
    
    public void setReviewInDays(long reviewInDays) {
        ReviewInDays = reviewInDays;
    }

    public LocalDate getNextReviewDate() {
        System.out.println(NextReviewDate);
        System.out.println(ReviewDate.plusDays(365));
        return NextReviewDate;
    }


    public void setLastReviewScore(int lastReviewScore) {
        LastReviewScore = lastReviewScore;
    }
    
    public int getLastReviewScore() {
        return LastReviewScore;
    }

    @Override
    public void setId(int id) {
        // TODO Auto-generated method stub
        this.id = id;
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }

    public void setClassroomId(int id){
        this.ClassroomId = id;
    }
    
    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        return this.age;
    }
    
    @Override
    public void setAge(int age) {
        // TODO Auto-generated method stub

    }

    public LocalDate getReviewDate(){
        return this.ReviewDate;
    }

    @Override
    public String getFirstName() {
        return this.FirstName;
    }

    @Override
    public String getLastName() {
        return this.LastName;
    }

    public void deleteStudentById(int id){                
        List<Student> students = StudentList
            .stream()
            .filter(i -> i.getId()!=id)            
            .collect(toList());
        
        this.StudentList = students;        
    }

    public int getWage(){return this.Wage;}

    public void addStudent(Student s){
        StudentList.add(s);
        s.setTid(this.id);
        count++;
    }

    public boolean isEmpty(){
        return count < size;
    }

    public List<Student> getStudentList() {
        return StudentList;
    }
    
    public void showStudents(){
        if(!StudentList.isEmpty()){
            for (Student s: StudentList){
                System.out.println(s.getFirstName());
            }

        }

    }

    public void setStudentList(List<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public int getCount() {
        return count;
    }

    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public int getClassroomId() {
        return ClassroomId;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public void setWage(int Wage) {
        this.Wage = Wage;
    }

    public void setReviewDate(LocalDate ReviewDate) {
        this.ReviewDate = ReviewDate;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Id=" + id + ", Age=" + age + ", LastName=" + LastName + ", FirstName=" + FirstName + ", Wage=" + Wage + ", count=" + count + ", size=" + size + '}';
    }
    
    
}

