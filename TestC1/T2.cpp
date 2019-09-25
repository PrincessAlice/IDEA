#include<iostream>
#include<string>
#include<cmath>
using namespace std;

double fd(double x) {
	double c = x*exp(x)-1;
	double d = (x + 1)*exp(x);
	return (c / d);
}

//牛顿迭代解非线性方程组
double newton(double x0, double e) {
	double a = x0;
	double x = x0 - fd(x0);
	int i = 0;
	while (abs(x - a) > e) {
		cout << a << endl;
		a = x;
		i++;		//循环次数
		x = x - fd(x0);
		cout << "迭代次数为:" << i << endl;
		if (i > 10) {
			cout << "迭代失败！" << endl;
			return x;
		}
	}
	cout << "迭代次数为:" << i << endl;
}

void main5(){
	double x0, e, accx;
	cout << "请输入x0的值：" << endl;
	cin >> x0;
	cout << "请输入容许误差:" << endl;
    cin >> e;
	accx = newton(x0, e);
	cout << "达到计算精度使f(x)=0的解为:" << accx << endl;
	system("pause");

}