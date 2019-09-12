#include <stdio.h>
#include <stdlib.h>
void printNum(int n)   //输出整数的每一位数
{
	if (n)
	{
		printNum(n / 10);
		printf("%d ", n % 10);
	}
}

int main7()
{
	printNum(1729);   
	system("pause");
	return 0;
}