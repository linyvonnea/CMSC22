import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalCatalogueSystem catalogueSystem = new AnimalCatalogueSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Report Lost/Found Animal");
            System.out.println("2. Adopt an Animal");
            System.out.println("3. Search for Animals");
            System.out.println("4. Update Animal Record");
            System.out.println("5. Delete Animal Record");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reportLostFoundAnimal(catalogueSystem, scanner);
                    break;
                case 2:
                    adoptAnimal(catalogueSystem, scanner);
                    break;
                case 3:
                    searchForAnimals(catalogueSystem, scanner);
                    break;
                case 4:
                    updateAnimalRecord(catalogueSystem, scanner);
                    break;
                case 5:
                    deleteAnimalRecord(catalogueSystem, scanner);
                    break;
                case 6:
                    catalogueSystem.saveToCSV(); // Save data to CSV before exiting
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void reportLostFoundAnimal(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.print("Enter animal type (Dog/Cat): ");
        String animalType = scanner.nextLine();
    
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter animal breed: ");
        String breed = scanner.nextLine();

        System.out.print("Enter animal color: ");
        String color = scanner.nextLine();
    
        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();
    
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Is the animal missing? (true/false): ");
        boolean isLost = scanner.nextBoolean();
        scanner.nextLine(); 
    
        Animal animal;
        if ("Dog".equalsIgnoreCase(animalType)) {
            animal = new Dog(name, breed, color, healthStatus, age, isLost);
        } else if ("Cat".equalsIgnoreCase(animalType)) {
            animal = new Cat(name, breed, color, healthStatus, age, isLost);
        } else {
            System.out.println("Invalid animal type. Animal not reported.");
            return;
        }
    
        catalogueSystem.reportLostFoundAnimal(animal, isLost);
    }

    private static void adoptAnimal(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        //System.out.println("Available animals for adoption:");
        catalogueSystem.displayAvailableAnimals();
    
        System.out.print("Enter the name of the animal you want to adopt: ");
        String adoptAnimalName = scanner.nextLine();
    
        Animal adoptAnimal = catalogueSystem.getAnimalByName(adoptAnimalName);
    
        if (adoptAnimal != null) {
            catalogueSystem.adoptAnimal(adoptAnimal);
            // if (adoptAnimal instanceof Dog) {
            //     System.out.println("Adoption Fee: $" + ((Dog) adoptAnimal).calculateAdoptionFee());
            // } else if (adoptAnimal instanceof Cat) {
            //     System.out.println("Adoption Fee: $" + ((Cat) adoptAnimal).calculateAdoptionFee());
            // }
        } else {
            System.out.println("Animal not found for adoption.");
        }
    }
    
    
    private static void searchForAnimals(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.print("Enter Breed: ");
        String breed = scanner.nextLine();

        catalogueSystem.searchForAnimals(breed);
    }

    private static void updateAnimalRecord(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.println("Available animals for updating:");
        catalogueSystem.displayAvailableAnimals();
    
        System.out.print("Enter the name of the animal you want to update: ");
        String updateAnimalName = scanner.nextLine();
    
        Animal oldAnimal = catalogueSystem.getAnimalByName(updateAnimalName);
    
        if (oldAnimal != null) {
            System.out.println("Enter updated information for the animal:");
    
            System.out.print("Enter animal type (Dog/Cat): ");
            String animalType = scanner.nextLine();
    
            System.out.print("Enter animal name: ");
            String name = scanner.nextLine();
    
            System.out.print("Enter animal breed: ");
            String breed = scanner.nextLine();

            System.out.print("Enter animal color: ");
            String color = scanner.nextLine();
    
            System.out.print("Enter health status: ");
            String healthStatus = scanner.nextLine();
    
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
    
            System.out.print("Is the animal lost? (true/false): ");
            boolean isLost = scanner.nextBoolean();
            scanner.nextLine(); 
    
            Animal newAnimal;
            if ("Dog".equalsIgnoreCase(animalType)) {
                newAnimal = new Dog(name, breed, color, healthStatus, age, isLost);
            } else if ("Cat".equalsIgnoreCase(animalType)) {
                newAnimal = new Cat(name, breed, color, healthStatus, age, isLost);
            } else {
                System.out.println("Invalid animal type. Animal not updated.");
                return;
            }
    
            catalogueSystem.updateAnimal(oldAnimal, newAnimal);
        } else {
            System.out.println("Animal not found for updating.");
        }
    }
    
    

    private static void deleteAnimalRecord(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.println("Available animals for deletion:");
        catalogueSystem.displayAvailableAnimals();

        System.out.print("Enter the name of the animal you want to delete: ");
        String deleteAnimalName = scanner.nextLine();

        
        Animal deleteAnimal = catalogueSystem.getAnimalByName(deleteAnimalName);

        if (deleteAnimal != null) {
            catalogueSystem.deleteAnimal(deleteAnimal);
        } else {
            System.out.println("Animal not found for deletion.");
        }
    }
}
