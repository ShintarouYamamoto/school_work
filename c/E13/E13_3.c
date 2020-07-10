#include<stdio.h>

int main(void)
{
	int i,x,y,a,b;
	
	printf("整数xを入力\n");
	scanf("%d",&x);
	
	printf("整数yを入力\n");
	scanf("%d",&y);
	
	b=x;
	
	for(i=0;b<y;i=i+4)
	{
		b=b+i;
	}
	
	printf("yより小さい数の和は%d\n",b-4);
	
	return 0;
}
