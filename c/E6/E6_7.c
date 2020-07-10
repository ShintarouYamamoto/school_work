#include <stdio.h>

int a;/*外部変数のa*/

void inc( int );
void set_a( int );
int get_a( void );

int main( void )
{
	int a, b, c;/*mainのローカル変数*/

	a = 10;/*mainのローカル変数*/
	b = 20;/*mainのローカル変数*/

	set_a(100);

	inc(a);

	printf( "(main 1) a = %3d\n", a);/*mainのローカル変数*/

	inc(b);

	printf( "(main 2) b = %3d\n", b);/*mainのローカル変数*/

	c = get_a();

	printf( "(main 3) c = %3d\n", c);/*mainのローカル変数*/

	return 0;
}

void inc( int b )
{
	a++;
	b++;

	printf("(inc  1) a = %3d\n", a);/*外部変数*/
	printf("(inc  2) b = %3d\n", b);/*incのローカル変数*/
}

void set_a( int v )
{
	a = v;/*外部変数のaの値をincのローカル変数に代入*/
}

int get_a()
{
	return a;/*外部変数のaの値をそのまま使用*/
}
