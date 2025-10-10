class Person:
    def __init__(self, name):
        self.my_name = name

    def get_name(self):
        return self.my_name
    
    def hello(self):
        return f"Hello from {self.my_name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
