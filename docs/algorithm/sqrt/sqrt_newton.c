#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// 1. 先在函数上任选一个点
// 2. 作切线，和x轴相交，判断交点是否为近似解，是就跳出，否就继续下一步
// 3. 通过交点作x轴的垂线，和函数图像相交
// 4. 重复第二步，直到找出近似解。
//
// x[n+1] = x[n] - f(x[n])/f'(x[n])
//
// 1. 先在函数上任选一个点，不妨就选N
// 2. 作切线，和x轴相交，判断交点是否为近似解，是就跳出，否就继续下一步
//     * 斜率为 2x[n]
//     * 过(x[n], f([n]))的切线是：f(x) - f(x[n]) = 2x[n] * (x - x[n]), 导入f(x) = x^2 -N 得f(x) - (x[n]^2 - N) = 2x[n] * (x - x[n])
//     * 上式中 f(x) = 0时得到切线和x轴交点：x = (x[n] + N/x[n])/2
//     * 将这个值代入 f(x) = x^2 - N 验算，看是否满足近似条件
// 3. 通过交点作x轴的垂线，和函数图像相交
// 4. 重复第二步，直到找出近似解
//
// 不妨从参数 n 本身开始尝试。
double calSqrt(double number)
{
    if (number < 0)
    {
        printf("The input value should be greater than zero.");
        exit(1);
    }

    double err = 1e-15;   //设置误差范围，当误差小于这个值时认为得到准确值
    double root = number; //给平方根一个预设值，不妨从参数 n 本身开始尝试。
    while (abs(number - root * root) > err)
    {
        root = (number / root + root) / 2.0;
    }
    return root;
}

int main()
{
    printf("%f, %f\n", calSqrt(1.0), sqrt(1.0));
    printf("%f, %f\n", calSqrt(2.0), sqrt(2.0));
    printf("%f, %f\n", calSqrt(3.0), sqrt(3.0));
    printf("%f, %f\n", calSqrt(4.0), sqrt(4.0));
    printf("%f, %f\n", calSqrt(5.0), sqrt(5.0));
}