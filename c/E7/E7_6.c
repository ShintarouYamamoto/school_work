#include<stdio.h>
int main (void)
{
	int month[12],m,i,d,sum=0,a;
	
	
	month[0]=31;
	month[1]=28;
	month[2]=31;
	month[3]=30;
	month[4]=31;
	month[5]=30;
	month[6]=31;
	month[7]=31;
	month[8]=30;
	month[9]=31;
	month[10]=30;
	month[11]=31;
	
	printf("月を入力してください\n");
	scanf("%d",&m);
	
	printf("日を入力してください\n");
	scanf("%d",&d);
	
	if(m<=0||m>=13||d<=0)
	{
		printf("%d月%d日NG\n",m,d);
		return 0;
	}
	
	if(m==1,3,5,7,8,10,12&&d>=32)
	{
		printf("%d月%d日NG\n",m,d);
		return 0;
	}
	
	if(m==4,6,9,11&&d>=31)
	{
		printf("%d月%d日NG\n",m,d);
		return 0;
	}
	
	if(m==2&&d>=29)
	{
		printf("%d月%d日NG\n",m,d);
		return 0;
	}
	
	for(i=0; i<m-1; i++)
	{
		sum=sum+month[i];
	}
	
	a=sum+d;
	
	printf("%d月%d日%d日目\n",m,d,a);
	
	return 0;
}
