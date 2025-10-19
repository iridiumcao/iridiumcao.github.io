class Hello:
    pass

def class_hi(cls):  # 注意第一个参数是 cls（类）
    print(f"hello from class {cls.__name__}!")

Hello.class_hi = classmethod(class_hi)  # 用 classmethod 包装

Hello.class_hi()   # 输出: hello from class Hello!