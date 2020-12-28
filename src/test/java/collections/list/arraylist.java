package collections.list;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class arraylist {
    @Test
    public void arraylist(){
        ArrayList<String> alist=new ArrayList<String>();
        alist.add("Steve");
        alist.add("Tim");
        alist.add("Lucy");
        alist.add("Pat");
        alist.add("Angel");
        System.out.println("Array list in normal added manner");
        System.out.println(alist);
        alist.add(3, "Steve");
        System.out.println("New data 'Steve' added in 3rd index starting from 0th index");
        System.out.println(alist);
        alist.set(0, "Buck");
        System.out.println("Oth index data 'Steve' replaced with new data 'Buck'");
        System.out.println(alist);
        alist.remove("Tim");
        System.out.println("Remove 'Tim' specific data from the array");
        System.out.println(alist);
        alist.remove(2);
        System.out.println("Remove 2nd index data 'Steve' from the array");
        System.out.println(alist);
        System.out.println("iterating ArrayList");
        for(String str:alist)
            System.out.println(str);
        System.out.println("Size of array list is :"+alist.size());
        Collections.sort(alist);

        for (String str : alist) {
            System.out.println(str);
        }
        ArrayList<Integer> arylst = new ArrayList<Integer>();
        arylst.add(40);
        arylst.add(43);
        arylst.add(41);
        arylst.add(12);
        arylst.add(53);
        System.out.println(arylst);
        Collections.sort(arylst);
        System.out.println(arylst);
        arylst.add(23);
        System.out.println(arylst);
        Collections.sort(arylst, Collections.reverseOrder());
        System.out.println(arylst);
        for(int list : arylst){
            System.out.println("for each loop"+arylst);
            System.out.println(list);
        }
        Iterator it = arylst.iterator();

        while(it.hasNext()) {
            Integer obj = (Integer) it.next();
            System.out.println(obj);
        }
        int arr[]=new int[3];
        for (int lst : arr) {
            System.out.println(lst);
        }

    }

}
