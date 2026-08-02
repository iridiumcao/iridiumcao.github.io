#include <stdio.h>
#include <stdlib.h>

int isPrime(long n)
{
    if (n < 2)
    {
        return 0;
    }

    for (long i = 2; i <= n / i; i++)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }

    return 1;
}

int main()
{
    for (long i = 0; i <= 50; i++)
    {
        if (isPrime(i))
        {
            printf("%li, ", i);
        }
    }

    return 0;
}

// Note:
// $ gcc prime2.c -o prime2
