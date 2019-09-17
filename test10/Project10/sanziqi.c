#include <stdio.h>
#include <stdlib.h>
int Menu()
{
	printf("********************\n");
	printf("    1.开始游戏      \n");
	printf("    0.结束游戏      \n");
	printf("********************\n");
	printf("请输入你的选择：\n");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}

#define Max_Row 3
#define Max_Col 3
char chess_board[Max_Row][Max_Col];

void Init()  //初始化  棋盘使用x表示玩家落子 h表示电脑落子 ' '表示未落子
{
	for (int row = 0; row < Max_Row; ++row)
	{
		for (int col = 0; col < Max_Col; ++col)
		{
			chess_board[row][col] = ' ';
		}
	}
}
void Print()  //打印棋盘 
{
	for (int row = 0; row < Max_Row; ++row)
	{
		printf("| %c| %c| %c|\n",chess_board[row][0],chess_board[row][1],chess_board[row][2]);
	    if(row!=Max_Row-1)
		{
			printf("|---|---|---|\n");
		}
	}
}
void ManPlay()
{
	printf("玩家落子!\n");
	printf("请输入一组坐标(row col):");
	int row = 0;
	int col = 0;
	scanf("%d %d" ,&row, &col);
	if(row>=Max_Row||row<0||col>=Max_Col||col<0)
	{
		printf("您的输入有误!\n");
		continue;
	}
	if()

}
void CheckGameOver()
{

}
void CompPlay()
{

}
void Game()
{
	Init();//1.创建并初始化一个棋盘
	while(1)
	{
		Print();//2.打印棋盘

	    ManPlay();//3.玩家落子

	    CheckGameOver();//4.检测游戏结束

    	CompPlay();//5.电脑落子

	    CheckGameOver();//6.检测游戏结束
	}
}
int main()
{
	while (1)
	{
		int choice = Mneu();
		if (choice==1)
		{
			Game();
		}else if(choice==0)
		{
			printf("游戏结束，感谢您的参与!\n");
		}
		else
		{
			printf("您的输入有误！\n");
			break;
		}
	}
	system("pause");
	return 0;
}