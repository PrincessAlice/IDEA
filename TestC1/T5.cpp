//�����������

#include<iostream>
#include<cmath>
using namespace std; 

double ff(double x) {
	return 4 / (1 + pow(x,2));  //pow ָ������
}

double Romberg(double a, double b,double eps) {  

	int N = 0; //NΪ���������ݸ���
	double h;  //����
	double x, sum;
	double T[10],S[10],C[10],R[10]; //һά���飬�洢Romberg�ļ���ֵ
	double T1, T2;

	//������ֵ
	h = b - a;
	T2=T1= h * (ff(a) + ff(b)) / 2.0;
	
	//���ι�ʽ
	for (int i = 0; i < N + 3; i++) {
		T[i] = T2;
		sum = 0;
		x = a + h / 2;
		while (x < b) {
			sum = ff(x) + sum;
			x += h;
		}
		T2 = (T1 + h * sum) / 2;
		h = h / 2;
		T1 = T2;
	}
	//�������ι�ʽ����������ʽ��ת��
	for (int i = 0; i < N + 2; i++) {
		S[i] = (4 * T[i + 1] - T[i]) / 3;
	}
	//����������������˹��ת��
	for (int i = 0; i < N + 1; i++) {
		C[i] = (16 * S[i + 1] - S[i]) / 15;
	}
	//���п���˹���������ת��
	for (int i = 0; i < N; i++) {
		R[i] = (64 * C[i + 1] - C[i]) / 63;
	}	
	return R[2];

}

int main50() {
	double a, b,N;
	double eps = 0;
	cout << "��������ֵ�������[a,b]:" << endl;
	cin >> a >> b;
	cout << "���������������ݸ���N:" << endl;
	cin >> N;
	cout << "�����뾫��eps :" << endl;
	cin >> eps;
	cout << " ���ֽ��: " << Romberg(a, b, eps) << endl;
	system("pause");
	return 0;
}

