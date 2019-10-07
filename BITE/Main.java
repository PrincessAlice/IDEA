public class main{
	private static void printCondition(int[] list,Condition cond){
		for(int val :list){
			if(cond.test(val)){
				System.out.println(val);
			}
		}
	}


    public static void main(String[] args){
		int[] a=new int[100];
		for(int i=0;i<100;i++){
			a[i]=i;
		}
	
		class Even implements Condition{
			@Override
			public boolean test(int val){
				return val%2==0;
			}
		}
	
		//打印2的倍数
		printCondition(a,new Even());
	
		//打印3的倍数
		printCondition(a,new Condition(){
			@Override
			public boolean test(int val){
				return val%3==0;
			}
		});
	
		//打印5的倍数，使用Lambda 表达式
		printCondition(a,(int val)-> val %5 ==0);
	
	
	}

}