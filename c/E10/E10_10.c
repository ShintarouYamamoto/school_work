#include <stdio.h>

int main( void ){

    int x, y;
    int i;

    x = 0;
    y = 1;
    for( i = 2; i < 10; i += 2 ){
          x += i;
          y *= i;
    }

    printf("x = %d, y = %d\n", x, y);

    x = 0;
    y = 1;
    for( i = 2; i < 10; i += 2 )
	x += i;
	y *= i;
 
    printf("x = %d, y = %d\n", x, y);

   return 0;
}

/*一つ目のfor文はすべてを繰り返しているが、
二つ目は直後の文のみ繰り返している、繰り返したあと、iは10なので
ただ、一度iをかけた結果となる*/

/*結果
予想通り*/