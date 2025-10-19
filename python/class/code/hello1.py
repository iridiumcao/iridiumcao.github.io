# 定义一个空类
class Hello:
    pass

def hi(self):  # 因为这个函数将要作为 Hello 类的实例方法，所以第一个参数 self 必须有。
    print("hi, word!")

# 将上面定义的函数赋值给 Hello 的属性 hi
Hello.hi = hi

h = Hello()
h.hi()  # 注意这里需要调用h.hi()，而不是Hello.hi()
Hello.hi(h)  # 也可以这样调用，不过不推荐