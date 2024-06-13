/**
 *
 * 四名专家对四款赛车进行了评论：
 * A说：2号赛车是最好的。
 * B说：4号赛车是最好的。
 * C说：3号赛车不是最好的。
 * D说：B说错了。
 *
 * 事实上只有一款赛车最佳，且只有一名专家的评论是正确的。
 *
 * 那个赛车最好？
 *
 * Ref: https://iridiumcao.github.io/algorithm/bestcar/content.html
 *
 */

#include <stdio.h>

int main(void)
{
    int m; // 赛车的编号
    for (m = 1; m < 5; m++)
    {
        if (((m == 2) + (m == 4) + (m != 3) + (m != 4)) == 1)
        {
            printf("第%d赛车是最好的", m);
        }
    }
}