class Hello(object):
    pass

def hi3(self):
    print("hi, word!")

Hello.hi = hi3

s2 = Hello()
s2.hi()