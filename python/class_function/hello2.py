class Hello(object):
    pass

def hi(self):  # 这是唯一的修改点，加了self参数
    print("hi, word!")

Hello.hi = hi

s2 = Hello()
s2.hi()  # 注意这里需要调用s2.hi()，而不是Hello.hi()