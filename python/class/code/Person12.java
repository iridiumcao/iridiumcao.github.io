class Person12 {
    public static String greet() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        // 通过类名调用静态方法
        System.out.println(Person12.greet()); // Output: Hello, world!

        // 通过实例调用静态方法
        Person12 person = new Person12();
        System.out.println(person.greet()); // Output: Hello, world!
    }
}