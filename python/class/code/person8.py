class Person:
    def __init__(myself, name):
        myself.name = name

    def get_name(myself):
        return myself.name
    
    def hello(myself):
        return f"Hello from {myself.name}!"

alice = Person("Alice")
print(alice.get_name())  # "Alice"
print(alice.hello())     # "Hello from Alice!"
