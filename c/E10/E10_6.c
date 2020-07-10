#include<stdio.h>


int max2(int a, int b)
{
	if(a>b)
	{
		return a;
	}
	
	if(a<b)
	{
		return b;
	}
	
	return 0;
}

int min2(int a, int b)
{
	if(a<b)
	{
		return a;
	}
	
	if(a>b)
	{
		return b;
	}
	
	return 0;
}

int max4(int a, int b, int c, int d)
{
	int M;
	M=a;
	
	if(M<b)
	{
		M=b;
	}
	
	if(M<c)
	{
		M=c;
	}
	
	if(M<d)
	{
		M=d;
	}
	
	return M;
	
	
}

int min4(int a, int b, int c, int d)
{
	int M;
	M=a;
	
	if(M>b)
	{
		M=b;
	}
	
	if(M>c)
	{
		M=c;
	}
	
	if(M>d)
	{
		M=d;
	}
	
	return M;
	
	
}




int main(void)
{
	int a,b,c,d,x,y,k=0;
	
	for(a=1; a<=10; a++)
	{
		for(b=1; b<=10; b++)
		{
			for(c=1; c<=10; c++)
			{
				for(d=1; d<=10; d++)
				{
					x=max4(a,b,c,d);
					y=min4(a,b,c,d);
					if(x==7 && y==3)
					{
						k=k+1;
					}
				}
			}
		}
	}
	
	printf("%d\n",k);
	
	return 0;
	
}