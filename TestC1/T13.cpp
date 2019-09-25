//Aug=[1 1 1 1 10;-1 2 -3 1 -2;3 -3 6 -2 7;-4 5 2 -3 0]
//x[i]={1 2 3 4}

#include<iostream>
#include<cmath>
using namespace std;

#define N 10				//定义矩阵的维数，可自定义
static double A[N][N];       //系数矩阵
static double b[N];			 //右端项
static double Aug[N][N + 1]; //增广矩阵

//高斯列主元消去法解线性方程组
void gaussin_LZY(double A[N][N],double b[N],double x[N],int n) {
	int i,i1, j, k;
	double Aug[N][N + 1], maxele, Temp, M;
	for (i = 0; i < n; i++) {			//构造增广矩阵Aug
		for (j = 0; j < n; j++)
			Aug[i][j] = A[i][j];
			Aug[i][n] = b[i];
	}
	for (i1 = 0; i1 < n - 1; i1++) {  //列主元
		maxele = fabs(Aug[i1][i1]);  //取主元，fabs是取绝对值函数
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
		//消元，以第i1行为工具行处理下一行的元素
		for (k = i1 + 1; k < n; k++)
		{
			M = -Aug[k][i1] / Aug[i1][i1];
			for (j = i1; j < n + 1; j++)
				Aug[k][j] = Aug[k][j] + M * Aug[i1][j];
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
int main5()
{
	int i, j, n; double A[N][N], b[N], x[N];//x[N]为未知数的个数
	cout << "请输入未知数的个数" << endl;
	cin >> n;

	if (n > N){
		cout << "问题规模太大，请修改源程序中符号常量N" << endl;
		return 0;
	}
	for (i = 0; i < n; i++){
		cout << "请按顺序输入Aug的第" << i + 1 << "行:";
		for (j = 0; j < n; j++)
			cin >> A[i][j];//系数矩阵
			cin >> b[i];
	}
	gaussin_LZY(A, b, x, n);//声明函数
	for (i = 0; i < n; i++)//输出x的值
	{
		cout << "x" << "[" << i << "]=" << x[i] << endl;
	}
	system("pause");
	return 0;
}



