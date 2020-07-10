#include<stdio.h>

int  gcd(int a,int b)
{
	int c;
	
	while((c=a%b)!=0)
	{
		a=b;
		b=c;
	}
	return b;
}

void  print_cd(int a,int b)
{
	int i,g;
	
	g=gcd(a,b);
	
	printf("全約数を表示\n");
	
	for(i=1;i<=g;i++)
	{
		if(g%i==0)
		{
			printf("%d ",i);
		}
	}
}

int main(void)
{
	int a,b;
	
	printf("整数aを入力\n");
	scanf("%d",&a);
	
	printf("整数bを入力\n");
	scanf("%d",&b);
	
	printf("最大公約数 %d\n",gcd(a,b));
	
	print_cd(a,b);
	
	return 0;
}
