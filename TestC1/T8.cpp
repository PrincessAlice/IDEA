//ŷ������΢�ַ���
#include<iostream>
//#include<gdiplusmatrix.h>   //3*3����
#include<cmath>
//#include "matrix.h"
using namespace std;

double F(double t, double y) {  //�����΢�ַ���
	double dy;
	dy = (t - y) / 2;
	return dy;
}

int main8() {
	double a, b, y0, h,Aug;
	int M, i;
	//matrix  T, Y, E;
	cout << "��������������������Ҷ˵�ֵa,b,��ʼֵy0,��������M��";
	cin >> a >> b >> y0 >> M;
	h = (b - a) / M;
	//for (i = 1; a + (i - 1)*h <= b; i++) {
	//	T(1, i) = a + (i - 1)*h;
	//}
	//Y(1, 1) = y0;
	//for (i = 1; i <= M; i++) {
	//	Y(1, i + 1) = Y(1, i) + h * F(T(1, i), Y(1, i));
	//}
	cout << "��Ľ�����£�" << endl;
	//E = Aug(T, Y);
	//E.print(7);
	return 0;

}