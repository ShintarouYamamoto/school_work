#include <stdio.h>

#define LUCKYNO1 1122 
#define LUCKYNO2 929 
#define LUCKYNO3 88

int main (void)
{
int no;

printf("宝くじ券の番号を入力してください＞＞＞");
scanf("%d",&no);
if(no==LUCKYNO1) printf("おめでとうございます！一等に当たりました！\n");
if(no%1000==LUCKYNO2) printf("なんと！二等当選です！\n");
if(no%100==LUCKYNO3) printf("やったね！三等です！\n");

return 0;
}