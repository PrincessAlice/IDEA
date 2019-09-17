#include<stdio.h>
#include<stdlib.h>
typedef int Elemtype
typedef struct Node
{
	Elemtype data;
	struct Node*next;
}Node,*Linklist;
void Creatheadlist(Linklist L)
{
	Linklist p, t;
	Elemtype shuzi = 1;
	p = L;
	while (shuzi != 0)
	{
		scanf("%d", &shuzi);
		t = (Linklist)malloc(sizeof(Node));
		t->data = shuzi;
		t->next = NULL;
		t->next = p->next;
		p->next = t;
		p = t;
	}
}