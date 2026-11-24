# The First Time I Used AI to Resolve Work Issues (Draft)

[Index](../other/index.md)

([Edited with ChatGPT and Grok](first-time-ai-complex-problem.md))

The QA team had wanted an auto-task tool for a long time.

I knew about the requirement, but I put off the project. I thought I could build the tool, but the logic was too complex for the short stretches of time I had available.

Two weeks ago, I tried AI with the most powerful models: Claude Opus 4.6, Gemini 3.1 Pro Preview, and GPT 5.4. I felt confident I could implement it, so I began.

At first, everything seemed to be going well!

Last Friday, however, the QA team reported issues in a repository. I looked into them and found that the original requirement was unclear. We discussed it and updated the requirement.

The new logic was still complex, but Claude implemented it quickly. When I reviewed the code, I struggled to understand it. I read it again at home that evening and realized I had left out an implicit condition. Claude had made its own assumptions, which made the code harder to follow. I also realized there were parts of the problem I didn’t fully understand.

Then I clarified the logic and asked Claude and Gemini to write two new versions independently. Both looked better than the old version, and I thought they were both correct. Still, I suspected they behaved differently, and I couldn’t verify that by reading the code.

I was tired and went to bed.

As I kept thinking about it in bed, I decided to ask another AI to compare the two versions.

Saturday. I asked GPT 5.4 to compare the versions from Claude and Gemini. It said they were almost equivalent but differed in some edge cases. That was reassuring, but I still wanted to be sure. I gave GPT my requirement and asked how well each version met it. About ten minutes later, GPT told me that Gemini’s version matched more closely. When I checked a point in the report, I was sure GPT had got it wrong.

Sunday. I was about 90% sure Gemini’s version was right. I printed both of GPT’s reports and read them again. This time I understood everything. Gemini’s version fully matched my requirement, while Claude’s covered more than I wanted. The reports were accurate apart from that one point.

Monday. Back at the office, I took another look at the logic and realized I could simplify it. I wrote out the simplified version and asked Gemini and Claude in turn whether it was equivalent to Gemini’s implementation. Both said yes, which made me more confident. I asked Gemini to refactor the code using my idea. This time it used a Flash model instead of 3.1 Pro Preview. The result was frustrating. It just renamed some parameters and rewrote some comments. I discarded that change and deployed the previous version. Everything went well, and no complaints came in that afternoon.

This experience scared me because it was the first time I had used AI to solve a genuinely complex problem at work.

We can use AI to:

- code our ideas.
- review the code.

We still need to define the requirements ourselves. AI can help us refine them.

We also need to understand the code. Using AI-generated code without understanding how it works is risky.


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