/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{int a[200],sum,max,min,i,n; 
printf("请输入成绩的个数:"); 
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
printf("这门课程的平均分数为:%d\n",sum/n); 
printf("这门课程的最高分为:%d\n",max); 
printf("这门课程的最低分为:%d\n",min); 
    
}