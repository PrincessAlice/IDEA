/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int i=0;
    int count=0;
    for(i=100;i<=200;i++)
    {
    	int j=0;
    	for(j=2;j<=i;j++)
    	{
    		if(i%j==0)
    		{
    			break;
    		}
    	}
    }
    if(i==j)
    {
    	count++;
    	printf("%d",i);
    }
    printf("\n count=%\n",count);
    return 0;    	
}
