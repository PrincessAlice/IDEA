#include<iostream>
#include<string>
#include<cmath>
using namespace std;

double fd(double x) {
	double c = x*exp(x)-1;
	double d = (x + 1)*exp(x);
	return (c / d);
}

//ţ�ٵ���������Է�����
double newton(double x0, double e) {
	double a = x0;
	double x = x0 - fd(x0);
	int i = 0;
	while (abs(x - a) > e) {
		cout << a << endl;
		a = x;
		i++;		//ѭ������
		x = x - fd(x0);
		cout << "��������Ϊ:" << i << endl;
		if (i > 10) {
			cout << "����ʧ�ܣ�" << endl;
			return x;
		}
	}
	cout << "��������Ϊ:" << i << endl;
}

void main5(){
	double x0, e, accx;
	cout << "������x0��ֵ��" << endl;
	cin >> x0;
	cout << "�������������:" << endl;
    cin >> e;
	accx = newton(x0, e);
	cout << "�ﵽ���㾫��ʹf(x)=0�Ľ�Ϊ:" << accx << endl;
	system("pause");

}