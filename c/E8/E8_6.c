#include <stdio.h>

#define N 7

int main(void) 
{
	int account[N],i,x,n,k;
	
	account[0]=100000;
	
	for(i=1; i<N; i++)
	{
		account[i]=account[i-1]*1.004+0.5;
	}
	
	printf("何年後かを入力してください\n");
	scanf("%d",&n);
	
	printf("金額を入力してください\n");
	scanf("%d",&x);
	
	if(n>=7)
	{
		return 0;
	}
	
	printf("%d年後の預金額は%d円です\n",n,account[n]);
	
	for(k=0; k<N; k++)
	{
		if(x<account[k])
		{
			printf("初めて%d円を超えたのは\n%d年後でその預金額は%d円です\n",x,k,account[k]);
			return 0;
		}
	}
	
	if(x>account[6])
	{
		printf("指定した金額を超えません\n");
	}
	return 0;
}