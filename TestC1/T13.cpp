//Aug=[1 1 1 1 10;-1 2 -3 1 -2;3 -3 6 -2 7;-4 5 2 -3 0]
//x[i]={1 2 3 4}

#include<iostream>
#include<cmath>
using namespace std;

#define N 10				//��������ά�������Զ���
static double A[N][N];       //ϵ������
static double b[N];			 //�Ҷ���
static double Aug[N][N + 1]; //�������

//��˹����Ԫ��ȥ�������Է�����
void gaussin_LZY(double A[N][N],double b[N],double x[N],int n) {
	int i,i1, j, k;
	double Aug[N][N + 1], maxele, Temp, M;
	for (i = 0; i < n; i++) {			//�����������Aug
		for (j = 0; j < n; j++)
			Aug[i][j] = A[i][j];
			Aug[i][n] = b[i];
	}
	for (i1 = 0; i1 < n - 1; i1++) {  //����Ԫ
		maxele = fabs(Aug[i1][i1]);  //ȡ��Ԫ��fabs��ȡ����ֵ����
		k = i1;
		for (i = i1; i < n; i++)
			if (maxele < fabs(Aug[i1][i]))//�Ƚ�i1��
				k = i1;
		//����
		for (j = 0; j < n + 1; j++)
		{
			Temp = Aug[i1][j];
			Aug[i1][j] = Aug[k][j];
			Aug[k][j] = Temp;
		}
		//��Ԫ���Ե�i1��Ϊ�����д�����һ�е�Ԫ��
		for (k = i1 + 1; k < n; k++)
		{
			M = -Aug[k][i1] / Aug[i1][i1];
			for (j = i1; j < n + 1; j++)
				Aug[k][j] = Aug[k][j] + M * Aug[i1][j];
		}
	}
	//�ش����
	double s;
	x[n - 1] = Aug[n - 1][n] / Aug[n - 1][n - 1];
	for (i = n - 2; i >= 0; i--)
	{
		s = 0;
		for (j = i + 1; j < n; j++)
			s = s + Aug[i][j] * x[j];
		x[i] = (Aug[i][n] - s) / Aug[i][i];
	}

}
//����Ϊ������
int main5()
{
	int i, j, n; double A[N][N], b[N], x[N];//x[N]Ϊδ֪���ĸ���
	cout << "������δ֪���ĸ���" << endl;
	cin >> n;

	if (n > N){
		cout << "�����ģ̫�����޸�Դ�����з��ų���N" << endl;
		return 0;
	}
	for (i = 0; i < n; i++){
		cout << "�밴˳������Aug�ĵ�" << i + 1 << "��:";
		for (j = 0; j < n; j++)
			cin >> A[i][j];//ϵ������
			cin >> b[i];
	}
	gaussin_LZY(A, b, x, n);//��������
	for (i = 0; i < n; i++)//���x��ֵ
	{
		cout << "x" << "[" << i << "]=" << x[i] << endl;
	}
	system("pause");
	return 0;
}



