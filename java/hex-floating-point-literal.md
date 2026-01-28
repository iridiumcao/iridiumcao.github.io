# Java中的小数可以使用十六进制

[返回目录](index.md)

支持十六进制小数是从JDK 5开始的一个特性。但它对定义有比较多的限制：

* 必须以`0X`或者`0x`开头
* 必须以PN或者`pN`结束。`p`或者`P`相当于十进制小数中使用科学计数法时的`e`或者`E`，`N`是一个十进制数。

假设一个数字定义成`double d = 0xa.eP3`，它表示的值为 `(10 + 14*(16^(-1))) * 2^3`，也就是它限定用科学计数法表示，但底数不是16，而是2，这点也要注意。

下面是两个非法的定义方式：

* `float f = 0x13.a`是非法的。
* `double d = 0x1a.e`也是非法的。

改成如下的就可以了：

* `float f = 0x13.ap0f;`
* `double d = 0x1a.ep0d;`

上面不是规范的科学计数法表示了，只是为了通过编译，加以`p0`在尾部而已。

Code:

```java
public class What022 {

	public static void main(String[] args) {
		double x = 0Xap0; // 10 * 2^0 = 10.0
		double y = 0XfP2D; // 15 * 2^2 = 60.0
		float z = 0Xf.aP1F; // (15 + 10/16ths) * 2^1 = 31.25f
		// Print in decimal
		System.out.printf("%f %f %f%n", x, y, z);
		// Print in hex
		System.out.printf("%a %a %a%n", x, y, z);
	}

}

/*
 * output
 * 10.000000 60.000000 31.250000
 * 0x1.4p3 0x1.ep5 0x1.f4p4
 * 
 */
```

参考：

* [Download code for this issue](code/What022.java)
* [我在在JW@TW上的提问](http://www.javaworld.com.tw/jute/post/view?bid=29&id=234053&sty=1#234053)(已失效)
* [Five Favorite Features from 5.0](http://www.onjava.com/pub/a/onjava/2005/04/20/javaIAN5.html)中的Hexadecimal Floating Point Literals部分。(已失效)

---

本文从[Google Sites](https://sites.google.com/site/iridiumsite/it/java/java-lang/hex-floating-point-literal)转移而来。

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
