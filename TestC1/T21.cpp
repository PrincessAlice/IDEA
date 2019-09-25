//牛顿迭代解非线性方程组
#include <iostream>
#include <cmath>
using namespace std;

//#define f(x) x*exp(x) - 1
//#define df(x) (x+1)*exp(x)

double f1(double x) {
	double f = x * exp(x) - 1;
	return f;
}
double f2(double x) {
	double df = (x + 1)*exp(x);
	return df;
}

double EPS = 1e-5;

double Newton(double x0)
{

	double x1=0;
	int itCount = 0;//迭代次数
	do
	{
		if (itCount)
			x0 = x1;

		x1 = x0 - ((f1(x0)) / (f2(x1)));
		itCount++;

	} while (abs(x1 - x0) > EPS);
	cout << " 运算迭代次数： " << itCount-1 << endl;
	return x1;

}

void main6()
{

	double x;
	double X;

	cout << " 请输入初值 x0: ";
	cin >> x;
	X = Newton(x);
	cout << " 达到计算精度使f(x)=0的解为: "  << X << endl;
	cout << endl;
	system("pause");
}