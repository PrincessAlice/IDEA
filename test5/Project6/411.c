#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
void printMul(int n)
{
	int i, j;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			printf("  %d * %d=%-2d",i,j, i*j);
		}
		printf("\n");
	}
}
int main3 ( )
{
	int n;
	scanf("%d", &n);
	printMul(n);
	system("pause");
	return 0;
}