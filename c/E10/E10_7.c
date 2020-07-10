#include<stdio.h>
#include<math.h>

double cos_triangle(int x, int y, int z)
{
	double cos;
	
	cos=((double)y*(double)y+(double)z*(double)z-(double)x*(double)x)/(2*(double)y*(double)z);
	
	return cos;
}

int main(void)
{
	int a,b,c;
	double cos,sin,tan;
	
	printf("正の整数aを入力>>>");
	scanf("%d",&a);
	
	printf("正の整数bを入力>>>");
	scanf("%d",&b);
	
	printf("正の整数cを入力>>>");
	scanf("%d",&c);
	
	if(a+b<=c)
	{
		printf("三角形ではありません\n");
		
		return 0;
	}
	
	cos=cos_triangle(a,b,c);
	sin=sqrt(1-cos*cos);
	tan=sin/cos;
	
	printf("sin %lf\n",sin);
	printf("cos %lf\n",cos);
	printf("tan %lf\n",tan);
	
	return 0;
}

