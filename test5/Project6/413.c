#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int judgeLeapYear(int y)
{
	if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
	{
		return 1;
	}
	return 0;
}
int main1( )
{
	if (judgeLeapYear(1998))
	{
		printf("ÈòÄê\n");
	}
	else
	{
		printf("Æ½Äê\n");
	}
	system("pause");
	return 0;
}