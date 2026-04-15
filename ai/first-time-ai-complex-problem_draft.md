# The First Time I Used AI to Resolve Work Issues (Draft)

[Index](../other/index_en.md)

([Edited with ChatGPT and Grok](first-time-ai-complex-problem.md))

The QA team had wanted an auto-task tool for a long time.

I knew it and did not start the project because when I reviewed the requirement I thought I can complete it but it was too complex to implement in my fragmented time.

Two weeks ago, I tried AI with the most powerful modules: Claude Opus 4.6, Gemini 3.1 Pro Preview, and GPT 5.4. I felt confident I could implment it, so I began.

Yes, everything seems to go well as expected!

Last Friday, however, the QA team complained there were issues in a repository. I looked into it, it was due to the requirement was not clarified cleanly originally, then we discussed it and updated the requirement.

The new logic was still complex. However, AI could handle it quickly. I used Claude to implement it, but when I review the code, I found I can hardly understand. I reviewed it again at home that evening and found I forgot an implict condition, so that Claude implemented it as his free thinking, that made the code was complex to understatnd. Indeed, I did not understand some parts of the whole problem.

Then I cleaned the logic and use Claude and Gemini to write two new versions individually. Both versions looked better than the old, and I thought both of them were correct. However, I still suspected that they were different, but I could not verify it per my review.

I was tired and I went to sleep.

I was thinking more at bed, decided to use another AI to compare it.

Saturday. First I used GPT 5.4 to compare the versions implemented by Claude and Gemini, it told me that they were almost equally but different at some edge cases. I could be relax at that time but still want to get everything cleanly. Then I told GPT 5.4 my requirement and ask him to test how much the two versions implment my requirement. After a while, about 10 minutes, GPT told me that Gemini's version were more constensive to my requirement. And GPT told me that neither Claude nor Gemini did same wrong, I looked that point, and I could 100% be sure that GPT did wrong.

Sunday. I was still 90% but not 100% confirmed the Gemini's version was OK. So I printed GPT's two reports and read again. I understood all. Gemini's version matched 100% of my requirement, Claude did some broader than I wanted. GPT's reports were accurately execept it pointed the wrong point.

Monday. When I was at office, I continue to think the logic again, and found it can be simplified. I wrote the simplified logic and asked Gemini and Claude in turn if my new idea are equal to the Gemini version. Both Gemini and Claude said YES, my new idea was 100% equal to the current implmentation. I was more confident! Then I asked Gemini to refactor the code with my new idea. But unluckly, Gemini did not use 3.1 Pro Preview this time, it switched to a "flash" version instead of the Pro Preview. The result was frustrating, it just renamed some parameters and rewrote some comments. I aborted this change and deployed the old version. Everything goes well, no complains comes out in the afternoon.

This experience scared me because it's the first time I used AI to resolve a real complex issue for work.

We can use AI to:

- code our ideas.
- review the code.

But we cannot use AI to replace our own thinking, the requirement must be built by ourself, however, we can use AI to improve it.

We still need to know the code. If we are blind to the implementation by AI, it's dangerous.


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