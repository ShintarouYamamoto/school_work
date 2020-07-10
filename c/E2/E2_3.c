#include<stdio.h>

int main(void)
{
	int diff;
	char Large;
	char Small;
	
	printf("小文字を入力してください。");
	scanf("%c",&Small);
	
	diff='a'-'A';
	
	Large=Small-diff;
	
	printf("大文字は%cです。\n",Large);
	
	return 0;
}

	
	