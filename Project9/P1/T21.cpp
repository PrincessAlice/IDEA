#include <iostream>
#include <cmath>
using namespace std;

#define f(x) x*x - 8
#define df(x) 2*x

double EPS = 1e-6;

double Newton(double xFirst)
{

	double xSecond;
	int iteCount = 0;//迭代次数
	do
	{
		if (iteCount)
			xFirst = xSecond;

		xSecond = xFirst - ((f(xFirst)) / (df(xFirst)));
		iteCount++;

	} while (abs(xSecond - xFirst) > EPS);
	cout << "　运算迭代次数： " << iteCount << endl;
	return xSecond;

}

void main()
{

	double x;
	double accX;

	cout << " Input xFirst: ";
	cin >> x;
	accX = Newton(x);
	cout << "  达到计算精度使f(x)=0的解为： " << accX;
	cout << endl;
	system("pause");
}