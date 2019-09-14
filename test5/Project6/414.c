#include <stdio.h>
#include <stdlib.h>

void init(int data[], int a[], int n) //初始化
{
	int i;
	for (i = 0; i < n; i++)
	{
		a[i] = data[i];
	}
}

void empty(int a[], int n) //清空数组
{
	int i;
	for (i = 0; i < n; i++)
	{
		a[i] = 0;
	}
}

void reverse(int a[], int n)  //逆置
{
	int i, j;
	int tmp;
	for (i = 0, j = n - 1; i < j; i++, j--)
	{
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

void printArray(int a[],int n) //创建数组
{
	int i;
	for (i = 0; i < n; i++)
	{
		printf("%d", a[i]);
	}
	putchar('\n');
}

int main5( )
{
	int data[10] = { 9,6,5,7,2,4,3,1,0,8 };
	int a[10] = { 0 };

	init(data, a, 10);
	printArray(a, 10);
	empty(a, 10);
	printArray(a, 10);
	reverse(a, 10);
	printArray(a, 10);

	system("pause");
	return 0;
}