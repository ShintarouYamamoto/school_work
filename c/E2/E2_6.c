#include<stdio.h>

int main(void)
{
	int a,b,c;
	double result;
	printf("aの値を入力してください。\n");
	scanf("%d",&a);
	printf("bの値を入力してください。\n");
	scanf("%d",&b);
	c=a+b;
	result=(double)c/2;
	
	printf("%g\n",result);
	
	
	return 0;
}