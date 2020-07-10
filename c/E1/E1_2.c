#include <stdio.h>
int main(void)
{
int a,b,c,p,q,r;
a=94;
b=12;
c=14;
p=a*5;
q=a/b;
r=a%c;

printf("%d*5=\t%d\n",a,p);
printf("%d/%d=\t%d\n",a,b,q);
printf("%d%%%d=\t%d\n",a,c,r);
return 0;
}