class Person:
    def __init__(self, name=""):
        self.name = name

    @staticmethod
    def greet():
        return f"Hello, world!"
    
    @staticmethod
    def is_name_empty(name):
        return name == ""

print(Person.greet()) # Output: Hello, world!

alice = Person()
print(Person.is_name_empty(alice.name)) # Output: True

bob = Person("Bob")
print(Person.is_name_empty(bob.name)) # Output: False