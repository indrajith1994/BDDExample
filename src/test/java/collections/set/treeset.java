package collections.set;

import org.testng.annotations.Test;

import java.util.TreeSet;

public class treeset {
    @Test
    public void treeset(){
    	//change here
        TreeSet<String> tset = new TreeSet<String>();
        tset.add("ABC");
        tset.add("String");
        tset.add("Test");
        tset.add("Pen");
        tset.add("Ink");
        tset.add("Jack");
        tset.add("Pen");

        //Displaying TreeSet
        System.out.println(tset);

        // TreeSet of Integer Type
        TreeSet<Integer> tset2 = new TreeSet<Integer>();

        // Adding elements to TreeSet<Integer>
        tset2.add(88);
        tset2.add(7);
        tset2.add(101);
        tset2.add(0);
        tset2.add(3);
        tset2.add(222);
        System.out.println(tset2);
    }
}
