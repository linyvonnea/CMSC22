import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {
    // Comma Separated
    private static final String DELIMITER = ",";

    public static List<Animal> readFromCSV(String filePath) {
        List<Animal> animals = new ArrayList<>();
        File file = new File(filePath);

        // Check if the file exists before attempting to read
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return animals;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(DELIMITER);
                
                String name = data[0];
                String breed = data[1];
                String color = data[2];
                String healthStatus = data[3];
                int age = Integer.parseInt(data[4]);
                boolean lost = Boolean.parseBoolean(data[5]);

                // Create a specific type of Animal (Dog or Cat) based on the breed
                Animal animal;
                if ("Dog".equalsIgnoreCase(breed)) {
                    animal = new Dog(name, breed, color, healthStatus, age, lost);
                } else if ("Cat".equalsIgnoreCase(breed)) {
                    animal = new Cat(name, breed, color, healthStatus, age, lost);
                } else {
                    // Handle other cases or skip invalid data
                    continue;
                }

                animals.add(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

    public static void writeToCSV(String filePath, List<Animal> animals) {
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Animal animal : animals) {
                String line = String.join(DELIMITER,
                        animal.getName(),
                        animal.getBreed(),
                        animal.getColor(),
                        animal.getHealthStatus(),
                        String.valueOf(animal.getAge()),
                        String.valueOf(animal.isLost())
                );

                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
