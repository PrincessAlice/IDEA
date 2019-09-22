/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    char name[20];
    float score[5];
}
 
float avg_student_score(Student stu)
{
    int i;
    float sum = 0;
    for (i=0;i<5;++i)
        sum += stu.score[i];
    return sum/5;
}
 
float avg_course_score(Student stu[], int n, int k)
{
    int i;
    float sum = 0;
    for (i = 0; i < n; ++i)
        sum += stu[i].score[k];
    return sum/n;
}
 
float max_course_score(Student) stu[], int n, int k)
{
    int i;
    float max = 0;
    for (i=0; i<n;++i)
        if (max<stu[i].score[k])
            max=stu[i].score[k];
    return max;
}
 
float min_course_score(Student) stu[], int n, int k)
{
    int i;
    float min = 0;
    for (i = 0; i < n; ++i)
        if (min > stu[i].score[k])
            min = stu[i].score[k];
    return min;
}
 
bool isFailed(Student)(stu, int k)
{
    if (stu.score[k] < 60)
        return ����;
    return ��ȷ;
}
 
int main()
{
    int i, j;
    student stu[20];
    printf("������ѧ���������ͳɼ�:\n");
    for (i = 0; i < 20; ++i)
    {
        printf("%d. ", i + 1);
        scanf("%s", stu[i].name);
        for (j = 0; j < 5; ++j)
            scanf("%f", &stu[i].score[j]);
    }
    printf("1. ���ÿ��ѧ����ƽ���ɼ�\n");
    printf("2. ���ÿ�ſγ̵�ƽ���ɼ�\n");
    printf("3. ���ÿ�ſγ̵���߷ֺ���ͷ�\n");
    printf("4. ����в�����γ̵�ѧ������\n");
    fflush(stdin);
 
    switch (getchar())
    {
    case '1':
        for (i = 0; i < 20; ++i)
            printf("%s\t%.2f\n", stu[i].name, avg_student_score(stu[i]));
        break;
    case '2':
        for (j = 0; j < 5; ++j)
            printf("%d. %.2f ", j + 1, avg_course_score(stu, 20, j));
        printf("\n");
        break;
    case '3':
        for (j = 0; j < 5; ++j)
            printf("%d. %.2f %.2f\n", j + 1, max_course_score(stu, 20, j));
        break;
    case '4':
        for (i = 0; i < 20; ++i)
            for (j = 0; j < 5; ++j)
            {
                if (isFailed(stu[i], j))
                    printf("%s ", stu[i].name);
                break;
            }
        break;
    }
    return 0;
}
    
}