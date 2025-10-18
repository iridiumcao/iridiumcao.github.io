class Person:
    def __init__(self, name):
        self.name = name

    def get_name(self):
        return self.name
    
    def hello(self):
        return f"Hello from {self.name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"

bob = Person("Bob")
print(bob.get_name())  # "Bob"
print(bob.hello())     # "Hello from Bob!"