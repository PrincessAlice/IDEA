#include<iostream>
#include<cmath>
using namespace std;

#define ep 0.00001  //ep����

double fun(double x)
{
	double y;
	y = x *exp(x)-1;
	return y;
}

int main9()
{
	double a = 0.0, b = 0.0, z = 0.0;  //aΪ������˵㣬bΪ�����Ҷ˵㣬zΪa��b���е�
	cout << "���ַ� �������������Ҷ˵�a��b:" << endl;
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
