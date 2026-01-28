# 洗牌算法(Shuffle)

[返回目录](../index.md)

洗牌算法(Shuffle)简单说，可以看成把一个数组的元素打乱。

假设要洗牌的数组是 ArrayA, 可以这么考虑：

1. 新建一个和 ArrayA 等常的空数组 ArrayB
2. 依次遍历 ArrayA 的元素，并随机分配到 ArrayB 的未赋值位置。

这个想法理论上可行，但实践很麻烦，不信试试怎么将一个值随机分配到 ArrayB 的未赋值位置？这步如果用代码表示，还是挺繁琐的。

洗牌算法有一个基本要求是，洗牌前后的元素集合不变但元素顺序会改变。尝试新的算法如下：

1. 依次遍历 ArrayA 的每个元素
2. 遍历到某个元素时，再随机选择一个元素，并与当前遍历到的元素交换
3. 以上执行到 ArrayA 的最后一个与元素。

代码如下：

```java
    /**
     * 对数组洗牌
     *
     * @param array
     */
    void shuffle(int[] array) {
        int digitalCount = digitalCount(array.length);
        int base = (int) Math.pow(10, digitalCount); // digitalCount 计算整数的位数
        for (int i = 0; i < array.length; i++) {
            int denominator = (int) (Math.random() * base) % array.length;
            //exchange array[i] and array[denominator]
            int tmp = array[i];
            array[i] = array[denominator];
            array[denominator] = tmp;
        }
    }
```

完整的代码，参：
http://git.oschina.net/iridiumcao/iridiumonline/blob/master/helloalgorithm/src/main/java/info/iridiumcao/algorithm/shuffle/Shuffle.java

注：在 Java 集合 API 中也有现成的 Shuffle 工具了，比如：[Collections.shuffle(...)](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#shuffle-java.util.List-)

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="zh-CN"
        crossorigin="anonymous"
        async>
</script>