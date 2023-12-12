import java.util.ArrayList;
import java.util.List;

public class AnimalCatalogueSystem implements AnimalOperations {
    private List<Animal> animals;

    public AnimalCatalogueSystem() {
        // Initialize the list of animals, load data from CSV if available
        this.animals = CSVFileHandler.readFromCSV("animal_data.csv");
    }

    @Override
    public void reportLostFoundAnimal(Animal animal, boolean isLost) {
        animal.setLost(isLost);
        animals.add(animal);
        System.out.println("Animal reported " + (isLost ? "lost" : "found") + " successfully!");
    }

    @Override
    public void adoptAnimal(Animal animal) {
        animals.remove(animal);
        System.out.println("Congratulations! You have adopted " + animal.getName() + ".");
        if (animal instanceof Dog) {
            System.out.println("Adoption Fee: $" + ((Dog) animal).calculateAdoptionFee());
        } else if (animal instanceof Cat) {
            System.out.println("Adoption Fee: $" + ((Cat) animal).calculateAdoptionFee());
        }
    }
    

    @Override
    public void searchForAnimals(String breed) {
        List<Animal> results = new ArrayList<>();
        for (Animal animal : animals) {
            if ((breed == null || breed.equals(animal.getBreed()))) {
                results.add(animal);
            }
        }
    
        // Display search results
        System.out.println("Search Results:");
        for (Animal result : results) {
            System.out.println(result);
        }
    }
    

    @Override
    public void updateAnimal(Animal oldAnimal, Animal newAnimal) {
        if (animals.contains(oldAnimal)) {
            animals.remove(oldAnimal);
            animals.add(newAnimal);
            System.out.println("Animal record updated successfully!");
        } else {
            System.out.println("Animal not found for updating.");
        }
    }

    @Override
    public void deleteAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println("Animal record deleted successfully!");
        } else {
            System.out.println("Animal not found for deletion.");
        }
    }

    // Save data to CSV file
    public void saveToCSV() {
        CSVFileHandler.writeToCSV("animal_data.csv", animals);
    }

    public void displayAvailableAnimals() {
        System.out.println("Available Animals:");
        for (Animal animal : animals) {
            if (!animal.isLost()) {
                System.out.print(animal.getName());
                if (animal instanceof Dog) {
                    System.out.println(" - Adoption Fee: $" + ((Dog) animal).calculateAdoptionFee());
                } else if (animal instanceof Cat) {
                    System.out.println(" - Adoption Fee: $" + ((Cat) animal).calculateAdoptionFee());
                } else {
                    System.out.println();
                }
            }
        }
    }
    

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null; // Animal not found
    }
    
    
}
