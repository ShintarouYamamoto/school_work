#include<stdio.h>
#include<string.h>
struct student
{
	int no;
	double height;
	double weight;
	double bmi; 
};

typedef struct student student_t;
#define N_STUDENTS 5

void calculate_bmi(student_t data[]);

void print_student(student_t student);

int main(void)
{
	student_t person[N_STUDENTS];
	
	int i;
	person[0].no=1001;
	person[0].height=160.5;
	person[0].weight=53.1;
	
	person[1].no=1002;
	person[1].height=173.8;
	person[1].weight=79.2;
	
	person[2].no=1003;
	person[2].height=169.7;
	person[2].weight=65.3;
	
	person[3].no=1004;
	person[3].height=175.3;
	person[3].weight=72.7;
	
	person[4].no=1005;
	person[4].height=187.2;
	person[4].weight=98.9;
	
	calculate_bmi(person);
	
	for (i=0; i<N_STUDENTS ;i++)
	{
		print_student(person[i]);
	} 
	return 0;
}
void calculate_bmi(student_t data[])
{
	int i;
	for(i=0;i<N_STUDENTS;i++)
	{
		data[i].bmi=data[i].weight/((data[i].height/100.0)*(data[i].height/100.0));
	}
}
void print_student(student_t student)
{
	printf("%4d %5.1f %4.1f %4.1f\n",student.no,student.height,student.weight,student.bmi);
}