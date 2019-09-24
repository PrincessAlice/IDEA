//龙贝格求积分

#include<iostream>
#include<cmath>
using namespace std; 

double ff(double x) {
	return 4 / (1 + pow(x,2));  //pow 指数函数
}

double Romberg(double a, double b,double eps) {  

	int N = 0; //N为龙贝格数据个数
	double h;  //步长
	double x, sum;
	double T[10],S[10],C[10],R[10]; //一维数组，存储Romberg的计算值
	double T1, T2;

	//迭代初值
	h = b - a;
	T2=T1= h * (ff(a) + ff(b)) / 2.0;
	
	//梯形公式
	for (int i = 0; i < N + 3; i++) {
		T[i] = T2;
		sum = 0;
		x = a + h / 2;
		while (x < b) {
			sum = ff(x) + sum;
			x += h;
		}
		T2 = (T1 + h * sum) / 2;
		h = h / 2;
		T1 = T2;
	}
	//进行梯形公式到辛普生公式的转化
	for (int i = 0; i < N + 2; i++) {
		S[i] = (4 * T[i + 1] - T[i]) / 3;
	}
	//进行辛普生到柯特斯的转化
	for (int i = 0; i < N + 1; i++) {
		C[i] = (16 * S[i + 1] - S[i]) / 15;
	}
	//进行柯特斯到龙贝格的转化
	for (int i = 0; i < N; i++) {
		R[i] = (64 * C[i + 1] - C[i]) / 63;
	}	
	return R[2];

}

int main50() {
	double a, b,N;
	double eps = 0;
	cout << "请输入积分的上下限[a,b]:" << endl;
	cin >> a >> b;
	cout << "请输入龙贝格数据个数N:" << endl;
	cin >> N;
	cout << "请输入精度eps :" << endl;
	cin >> eps;
	cout << " 积分结果: " << Romberg(a, b, eps) << endl;
	system("pause");
	return 0;
}

