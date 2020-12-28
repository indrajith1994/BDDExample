package collections.set;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class hashset {
    @Test
    public void hashset(){
        HashSet<String> hset = new HashSet<String>();
        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        System.out.println(hset);
        hset.add("Apple");
        hset.add("Mango");
        System.out.println(hset);
//        hset.add(null);
        hset.add(null);
        System.out.println(hset);
        Iterator<String> it = hset.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        hset.remove(null);
        for (String temp : hset) {
            System.out.println(temp);
        }

        Set<String> tset = new TreeSet<String>(hset);

        // Displaying TreeSet elements
        System.out.println("TreeSet contains: ");
        for(String temp : tset){
            System.out.println(temp);
        }
    }
}
