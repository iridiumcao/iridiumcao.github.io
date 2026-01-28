# Logarithm Change of Base Rule

[Index](index_en.md)

To prove

$
(a \gt 0, a\ne1, b \gt 0, c \gt 0, c \ne 1)(\log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}})
$

## Proof I

Assume $\log_{a}{b} = x$

$\therefore a^x = b$

$\therefore \log_{c}{a^x} = \log_{c}{b}$

$\therefore x\log_{c}{a} = \log_{c}{b}$

$\therefore x = \dfrac{\log_{c}{b}}{\log_{c}{a}}$

$\therefore \log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}}$

Q.E.D.

## Proof II

$\because b=a^{\log_{a}{b}}=(c^{\log_{c}{a}})^{\log_{a}{b}}=c^{\log_{c}{a}\log_{a}{b}}$

$\therefore \log_{c}{b}=\log_{c}{a}\log_{a}{b}$

$\therefore \log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}}$

Q.E.D.

## Proof III

$\because b=c^{\log_{c}{b}}=c^{\log_{c}{a^{\log_{a}{b}}}}=c^{\log_{a}{b}\log_{c}{a}}$

$\therefore \log_{c}{b}=\log_{a}{b}\log_{c}{a}$

$\therefore \log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}}$

Q.E.D.

## Proof IV

$\because \log_{c}{b}=\log_{c}{a^{\log_{a}{b}}}=\log_{a}{b}\log_{c}{a}$

$\therefore \log_{a}{b} = \dfrac{\log_{c}{b}}{\log_{c}{a}}$

Q.E.D.

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