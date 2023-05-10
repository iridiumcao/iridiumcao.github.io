# How to Display Maths Formula in GitHub Pages

I have encountered a problem that the maths formula cannot display when the site published, although the formula can display while editing as markdown.

I input:

```plaintext
$$ P(A\cup B)=P(A)+P(B)-P(A\cap B) $$

$$ P(\Omega -E)=1-P(E) $$

$$ P(A\cap B)=P(A)\cdot P(B\vert A) $$
```

I expected to display:

![](images/math_formula_demo.png)

But it shows me some inhumanable text

```plaintex
\[P(A\cup B)=P(A)+P(B)-P(A\cap B)\] \[P(\Omega -E)=1-P(E)\] \[P(A\cap B)=P(A)\cdot P(B\vert A)\]
```

## Solution

Add the script at he head of the markdown, following <https://docs.mathjax.org/en/latest/web/start.html>

```html
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
```
