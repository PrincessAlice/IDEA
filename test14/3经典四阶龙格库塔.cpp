#include<iostream>
#include<iomanip>
using namespace std;
double a[2][3];
int main()
{
	cout << "请输入一阶微分方程组的系数矩阵：\n" << "       dy=ax+by+cz\n       dz=dx+ey+fz\n";
	int n, i, j;
	double x[100] = { 0 }, y[100] = { 0 }, z[100] = { 0 }, xspan[2], h;
	//x返回节点，y、z分别为方程组函数，xspan为求解区间，h为步长
	int runge4s(double xspan[], double h, double x[], double y[], double z[]);//返回的值为节点个数
	for (i = 0; i < 2; i++)

	for (j = 0; j < 3; j++)
		cin >> a[i][j];
	cout << "请输入两方程左端函数的初值\n    y(0)= ";
	cin >> y[0];
	cout << "    z(0)= ";
	cin >> z[0];
	cout << "\n请输入步长 h= ";
	cin >> h;
	cout << "\n请输入求解区间 ：    ";
	cin >> xspan[0] >> xspan[1];
	n = runge4s(xspan, h, x, y, z);
	cout << setw(20) << "节点" << setw(20) << "函数y" << setw(20) << "函数z" << endl;
	for (i = 0; i < n; i++)
		cout << setw(20) << x[i] << setw(20) << y[i] << setw(20) << z[i] << endl;
	system("pause");
	return 0;
}
int runge4s(double xspan[], double h, double x[], double y[], double z[])
{
	double k[4], l[4];
	double fun_y(double x, double y, double z);
	double fun_z(double x, double y, double z);
	int i, j, n;
	n = (xspan[1] - xspan[0]) / h;//如果不是整数，进行强制转换，只取整数部分
	x[0] = xspan[0];
	for (i = 1; i <= n; i++)
		x[i] = x[i - 1] + h;
	for (i = 0; i < n; i++) {
		k[0] = fun_y(x[i], y[i], z[i]);
		l[0] = fun_z(x[i], y[i], z[i]);
		for (j = 1; j < 3; j++) {
			k[j] = fun_y(x[i] + h / 2, y[i] + h*k[j - 1] / 2, z[i] + h*l[j - 1] / 2);
			l[j] = fun_z(x[i] + h / 2, y[i] + h*k[j - 1] / 2, z[i] + h*l[j - 1] / 2);
		}
		k[3] = fun_y(x[i] + h, y[i] + h*k[2], z[i] + h*l[2]);
		l[3] = fun_z(x[i] + h, y[i] + h*k[2], z[i] + h*l[2]);
		y[i + 1] = y[i] + h*(k[0] + 2 * k[1] + 2 * k[2] + k[3]) / 6;
		z[i + 1] = z[i] + h*(l[0] + 2 * l[1] + 2 * l[2] + l[3]) / 6;
	}
	return n + 1;
}
double fun_y(double x, double y, double z)
{
	double fy;
	fy = a[0][0] * x + a[0][1] * y + a[0][2] * z;
	return fy;
}
double fun_z(double x, double y, double z)
{
	double fz;
	fz = a[1][0] * x + a[1][1] * y + a[1][2] * z;
	return fz;
}
