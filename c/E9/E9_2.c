#include <stdio.h>
#include<string.h>
#define N 1000
#define M 2000

int main (void)
{
	char s_out[M],s_in1[N],s_in2[N];
	
	
	printf("Key in 2 words>>  ");
	scanf("%s",&s_in1);
	scanf("%s",&s_in2);
	strcpy(s_out,s_in1);
	strcat(s_out,s_in2);
	
	
	printf("%s\n",s_out);
	
	
	
	return 0;
}

	