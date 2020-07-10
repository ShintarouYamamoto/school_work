#include <stdio.h>
int main(void)
{
int x,y,r; 

printf("xをyで割った結果を表示します\n");

printf("xの値を入力してください");

scanf("%d",&x);

printf("yの値を入力してください");

scanf("%d",&y);

r=x/y;

printf("%d / %d =\t%d\n",x,y,r);
return 0;
}