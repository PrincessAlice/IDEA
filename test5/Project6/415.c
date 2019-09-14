#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int judgePrintNumber(int n)
{
	int i;
	int tmp = sqrt(n);
	for (i = 2; i <= tmp; i++)
	{
		if (n%i == 0)
		{
			return 0;
		}
	}
	return 1;
}
int main()
{
	int i;
	for (i = 2; i <= 1000; i++)
	{
		if (judgePrintNumber)
		{
			printf("%d\n", i);
		}
	}
	system("pause");
	return 0;
}