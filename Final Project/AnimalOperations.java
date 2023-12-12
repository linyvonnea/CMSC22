// Abstract class or interface for operations like searching, updating, and deleting
public interface AnimalOperations {
    void reportLostFoundAnimal(Animal animal, boolean isLost);
    void adoptAnimal(Animal animal);
    void searchForAnimals(String breed);
    void updateAnimal(Animal oldAnimal, Animal newAnimal);
    void deleteAnimal(Animal animal);
}
