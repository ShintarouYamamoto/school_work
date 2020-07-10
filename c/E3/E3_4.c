#include<stdio.h>

int main(void)
{
	int a;
	
	
	printf("自然数を入力してください。\n");
	scanf("%d",&a);
	
	
	if(a%15==0) 
	{
		printf("15の倍数です\n");
	}
	else if(a%5==0) 
	{
		printf("15の倍数ではないが，5の倍数です\n");
	}
	
	else if(a%3==0) 
	{ printf("15の倍数でも5の倍数でもないが，3の倍数です\n");
	}
	
	else 
	{  printf("15の倍数でも5の倍数でも3の倍数でもありません\n");
	}
	
	return 0;
}

