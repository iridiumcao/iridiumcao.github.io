# 表的连接

[返回目录](index.md)

按：这篇短文具体何时写的已经不晓得了，大概是2008年左右，距今已经15年了。

表的连接就是两张或者多张表在水平方向上进行合并, 多张表的连接仍是基于两张表的连接再连接, 要弄清这个问题弄清两张表的连接就够了. 连接按照具体的规则差别, 分成 {交叉; 内: 等值, 自然; 外: 左, 右, 全} 等子类. 最易「连接」操作不一定满足结合律或交换律。

## 1. 交叉连接

它的返回就是两表的[笛卡尔积](https://sites.google.com/site/iridiumsite/it/database/cartesian-product)了. 表是记录(行)的集合, 两表可作笛卡尔运算. 

## 2. 内连接(inner join)

包含相等连接, 自然连接两种, 可以理解为建立在交叉连接之上的连接. 
在实际应用中, 相当多的查询都写成在笛卡尔积中过滤的样式: 

```sql
select * 
from A, B, .. 
where ...
```

`from` 里一坨, 就简单用逗号连接起来而已. 前面两句即是笛卡尔积, 后面的 where 再做选取. 不过具体的 RDBMS 在操作这样的语句时, 会转化成等价的高效的, 对人不友好的方式去执行, 管他呢, 我们写我们的, 它转化它的, 反正它能转化么, O(∩_∩)O~ 不过, 能直接写出优质的少转化的查询更好啦.

### 2.1 等值连接

两表基于某一列, 凡在这里列中等值行都连起来.
按照本文的分类体系, 并没有所谓的"不等连接", 那么 where 条件中出现不等关系是什么? O(∩_∩)O哈哈~ where 条件是对 from 项的表做选取(filter)操作而已. 这里的等值并非说 where 条件中相等关系.

### 2.2 自然连接

不指定连接的列, 凡两表中名称相同的列, 就进行连接. 连接后, 用于连接的列在连接表中只出现一次, 并且没有表名作前缀.

## 3. 外连接(outer join)

### 3.1 左连接和右连接

左外连接(left outer join)简称左连接(left join), 连接表中, 左边的表所有记录必须出现, 右边的, 如果没有匹配项, 以空值出现. 右外连接为何? 把前面话中的"左"变成"右", "右"变成"左"就好了.
具体到 Oracle 中, 外连接有两种写法, 一种是用 left/right join 的关键字, 一种是用加号表达, 如下面两条 SQL 语句, 其实是一样的.

```sql
select distinct t1.kname
  from t1
  left join t2 on t1.id = t2.id
 where t1.can > (select count(*) from t2 where t1.id = t2.id);
select distinct t1.kname
  from t1, t2
 where t1.can > (select count(*) from t2 where t1.id = t2.id)
   and t1.id = t2.id(+);
```

对于+号, 可以理解为有+号的一边出现了NULL, 也可以做为合法的条件
外连接的限制：
1. 外连接符只能出现在信息缺少的那边
2. 在条件中, 不能用 IN 或者 OR 做连接符(TODO 暂无体会)

### 3.2 完全连接

完全连接(full outer join), 也称全连接(full join), 是左右连接的并集. 参与连接的表的所有的记录在连接表中都会出现, 没有匹配项的地方, 以空值填充.

## 4. 注意

两表连接时要特别注意连接的字段是否唯一，如果不唯一，会导致连接后的记录数比左边或右边的表都多。

## 5. 后记

某天, 新同事 ZGD 问 Oracle 查询语句 where 条件里的(+)是什么意思, 我知道是外连接, 不过一下又搞不清楚, 虽然很快 Google 到, 但还是缺乏整体把握, 遂找到维基条目 Join 细读, 读完, 感觉通了, 终于对连接了然于心了. 顺带给这个维基条目建了一个中文版, 目前翻译到"实现"部分, 感觉有点难度了, 希望这个周末搞定.

原先打算给用两张表给一个实例, 但看完维基条目之后, 觉得无甚必要了.

## 6. 参考

* Wikipedia: [English](https://en.wikipedia.org/wiki/Join_%28SQL%29), [中文版](https://zh.wikipedia.org/wiki/%E8%BF%9E%E6%8E%A5)
* 在关系型数据库中使用连接运算 (invalid link)
* 关于Oracle外连接的若干问题(by anly) (invalid link)

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