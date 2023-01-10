package models;

public class ClassroomLazySingletonFactory extends AbstractFactory{
    private ClassroomLazySingletonFactory(){

    }
    private static ClassroomLazySingletonFactory instance = null;
    public static ClassroomLazySingletonFactory getInstance(){
        if(instance == null){
            instance = new ClassroomLazySingletonFactory();
        }
        return instance;
    }

    public Classroom getObject(int cid,int low,int high, int size, int number){
        return new Classroom(cid,low,high,size,number);
    }

}
