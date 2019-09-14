#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void swapArgs(int* pa,int* pb)
{
	int tmp = *pa;
	*pa = *pb;
	*pb = tmp;
}
int main2()
{
	int a = 10, b = 21;
	swapArgs(&a, &b);
	system("pause");
	return 0;
}