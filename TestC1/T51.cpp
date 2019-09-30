#include<iostream>
#include<cmath>
using namespace std;

#define epsilon 0.0001  //����
#define MAXREPT  10  //��������,������Դﲻ������Ҫ��,�����T(m=10)

double f(double x) {
	return 4 / (1 + pow(x, 2));  //pow ָ������
}
double Romberg(double a, double b){ 
	int m, n;//m���Ƶ�������, ��n���Ƹ������λ��ֵķֵ���. n=2^m
	double h, x;
	double s, q;
	double ep; //����Ҫ��
	double *y = new double[MAXREPT];//Ϊ��ʡ�ռ�,ֻ��һά����
	//ÿ��ѭ�����δ洢Romberg�������ÿ��Ԫ��,�Թ�������һ��,��������
	double p;//p����ָʾ������Ԫ�ص�ǰһ��Ԫ��(ͬһ��)
	//������ֵ
	h = b - a;
	y[0] = h * (f(a) + f(b)) / 2.0;
	m = 1;
	n = 1;
	ep = epsilon + 1.0;
	//��������
	while ((ep >= epsilon) && (m < MAXREPT))
	{
		//�������ֹ�ʽ��T2n(Romberg������еĵ�һ��),n��ʼΪ1,�Ժ���
		p = 0.0;
		for (int i = 0; i < n; i++)//��Hn
		{
			x = a + (i + 0.5)*h;
			p = p + f(x);
		}
		p = (y[0] + h * p) / 2.0;//��T2n = 1/2(Tn+Hn),��pָʾ
		//���m��Ԫ��,����Romberg��������е�ǰһ��Ԫ��(pָʾ),
		//����һ�����Ͻ�Ԫ��(y[k-1]ָʾ)���.        
		s = 1.0;
		for (int k = 1; k <= m; k++)
		{
			s = 4.0*s;
			q = (s*p - y[k - 1]) / (s - 1.0);
			y[k - 1] = p;
			p = q;
		}
		p = fabs(q - y[m - 1]);
		m = m + 1;
		y[m - 1] = q;
		n = n + n; h = h / 2.0;
	}
	return (q);
}
int main51()
{
	double a, b;
	cout << " ���������,�������������a������b:" << endl;
	cin >> a >> b;
	cout << " ���ֽ��: " << Romberg(a, b) << endl;
	system("pause");
	return 0;
}