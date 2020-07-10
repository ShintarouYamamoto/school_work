#include <stdio.h>
int main(void)

 {
	int max,n,a,i;
 	printf("maxを入力してください\n");
 	scanf("%d",&max);
    a=0;
 	for (i=1; i<max; i++)
 	{   a=i+a;
 		if(a<=max)printf( "n=%d sum=%d\n",i,a);
 		
 	}

	return 0;

 }