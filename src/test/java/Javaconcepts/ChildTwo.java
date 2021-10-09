package Javaconcepts;

//public class ChildTwo {
public class ChildTwo extends Parent {
    public void csarstart(){
        System.out.println("child two car start");
    }
    @Override
    public void carstop(){
        System.out.println("child two car stop");
    }
}
