#include <stdio.h>
#include <stdlib.h>

int strleN(char *str)  //�ݹ�ʵ��strleN
{
	if (*str)
	{
		return 1 + strleN(str + 1);
	}
	return 0;
}

void reverse_string(char *str) //���ַ����е��ַ���������
{
	int end = strleN(str) - 1;
	char tmp = str[0];
	if (str[0])
	{
		str[0] = str[end];
		str[end] = '\0';
		reverse_string(str + 1);
		str[end] = tmp;
	}
}

int main()
{

	printf("%d\n", strleN("lxlhh520"));
	char arr[ ] = "lxlhh520";
	reverse_string(arr);
	puts(arr);
	system("pause");
	return 0;
}