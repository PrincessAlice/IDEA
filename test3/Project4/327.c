#define  _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main2 ( )
{
	int a, n, i = 1, Sn = 0, tn = 0;
	printf("a,n=:");
	scanf("%d,%d", &a, &n);
	while (i <= n)
	{
		tn = tn + a;
		Sn = Sn + tn;
		a = a * 10;
		++i;
	}
	printf("a+aa+aaa+...=%d\n", Sn);
	system("pause");
	return 0;

}