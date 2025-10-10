class Hello(object):
    pass

def hi():
    print("hi, word!")

Hello.hi = hi

s2 = Hello()
s2.hi()