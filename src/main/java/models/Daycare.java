package models;

import Utils.ConversionUtil;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Daycare {
    
    
    private int cid;
    private int tid;
    
    private List<Classroom> ClassroomList = new ArrayList<>();
    
    private List<RatioRule> ratioRules = new ArrayList<>();
    private List<Student> StudentList = new ArrayList<>();
    
    private List<Student> StudentListIsRenewFalse = new ArrayList<>();
    private List<AbstractIndividual> TeacherList = new ArrayList<>();
    private List<String> TeacherCSVList = new ArrayList<>();
    private List<Student> StudentListIsRenewTrue = new ArrayList<>();


    public Daycare() {

        tid = 0;
        cid = 0;

    }
    
    public void addRatioRule(RatioRule r){
        ratioRules.add(r);
    }

    public void addToDaycare(Student s){
        StudentList.add(s);

        addNewStudentToClass(s);

    }
    
    private void addNewStudentToClass(Student studentObj){
        if (ClassroomList.isEmpty()){
            for (RatioRule ratioObj:ratioRules){
                if (ratioObj.inRange(studentObj.getAge())){
                    Classroom classRoomObj = ClassroomLazySingletonFactory.getInstance().getObject(cid++,ratioObj.getLow(),ratioObj.getHigh(), ratioObj.getClassroomSize(), ratioObj.getNumber());
                    Instructor teacherObj = getNextTeacherObj(ratioObj.getGroupSize(),classRoomObj.getId());
                    studentObj.setClassId(classRoomObj.getId());
                    teacherObj.addStudent(studentObj);
                    classRoomObj.addTeacher(teacherObj);
                    for(int i = 0; i < ratioObj.getClassroomSize()-1; i++){
                        classRoomObj.addTeacher(getNextTeacherObj(ratioObj.getGroupSize(),classRoomObj.getId()));
                    }
                    ClassroomList.add(classRoomObj);
                    return;

                }
            }
        }

        for(Classroom classRoomObj : ClassroomList){
            // Iterates through the list of ClassRooms
            if (classRoomObj.inRange(studentObj.getAge())){
                // For each Teacher in ClassRoom
                for(Instructor teacherObj:classRoomObj.getTeacherList()){
                    if(teacherObj.isEmpty()){
                        // if teacher has space, assign
                        studentObj.setClassId(classRoomObj.getId());
                        teacherObj.addStudent(studentObj);
                        return;
                    }

                }
            }

        }

        // For case when no classRoom exists
        for (RatioRule ratioObj:ratioRules){
            if (ratioObj.inRange(studentObj.getAge())){
                Classroom classRoomObj = ClassroomLazySingletonFactory.getInstance().getObject(cid++,ratioObj.getLow(),ratioObj.getHigh(),ratioObj.getClassroomSize(), ratioObj.getNumber());
                Instructor teacherObj = getNextTeacherObj(ratioObj.getGroupSize(),classRoomObj.getId());
                studentObj.setClassId(classRoomObj.getId());
                teacherObj.addStudent(studentObj);
                classRoomObj.addTeacher(teacherObj);
                for(int i = 0; i < ratioObj.getClassroomSize()-1; i++){
                    classRoomObj.addTeacher(getNextTeacherObj(ratioObj.getGroupSize(),classRoomObj.getId()));

                }
                ClassroomList.add(classRoomObj);

            }
        }

    }
    
    public Instructor getNextTeacherObj(int size, int cid){
        return new Instructor(TeacherCSVList.get(tid), tid++, size, cid);
    }

    public void addAllStudentObjectsToCSV(){
        List<String> CSVListObj = new ArrayList<>();        
        for (Student studentObj : StudentList) {
            CSVListObj.add(studentObj.toCSV());
        }        
        ConversionUtil.writingCSVFile(CSVListObj, "Student.txt");
    }
    
    public AbstractIndividual getStudentObjById(int id) {
        for(AbstractIndividual person : StudentList) {
            if(person.getId() == id)
                return person;
        }
        return null;
    }
     

   
    public void deleteStudentObjById(int studentId) {
        
        List<Student> studentsListObj = StudentList
            .stream()
            .filter(i -> i.getId()!=studentId)            
            .collect(toList());
        
        this.StudentList = studentsListObj;        
    }
    
    

    public List<Student> getStudentList(){
        return StudentList;
    }

    public List<Classroom> getClassroomList() {
        return ClassroomList;
    }

    public void showAll(){
        for (Classroom c: ClassroomList){
            c.showTeachers();
        }
    }

    
    public void setTeacherCSVList(List<String> teacherCSVList) {
        TeacherCSVList = teacherCSVList;
    }

    
    public List<Student> getStudentListwithIsNeedRenewTrue(){
       StudentListIsRenewTrue.clear();
       for(Student s: StudentList){
           if(s.isNeedRenew() == true)
               StudentListIsRenewTrue.add(s);
       }
        return StudentListIsRenewTrue;
    }

    public List<Student> getStudentListwithIsNeedRenewFalse(){
       StudentListIsRenewFalse.clear();
       for(Student s: StudentList){
           if(s.isNeedRenew() == false)
               StudentListIsRenewFalse.add(s);
       }
        return StudentListIsRenewFalse;
    }

    
    
   
   
}
