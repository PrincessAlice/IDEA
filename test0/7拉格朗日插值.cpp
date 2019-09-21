#include<iostream>
#include <malloc.h>
using namespace std;
double func(double X, int k, double x[], int n);
int main()
{
	double Sn = 0;
	int n;
	cout << "请输入点的个数n:";
	cin >> n;
	double*x = (double*)malloc(n*sizeof(double));
	double*y = (double*)malloc(n*sizeof(double));
	double X;
	int i;
	for (i = 0; i<n; i++)
	{
		cout << "请输入x" << i + 1 << ",y" << i + 1 << ":" << endl;
		cin >> x[i] >> y[i];
	}
	cout << "请输入x";
	cin >> X;
	for (i = 0; i<n; i++)
	{
		Sn = Sn + func(X, i, x, n)*y[i];
	}
	cout << "通过拉格朗日插值公式所得的结果：" << "当x=" << X << "时，y=" << Sn << endl;
	system("pause");
	return 0;
}
double func(double X, int k, double x[], int n)
{
	int i;
	double Pn = 1;
	double p;
	for (i = 0; i<n; i++)
	{
		if (i == k) continue;
		else p = (X - x[i]) / (x[k] - x[i]);
		Pn = Pn*p;
	}
	return Pn;
}
