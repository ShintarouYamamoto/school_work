#include<stdio.h>
#include <math.h>

int main(void)
{
	int n,i;
	double a;
	
	printf("nを入力してください。\n");
	scanf("%d",&n);
	printf("aを入力してください。\n");
	scanf("%lf",&a);
	
	for(i=1; i<=n; i++)
	{
		a=a/2;
		printf("%d年後%fkg\n",i,a);
	}
	return 0;
	
}