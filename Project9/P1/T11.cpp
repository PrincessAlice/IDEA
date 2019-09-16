#include<iostream>
#include<cmath>
using namespace std;

#define N 3        //矩阵维数，可自定义

static double A[N][N];      //系数矩阵
static double B[N];         //右端项
static double Y[N];         //中间项
static double X[N];         //输出
static double S[N];         //选取列主元的比较器

int i, j, k;         //计数器

void main1()
{
	cout << "请输入线性方程组（ai1，ai2，ai3......ain, yi）：" << endl;
	for (i = 0; i < N; i++){
		for (int j = 0; j < N; j++)
			cin >> A[i][j];
		cin >> B[i];
	}
	for (k = 0; k < N; k++){
		//选列主元
		int index = k;
		for (i = k; i < N; i++){
			double temp = 0;
			for (int m = 0; m < k; m++){
				temp = temp + A[i][m] * A[m][k];
			}
			S[i] = A[i][k] - temp;
			if (S[index] < S[i]){
				index = i;
			}
		}
		//交换行
		double temp;
		for (i = k; i < N; i++){
			temp = A[index][i];
			A[index][i] = A[k][i];
			A[k][i] = temp;
		}
		temp = B[index];
		B[index] = B[k];
		B[k] = temp;
		// 构造L、U矩阵
		for (j = k; j < N; j++){
			double temp = 0;
			for (int m = 0; m < k; m++){

				temp = temp + A[k][m] * A[m][j];
			}
			A[k][j] = A[k][j] - temp;   //先构造U一行的向量
		}
		for (i = k + 1; i < N; i++){
			double temp = 0;
			for (int m = 0; m < k; m++){
				temp = temp + A[i][m] * A[m][k];
			}
			A[i][k] = (A[i][k] - temp) / A[k][k];  //再构造L一列的向量
		}
	}
	//求解LY = B
	Y[0] = B[0];
	for (i = 1; i < N; i++){
		double temp = 0;
		for (int j = 0; j < i; j++){
			temp = temp + A[i][j] * Y[j];
		}
		Y[i] = B[i] - temp;
	}
	//求解UX = Y
	X[N - 1] = Y[N - 1] / A[N - 1][N - 1];
	for (i = N - 2; i >= 0; i--){
		double	temp = 0;
		for (int j = i + 1; j < N; j++){
			temp = temp + A[i][j] * X[j];
		}
		X[i] = (Y[i] - temp) / A[i][i];
	}
	//打印X
	cout << "线性方程组的解（X1，X2，X3......Xn）为：" << endl;
	for (i = 0; i < N; i++){
		cout << X[i] << " ";
	}
}
