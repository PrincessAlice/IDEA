#include<iostream>
#include<string>
#include<cmath>
using namespace std;
double fd(double x) {
	double c = x*exp(x)-1;
	double d = (x + 1) *exp(x);
	return (c / d);
}

void newton(double x0, double e) {
	double a = x0;
	double x = x0 - fd(x0);
	int i = 0;
	while (abs(x - a) > e) {
		cout << a << endl;
		a = x;
		i++;		//ѭ������
		x = x - fd(x0);
		if (i > 50) {
			cout << "����ʧ�ܣ�" << endl;
			return;
		}
	}
	cout << "��������Ϊ��" << i << endl;
}

int main5(){
	double x0, e;
	cout << "������x0��ֵ��" << endl;
	cin >> x0;
	cout << "�������������:" << endl;
    cin >> e;
	newton(x0, e);
	system("pause");
	return 0;

}