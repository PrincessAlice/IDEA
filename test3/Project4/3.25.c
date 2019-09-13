#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main1( )
{
	int i,j,k,n;
	printf("水仙花数是:");
	for (n = 0; n < 1000; n++)
	{
		i = n / 100;
		j = n / 10 - i * 10;
		k = n % 10;
		if (n == i * i*i + j * j*j + k * k*k)
			printf("%d\n", n);
	}
	printf("\n");
    system("pause");
    return 0;
}