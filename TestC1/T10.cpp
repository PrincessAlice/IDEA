////多项式拟合
//#include<iostream>
//#include<cmath>
//using namespace std;
//#define MAX 20
//
////求解任意可逆矩阵的逆，X为待求解矩阵，E为全零矩阵
//void inv(double X[MAX][MAX], int n, double E[MAX][MAX])//定义二维数组构造矩阵
//{
//	int i, j, k;
//	double temp = 0;
//	for (i = 0; i < MAX; i++)
//	{
//		for (j = 0; j < MAX; j++)
//			if (i == j)
//				E[i][j] = 1;
//	}
//	for (i = 0; i < n - 1; i++)
//	{
//		temp = X[i][i];
//		for (j = 0; j < n; j++)
//		{
//			X[i][j] = X[i][j] / temp;
//			E[i][j] = E[i][j] / temp;
//		}
//		for (k = 0; k < n; k++)
//		{
//			if (k == i)
//				continue;
//			temp = -X[i][i] * X[k][i];
//			for (j = 0; j < n; j++)
//			{
//				X[k][j] = X[k][j] + temp * X[i][j];
//				E[k][j] = E[k][j] + temp * E[i][j];
//			}
//		}
//	}
//}
//int main1()
//{
//	int n, M, i, j, k;
//	double X[MAX] = { 0 }, Y[MAX] = { 0 }, F[MAX][MAX] = { 0 }, B[MAX] = { 0 };
//	double A[MAX][MAX] = { 0 }, BF[MAX][MAX] = { 0 }, C[MAX] = { 0 }, E[MAX][MAX] = { 0 };
//	cout << "请先输入待拟合曲线的点的个数: " << endl;
//	cin >> n;
//	cout << " \n请输入" << n << "个点的X坐标点序列:\n" << endl;
//	for (i = 0; i < n; i++)
//		cin >> X[i];
//	cout << " \n请输入" << n << "个点的Y坐标点序列:\n" << endl;
//	for (i = 0; i < n; i++)
//		cin >> Y[i];
//	cout << " \n请输入需要拟合的次数: \n" << endl;
//	cin >> M;
//	for (i = 0; i < n; i++)
//		for (k = 1; k <= M + 1; k++)
//			F[i][k - 1] = pow(X[i], k - 1);
//
//	//求F的转置
//	for (i = 0; i < n; i++)
//	{
//		for (j = 0; j < M + 1; j++)
//		{
//			BF[j][i] = F[i][j];
//		}
//	}
//	//计算其转置BF与F的乘 
//	for (i = 0; i < M + 1; i++)
//		for (j = 0; j < M + 1; j++)
//			for (k = 0; k < n; k++)
//				A[i][j] += BF[i][k] * F[k][j];
//	//计算F的转置BF与Y的乘
//	for (i = 0; i < M + 1; i++)
//		for (j = 0; j < n; j++)
//			B[i] += BF[i][j] * Y[j];
//	//调用inv函数求解矩阵A的逆矩阵E
//	inv(A, n, E);
//	//计算A的逆BF与B的乘
//	for (i = 0; i < M + 1; i++)
//		for (j = 0; j < n; j++)
//			C[i] += E[i][j] * B[j];
//	cout << " \n拟合后的" << M << "次多项式系数为，幂次由高到低C[i]分别为：\n";
//	for (i = M; i >= 0; i--)
//		cout << C[i] << "\t";
//	cout << " \n拟合后的" << M << "次多项式为:\n";
//	cout << " \nP(x)=";
//	for (i = M; i >= 0; i--)   //输出曲线拟合函数式
//	{
//		if (i == 0)
//			cout << "+" << "(" << C[i] << ")";
//		else
//			cout << "+" << "(" << C[i] << ")" << "(" << "*x^" << i << ")";
//	}
//	cout << endl;
//	system("pause");
//	return 0;
//}