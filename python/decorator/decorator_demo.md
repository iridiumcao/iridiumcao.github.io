# Python Decorator Demo

[Index](../index.md)

We have scheduled some automated tasks that run regularly. They work well under normal circumstances. However, we realized that during Chinese public holidays, we don’t need to execute some of these tasks.

To handle this, we use the tool [中国节假日 (chinesecalendar)](https://pypi.org/project/chinesecalendar/) to detect whether the current date is a working day in China.
By combining it with a Python decorator, we can easily control whether a function should run based on the calendar.

## Implementation

Below is the decorator implementation that checks if today is a working day before running the decorated function.

```python
import datetime
import logging
from functools import wraps
from chinese_calendar import is_workday

def chinese_workday_check(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        today = datetime.date.today()
        if is_workday(today): 
            logging.info(f"Today is a workday: {today}. Executing function '{func.__name__}'.")
            return func(*args, **kwargs)
        else:
            logging.info(f"Today is not a workday: {today}. Function '{func.__name__}' will not be executed.")
            return None
    return wrapper

@chinese_workday_check
def my_function():
    print("Function is executed.")
```

([Download code here](pydecorator.py))

## How it works

1. `@chinese_workday_check` is a decorator. When applied to a function (like `my_function`), it wraps the function’s behavior.
2. When the decorated function is called, control first goes to the `wrapper()` inside the decorator.
3. The decorator checks if today is a workday using `is_workday(today)` from the `chinesecalendar` library.
   - If yes → it executes the original function.
   - If not → it skips execution and logs a message.
4. This approach keeps your business logic simple while ensuring that task execution automatically respects local holidays.

## Understanding `*args`

In Python, `*args` allows a function to **accept any number of positional arguments**.

For example:

```python
def example(*args):
    print(args)
    for arg in args:
        print("Argument:", arg)

example(1, 2, 3, "hello")
```

Output:

```plaintext
(1, 2, 3, 'hello')
Argument: 1
Argument: 2
Argument: 3
Argument: hello
```

- The variable `args` is a **tuple** containing all positional arguments passed to the function.
- You can use this mechanism when you don’t know in advance how many arguments a function will receive.
- In our decorator, `*args` ensures the wrapper can forward all positional arguments to the original function, keeping its signature flexible.

## Understanding `**kwargs`

Similarly, `**kwargs` allows a function to **accept any number of keyword arguments**.

Example:

```python
def example(**kwargs):
    print(kwargs)
    for key, value in kwargs.items():
        print(f"{key} = {value}")

example(name="Alice", age=25, city="Chengdu")
```

Output:

```plaintext
{'name': 'Alice', 'age': 25, 'city': 'Chengdu'}
name = Alice
age = 25
city = Chengdu
```

- The variable `kwargs` is a **dictionary** (`dict`) containing all keyword arguments.
- You can use it to handle functions with optional named parameters.
- In the decorator, `**kwargs` ensures all keyword arguments are correctly passed through to the decorated function, so the decorator does not interfere with the original function’s flexibility.

## Why decorators use `*args` and `**kwargs`

Decorators often use both `*args` and `**kwargs` because:

- They don’t know in advance the number or names of parameters the decorated function might have.
- This pattern makes the decorator **reusable** for different kinds of functions — with or without parameters.

Example of a decorated function with parameters:

```python
@chinese_workday_check
def generate_report(department, date=None):
    print(f"Generating report for {department} on {date or datetime.date.today()}")

generate_report("Finance")
```

This will:

- Check if today is a workday.
- Execute `generate_report()` with all its original arguments if it is.

## Summary

| Concept    | Description                                                            |
| ---------- | ---------------------------------------------------------------------- |
| Decorator  | A wrapper that modifies or enhances another function’s behavior.       |
| `*args`    | Collects all **positional arguments** into a tuple.                    |
| `**kwargs` | Collects all **keyword arguments** into a dictionary.                  |
| Use Case   | Skipping task execution on non-workdays based on the Chinese calendar. |

(Edit with ChatGPT)