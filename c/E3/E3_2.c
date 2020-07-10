#include<stdio.h>

int main(void)
{
	int diff='A'-'a';
	char c,result;
	
	
	printf("文字を入力してください。\n");
	scanf("%c",&c);
	
	
	if(c>='a' && c<='z') 
	{
	    result=c+diff;
		printf("%c\n",result);
	}
	else if(c>='A' && c<='Z') 
	{
		result=c-diff;
		printf("%c\n",result);
	}

	return 0;
}

