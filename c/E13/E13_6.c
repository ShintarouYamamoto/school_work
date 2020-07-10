#include<stdio.h>

int main(void)
{
	int score_a[4],score_b[4],sum[4],i;
	
	for(i=0;i<4;i++)
	{
		printf("中間試験 %dの科目\n",i);
		scanf("%d",&score_a[i]);
		
		printf("期末試験 %dの科目\n",i);
		scanf("%d",&score_b[i]);
		
		sum[i]=score_a[i]+score_b[i];
	}
	
	printf("英語 合計点数 %d 平均点 %f\n",sum[0],(double)sum[0]/2);
	printf("数学 合計点数 %d 平均点 %f\n",sum[1],(double)sum[1]/2);
	printf("物理 合計点数 %d 平均点 %f\n",sum[2],(double)sum[2]/2);
	printf("化学 合計点数 %d 平均点 %f\n",sum[3],(double)sum[3]/2);
	
	return 0;
}