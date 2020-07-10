#include<stdio.h>

int main(void)
{
	int a,b,c;
	double BMI;
	
	printf("身長を入力してください。\n");
	scanf("%d",&a);
	printf("体重を入力してください。\n");
	scanf("%d",&b);
	
	c=a*a;
	BMI=(double)b/(double)c*10000;
	
	printf("BMIは%.2f",BMI);
	
	return 0;
}
