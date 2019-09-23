#define  _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<cmath>
using namespace std;

//改进欧拉法
//[1,1.5] y(1)=0.5  h=0.1 => n=5

float f(float x, float y) {
	return (y / x - y * y / x);
}

float Euler(float x0, float xn, float y0, int n) {
	int i;
	float yp, yc, x = x0, y = y0, h;
	h = (xn - x0) / n;
	for (i = 1; i <= n; i++) {
		yp = y + h * f(x, y);
		x = x0 + i * h;
		yc = y + h * f(x, yp);
		y = (yp + yc) / 2.0;
		printf("x[%d]=%f	y[%d]=%f\n", i, x, i, y);
	}
	return y;
}

int main80() {
	int i;
	float x0, xn, y0, h, S, n;
	printf("\nInput the x0 value:");
	scanf("%f", &x0);
	printf("\nInput the xn value:");
	scanf("%f", &xn);
	printf("\nInput the y0 value at %f:", x0);
	scanf("%f", &y0);
	printf("\n input value[divide(%f,%f)]:", x0, xn);
	scanf("%f", &n);
	printf("\n x[0]=%8f \t y[0]=%8f \n", x0, y0);
	Euler(x0, xn, y0, n);
	system("pause");
	return 0;
}
