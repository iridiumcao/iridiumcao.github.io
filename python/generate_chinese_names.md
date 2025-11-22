# 用Python的列表生成式批量产生姓名

[返回目录](index.md)

Python的列表生成式可以做一些比较有趣的事情，比如用它半自动生成一些人名：

```python
>>> [a + b + c for a in '赵钱孙李' for b in '环球中心' for c in '春暖花开']
['赵环春', '赵环暖', '赵环花', '赵环开', '赵球春', '赵球暖', '赵球花', '赵球开', '赵中春', '赵中暖', '赵中花', '赵中开', '赵心春', '赵心暖', '赵心花', '赵心开', '钱环春', '钱环暖', '钱环花', '钱环开', '钱球春', '钱球暖', '钱球花', '钱球开', '钱中春', '钱中暖', '钱中花', '钱中开', '钱心春', '钱心暖', '钱心花', '钱心开', '孙环春', '孙环暖', '孙环花', '孙环开', '孙球春', '孙球暖', '孙球花', '孙球开', '孙中春', '孙中暖', '孙中花', '孙中开', '孙心春', '孙心暖', '孙心花', '孙心开', '李环春', '李环暖', '李环花', '李环开', '李球春', '李球暖', '李球花', '李球开', '李中春', '李中暖', '李中花', '李中开', '李心春', '李心暖', '李心花', '李心开']
```

从上面生成的名字列表可以看出它的循环规律：

最内的循环是'春暖花开'，最外的是'赵钱孙礼'. 等价的循环写法是：

```python
name_list = []
for a in '赵钱孙李':
    for b in '环球中心':
        for c in '春暖花开':
            name_list.append(a + b + c)
```

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