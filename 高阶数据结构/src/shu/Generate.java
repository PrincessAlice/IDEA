package shu;

import java.util.Random;

public class Generate {
    public static void main(String[] args) {
        Random random = new Random(20200403);
        for(int i = 0;i<20;i++){
            int r = random.nextInt(200);
            System.out.println(r+"");

        }
        System.out.println();
    }
}
