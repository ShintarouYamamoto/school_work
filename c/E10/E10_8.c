#include <stdio.h>

int main(void)
{
     int a, x, y;

     printf("整数を入力して下さい\n");
     scanf("%d", &a);

     x = a;
     y = a;

     if( a % 2 == 0 )
          x = x * 2;
     if( a % 3 == 0 )
          x = x * 5;


     if( a % 2 == 0 )
          y = y * 2;
     else if( a % 3 == 0 )
          y = y * 5;

     printf("x = %d, y = %d です．", x, y);

  return 0;
}

/*予想
ｘについてはif文で構成されているため、どちらの条件にも当てはまる場合、
最大10倍されてしまうが、yはelse ifで構成されているためどちらか一方しか
実行されず10倍されるようなことはない。*/

/*結果
予想通り*/
