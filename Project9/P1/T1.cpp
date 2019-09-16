#include<iostream>
#include<cmath>
using namespace std;

//定义矩阵的维数，可自定义
const int n = 3;
//交换2个数的大小
template<class T>
void SWAP(T& a, T& b){
	T c;
	c = a;
	a = b;
	b = c;
}

//高斯列主元素消去法
void gaussin_L(double a[n][n], double b[n])
{
	int i, j, k;
	int col, row;
	for (k = 0; k < n - 1; k++)
	{
		double ave = 0;
		//找主元的位置
		for (i = k; i < n; i++)
			if (fabs(a[i][k]) > ave)
			{
				ave = fabs(a[i][k]);
				cout << "ave " << ave << endl;
				row = i;
				col = k;
			}

		//如果该对角线元素是0，同样不能用高斯消元法来求解
		if (a[row][row] == 0)
		{
			cout << "can't solve" << endl;
			return;
		}
		//将找出的行进行交换
		if (k != row)
			for (i = 0; i < n; i++)
			{
				SWAP(a[row][i], a[k][i]);
				SWAP(b[k], b[row]);
			}
		//消元过程
		double c[n];
		for (j = k + 1; j < n; j++)
		{
			c[j] = a[j][k] / a[k][k];
			cout << c[j] << endl;
			cout << "======================================" << endl;
		}
		for (i = k + 1; i < n; i++)
		{
			for (j = 1; j < n; j++)
			{
				a[i][j] = a[i][j] - c[i] * a[k][j];
			}
			b[i] = b[i] - c[i] * b[k];
		}

	}

	double x[n];
	x[n - 1] = b[n - 1] / a[n - 1][n - 1];
	for (i = n - 2; i >= 0; i--)
	{

		double sum = 0 ;
			for (j = i + 1; j < n; j++)
				sum += a[i][j] * x[j];
		x[i] = (b[i] - sum) / a[i][i];
	}
	//打印输出
	for (i = 0; i < n; i++)
		cout << " x" << "[" << i << "]=" << x[i] << endl;
	    cout << "======================================" << endl;
}


//输入矩阵数据
int main2()
{
	double a[3][3] = { 0.001,2.000,3.000,-1.000,3.712,4.623,-2.000,1.072,5.643 };
	double b[3] = { 1.000,2.000,3.000 };
	cout << "======================================" << endl;
	cout << a[3][3] << endl;
	cout << b[3] << endl;
	gaussin_L(a, b);
	system("pause");
	return 0;
}
