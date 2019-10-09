public class LoadOrder{
	private static int initB(){
		System.out.println(1);
		return 0;
	}
	
	static int a=initA();
	
	static {
		System.out.println(2);
	}
	
	static int b=initB();
	
	private static int initA(){
		System.out.println(3);
		return0;                                   
	}
	
	
}