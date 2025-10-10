import datetime
import logging
from functools import wraps
from chinese_calendar import is_workday

# pip install chinesecalendar

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
    
if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    my_function()