#include<stdio.h>
int main (void)
{
	int N,i,sequence[N],inverse[N];
	
	printf("整数の個数を入力してください\n");
	scanf("%d",&N);
	
	for(i=0; i<N; i++)
	{
		printf("%d個目の整数\n",i+1);
		scanf("%d",&sequence[i]);
	}
	
	for(i=0; i<N; i++)
	{
		inverse[i]=sequence[N-i-1];
	}
	
	printf("sequence ");

	for(i=0; i<N; i++)
	{
		printf("%d ",sequence[i]);
	}
	
	printf("\n");
	printf("inverse ");
	
	for(i=0; i<N; i++)
	{
		printf("%d ",inverse[i]);
	}
	return 0;
}
