#include<stdio.h>
#define N 10

void modeuler(float(*f)(float, float), float x0, float y0, float xn, int n)
{
	int i;
	float yp, yc, x = x0, y = y0, h = (xn - x0) / n;
	printf("第一问\n");
	printf("x[0]=%f\ty[0]=%f\n", x, y);
	for (i = 1; i <= n; i++)
	{
		yp = y + h * (*f)(x, y);
		x = x0 + i * h;
		yc = y + h * (*f)(x, yp);
		y = (yp + yc) / 2;
		printf("x[%d]=%f\ty[%d]=%f\n", i, x, i, y);
	}
}

float f1(float x, float y)//求解的方程，对应问题进行修改
{
	return x * x + y * y;
}

void main83()
{
	float xn = 1, x0 = 0, y0 = 0;
	modeuler(f1, x0, y0, xn, N);
}