import java.util.Scanner;

public class AnimalActions {
    static void reportLostFoundAnimal(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.println("---------------------------------------------\n\n");
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
    
        System.out.println("\n============-= ^._.^ =-===========");
        System.out.print("Is the animal missing? (true/false): ");
        
        boolean isLost = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("===================================\n");

    
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

    static void adoptAnimal(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        //System.out.println("Available animals for adoption:");
        catalogueSystem.displayAvailableAnimals();
    
        System.out.println("\n================-= ^._.^ =-=================");
        System.out.print(" Enter the name of the animal you want to adopt: ");
        System.out.println("==============================================");

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
        System.out.println("==============================================");
            System.out.println("    Animal not found for adoption.");
        System.out.println("==============================================");

        }
    }
    
    
    static void searchForAnimals(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.print("Enter Breed: ");
        String breed = scanner.nextLine();

        catalogueSystem.searchForAnimals(breed);
    }

    static void updateAnimalRecord(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.println("==============================================");
        System.out.println("       Available animals for updating:");
        System.out.println("==============================================");

        catalogueSystem.displayAvailableAnimals();
    
        System.out.print("Enter the name of the animal you want to update: ");
        String updateAnimalName = scanner.nextLine();
    
        Animal oldAnimal = catalogueSystem.getAnimalByName(updateAnimalName);
    
        if (oldAnimal != null) {
        System.out.println("==============================================");
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
            System.out.println("\n==============================================");
                System.out.println("Invalid animal type. Animal not updated.");
            System.out.println("================================================");

                return;
            }
    
            catalogueSystem.updateAnimal(oldAnimal, newAnimal);
        } else {
            System.out.println("\n================================");
            System.out.println("   Animal not found for updating.");
            System.out.println("================================\n");

        }
    }
    
    

    static void deleteAnimalRecord(AnimalCatalogueSystem catalogueSystem, Scanner scanner) {
        System.out.println("Available animals for deletion:");
        catalogueSystem.displayAvailableAnimals();

        System.out.print("Enter the name of the animal you want to delete: ");
        String deleteAnimalName = scanner.nextLine();

        
        Animal deleteAnimal = catalogueSystem.getAnimalByName(deleteAnimalName);

        if (deleteAnimal != null) {
            catalogueSystem.deleteAnimal(deleteAnimal);
        } else {
            System.out.println("\n==================================");
            System.out.println("   Animal not found for deletion.");
            System.out.println("====================================\n");

        }
    }
}