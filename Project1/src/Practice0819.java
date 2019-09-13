import java.util.ArrayList;
import java.util.LinkedList;

class Person{}
class Bird{}
public class Practice0819 {
    public static void main(String[] args) {
        ArrayList<String>list1 = new ArrayList<>();
        ArrayList<Person>list2 = new ArrayList<>();
        ArrayList<Bird>list3 = new ArrayList<>();
        System.out.println(list1 instanceof ArrayList);
        System.out.println(list2 instanceof ArrayList);
        System.out.println(list3 instanceof ArrayList);

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println(list3.getClass());
    }
}
