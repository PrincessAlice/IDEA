#include <stdio.h>
#include <stdlib.h>
int p_N(int n)     //µİ¹éÇó10£¡
{
	if (n == 1)
	{
		return 1;
	}
	return n * p_N(n - 1);
}
int main6()
{
	printf("%d\n", p_N(10));   
	system("pause");
	return 0;
}