#include<iostream>
#include<cmath>
using namespace std;
#define ep 0.00001  //ep精度

void main()
{
	double fun(double x);  //局部声名：fun为一个函数
	double a = 0.0, b = 0.0, z = 0.0;  //a为区间左端点，b为区间右端点，z为a和b的中点
	cout << "请输入区间a和b:" << endl;
	cin >> a >> b;
	while (fabs(b - a)>ep)
	{
		z = (a + b) / 2.0;
		if (fun(z) == 0)
			break;
		else
		{
			if (fun(a)*fun(z)<0)
				b = z;
			else
				a = z;
		}
	}
	cout << z;
	cout << endl;
	system("pause");
}
double fun(double x)
{
	double y;
	y = x*x*x - x - 1;
	return y;
}
