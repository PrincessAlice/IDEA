class Group{
	//属性
	String name; //名称
	int number;   //人数
	//方法
	//构造方法
	Group(String n, int m){
		name=n;
		number=m;
	}
	
	void print(String welcome){
		System.out.printf("%s%s的%d位同学们%n",
		     welcome,    //形参
			 name,   //属性
			 number   //属性
		);
	}
}

class B{
	int sum;
	B(int a,int b,int c){
		System.out.println(a+b+c);
		sum=a+b+c;
	}
	
	void print(){
		System.out.println(sum);
	}
}
//一个文件只允许有一个public修饰的类，这个类名称和文件名同名
public class Practice0519{
	public static void main(String[] args){
		Group group=new Group("java 10班",50);
		group.print("欢迎来到比特,");
		//欢迎来到比特，java10班的50位同学们
	
	B b=new B(1,2,3);
	b.print();
	}
}