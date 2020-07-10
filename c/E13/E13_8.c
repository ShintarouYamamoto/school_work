#include <stdio.h>
#include <string.h>

int main(void)
{
  char  s_in[128], s_out[128];

  s_out[0]='\0';
  for (;;)
  {
    printf("Keyin a word>> ");
    scanf("%127s", s_in);
    /* ここにプログラムを追加せよ */
  	strcpy(s_out,s_in);
  	strcat(s_out,s_in);
  	if(strcat(s_out,s_in)==0)
  	{
  		continue;
  	}
  	
  	else if(s_in=='.')
  	{
  		break;
  	}
  		
    /* ここまで */
  }
  printf("%s\n", s_out);

  return 0;
}