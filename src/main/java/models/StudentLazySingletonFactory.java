package models;

public class StudentLazySingletonFactory extends AbstractFactory{
    private static StudentLazySingletonFactory instance = null;
    public static StudentLazySingletonFactory getInstance(){
        if(instance == null){
            instance = new StudentLazySingletonFactory();
        }
        return instance;
    }

    public Student getObject(String csv){
        return new Student(csv);     
    }

}
