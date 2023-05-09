#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrime(long n)
{
    if (n < 2)
    {
        return 0;
    }

    for (int i = 2; i <= sqrt(n); i++) // 2 ~ sqrt(n)
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

// Notice:
// as this program includes <math.h>, it should use "-lm" when compiling in Linux
// $ gcc prime.c -o prime -lm
// Ref: https://stackoverflow.com/questions/10409032/why-am-i-getting-undefined-reference-to-sqrt-error-even-though-i-include-math
