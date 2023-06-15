public class AnimalFactory {
    Animal generateAnimal(AnimalType type) {
        if (type.equals(AnimalType.COCK)) {
            return new Cock();
        } else if (type.equals(AnimalType.DUCK)) {
            return new Duck();
        }
        return null;
    }
}
