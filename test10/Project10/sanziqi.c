#include <stdio.h>
#include <stdlib.h>
int Menu()
{
	printf("********************\n");
	printf("    1.��ʼ��Ϸ      \n");
	printf("    0.������Ϸ      \n");
	printf("********************\n");
	printf("���������ѡ��\n");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}

#define Max_Row 3
#define Max_Col 3
char chess_board[Max_Row][Max_Col];

void Init()  //��ʼ��  ����ʹ��x��ʾ������� h��ʾ�������� ' '��ʾδ����
{
	for (int row = 0; row < Max_Row; ++row)
	{
		for (int col = 0; col < Max_Col; ++col)
		{
			chess_board[row][col] = ' ';
		}
	}
}
void Print()  //��ӡ���� 
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
	printf("�������!\n");
	printf("������һ������(row col):");
	int row = 0;
	int col = 0;
	scanf("%d %d" ,&row, &col);
	if(row>=Max_Row||row<0||col>=Max_Col||col<0)
	{
		printf("������������!\n");
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
	Init();//1.��������ʼ��һ������
	while(1)
	{
		Print();//2.��ӡ����

	    ManPlay();//3.�������

	    CheckGameOver();//4.�����Ϸ����

    	CompPlay();//5.��������

	    CheckGameOver();//6.�����Ϸ����
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
			printf("��Ϸ��������л���Ĳ���!\n");
		}
		else
		{
			printf("������������\n");
			break;
		}
	}
	system("pause");
	return 0;
}