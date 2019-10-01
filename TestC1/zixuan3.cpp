#include<iostream>
#include<cmath>
#define M 4
using namespace std;

void majacobi(double A[M][M],double b[M],double x0[M],double ep,int N)
{
	int k=1,i,j;
	double x[M]={0};
	double chax[M];
	
	while(k<N)
	{
		cout<<"��"<<k<<"�ε������\n";
		for(i=0;i<M;i++)
		{
			cout<<"x0["<<i<<"]="<<x0[i]<<"  ";
		}
		cout<<endl;

		for(i=0;i<M;i++)
		{
			double sum=0;
			for(j=0;j<M;j++)
			{
				if(j==i) continue;
				sum=sum+A[i][j]*x0[j];
			}
			x[i]=(b[i]-sum)/A[i][i];
			cout<<"x["<<i<<"]="<<x[i]<<"   ";
		}
		cout<<endl;
		for(i=0;i<M;i++)
		{
			chax[i]=x[i]-x0[i];
		}
		cout<<endl;
		double max=fabs(chax[0]);
		for(i=1;i<M;i++)
		{
			if(max<=chax[i])
			{
				max=fabs(chax[i]);
			} 
		}
		if(max<ep) break;

		for(i=0;i<M;i++)
		{
			x0[i]=x[i];
		}
		k++;
		cout<<"k="<<k;
	}
	if(k==N) cout<<"�Ѵ������������"<<endl;
	cout<<"k="<<k-1<<endl;
	for(i=0;i<M;i++)
	{
		cout<<"x["<<i<<"]="<<x[i]<<endl;
	}
	
}
//�ſ˱ȵ���
int main()
{
	double A[M][M];
	double x0[M]={0};
	double b[M]={0.68,1.18,0.12,0.74};
	cout<<"������ϵ������: "<<endl;
	for(int i=0;i<M;i++)
	{
		for(int j=0;j<M;j++)
		{
			cin>>A[i][j];
		}
	}
	cout<<"�����볣������: "<<endl;
	for(int k=0;k<M;k++)
	{
		cin>>b[k];
	}
	cout<<"�����������ʼ����: "<<endl;
	for(int l=0;l<M;l++)
	{
		cout<<"x0["<<l+1<<"]=";
		cin>>x0[l];
	}
	
	majacobi(A,b,x0,0.000001,500);
	return 0;
}