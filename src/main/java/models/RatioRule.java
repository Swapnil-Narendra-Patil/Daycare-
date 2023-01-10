package models;

public class RatioRule {
    private int low;
    private int high;
    private int GroupSize;
    private int ClassroomSize;

    public RatioRule(String csv){
        String[] item = csv.split(",");
        low = Integer.parseInt(item[0]);
        high = Integer.parseInt(item[1]);
        GroupSize = Integer.parseInt(item[2]);
        ClassroomSize = Integer.parseInt(item[3]);
    }
    
    public int getGroupSize(){return GroupSize;}
    public int getClassroomSize(){return ClassroomSize;}
    public int getLow(){return low;}
    public int getHigh(){return  high;}
    public boolean inRange(int age){
        return (low<=age && age < high);
    }
    public int getNumber(){return GroupSize;}   
}
