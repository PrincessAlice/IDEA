#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int pwdJudge(char pwd[])
{
	char input[21] = { 0 };
	int i;
	for (i = 0; i < 3; i++)
	{
		scanf("%s", input);
		if (0 == strcmp(input, pwd))
		{
			return 1;
		}
	}
	return 0;
}
int main4()
{
	char pwd[21] = "12345";
	if (pwdJudge(pwd))
	{
		printf("exit\n");
	}
	else
	{
		printf("log in\n");
	}
	system("pause");
	return 0;
}

