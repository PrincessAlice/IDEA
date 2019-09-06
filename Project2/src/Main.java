import java.util.*;

public class Main {
    private static void swap(ArrayList<PokeCard>list,int i,int j){
        PokeCard temp1 = list.get(i);
        PokeCard temp2 = list.get(j);
        list.set(i,temp2);
        list.set(j,temp1);
    }

    public static void main(String[] args) {
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] colors = {"♥", "♦", "♣", "♠"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                PokeCard card = new PokeCard(colors[i], j);
                cards.add(card);
            }
        }
        System.out.println(cards);
        System.out.println("*********************************************************");

        //洗牌
        Random random = new Random(20190820); //随机数洗牌，种子固定
        for (int i = 51; i > 0; i--) {       //bound为[0,51),
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        System.out.println(cards);
        System.out.println("*********************************************************");

        //有4个人，每个人抽5张牌
        ArrayList<PokeCard> A = new ArrayList<>();
        ArrayList<PokeCard> B = new ArrayList<>();
        ArrayList<PokeCard> C = new ArrayList<>();
        ArrayList<PokeCard> D = new ArrayList<>();

        System.out.println(cards.subList(52-20,52));//打印[32,52]之间的20个数
        for(int i=0;i<20;i++){
            PokeCard card = cards.remove(cards.size()-1); //尾删
            switch(i%4){
                case 0: A.add(card);break;
                case 1: B.add(card);break;
                case 2: C.add(card);break;
                case 3: D.add(card);break;
            }
        }
        System.out.println(cards.size());
        System.out.println("*********************************************************");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);

        //A抓到手心里的牌中，有没有[红心A]
        PokeCard heartA = new PokeCard("♥",6);
        //判断对象是否相等，需自定义类equals 来进行判断
        for(PokeCard card:A){
            if(card.equals(heartA)){            //遍历判断A的card是不是【6，♥】
                System.out.println("包含");
            }else{
                System.out.println("不包含");
            }
        }
            if(A.contains(heartA)){
                System.out.println("包含");
            }else{
                System.out.println("不包含");
            }

        //迭代器
        System.out.println(A);
        Iterator<PokeCard>it = A.iterator();
        while(it.hasNext()){            //判断下一个有没有元素
            PokeCard o = it.next();
            if(o.equals(heartA)){
                it.remove();
            }
        }
        System.out.println("*********************************************************");
        System.out.println(A);

        /*
        * System.out.println(A);
        * for(PockCard o:A){
        *   if(o.equals(heartA)){
        *       A.remove();
        *   }
        * }
        * System.out.println(A);
        * */

        Iterator<PokeCard> it1 = A.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
        ListIterator<PokeCard> it2 = A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());
    }

}
