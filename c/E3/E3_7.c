#include<stdio.h>
#include<math.h>
int main(void)
{
	int n,m;
	double a,b,c;
	double x;
	
	printf("整数nを入力してください。\n");
	scanf("%d",&n);
	printf("整数mを入力してください。\n");
	scanf("%d",&m);
	
	printf("整数 逆数 平方根 自然対数\n");
	printf("----------------------------------\n");
	
	while (n<=m)
	{
		x=n;
		a=1/x;
		b=sqrt(x);
		c=log(x);
		printf("%d, %f, %f, %f\n",n,a,b,c);
		n=++n;
	}
	
	return 0;
}

