#include <stdio.h>
#include <stdlib.h>
int p_pow(int k, int n)
{
	if (n == 1)
	{
		return k;
	}
	return k * p_pow(k, n - 1);
}

int main2()
{
	printf("%d\n", p_pow(3, 7)); //Çó3^7µÄÖµ
	system("pause");
	return 0;
}