#include<stdio.h>
#include<float.h>
#include<math.h>
int main (void)
{
	int month[12],i;
	double max_a,min_a,v,s,t,x=0.0;
	
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
	
	max_a=-DBL_MAX;
	min_a=DBL_MAX;
	for(i=0;i<=11;i++)
	{
		if(month[i]>=max_a)
		{
			max_a=(double)month[i];
		}
		if(month[i]<=min_a)
		{
			min_a=(double)month[i];
		}
	}
	printf("最大の日数は%.0f\n",max_a);
	printf("最小の日数は%.0f\n",min_a);
	
	for(i=0;i<=11;i++)
	{
		x=x+(double)month[i];
	}
	printf("日数の合計は%0.f日\n",x);
	
	t=x/12;
	for(x=0,i=0;i<=11;i++)
	{
		x+=((double)month[i]-t)*((double)month[i]-t);
	}
	v=x/12;
	s=sqrt(v);
	printf("日数の標準偏差%10.3f\n",s);
	
	return 0;
}
