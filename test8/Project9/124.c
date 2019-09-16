#include<stdio.h>
#include<stdlib.h>
int strlen(char* str)
{
	if (*str)
	{
		return 1 + strlen(str + 1);
	}
	return 0;
}
void reverse_string(char *str)
{
	int end = strlen(str) - 1;
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
	char arr[] = ".tneduts a ma i";
	reverse_string(arr);
	puts(arr);
	system("pause");
	return 0;
}