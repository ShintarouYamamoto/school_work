#include<stdio.h>
int main(void)
{
	int x,y,a;
	a=0;
	
	for (x=1; x<=6; x++)
	{
		for (y=1; y<=6; y++)
		{
			if (x+y<=6) printf("%d+%d=%d\n",x,y,x+y);
			if (x+y<=6) a++;
			
		}
	}
	printf("個数は%d個\n",a);
	return 0;
}