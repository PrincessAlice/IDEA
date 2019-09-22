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
		cout << "请问要继续录入吗？（请输入Y或N）";
		cin >> flag;
		if (toupper(flag) != 'Y')
		{
			if (toupper(flag) == 'N')
			{
				break;
			}
			else
			{
				cout << "输入错误，请重新输入： ";
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
		cout << "学号        姓名  性别  语文  数学  英语  物理  化学  生物  平时成绩   总评" << endl;
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
	cout << "请输入要查找的学生的姓名：";
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
		cout << "对不起，没有你要查找的学生" << endl;
	else
	{
		cout << "************************************************************************\n";
		cout << "学号  姓名  性别  语文  数学  英语  物理  化学  生物  平时成绩  总评    \n";
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
	cout << "请输入你要修改的学生姓名：";
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
		cout << "对不起，没有要修改的学生" << endl;
	else
	{
		cout << "请输入修改后学生的学号：";
		cin >> stu[t].number;
		cout << "请输入修改后学生的姓名：";
		cin >> stu[t].name;
		cout << "请输入修改后学生的性别：";
		cin >> stu[t].sex;
		cout << "请输入修改后学生的语文成绩：";
		cin >> stu[t].score[0];
		cout << "请输入修改后学生的数学成绩：";
		cin >> stu[t].score[1];
		cout << "请输入修改后学生的英语成绩：";
		cin >> stu[t].score[2];
		cout << "请输入修改后学生的物理成绩：";
		cin >> stu[t].score[3];
		cout << "请输入修改后学生的化学成绩：";
		cin >> stu[t].score[4];
		cout << "请输入修改后学生的生物成绩：";
		cin >> stu[t].score[5];
		cout << "请输入修改后学生的平时成绩：";
		cin >> stu[t].score[6];
		stu[t].total = stu[t].score[0] + stu[t].score[1] + stu[t].score[2] + stu[t].score[3] + stu[t].score[4] + stu[t].score[5] + stu[t].score[6];
		stu[t].average = stu[t].total / 6;
		stu[t].last = (int)(stu[t].score[6] * 0.3 + stu[t].average*0.7);
		cout << "修改成功 ！" << endl;
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
		cout << "请输入你要删除的学生姓名：";
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
			cout << "你要删除的学生不存在" << endl;
		cout << "是否要继续删除？（请输入Y或N）" << endl;
		cin >> c;
		if (toupper(c) != 'Y'&&toupper(c) != 'N')
		{
			cout << "选择错误，请重新选择！" << endl;
			cin >> c;
		}
	} while (toupper(c) == 'Y');
	_getch();
}
void student::save()
{
	char filename1[20];
	cout << "请输入文件名：";
	cin >> filename1;
	ofstream fout(filename1,ios::app);
	if (!fout)cout << "文件不能够打开！" << endl;
	else
	{
		for (int i = 0; i<n; i++)
			fout << ' ' << stu[i].number << ' ' << stu[i].name << ' ' << stu[i].sex << ' '
			<< stu[i].score[0] << ' ' << stu[i].score[1] << ' ' << stu[i].score[2] << ' ' << stu[i].score[3] << ' '
			<< stu[i].score[4] << ' ' << stu[i].score[5] << ' ' << stu[i].score[6] << ' '
			<< stu[i].total << ' ' << stu[i].average << ' ' << stu[i].last;

		cout << "保存成功！" << endl;
	}
	fout.close();
	_getch();
}
void student::load()
{
	char filename2[40];
	cout << "请输入你要读取的文件名：";
	cin >> filename2;
	ifstream fin(filename2, ios::in);
	if (!fin)cout << "文件打不开！" << endl;
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
		cout << "文件已录入！" << endl;
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
	cout << "学号：";
	scin >> s1.number;
	cout << "姓名：";
	scin >> s1.name;
	cout << "性别：";
	scin >> s1.sex;
	cout << "语文：";
	scin >> s1.score[0];
	cout << "数学：";
	scin >> s1.score[1];
	cout << "英语：";
	scin >> s1.score[2];
	cout << "物理：";
	scin >> s1.score[3];
	cout << "化学：";
	scin >> s1.score[4];
	cout << "生物：";
	scin >> s1.score[5];
	cout << "平时成绩：";
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
	cout << "    欢迎登录学生成绩管理系统" << endl;
	cout << "1.学生成绩录入     2.浏览学生成绩 " << endl;
	cout << "3.查询学生成绩     4.修改学生成绩 " << endl;
	cout << "5.删除学生成绩     6.数据存入文件 " << endl;
	cout << "7.文件读出数据     0.退出系统     " << endl;
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
