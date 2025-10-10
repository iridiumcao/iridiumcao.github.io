class Person:
    @staticmethod
    def greet():
        return f"Hello, world!"

print(Person.greet()) # Output: Hello, world!

alice = Person()
print(alice.greet())  # Output: Hello, world!