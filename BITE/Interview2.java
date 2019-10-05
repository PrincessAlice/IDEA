class Base{
	{
		System.out.println("Base 的构造代码块 1");
	}
	
	Base(){
		System.out.println("Base 的构造方法");
	}
	
	static{
		System.out.println("Base 的静态代码块 1");
	}
	
	{
		System.out.println("Base 的构造代码块 2");
	}
	
	static{System.out.println("Base 的静态代码块 2");}
	
}

class Derived extends Base{
	{
		System.out.println("Derived 的构造代码块 1");
	}
	
	Derived(){
		this(18);
		System.out.println("Derived 的无参构造方法");
	}	
	
	Derived(int n){
		System.out.println("Derived 的有参构造方法");
	}
	
	static{
		System.out.println("Derived 的静态代码块 1");
	}
	
	{System.out.println("Derived 的构造代码块 2");}
	
	static{
		System.out.println("Derived 的静态代码块 2");
	}
	
}


//构造的演示代码
abstract class Base{
	String field="父类的属性";
	int a;
	
	//因为父类定义了构造方法，所以没有了默认的无参构造方法
	Base(int a){
		this.a=a;
	}
}

final class Derived extends Base{
	String field="子类的属性";
	
	//必须显式给出构造方法，因为父类没有无参的构造方法
	Derived(int a){
		//super;   编译错误，因为父类没有无参的构造方法
		super(a);
	}
	
	void printFields(String field){
		System.out.println(field);
		System.out.println(this.field);
		System.out.println(super.field);
	}
	
	//Derived 要不做一个抽象类(前面加 abstract)，要不覆写父类的抽象方法
	@Override
	void abstractMethod(){
		
	}
}

//编译错误，因为Derived已经是最终类了
//class DerivedOfDerived extends Derived{}

public class Interview2{
	public static void main(String[] args){
		System.out.println("开始");
		new Derived();
		new Derived();
		System.out.println("结束");
		
		
		new Derived(18).printFields("传入的参数");
		//new Base(18);   编译错误，因为Base是一个抽象类
	}
}