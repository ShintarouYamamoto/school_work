#include<stdio.h>
#include<string.h>
#define N 128

void get_line(char buff[], int size)
{
    int i, c;

    for (i=0; i<size-1; i++)
    {
        c = getchar();
        if (c == EOF || c == '\n') break;
        buff[i] = c;
    }
    buff[i] = '\0';
}


void str_copy_reverse(char dst[ ], char src[ ])
{
	int i,a,t;
	
	a=strlen(dst);
	
	for(i=0;i<a;i++)
	{
		src[i]=dst[i];
	}
	
	for(i=0;i<a/2;i++)
	{
		t=src[i];
		src[i]=src[a-i-1];
		src[a-i-1]=t;
	}
}	
int main (void)
{
	char m[N],n[N];
	int a;
	
	printf("Key in string>>");
	get_line(m,128);
	
	

	str_copy_reverse(m,n);
	
	printf("%s\n",n);
	
	return 0;
}

