class Person:
    def __init__(this, name):
        this.name = name

    def get_name(this):
        return this.name
    
    def hello(this):
        return f"Hello from {this.name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"

bob = Person("Bob")
print(bob.get_name())  # "Bob"
print(bob.hello())     # "Hello from Bob!"