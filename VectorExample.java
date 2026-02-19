package batch60;


import java.util.Vector;
import java.util.Enumeration;

public class VectorExample {

    public static void main(String[] args) {
        Vector<String> names = new Vector<>();
        names.add("Minakshi");
        names.add("Gouri");
        names.add("Kalyani");
        names.add("Sayali");

        System.out.println("names: " + names);

        names.add(2, "Priya");
        System.out.println("After addind" + names);

        System.out.println("get name at index" + names.get(3));

        System.out.println("Size: " + names.size());
        System.out.println("Capacity: " + names.capacity());

        names.set(1, "Gouri Updated");
        System.out.println("After Update: " + names);

        System.out.println("check presence" + names.contains("Kalyani"));

        names.remove("Sayali");
        names.remove(2);

        System.out.println("After Removing: " + names);

        System.out.println("First Element: " + names.firstElement());
        System.out.println("Last Element: " + names.lastElement());

        System.out.println("ckeck empty: " + names.isEmpty());

        Enumeration<String> en = names.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }

        names.clear();
        System.out.println("After Clear(): " + names);
        System.out.println("Is Empty: " + names.isEmpty());
    }
}

