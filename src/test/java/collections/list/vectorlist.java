package collections.list;

import java.util.Enumeration;
import java.util.Vector;

public class vectorlist {
    public static void main(String args[]) {
        /* Vector of initial capacity(size) of 2 */
        Vector<String> vec = new Vector<String>(2);
        System.out.println("Size before adding is: "+vec.size());
        System.out.println("Default capacity is: "+vec.capacity());
        /* Adding elements to a vector*/
        vec.addElement("Apple");
        System.out.println("Size after adding 1 is: "+vec.size());
        System.out.println("Default capacity after adding 1 is: "+vec.capacity());
        vec.addElement("Orange");
        vec.addElement("Mango");
        System.out.println("Default capacity adding 3rd is: "+vec.capacity());
        vec.addElement("Fig");
        vec.add("Next");
        vec.insertElementAt("Banana",1);

        /* check size and capacityIncrement*/
        System.out.println("Size is: "+vec.size());
        System.out.println("Default capacity increment is: "+vec.capacity());

        vec.addElement("fruit1");
        vec.addElement("fruit2");
        vec.addElement("fruit3");

        /*size and capacityIncrement after two insertions*/
        System.out.println("Size after addition: "+vec.size());
        System.out.println("Capacity after increment is: "+vec.capacity());

        /*Display Vector elements*/
        Enumeration en = vec.elements();
        System.out.println("\nElements are:");
        while(en.hasMoreElements())
            System.out.print(en.nextElement() + " ");
    }
}
