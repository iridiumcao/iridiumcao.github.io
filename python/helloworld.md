# Hello World in Python

[Index](index_en.md)

Python is one of the most popular programming languages.
In this guide, we’ll walk through the simplest possible example: printing **“Hello, world!”**.

---

## Install Python

Download Python from the official website and install it:

- [https://www.python.org/downloads/](https://www.python.org/downloads/)

Python is **cross-platform** and works on Windows, Linux, and macOS.

After installation, open a terminal to verify it:

- Windows: PowerShell or Command Prompt
- Linux: Bash
- macOS: Terminal

Run:

```bash
python --version
python3 --version
py --version   # Windows only
```

Depending on your system, you may use `python`, `python3`, or `py`.
If Python is installed correctly, the command will print the installed version.

---

## Say Hello in the Terminal

Start the Python interactive environment:

```bash
python
```

(or `python3`/`py` depending on your operating system.)

You will see a prompt like:

```python
>>>
```

Then type:

```python
print("Hello, world!")
```

Press Enter, and you will see:

```plaintext
Hello, world!
```

Explanation:

- `print()` is a built-in function used to display output
- `"Hello, world!"` is a string (text)
- Parentheses `()` are used to pass arguments to the function

Two useful functions in the interactive environment:

```Python
help()
quit()
```

---

## Save the Script to a File

Instead of typing code interactively, you can save it in a file.

Create a file named `helloworld.py`:

```python
print("Hello, world!")
```

Run it in the terminal:

```bash
$ python helloworld.py
Hello, world!
```

Or:

```bash
$ python3 helloworld.py
Hello, world!
```

On Windows:

```powershell
> py helloworld.py
Hello, world!
```

Here, `python` (or `python3` / `py`) is the Python interpreter.
It works because the Python executable is included in your system’s **PATH**, which allows the terminal to locate and run it.

You can inspect PATH using:

- Linux/macOS:

  ```bash
  echo $PATH
  ```
- Windows (PowerShell):

  ```powershell
  $env:PATH
  ```
- Windows (Command Prompt):

  ```cmd
  echo %PATH%
  ```

---

## Shebang (Optional)

On Linux and macOS, you can make a script executable by adding a **shebang** line:

```python
#!/usr/bin/env python3
print("Hello, world!")
```

Then make the file executable:

```bash
chmod +x helloworld.py
```

Run it directly:

```bash
./helloworld.py
```

(Run this in the same directory as the file.)

Windows will ignore the shebang line but it is usually left in for portability.

### What is a shebang?

- `#!` tells the operating system this is a script
- `/usr/bin/env python3` locates the `python3` interpreter and runs the script

Notes:

- Works on Linux and macOS
- Not required on Windows
- Requires executable permission (`chmod +x`)

---

## File Name Suffix

Python files usually use the `.py` suffix:

```plaintext
helloworld.py
```

This is a **convention**, not a requirement.
Python can run files with any name, but using `.py` is strongly recommended for:

- readability
- editor support
- tooling compatibility

---

## Summary

You’ve now seen three ways to run Python code:

1. Interactive mode (`python`)
2. Script file (`python helloworld.py`)
3. Executable script with shebang (Linux/macOS)

This is the simplest possible Python program—but it’s the starting point for everything else.
