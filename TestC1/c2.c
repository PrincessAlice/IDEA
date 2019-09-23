/* Note:Your choice is C IDE */
#define _CRT_SECURE_NO_WARNINGS	
#include "iostream"
#include "conio.h"
#include "iomanip"
#include "stdio.h"
#include "string.h"
#include "stdlib.h"
#include "fstream"
using namespace std;
class student
{
private:
	char name[20];
	char sex[10];
	int number;
	int score[10];
	int total;
	int average;
	int last;
public:
	student();
	void add();
	void output();
	void find();
	void modify();
	void deleted();
	void save();
	void load();
	student & operator=(student & T);
	friend istream & operator >> (istream & scin, student & s1);
	friend ostream & operator << (ostream & scout, student & s2);
};
student stu[400];
int n = 0;
void student::add()
{
	char flag = 'Y';
	while (toupper(flag) == 'Y')
	{
		cin >> stu[n];
		n++;
		cout << "����Ҫ����¼���𣿣�������Y��N��";
		cin >> flag;
		if (toupper(flag) != 'Y')
		{
			if (toupper(flag) == 'N')
			{
				break;
			}
			else
			{
				cout << "����������������룺 ";
				cin >> flag;
			}
		}
	}
}
void student::output()
{
	if (n != 0)
	{
		cout << "************************************************************************" << endl;
		cout << "ѧ��        ����  �Ա�  ����  ��ѧ  Ӣ��  ����  ��ѧ  ����  ƽʱ�ɼ�   ����" << endl;
		cout << "************************************************************************" << endl;
		for (int t = 0; t<n; t++)
		{
			cout << stu[t];
		}
	}
	getchar();
}
void student::find()
{
	int f3 = 0;
	char n1[40];
	student temp;
	cout << '/n';
	cout << "������Ҫ���ҵ�ѧ����������";
	cin >> n1;
	for (int j = 0; j<n; j++)
	{
		if (strcmp(stu[j].name, n1) == 0)
		{
			temp = stu[j];
			f3 = 1;
		}
	}
	if (f3 = 0)
		cout << "�Բ���û����Ҫ���ҵ�ѧ��" << endl;
	else
	{
		cout << "************************************************************************\n";
		cout << "ѧ��  ����  �Ա�  ����  ��ѧ  Ӣ��  ����  ��ѧ  ����  ƽʱ�ɼ�  ����    \n";
		cout << "************************************************************************\n";
		cout << setw(9) << temp.number << setw(6) << temp.name << setw(6) << temp.sex << setw(6) << temp.score[0]
			<< setw(6) << temp.score[1] << setw(6) << temp.score[2] << setw(6) << temp.score[3] << setw(6) << temp.score[4]
			<< setw(6) << temp.score[5] << setw(6) << temp.score[6] << setw(6) << temp.last << endl;
	}
	_getch();
}
void student::modify()
{
	int f4 = 0;
	int t;
	char n2[100];
	cout << '\n';
	cout << "��������Ҫ�޸ĵ�ѧ��������";
	cin >> n2;
	for (int j = 0; j<n; j++)
	{
		if (strcmp(stu[j].name, n2) == 0)
		{
			t = j;
			f4 = 1;
		}
	}
	if (f4 == 0)
		cout << "�Բ���û��Ҫ�޸ĵ�ѧ��" << endl;
	else
	{
		cout << "�������޸ĺ�ѧ����ѧ�ţ�";
		cin >> stu[t].number;
		cout << "�������޸ĺ�ѧ����������";
		cin >> stu[t].name;
		cout << "�������޸ĺ�ѧ�����Ա�";
		cin >> stu[t].sex;
		cout << "�������޸ĺ�ѧ�������ĳɼ���";
		cin >> stu[t].score[0];
		cout << "�������޸ĺ�ѧ������ѧ�ɼ���";
		cin >> stu[t].score[1];
		cout << "�������޸ĺ�ѧ����Ӣ��ɼ���";
		cin >> stu[t].score[2];
		cout << "�������޸ĺ�ѧ���������ɼ���";
		cin >> stu[t].score[3];
		cout << "�������޸ĺ�ѧ���Ļ�ѧ�ɼ���";
		cin >> stu[t].score[4];
		cout << "�������޸ĺ�ѧ��������ɼ���";
		cin >> stu[t].score[5];
		cout << "�������޸ĺ�ѧ����ƽʱ�ɼ���";
		cin >> stu[t].score[6];
		stu[t].total = stu[t].score[0] + stu[t].score[1] + stu[t].score[2] + stu[t].score[3] + stu[t].score[4] + stu[t].score[5] + stu[t].score[6];
		stu[t].average = stu[t].total / 6;
		stu[t].last = (int)(stu[t].score[6] * 0.3 + stu[t].average*0.7);
		cout << "�޸ĳɹ� ��" << endl;
	}
	_getch();
}
void student::deleted()
{
	char n3[40];
	bool f5 = 0;
	char c;
	do{
		cout << '\n';
		cout << "��������Ҫɾ����ѧ��������";
		cin >> n3;
		for (int i = 0; i<n; i++)
		{
			if (strcmp(n3, stu[i].name) == 0)
			{
				f5 = 1;
				n--;
				do{
					stu[i] = stu[i + 1];
					i++;
				} while (i <= n);
			}
		}
		if (f5 == 0)
			cout << "��Ҫɾ����ѧ��������" << endl;
		cout << "�Ƿ�Ҫ����ɾ������������Y��N��" << endl;
		cin >> c;
		if (toupper(c) != 'Y'&&toupper(c) != 'N')
		{
			cout << "ѡ�����������ѡ��" << endl;
			cin >> c;
		}
	} while (toupper(c) == 'Y');
	_getch();
}
void student::save()
{
	char filename1[20];
	cout << "�������ļ�����";
	cin >> filename1;
	ofstream fout(filename1,ios::app);
	if (!fout)cout << "�ļ����ܹ��򿪣�" << endl;
	else
	{
		for (int i = 0; i<n; i++)
			fout << ' ' << stu[i].number << ' ' << stu[i].name << ' ' << stu[i].sex << ' '
			<< stu[i].score[0] << ' ' << stu[i].score[1] << ' ' << stu[i].score[2] << ' ' << stu[i].score[3] << ' '
			<< stu[i].score[4] << ' ' << stu[i].score[5] << ' ' << stu[i].score[6] << ' '
			<< stu[i].total << ' ' << stu[i].average << ' ' << stu[i].last;

		cout << "����ɹ���" << endl;
	}
	fout.close();
	_getch();
}
void student::load()
{
	char filename2[40];
	cout << "��������Ҫ��ȡ���ļ�����";
	cin >> filename2;
	ifstream fin(filename2, ios::in);
	if (!fin)cout << "�ļ��򲻿���" << endl;
	else
	{
		for (int i = 0;; i++, n = i - 1)
		{
			if (fin.eof())break;
			fin >> stu[i].number >> stu[i].name >> stu[i].sex
				>> stu[i].score[0] >> stu[i].score[1] >> stu[i].score[2] >> stu[i].score[3]
				>> stu[i].score[4] >> stu[i].score[5] >> stu[i].score[6]
				>> stu[i].total >> stu[i].average >> stu[i].last;
		}
		cout << "�ļ���¼�룡" << endl;
	}
	fin.close();
	_getch();
}
student & student::operator=(student & T)
{
	strcpy(name, T.name);
	strcpy(sex, T.sex);
	number = T.number;
	for (int i = 0; i<7; i++)
		score[i] = T.score[i];
	total = T.total;
	average = T.average;
	last = T.last;
	return (*this);
}
ostream & operator << (ostream & scout, student &s2)
{
	cout << setw(9) << s2.number << setw(6) << s2.name << setw(6) << s2.sex << setw(6) << s2.score[0]
		<< setw(6) << s2.score[1] << setw(6) << s2.score[2] << setw(6) << s2.score[3] << setw(6) << s2.score[4]
		<< setw(6) << s2.score[5] << setw(7) << s2.score[6] << setw(9) << s2.last << '\n';
	return scout;
}
istream & operator >>(istream & scin, student &s1)
{
	cout << '\n';
	cout << "ѧ�ţ�";
	scin >> s1.number;
	cout << "������";
	scin >> s1.name;
	cout << "�Ա�";
	scin >> s1.sex;
	cout << "���ģ�";
	scin >> s1.score[0];
	cout << "��ѧ��";
	scin >> s1.score[1];
	cout << "Ӣ�";
	scin >> s1.score[2];
	cout << "������";
	scin >> s1.score[3];
	cout << "��ѧ��";
	scin >> s1.score[4];
	cout << "���";
	scin >> s1.score[5];
	cout << "ƽʱ�ɼ���";
	scin >> s1.score[6];
	s1.total = s1.score[0] + s1.score[1] + s1.score[2] + s1.score[3] + s1.score[4] + s1.score[5];
	s1.average = s1.total / 6;
	s1.last = (int)(s1.score[6] * 0.3 + s1.average*0.7);
	return scin;
}
student::student()
{
	strcpy(name, " ");
	strcpy(sex, " ");
	number = 0;
	for (int i = 0; i<7; i++)score[i] = 0;
	total = 0;
	average = 0;
	last = 0;
}
void menu()
{
	cout << "    ��ӭ��¼ѧ���ɼ�����ϵͳ" << endl;
	cout << "1.ѧ���ɼ�¼��     2.���ѧ���ɼ� " << endl;
	cout << "3.��ѯѧ���ɼ�     4.�޸�ѧ���ɼ� " << endl;
	cout << "5.ɾ��ѧ���ɼ�     6.���ݴ����ļ� " << endl;
	cout << "7.�ļ���������     0.�˳�ϵͳ     " << endl;
}
int main()
{
	int choose;
	student s;
	do{
		menu();
		cin >> choose;
		switch (choose)
		{
		case 1: s.add(); break;
		case 2: s.output(); break;
		case 3: s.find(); break;
		case 4: s.modify(); break;
		case 5: s.deleted(); break;
		case 6: s.save(); break;
		case 7: s.load(); break;
		default:break;
		}
	} while (choose != 0);
	return 0;
}