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

## Logarithm Change of Base Rule

To prove 
$
(a \gt 0, a\ne1, b \gt 0, c \gt 0, c \ne 1)(\log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}})
$

Prove.

$
\because
b=c^{\log_{c}{b}}=a^{\log_{a}{b}}\\
\because
b=c^{\log_{c}{b}}=(c^{\log_{c}{a}})^{\log_{a}{b}}=c^{\log_{c}{a}\log_{a}{b}}\\
\therefore \log_{c}{b}=\log_{c}{a}\log_{a}{b}\\
\therefore \log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}}
$