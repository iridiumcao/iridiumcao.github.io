class Hello:
    pass

def hello(self):
    print("hi, word!")

Hello.hi = hello

h = Hello()
h.hi()
