#include<stdio.h>
#include<stdlib.h>

#define SIZE 200

struct student_data 
{
	int num;
	int phys;
	int chem;
};

typedef struct student_data student;

int main(void)
{
	
	int sum1=0,sum2=0;
	int num,phys,chem;
	int cnt=0;
	int number1,number2,number3;
	int max1=0,max2=0;
	int min1=10000,min2=10000;
	char buf[1000];
	char T[1000];
	student s[10];
	FILE *fp,*fpa;
	
	
	printf("ファイル名を入力してください");
	scanf("%s",buf);
	
	if((fp=fopen(buf,"r")) == NULL)
	{
		printf("ファイルなし\n");
		exit(EXIT_FAILURE);
	}
	
	printf("ファイル名を入力してください");
	scanf("%s",T);
	
	if((fpa=fopen(T,"w")) == NULL)
	{
		printf("ファイルなし\n");
		exit(EXIT_FAILURE);
	}
	
	while(fgets(buf,SIZE,fp))
	{
		sscanf(buf,"%d %d %d",&num,&phys,&chem);
		
		student s[10]={num,phys,chem};
		
	}
	
	printf("科目番号,点数の上限，および下限を入力\n");
	scanf("%d",&number1);
	scanf("%d",&number2);
	scanf("%d",&number3);
	
	if(number1==1)
	{
		printf("%d",s.phys);
		fprintf(fpa,"%d",s.phys);
	}
	
	fclose(fp);
	fclose(fpa);
	
	return EXIT_SUCCESS;
}


