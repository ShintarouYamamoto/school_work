#include<stdio.h>
int main(void)
{
	int a,b,c,r,n;
	
	printf("nを入力してください。\n");
	scanf("%d",&n);
	a=0;
	
	for (a=1; a<=n; a++)
	{
		for (b=1; b<=n; b++)
		{
			for (c=1; c<=n; c++)
			{if (a*a+b*b==c*c && a<b) r++;
			}
			
		}
	}
	printf("個数は%d個\n",r);
	return 0;
}