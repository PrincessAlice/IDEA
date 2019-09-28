package Exception异常;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//学生类，根据不同专业统计男女人数
 // 0 男  1 女


public class StuMethod {
    String major;
    int gender;

    StuMethod(String major,int gender){
        this.major = major;
        this.gender = gender;
    }

    //数组方法
   // public static int[] statistics(Student[] students,String major){
   // }

    //HashMap 法
    public static void main(String[] args) {
        String[] majors = {"计算机","数学","信息科学","金融"};
        StuMethod[] students = new StuMethod[1000];
        Random majorRandom = new Random(20190921);
        Random genderRandom = new Random(20190921);
        for(int i = 0;i < 1000;i++){
            int m = majorRandom.nextInt(5);
            int g = genderRandom.nextInt(2);
            students[i] = new StuMethod(majors[m],g);
        }

        Map<String,int[]>counts = new HashMap<>();
        for(String major:majors){
            counts.put(major,new int[2]);
        }
        for(StuMethod stuMethod : students){
            counts.get(stuMethod.major)[stuMethod.gender]++;
        }
        for(Map.Entry<String,int[]> e :counts.entrySet()){
            String major = e.getKey();
            int[] cnt = e.getValue();
            System.out.printf("专业: %s, 男生: %d, 女生: %d%n",major, cnt[0], cnt[1]);
        }
    }
}
