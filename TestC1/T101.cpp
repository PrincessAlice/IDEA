//雅可比迭代
#include<iostream>
#include<cmath>
#define MAX 4
using namespace std;

void Yacobi(double A[MAX][MAX], double b[MAX], double x0[MAX], double ep, int N)
{
	int k = 1, i, j;
	double x[MAX] = { 0 };
	double chax[MAX];

	while (k < N)
	{
		cout << "第" << k << "次迭代结果\n";
		for (i = 0; i < MAX; i++)
		{
			cout << "x0[" << i << "]=" << x0[i] << "  ";
		}
		cout << endl;

		for (i = 0; i < MAX; i++)
		{
			double sum = 0;
			for (j = 0; j < MAX; j++)
			{
				if (j == i) continue;
				sum = sum + A[i][j] * x0[j];
			}
			x[i] = (b[i] - sum) / A[i][i];
			cout << "x[" << i << "]=" << x[i] << "   ";
		}
		cout << endl;
		for (i = 0; i < MAX; i++)
		{
			chax[i] = x[i] - x0[i];
		}
		cout << endl;
		double max = fabs(chax[0]);
		for (i = 1; i < MAX; i++)
		{
			if (max <= chax[i])
			{
				max = fabs(chax[i]);
			}
		}
		if (max < ep) break;

		for (i = 0; i < MAX; i++)
		{
			x0[i] = x[i];
		}
		k++;
		cout << "k=" << k;
	}
	if (k == N) cout << "已达迭代次数上限" << endl;
	cout << "k=" << k - 1 << endl;
	for (i = 0; i < MAX; i++)
	{
		cout << "x[" << i << "]=" << x[i] << endl;
	}

}
//雅克比迭代
int main101()
{
	double A[MAX][MAX];
	double x0[MAX] = { 0 };
	double b[MAX] = { 0.68,1.18,0.12,0.74 };
	cout << "\n请输入系数矩阵A: " << endl;
	for (int i = 0; i < MAX; i++)
	{
		for (int j = 0; j < MAX; j++)
		{
			cin >> A[i][j];
		}
	}
	cout << "\n请输入常数向量b: " << endl;
	for (int k = 0; k < MAX; k++)
	{
		cin >> b[k];
	}
	cout << "\n请输入迭代初始解向量: " << endl;
	for (int l = 0; l < MAX; l++)
	{
		cout << "x0[" << l + 1 << "]=";
		cin >> x0[l];
	}
	Yacobi(A, b, x0, 0.000001, 500);
	system("pause");
	return 0;
}