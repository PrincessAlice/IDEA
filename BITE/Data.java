/**
*如何设计一个类（日期类）
*1.根据需求列出功能
* 1.传年、月、日 构造日期类
* 2.在当前日期上增加多少天
* 3.在当前日期上减少多少天
* 4.可以返回字符串String 的方法     “2019-05-20”
* 5.加一些限制，年支持的范围[1900,2100]
* 6.如果给定两个日期，希望计算
*2.设计属性
* 1.年、月、日
*/

public class Data{
	private int year;
	private int month;
	private int day;
	
	//构造方法
	public Data(int year,int month,int day){
		//至少做几倍的参数检查
		if(year<1990||year>2100){
			//最好的做法是抛异常
			System.out.println("年不合法："+year);
			return;
		}
		
		if(month<1||month>12){
		   System.out.println("月不合法："+month);
			return;
		}
		
		if(day<1||day>getDayOfMonth(year,month)){
	    	System.out.println("日不合法："+day);
			return;
		}
		
		//涉及name shadow
		this.year=year;
		this.month=month;
		this.day=day;
	}
	
	private Data(Data other){
		this(other.year,other.month,other.day);
	}
	
	//支持的方法
    public void add(int days){
		//days必须是正数
        if(day<0){
			System.out.println("days 不合法："+days);
			return;
		}		
		day+=days;
	    while(day>getDayOfMonth(year,month)){
			day-=getDayOfMonth(year,month);
			month++;
			if(month>12){
				month=1;
				year++;
			}
		}
    }
	
	public void sub(int days){
	   //days必须是正数
	   if(day<0){
		    System.out.println("days 不合法："+days);
			return; 			
	   }
	   day-=days;
	   while(day<1){
		   month--;
		   if(month<1){
			   month=12;
			   year--;
		   }
		   day+=getDayOfMonth(year,day);
	   }
    }
	
    public String toString(){
		return String.format("%04d-%02d-%02d",year,month,day);
	}
	
	//返回d1和d2之间相差的天数，要求d1必须大于d2
	public static int differ(Data d1,Data d2){
		if(!isGreatThan(d1,d2)){
			System.out.println("必须d1大于d2");
			return -1;
		}
		
		int days=0;
		Data tmp=new Data(d1);
		while(isGreatThan(tmp,d2)){
			tmp.sub(1);
			days++;
		}
		return days;
	}
	
	//内部使用的方法，private
	private static final int[] DAY_OF_MONTH={31,28,31,30,31,30,31,31,30,31,30,31};
	private static int getDayOfMonth(int year,int month){
		int days=DAY_OF_MONTH[month-1];
		if(month==2&&isLeapYear(year)){
			days=29;
		}
	    return days;
    }
	
	private static boolean isLeapYear(int year){
		if((year%4==0&&year%100!=0)||year%400==0){
			return true;
		}
		return false;
	}
	
	private static boolean isGreatThan(Data d1,Data d2){
	if(d1.year>d2.year){
		return true;
	}
	
	if(d1.year==d2.year&&d1.month>d2.month){
		return true;
	}
	
	if(d1.year==d2.year&&d1.month==d2.month&&d1.day>d2.day){
		return true;
	}
	
	return false;
	}
	
	
	//入口方法
	public static void main(String[] args){
		Data data=new Data(2019,5,20);
		System.out.println(data.toString());
		data.add(10);
		System.out.println(data.toString());
		data.add(10);
		System.out.println(data.toString());
		data.sub(22);
		System.out.println(data.toString());
		
		Data today=new Data(2019,5,20);
		Data intern=new Data(2019,12,1);
		
		System.out.printf("距离找实习还有%d天%n",Data.differ(intern, today));
	}
}   