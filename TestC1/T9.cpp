#include<iostream>
#include<cmath>
using namespace std;

#define ep 0.00001  //ep精度

double fun(double x)
{
	double y;
	y = x *exp(x)-1;
	return y;
}

int main9()
{
	double a = 0.0, b = 0.0, z = 0.0;  //a为区间左端点，b为区间右端点，z为a和b的中点
	cout << "二分法 请输入区间左右端点a和b:" << endl;
	cin >> a >> b;
	while (fabs(b - a) > ep)
	{
		z = (a + b) / 2.0;
		if (fun(z) == 0)
			break;
		else
		{
			if (fun(a)*fun(z) < 0)
				b = z;
			else
				a = z;
		}
	}
	cout << z;
	cout << endl;
	system("pause");
	return 0;
}
