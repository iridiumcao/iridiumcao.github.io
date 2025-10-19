class Hello:
    pass

def static_hi():  # 无需 self 或 cls
    print("hello from static method!")

Hello.static_hi = staticmethod(static_hi)  # 用 staticmethod 包装

Hello.static_hi()  # 输出: hello from static method!
h = Hello()
h.static_hi()      # 输出: hello from static method!