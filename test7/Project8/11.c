#include <stdio.h>
#include <stdlib.h>
int fib(int n)
{
	if (n <= 2)
	{
		return 1;
	}
	return fib(n - 1) + fib(n - 2);
}

int fibN(int n)   //实现第n个斐波那契函数
{
	int an, an_1 = 1, an_2 = 1;
	int i;
	if (n < 2)
	{
		return 1;
	}
	for (i = 2; i < n; i++)
	{
		an = an_1 + an_2;
		an_2 = an_1;
		an_1 = an;
	}
	return an;
}
int main1()
{
	printf("%d\n", fibN(9));
	printf("%d\n", fib(8));
	system("pause");
	return 0;
}