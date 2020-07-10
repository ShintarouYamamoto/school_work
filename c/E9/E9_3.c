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

int main (void)
{
	char s_in[N],s_out[N],s[N];
	int i,a;
	
	printf("Key in str>>");
	get_line(s_in,128);
	
	strcpy(s,s_in);
	
	for(i=0;i<=3;i++)
	{
		strcat(s," ");
		strcat(s,s_in);
	}
	
	a=strlen(s);
	
	printf("%d %s\n",a,s);

	return 0;
}
	

