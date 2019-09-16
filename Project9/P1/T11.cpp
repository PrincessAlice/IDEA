#include<iostream>
#include<cmath>
using namespace std;

#define N 3        //����ά�������Զ���

static double A[N][N];      //ϵ������
static double B[N];         //�Ҷ���
static double Y[N];         //�м���
static double X[N];         //���
static double S[N];         //ѡȡ����Ԫ�ıȽ���

int i, j, k;         //������

void main1()
{
	cout << "���������Է����飨ai1��ai2��ai3......ain, yi����" << endl;
	for (i = 0; i < N; i++){
		for (int j = 0; j < N; j++)
			cin >> A[i][j];
		cin >> B[i];
	}
	for (k = 0; k < N; k++){
		//ѡ����Ԫ
		int index = k;
		for (i = k; i < N; i++){
			double temp = 0;
			for (int m = 0; m < k; m++){
				temp = temp + A[i][m] * A[m][k];
			}
			S[i] = A[i][k] - temp;
			if (S[index] < S[i]){
				index = i;
			}
		}
		//������
		double temp;
		for (i = k; i < N; i++){
			temp = A[index][i];
			A[index][i] = A[k][i];
			A[k][i] = temp;
		}
		temp = B[index];
		B[index] = B[k];
		B[k] = temp;
		// ����L��U����
		for (j = k; j < N; j++){
			double temp = 0;
			for (int m = 0; m < k; m++){

				temp = temp + A[k][m] * A[m][j];
			}
			A[k][j] = A[k][j] - temp;   //�ȹ���Uһ�е�����
		}
		for (i = k + 1; i < N; i++){
			double temp = 0;
			for (int m = 0; m < k; m++){
				temp = temp + A[i][m] * A[m][k];
			}
			A[i][k] = (A[i][k] - temp) / A[k][k];  //�ٹ���Lһ�е�����
		}
	}
	//���LY = B
	Y[0] = B[0];
	for (i = 1; i < N; i++){
		double temp = 0;
		for (int j = 0; j < i; j++){
			temp = temp + A[i][j] * Y[j];
		}
		Y[i] = B[i] - temp;
	}
	//���UX = Y
	X[N - 1] = Y[N - 1] / A[N - 1][N - 1];
	for (i = N - 2; i >= 0; i--){
		double	temp = 0;
		for (int j = i + 1; j < N; j++){
			temp = temp + A[i][j] * X[j];
		}
		X[i] = (Y[i] - temp) / A[i][i];
	}
	//��ӡX
	cout << "���Է�����Ľ⣨X1��X2��X3......Xn��Ϊ��" << endl;
	for (i = 0; i < N; i++){
		cout << X[i] << " ";
	}
}
