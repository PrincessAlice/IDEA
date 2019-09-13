#include<stdio.h>
#include<stdlib.h>
int main2()
{
	int i;
	double tmp = 1, sum = 0, flag = 1;
	for (i = 1; i <= 100; i++)
	{
		tmp = 1.0 / i * flag;
		sum += tmp;
		flag *= -1;
	}
	printf("%f\n", sum);
	system("pause");
	return 0;
}