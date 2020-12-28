package collections.list;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class linkedlist {
    @Test
    public void linkedlist(){
        LinkedList<String> list=new LinkedList<String>();
        list.add("Steve");
        list.add("Carl");
        list.add("Raj");
        System.out.println(list);
        list.addFirst("Negan");
        System.out.println("Negan adding first "+list);
        list.addLast("Rick");
        System.out.println("Rick adding last "+list);
        list.add(2, "Glenn");
        System.out.println("Glenn adding in second index "+list);
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
