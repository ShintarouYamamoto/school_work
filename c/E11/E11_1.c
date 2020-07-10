#include<stdio.h>
#include<string.h>
struct lecture
{
	int day,
	period; 
	char name[40],prof[16]; 
};


void print_lecture(struct lecture subj[]);

int main(void)
{
	struct lecture subj[7];
	strcpy(subj[0].name,"Introduction toInfomations");
	strcpy(subj[0].prof,"isaka");
	subj[0].day=2; 
	subj[0].period=5;
	
	strcpy(subj[1].name,"Calculus");
	strcpy(subj[1].prof,"hayakaw");
	subj[1].day=5;
	subj[1].period=2;
	
	strcpy(subj[2].name,"Linear Algebra");
	strcpy(subj[2].prof,"miyanisi");
	subj[2].day=1;
	subj[2].period=4;
	
	strcpy(subj[3].name,"Operating System");
	strcpy(subj[3].prof,"oosaki");
	subj[3].day=2;
	subj[3].period=4;
	
	strcpy(subj[4].name,"Logic Circuit");
	strcpy(subj[4].prof,"isiura");
	subj[4].day=2;
	subj[4].period=2;
	
	strcpy(subj[5].name,"Computer Architecture");
	strcpy(subj[5].prof,"isiura");
	subj[5].day=3;
	subj[5].period=3;
	
	strcpy(subj[6].name,"Career Design");
	strcpy(subj[6].prof,"maekawa");
	subj[6].day=4;
	subj[6].period=3;
	
	print_lecture(subj);
	
	return 0;
}
void print_lecture(struct lecture subj[])
{
	int a,i,b=0;
	
	printf("時限を入力してください。");
	scanf("%d",&a);
	
	printf("科目名\n担当教員\n曜日\n時限\n");
	
	for(i=0;i<7;i++)
	{
		if(subj[i].period==a)
		{
			printf("%s \n%s \n%d \n%d \n",subj[i].name,subj[i].prof,subj[i].day,subj[i].period); 
		}
		else
		{
			b++;
		}
	}
	if(b==7)
	{ 
		printf("授業はありません\n");
	} 
}