//四阶龙格库塔法解一阶常微分方程组
#include<iostream>
#include<iomanip>
using namespace std;


//定义一阶微分方程组
double f(double x, double y,double t) { 
	double df;
	df = x + 2 * y;
	return(df);
}
double g(double x,double y,double t) {
	double dg;
	dg = 3 * x + 2 * y;
	return(dg);
}

//定义四阶龙格库塔函数
void RungeKutta4(double h, double chuzhi[3], double result[3], double(*f)(double x, double y, double z), double(*g)(double x, double y, double z)) {
	double f1, f2, f3, f4, g1, g2, g3, g4, x0, x1, y0, y1, t0;
	t0 = chuzhi[0]; x0 = chuzhi[1]; y0 = chuzhi[2];
	f1 = f(t0, x0, y0);
	g1 = g(t0, x0, y0);
	f2 = f(t0 + h / 2, x0 + h * f1 / 2, y0 + h * g1 / 2);
	g2 = g(t0 + h / 2, x0 + h * f1 / 2, y0 + h * g1 / 2);
	f3 = f(t0 + h / 2, x0 + h * f2 / 2, y0 + h * g2 / 2);
	g3 = g(t0 + h / 2, x0 + h * f2 / 2, y0 + h * g2 / 2);
	f4 = f(t0 + h, x0 + h * f3, y0 + h * g3);
	g4 = g(t0 + h, x0 + h * f3, y0 + h * g3);
	x1 = x0 + h * (f1 + f2 + f3 + f4) / 6;
	y1 = y0 + h * (g1 + g2 + g3 + g4) / 6;
	result[0] = t0 + h;
	result[1] = x1;
	result[2] = y1;
}

int main6() {
	double f(double x, double y, double z);
	double g(double x, double y, double z);
	double chuzhi[3], result[3];
	double a, b, H;
	double t, step;
	int i;
	cout << "请输入一阶常微分方程的初值:t0,x0,y0" << endl;
	cin >> chuzhi[0] >> chuzhi[1] >> chuzhi[2];
	cout << "请输入所求微分方程组的微分区间[a,b]:" << endl;
	cin >> a >> b;
	cout << "请输入所求微分方程组所分解子区间的个数step:" << endl;
	cin >> step;
	H = (b - a) / step;   //步长
	cout << chuzhi[0] << setw(10) << chuzhi[1] << setw(10) << chuzhi[2] << endl;
	for (i = 0; i < step; i++) {
		RungeKutta4(H, chuzhi, result, f, g);
		cout << result[0] << setw(10) << result[1] << setw(10) << result[2] << endl;
		chuzhi[0] = result[0];
		chuzhi[1] = result[1];
		chuzhi[2] = result[2];
	}
	system("pause");
	return 0;
}

