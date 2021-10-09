package Javaconcepts;

class first {
    public static void carstart(){
        System.out.println("Car started");
    }
    public void carstop(){
        System.out.println("Car stopped");
    }
}

class second extends first{

    public static void carstart(){
        System.out.println("Child car start");
    }
    public void carstop(){
        System.out.println("Child car stop");
    }
}

public class demo {
    public static void main(String[] args) {
        first obj1 = new second();
        obj1.carstart();
        obj1.carstop();
//        second obj2 = new second();
//        obj2.carstart();
//        obj2.carstop();

    }
}
