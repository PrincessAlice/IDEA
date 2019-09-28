package String类型;

public class StringDEMO {
    public static void main(String[] args) {
        String s = "hello";
        String t =s.toUpperCase();
        String r = s.substring(1,3);
        System.out.println(t);
        System.out.println(r);
        System.out.println(s == t);
        System.out.println(s == r);
    }
}
