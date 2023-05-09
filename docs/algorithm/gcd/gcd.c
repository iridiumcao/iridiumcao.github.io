#include <stdio.h>
#include <stdlib.h>

/*
* 递归版本
*/
long calculateGcd(long a, long b)
{
    if (a < 0 || b < 0)
    {
        printf("Only accept numbers greater than 0.");
        exit(0);
    }

    if (b == 0)
    {
        return a;
    }

    long r = a % b;

    return calculateGcd(b, r);
}

/*
* 非递归版本
*/
long calculateGcd2(long a, long b)
{
    if (a < 0 || b < 0)
    {
        printf("Only accept numbers greater than 0.");
        exit(0);
    }

    if (b == 0)
    {
        return a;
    }

    long r;
    while (1)
    {
        long r = a % b;
        if (r == 0)
        {
            break;
        }
        a = b;
        b = r;
    }

    return b;
}

int main()
{
    long a = 48;
    long b = 18;

    long gcd = calculateGcd(a, b);
    printf("gcd(%li, %li) = %li\n", a, b, gcd);

    long gcd2 = calculateGcd2(a, b);
    printf("gcd(%li, %li) = %li\n", a, b, gcd2);

    return 0;
}