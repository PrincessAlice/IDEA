#include <stdio.h>
#define row 4
#define line 3
int main()
{
	int a[22][22] = { 0 };
	int x, y;
	scanf("%d %d",&x,&y);
	int i, j;
	for (i = 0; i < line; i++)
	{
		for (j = 0; j < row; j++)
		{
			if (i == x + 1 && j == y + 1)
			{
				continue;
			}

		}
	}
	printf("")
	return 0;


}