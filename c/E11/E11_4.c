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
	int i;
	double x;
	student_t person[N_STUDENTS]=
	{
		{ 
			1001, 160.5, 53.1, 0.0,
		},
		{
			1002, 173.8, 79.2, 0.0,
		},
		{
			1003, 169.7, 65.3, 0.0,
		},
		{ 
			1004, 175.3, 72.7, 0.0,
		},
		{ 
			1005, 187.2, 98.9, 0.0,
		}
	};
	calculate_bmi(person);
	
	printf("BMIを入力してください。");
	scanf("%lf",&x);
	
	for (i=0; i<N_STUDENTS ;i++)
	{ 
		if(x<person[i].bmi)
		{
			print_student(person[i]);
		}
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