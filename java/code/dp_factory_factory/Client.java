public class Client {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal cock = factory.generateAnimal(AnimalType.COCK);
        System.out.println(cock.getName());
        System.out.println("Can I fly? " + ((Cock) cock).isFly());
    }
}
