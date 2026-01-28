# Range of Ruby's Random Functions in Integer

[Index](../index_en.md)

---

- [Range of Ruby's Random Functions in Integer](#range-of-rubys-random-functions-in-integer)
  - [Test 1: Using an Integer as Argument](#test-1-using-an-integer-as-argument)
  - [Test 2, Using an Integer Range as Argument](#test-2-using-an-integer-range-as-argument)
  - [Guess](#guess)
  - [Official Reference](#official-reference)
  - [PS](#ps)

---

There are two functions for genrating random numbers in Ruby, `rand()` and `SecureRandom.random_number()`. This article focuses specifically non-negegative integer.

Both functions accept either a non-negative integer or an integer range as argements.

When providing an argument `n` ($n \ge 0, n \in \mathbb{Z}$), what values do these functions return?

Let's begin with a test using small integers and ranges, such as 3 and 1 to 3, for easy observation.

## Test 1: Using an Integer as Argument

```ruby
require 'securerandom'

for i in 1..20 do
    puts "#{i}: #{rand(3)}, #{SecureRandom.random_number(3)}"
end
```

The output shows that all generated numbers are in the range [0, 1, 2], inclusive of 0 but not including 3.

```plaintext
1: 1, 0
2: 1, 0
3: 0, 1
4: 0, 2
5: 0, 2
6: 1, 2
7: 0, 0
8: 2, 2
9: 1, 0
10: 0, 0
11: 2, 1
12: 1, 2
13: 2, 2
14: 1, 1
15: 2, 2
16: 1, 0
17: 2, 0
18: 2, 1
19: 2, 2
20: 0, 0
```

## Test 2, Using an Integer Range as Argument

```ruby
require 'securerandom'

for i in 1..20 do
    puts "#{i}: #{rand(1..3)}, #{SecureRandom.random_number(1..3)}"
end
```

Here, all numbers generated fall within the range [1, 2, 3], inclusive of both the start number 1 and end number 3.

```plaintext
1: 1, 1
2: 2, 2
3: 3, 1
4: 2, 2
5: 1, 3
6: 3, 3
7: 1, 1
8: 2, 1
9: 2, 3
10: 3, 1
11: 1, 2
12: 2, 3
13: 3, 2
14: 2, 3
15: 1, 2
16: 1, 1
17: 2, 3
18: 3, 2
19: 1, 1
20: 1, 2
```

## Guess

Can we conclude the following?

> Assume the argument is $n$ ($n \ge 0, n \in \mathbb{Z}$) and the return value is $r$ ($r \in \mathbb{Z}$), then $0 \le r \lt n$.
>
> $0 \le r \lt n \Leftrightarrow 0 \le r \le n$
>
> $\therefore 0 \le rand(n) \le n-1$
> 
>  The range starts from 0 and ends at $n-1$.

Additionally,

> Assume the argument is $m..n$ ($0 \le m \le n, m \in \mathbb{Z}, n \in \mathbb{Z}$) and the return value is $r$ ($r \in \mathbb{Z}$), then $m \le r \le n$.
>
> $\therefore m \le rand(m..n) \le n$
>
> The range starts from $m$ and ends at $n$.

## Official Reference

The above conclusions align with [the official Ruby documentation](https://ruby-doc.org/3.3.1/Random.html), which states:

> `rand(max) → number`
>
> When `max` is an Integer, `rand` returns a random integer greater than or equal to zero and **less** than `max`.
> 
> `rand(range) → number`
>
> When `range` is a Range, `rand` returns a random number where `range.member?(number) == true`.

```ruby
prng = Random.new
prng.rand(5..9)      # => one of [5, 6, 7, 8, 9]
prng.rand(5...9)     # => one of [5, 6, 7, 8]
```

According to the documentation, the observations from our tests are accurate.

## PS

This discussion excludes topics such as negative numbers and floating-point numbers.

<script>
MathJax = {
  tex: {
    inlineMath: [['$', '$'], ['\\(', '\\)']]
  }
};
</script>
<script id="MathJax-script" async
  src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js">
</script>

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
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>