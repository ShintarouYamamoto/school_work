#include<stdio.h>
#include<float.h>
#define N 5
int main (void)
{   
	int i,j;
	int array[N],array_sort[N];
	int x; 
	int k; 
	int temp;
	
	printf("array input: ");
	
	for(i = 0; i < N; i++)
	{
		printf("array input: ");
		scanf("%d", &array[i]);
	}
	
	for(i = 0; i < N; i++)
	{		
		x = 0;	
		k = 0;  
		for(j = i+1; j < N; j++)
		{
			if(array[j]>=array[i])
			{
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				
			}
		}
		
		
	}
	
	printf("array_sort: ");	

	for(i = 0; i < N; i++)
	{
		printf("%d ", array_sort[i]);
	}
	printf("\n");
	
	return 0;
}
