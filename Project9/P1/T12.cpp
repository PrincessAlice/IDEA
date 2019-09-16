#include <iostream>
#include <cmath>
using namespace std;

#define m 10
double A[m][m], b[m], Aug[m][m + 1];//全局数组
void equ(double A[m][m], double b[m], double x[m], int n)
{
	int i, i1, j, k;
	double Aug[m][m + 1], maxele, Temp, l;

	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)//构建Aug即增广矩阵
			Aug[i][j] = A[i][j];
		    Aug[i][n] = b[i];
	}
	for (i1 = 0; i1 < n - 1; i1++)
	{
		maxele = fabs(Aug[i1][i1]);		//取主元，fabs取绝对值
		k = i1;
		for (i = i1; i < n; i++)
			if (maxele < fabs(Aug[i1][i]))//比较i1列
				k = i1;
		//换行
		for (j = 0; j < n + 1; j++)
		{
			Temp = Aug[i1][j];
			Aug[i1][j] = Aug[k][j];
			Aug[k][j] = Temp;
		}
		//消元，以第i1行为工具行处理一下行的元素
		for (k = i1 + 1; k < n; k++)
		{
			l = -Aug[k][i1] / Aug[i1][i1];
			for (j = i1; j < n + 1; j++)
				Aug[k][j] = Aug[k][j] + l * Aug[i1][j];
		}
	}
	//回代求解
	double s;
	x[n - 1] = Aug[n - 1][n] / Aug[n - 1][n - 1];
	for (i = n - 2; i >= 0; i--)
	{
		s = 0;
		for (j = i + 1; j < n; j++)
			s = s + Aug[i][j] * x[j];
		x[i] = (Aug[i][n] - s) / Aug[i][i];
	}

}
//以下为主函数
int main3()
{
	int i, j, n; double A[m][m], b[m], x[m];//x[m]为未知数的个数
	cout << "请输入未知数的个数" << endl;
	cin >> n;

	if (n > m)
	{
		cout << "问题规模太大，请修改源程序中符号常量m" << endl;
		return 0;
	}
	for (i = 0; i < n; i++)
	{
		cout << "请输入A的第" << i + 1 << "行：";
		for (j = 0; j < n; j++)
			cin >> A[i][j];//系数矩阵
		    cin >> b[i];
	}
	equ(A, b, x, n);//声明equ函数
	for (i = 0; i < n; i++)//输出x的值
	{
		cout << " x" << "[" << i << "]=" << x[i] << endl;
	}
	system("pause");
	return 0;
}
