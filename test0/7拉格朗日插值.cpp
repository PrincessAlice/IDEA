#include<iostream>
#include <malloc.h>
using namespace std;
double func(double X, int k, double x[], int n);
int main()
{
	double Sn = 0;
	int n;
	cout << "�������ĸ���n:";
	cin >> n;
	double*x = (double*)malloc(n*sizeof(double));
	double*y = (double*)malloc(n*sizeof(double));
	double X;
	int i;
	for (i = 0; i<n; i++)
	{
		cout << "������x" << i + 1 << ",y" << i + 1 << ":" << endl;
		cin >> x[i] >> y[i];
	}
	cout << "������x";
	cin >> X;
	for (i = 0; i<n; i++)
	{
		Sn = Sn + func(X, i, x, n)*y[i];
	}
	cout << "ͨ���������ղ�ֵ��ʽ���õĽ����" << "��x=" << X << "ʱ��y=" << Sn << endl;
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
