#include<stdio.h>
#include<math.h>
int main(void)
{
	int x,n,m;
	double a;
	
	m=1;
	printf("入金額を入力してください。\n");
	scanf("%d",&x);
	printf("何年後かを入力してください。\n");
	scanf("%d",&n);
	
	a=x;
	
	while (m<=n)
	{
		a=a*1003/1000;
		printf("%d年後 %.0f円\n",m,a);
		m=m+1;
		a=a+x;
	}
	
	return 0;
}

