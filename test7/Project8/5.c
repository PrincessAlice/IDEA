#include <stdio.h>
#include <stdlib.h>
int strlen(char *str)     //�ǵݹ����strlen
{
	int i;
	for (i = 0; str[i]; i++);
	return i;
}

int strleN5(char *str)  //�ݹ�ʵ��strleN
{
	if (*str)
	{
		return 1 + strleN(str + 1);
	}
	return 0;
}

int main5()
{

	printf("%d\n",strlen("lxlhh520"));
	printf("%d\n",strleN("lxlhh520"));
	system("pause");
	return 0;
}