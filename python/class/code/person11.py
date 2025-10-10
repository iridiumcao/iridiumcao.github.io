# Ref: https://x.com/i/grok/share/dwi2oqTGEsgPU9OSE40p8Gte1

class Person:
    count = 0  # Class variable to track total instances

    def __init__(self, name):
        self.name = name
        Person.count += 1  # Increment on each new instance

    # Instance method (uses 'self')
    def greet(self):
        return f"Hello, my name is {self.name}. Count: {self.__class__.count}"
   
    # Class method (uses 'cls', operates on the class)
    @classmethod
    def get_count(cls):
        return cls.count  # Just returns the class variable—no side effects


# Test the code
alice = Person("Alice")
print(Person.get_count())  # Output: 1
print(alice.greet())       # Output: Hello, my name is Alice. Count: 1

bob = Person("Bob")
print(Person.get_count())  # Output: 2
print(bob.greet())         # Output: Hello, my name is Bob. Count: 2