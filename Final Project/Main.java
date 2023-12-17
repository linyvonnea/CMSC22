import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalCatalogueSystem catalogueSystem = new AnimalCatalogueSystem();
        AnimalMenu animalMenu = new AnimalMenu(catalogueSystem);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            animalMenu.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            animalMenu.handleMenuChoice(choice, scanner);
        }
    }
}

class AnimalMenu {
    private AnimalCatalogueSystem catalogueSystem;

    public AnimalMenu(AnimalCatalogueSystem catalogueSystem) {
        this.catalogueSystem = catalogueSystem;
    }

    public void displayMenu() {
        System.out.println("============-= ^._.^ =-===========");
        System.out.println("== Animal Catalogue System Menu ==");
        System.out.println("==============U ^ v ^ U=============\n");

        System.out.println("Welcome! How may we help you today? \n");

        System.out.println("1. Report Lost/Found Animal");
        System.out.println("2. Adopt an Animal");
        System.out.println("3. Search for Animals");
        System.out.println("4. Update Animal Record");
        System.out.println("5. Delete Animal Record");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
    }

    public void handleMenuChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                AnimalActions.reportLostFoundAnimal(catalogueSystem, scanner);
                break;
            case 2:
                AnimalActions.adoptAnimal(catalogueSystem, scanner);
                break;
            case 3:
                AnimalActions.searchForAnimals(catalogueSystem, scanner);
                break;
            case 4:
                AnimalActions.updateAnimalRecord(catalogueSystem, scanner);
                break;
            case 5:
                AnimalActions.deleteAnimalRecord(catalogueSystem, scanner);
                break;
            case 6:
                System.out.println("-------------------(^o^)/-----------------");
                System.out.println("Exiting Animal Catalogue System. Goodbye!");
                System.out.println("-------------------------------------------");
                System.exit(0);
            default:
                System.out.println("--------------------(😑)--------------------");
                System.out.println("Invalid choice. Please enter a valid option.");
                System.out.println("---------------------------------------------");
        }
    }
}

