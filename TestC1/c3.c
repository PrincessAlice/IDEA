/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{int a[200],sum,max,min,i,n; 
printf("������ɼ��ĸ���:"); 
scanf("%d",&n); 
for(i=0;i<n;i++) 
scanf("%d",&a[i]); 
sum=a[0]; 
max=a[0]; 
min=a[0]; 
for(i=1;i<n;i++) 
{ 
if(max<a[i]) 
max=a[i]; 
if(min>a[i]) 
min=a[i]; 
sum+=a[i]; 
} 
printf("���ſγ̵�ƽ������Ϊ:%d\n",sum/n); 
printf("���ſγ̵���߷�Ϊ:%d\n",max); 
printf("���ſγ̵���ͷ�Ϊ:%d\n",min); 
    
}