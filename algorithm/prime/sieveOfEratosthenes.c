#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

// 统计并输出 [2, n] 范围内素数的个数
int sieveOfEratosthenes(int n)
{
    if (n < 2) {
        printf("在 %d 以内共有 0 个素数。\n", n);
        return 0;
    }

    size_t size = (size_t)n + 1;

    bool *isPrime = malloc(size * sizeof *isPrime);
    if (isPrime == NULL) {
        fprintf(stderr, "内存分配失败！\n");
        return -1;
    }

    // 不使用 memset，避免依赖 bool 的具体字节表示
    for (int i = 0; i <= n; i++) {
        isPrime[i] = true;
    }

    isPrime[0] = false;
    isPrime[1] = false;

    /*
     * 使用 p <= n / p，而不是 p * p <= n。
     * 这样即使扩大整数类型，也不会因为 p * p 而溢出。
     */
    for (int p = 2; p <= n / p; p++) {
        if (isPrime[p]) {
            /*
             * 此时 p * p <= n，因此这里的乘法不会溢出 int。
             */
            for (int i = p * p; i <= n; i += p) {
                isPrime[i] = false;
            }
        }
    }

    int count = 0;

    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
            printf("%d, ", i);
            count++;
        }
    }

    printf("在 %d 以内共有 %d 个素数。\n", n, count);

    free(isPrime);
    return count;
}

int main(void)
{
    int n = 100;

    int result = sieveOfEratosthenes(n);
    if (result < 0) {
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}