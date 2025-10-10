class Person:
    def hello(self):
        return f"Hello, world! Type of self is {type(self)}"

alice = Person()
print(alice.hello())