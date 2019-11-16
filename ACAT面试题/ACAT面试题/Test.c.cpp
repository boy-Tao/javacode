#include<stdio.h>
#include<stdlib.h>
#define ACAT(x) x/(x-1)
int climbStairs2(int n) {
	if (n == 1 || n == 2) {
		return 1;
	}
	int count;
	if (n == 3) {
		count++;
	}
	return  climbStairs2(n - 1) + climbStairs2(n - 2);
}
int climbStairs1(int n) {
	int num1 = 1;
	int num2 = 2;
	int add = 0;
	if (n <= 2)
	{
		return n;
	}
	else
	{
		for (int i = 2; i < n; i++)//从第三项开始， 第i项等于第i-1项加第i-2项
		{
			add = num1 + num2;
			num1 = num2;
			num2 = add;
		}
		return add;
	}
}
void getlength(char ar) {
	char arr[1000];
	int length = 0;
	gets(arr);
	for (length = 0; length < 1000; length++)
	{
		if (arr[length] == '\0')
		{
			break;
		}
	}
	printf("%d\n", length);
}
void main() 
{
	//爬楼梯
	int n = 0;
	printf("请输入一个正整数:");
	scanf("%d", &n);
	int a = climbStairs1(n);
	printf("%d\n", a);

	/*int a = 1, b = 2;
	printf("%d \n", ACAT(a - b));
	
	int i;
	for (i = 1; i<10; i++){
		if (i % 3)  i++;
		++i;
		printf("%d", i);
	}

	int i;
	for (i = 2; i == 0;)
	{
		printf("%d\n", i--);
	}

	/*int a = 0, b = 0, c = 0;
	c = (a -= a - 5), (a = b, b + 3);
	printf("%d, %d, %d\n", a, b, c);*/
}
int main1(int argc, char ** argv)
{
	int a[3][4] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	printf("%d %d %d\n", a, **a + 1, **(a + 1));
	return 0;
}
int main2(){
	struct node {
		char a;
		char b;
		short c;
		int d;
	};
	struct node s;
	s.a = 3;
	s.b = 5;
	s.c = 6;
	s.d = 99;
	struct node *pt = &s;
	printf("%X\n", *(int*)pt);
}
