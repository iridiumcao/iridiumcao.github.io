class Person:
    def hello(self):
        return "Hello, world!"

alice = Person()
print(Person.hello(alice)) # invoke the method via class, passing instance explicitly