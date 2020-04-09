import java.util.HashSet;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private  int gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                gender == person.gender &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    public static void main(String[] args) {
        HashMap<Person,Integer> map = new HashMap<>();
        Person p1 = new Person();
        p1.name ="你好";
        p1.age = 18;
        p1.gender = 1;
        Person p2 = new Person();
        p2.name = "我爱你";
        p2.age = 19;
        p2.gender =1;
        map.put(p1,108);
        //因为上面覆写了hashCode()和equals,下面代码才正常工作
        //返回108，否则就是返回null
        System.out.println(map.get(p2));
        HashSet<Person>set = new HashSet<>();
        set.add(p1);
    }
}
