# The First Time I Used AI to Solve a Real Work Problem

[Index](../other/index_en.md)

> AI helped me implement a complex feature—but the hardest part wasn’t writing the code. It was proving the code was correct.

The AI models mentioned in this article:

- Claude: Claude Opus 4.6
- Gemini: Gemini 3/3.1 Pro Preview
- GPT: GPT 5.4

For business reasons, I won't address the solution's details here.

## Background

Our QA team had wanted an auto-task tool for a long time.

I had known about this requirement, but I kept postponing it. The reason was simple: after reviewing the requirements, I believed I could implement it, but the logic was complex and the development cost felt too high for the time available.

Two weeks ago, that changed.

With the availability of powerful AI models — Claude, Gemini, and GPT — I felt confident enough to try. I decided to finally start the project.

At first, everything went smoothly—almost too smoothly.

---

## The First Problem

Last Friday, the QA team reported issues in one of the repositories.

After investigating, I realized the root cause wasn’t the implementation—it was the requirement itself. Some parts had not been clearly defined. We discussed it again and refined the logic.

However, the updated requirement was still quite complex.

I asked Claude to implement it. It produced a solution quickly.

But when I reviewed the code, I ran into a problem:

> I understood most of it, but not everything.

That evening, I looked at it again more carefully and found the real issue—I had missed an implicit condition in the requirement.

Because that condition was not specified, the AI had “filled in the gaps” on its own. The result was logically valid, but unnecessarily complex and hard to understand.

More importantly, I realized something uncomfortable:

> I didn’t fully understand the problem myself.

---

## Multiple Implementations, No Clear Answer

I went back and clarified the logic.

Then I asked two different AI models, Gemini and Claude, to implement the same requirement independently.

This time, both versions looked much better. Cleaner. More reasonable.

But there was a new problem:

> They were different.

I suspected there were subtle differences in behavior, but I couldn’t confidently verify them just by reading the code.

At that point, I was too tired to continue.

---

## Using AI to Evaluate AI

The next day, I tried a different approach.

I used another AI model, GPT, to compare the two implementations.

It told me:

- The two versions were largely similar
- But they differed in some edge cases

That sounded reasonable.

Then I took it further:

- I provided the original requirement
- Asked GPT to evaluate how well each implementation matched it

After about ten minutes, it gave a detailed report:

- The Gemini version matched the requirement more closely
- The Claude version had slight deviations

This was helpful—but not perfect.

In fact, I noticed something important:

> One of GPT’s conclusions was clearly wrong.

That was a turning point.

Even when using AI to evaluate AI, I still had to verify the results myself. In other words, AI didn’t remove the need for judgment—it just moved it to a higher level.

---

## The Real Solution

On Sunday, I printed the analysis and reviewed everything carefully.

This time, I fully understood:

- the requirement
- the differences between implementations
- and the edge cases involved

Gemini’s implementation matched the requirement completely. Claude's implementation slightly overreached.

By Monday, something interesting happened.

After thinking about the problem again, I realized:

> The entire logic could be simplified.

I rewrote the requirement in a simpler form and asked Gemini and Claude:

> “Is this new logic equivalent to the current implementation?”

Both models agreed: yes, it was equivalent.

Feeling much more confident, I asked Gemini to refactor the code using my new approach. Unfortunately, Gemini didn't use the 3.1 Pro Preview model this time; it defaulted to a faster version (flash version) and produced a frustrating result—mostly just renaming parameters and rewriting comments. I decided not to use it. 

Instead, I deployed the existing correct version.

It worked. No issues were reported.

---

## What This Experience Taught Me

This was the first time I used AI to solve a real, complex problem in production.

It was also a bit unsettling.

Here are the key lessons I took away:

### 1. AI Accelerates Coding, Not Thinking

AI can generate code extremely quickly.

But it does not replace the need to:

- define clear requirements
- understand the problem deeply

If your thinking is unclear, AI will amplify that confusion.

---

### 2. Ambiguity Becomes Complexity

The biggest issue I encountered was not implementation—it was ambiguity.

A single missing condition led to:

- more complex code
- inconsistent implementations
- difficulty in verification

AI doesn’t complain about unclear requirements. It just fills in the gaps.

---

### 3. Verification Is the Hardest Part

Generating solutions is easy.

Knowing whether they are correct is much harder.

Even when:

- multiple models agree
- outputs look reasonable

I still needed to verify the logic myself.

---

### 4. Multiple Models Don’t Guarantee Correctness

Using different AI models helped surface differences.

But agreement between models does not mean correctness.

And disagreement does not tell me which one is right.

---

### 5. Simplifying the Problem Is the Real Breakthrough

The biggest improvement didn’t come from better prompts or better models.

It came from simplifying the logic itself.

Once the problem became simpler:

- the implementation became clearer
- the correctness became easier to verify

---

## Final Thoughts

AI is a powerful tool.

I can use it to:

- write code
- review code
- compare implementations

But I cannot rely on it to replace my own understanding.

> AI does not reduce the need for thinking—it increases the cost of unclear thinking.

If we blindly trust AI-generated code without understanding it, we are taking a real risk.

If we use AI as a tool to sharpen our thinking, it becomes incredibly powerful.

---

(This article was edited using ChatGPT. The original draft can be found [here](1st_ai_4_complex_problem_draft.md).)


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