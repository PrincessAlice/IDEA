package view;

import java.util.Arrays;

//枚举
enum Week {
    one(1),two(2),three(3),four(4),five(5),six(6),seven(7);

    private int day;
    Week(int day){
        this.day = day;
    }

    public void print(){
        System.out.println(day);
    }
}

enum Gender{
    FEMALE,MALE
}

public class EnumDemo {
    public static void main(String[] args) {
        Gender gender = Gender.FEMALE;
        System.out.println(gender);
        System.out.println(Arrays.toString(Gender.values()));
        Gender g = Gender.valueOf("FEMALE");
        System.out.println(g);
        Gender.valueOf("FEMALE");
        System.out.println("==============================");
        Week week = Week.one;
        week.print();


    }
}
