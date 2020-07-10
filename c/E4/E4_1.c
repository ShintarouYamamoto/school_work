 #include <stdio.h>
 #include <math.h>
int main(void)

 {
	int n,i;
 	double b,a;
 	printf("nを入力してください\n");
 	scanf("%d",&n);
 	printf("uplimを入力してください\n");
 	scanf("%lf",&b);

 	for (i=n; i<=100; i++)
 	{   a=exp(i);
 		if(a<=b)printf( "整数%d指数関数%f\n",i,a);
 		}

	return 0;

 }