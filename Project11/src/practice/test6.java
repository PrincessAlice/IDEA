package practice;

//打印乘法口诀表
public class test6 {
    public static void main(String[] args) {
        for(int i =1; i<10;i++){ //控制行数
            for(int j = i;j<10;j++){  //控制列数
                System.out.print(i + "*" + j + "="+ i*j + "\t");
            }
            System.out.println( );  // 换行
        }
    }
}
