package IO_learning2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {

    @Test
    public void test1(){

    }

    public static void main(String[] args) {
        Person p = new Person("zhangsan",21);
        List<Cloth> cloth = new ArrayList<>();

    }

}

class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }

}

class Cloth{
    private String name;
    private String brand;
    public Cloth(String name,String brand){
        this.name = name;
        this.brand = brand;
    }
}
