import java.util.Scanner;

public class AnimalCatalogueSystem {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        AnimalDataHandler dataHandler = new AnimalDataHandler();

        while (true) {
            System.out.println("============-= ^._.^ =-===========");
            System.out.println("== Animal Catalogue System Menu ==");
            System.out.println("==============U・v・U=============\n");

            System.out.println("Welcome! How may we help you today? \n");

            System.out.println("1. Report Lost Animal");
            System.out.println("2. Report Found Animal");
            System.out.println("3. Adopt an Animal");
            System.out.println("4. Search for Animals");
            System.out.println("5. Update Animal Record");
            System.out.println("6. Delete Animal Record");
            System.out.println("7. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume newline char

            switch (choice) {
                case 1:
                    reportLostAnimal(userInput, dataHandler);
                    break;
                case 2:
                    reportFoundAnimal(userInput, dataHandler);
                    break;
                case 3:
                    adoptAnimal(userInput, dataHandler);
                    break;
                case 4:
                    searchForAnimals(userInput, dataHandler);
                    break;
                case 5:
                    updateAnimalRecord(userInput, dataHandler);
                    break;
                case 6:
                    deleteAnimalRecord(userInput, dataHandler);
                    break;
                case 7:
                    System.out.println("-------------------(^o^)/-----------------");
                    System.out.println("Exiting Animal Catalogue System. Goodbye!");
                    System.out.println("-------------------------------------------");

                    System.exit(0);
                default:
                    System.out.println("--------------------(-_-)--------------------");
                    System.out.println("Invalid choice. Please enter a valid option.");
                    System.out.println("---------------------------------------------");

            }
        }
    }

    //might add input validation for animal and color

    private static void reportLostAnimal(Scanner userInput, AnimalDataHandler dataHandler) {

        do {
            System.out.println("-------------= ^._.^ =------------");
            System.out.println("Enter details of the lost animal:");
            System.out.println("--------------U・v・U-------------\n");
    
            System.out.print("Animal: ");
            String animal = userInput.nextLine();
            
            System.out.print("Color: ");
            String color = userInput.nextLine();
        
            // Animal instance with the provided details
            Animal lostAnimal = new Animal(animal, color);
            
            // Add the lost animal to the data handler
            dataHandler.addLostAnimal(lostAnimal);
        
            System.out.println("-------------------(^o^)/-----------------");
            System.out.println("    Lost animal reported successfully!");
            System.out.println("-------------------(^o^)/-----------------");
    
            System.out.print("Do you want to report another lost animal? (yes/no): ");
        } while (userInput.nextLine().equalsIgnoreCase("yes"));
    }
    
    private static void reportFoundAnimal(Scanner userInput, AnimalDataHandler dataHandler) {
        do {
            System.out.println("-------------= ^._.^ =------------");
            System.out.println("Enter details of the found animal:");
            System.out.println("--------------U・v・U-------------\n");
    
            System.out.print("Animal: ");
            String animal = userInput.nextLine();
            
            System.out.print("Color: ");
            String color = userInput.nextLine();
        
            // Animal instance with the provided details
            Animal foundAnimal = new Animal(animal, color);
            
            // Add the found animal to the data handler
            dataHandler.addFoundAnimal(foundAnimal);
        
            System.out.println("-------------------(^o^)/-----------------");
            System.out.println("    Found animal reported successfully!");
            System.out.println("-------------------(^o^)/-----------------");
    
            System.out.print("Do you want to report another found animal? (yes/no): ");
        } while (userInput.nextLine().equalsIgnoreCase("yes"));
    }
    

    private static void adoptAnimal(Scanner userInput, AnimalDataHandler dataHandler) {

    }

    private static void searchForAnimals(Scanner userInput, AnimalDataHandler dataHandler) {

    }

    private static void updateAnimalRecord(Scanner userInput, AnimalDataHandler dataHandler) {

    }

    private static void deleteAnimalRecord(Scanner userInput, AnimalDataHandler dataHandler) {

    }
}
