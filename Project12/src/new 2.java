public class Pratice{
  public static long factorial1(int n){
	if (n==0||n==1){
	return 1;
   }      
   //递推公式
   return n*factorial(n-1);
  }
  
  public static int factorial2(int n){
  
    
  }
  
  
  
  public static void main(String[] args){
   int n=12;
   //求阶乘的方法
   //用递归
   long fact1=factorial1(n);
   System.out.printf("阶乘是 %d%n",fact1);
   //用循环
   long fact2=factorial2(n);
   System.out.printf("阶乘是 %d%n",fact2);
   
   
  }
  
   
}