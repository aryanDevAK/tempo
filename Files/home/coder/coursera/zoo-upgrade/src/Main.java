import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int continueOuterLoop = 1;
        int continueInnerLoop = 1;

        int menuChoice = 1;
        Tiger tigerObject = new Tiger();
        Dolphin dolphinObject = new Dolphin();
        Penguin penguinObject = new Penguin();

        do {
            switch (animalChoiceMenu(keyboard)) {
                case 1:
                    do {
                        System.out.println("The animal chosen is: " + tigerObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, tigerObject);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("Enter the number of stripes:");
                                tigerObject.setNumberOfStripes(keyboard.nextInt());
                                System.out.println("Enter speed:");
                                tigerObject.setSpeed(keyboard.nextInt());
                                System.out.println("Enter decibel of roar:");
                                tigerObject.setSoundLevel(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("Characteristics of " + tigerObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + tigerObject.getAge());
                                System.out.println("Height: " + tigerObject.getHeight());
                                System.out.println("Weight: " + tigerObject.getWeight());
                                System.out.println("Number of stripes: " + tigerObject.getNumberOfStripes());
                                System.out.println("Speed: " + tigerObject.getSpeed());
                                System.out.println("Sound level of roar: " + tigerObject.getSoundLevel());
                                break;
                            case 3:
                                tigerObject.walking();
                                break;
                            case 4:
                                tigerObject.eatingFood();
                                tigerObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        System.out.println("Continue with this animal? (1 = yes / 2 = no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 2:
                    do {
                        System.out.println("The animal chosen is: " + dolphinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, dolphinObject);
                        switch (menuChoice) {
                            case 1:
                                keyboard.nextLine(); // consume newline
                                System.out.println("Enter the color of the dolphin:");
                                dolphinObject.setColor(keyboard.nextLine());
                                System.out.println("Enter the swimming speed of the dolphin:");
                                dolphinObject.setSwimmingSpeed(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("Characteristics of " + dolphinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + dolphinObject.getAge());
                                System.out.println("Height: " + dolphinObject.getHeight());
                                System.out.println("Weight: " + dolphinObject.getWeight());
                                System.out.println("Color: " + dolphinObject.getColor());
                                System.out.println("Swimming Speed: " + dolphinObject.getSwimmingSpeed());
                                break;
                            case 3:
                                dolphinObject.swimming();
                                break;
                            case 4:
                                dolphinObject.eatingFood();
                                dolphinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        System.out.println("Continue with this animal? (1 = yes / 2 = no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 3:
                    do {
                        System.out.println("The animal chosen is: " + penguinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, penguinObject);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("Is the penguin swimming? (true/false):");
                                penguinObject.setSwimming(keyboard.nextBoolean());
                                System.out.println("Enter walk speed:");
                                penguinObject.setWalkSpeed(keyboard.nextInt());
                                System.out.println("Enter swim speed:");
                                penguinObject.setSwimSpeed(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("Characteristics of " + penguinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + penguinObject.getAge());
                                System.out.println("Height: " + penguinObject.getHeight());
                                System.out.println("Weight: " + penguinObject.getWeight());
                                System.out.println("Walk Speed: " + penguinObject.getWalkSpeed());
                                System.out.println("Swim Speed: " + penguinObject.getSwimSpeed());
                                break;
                            case 3:
                                if (penguinObject.isSwimming()) {
                                    penguinObject.swimming();
                                } else {
                                    penguinObject.walking();
                                }
                                break;
                            case 4:
                                penguinObject.eatingFood();
                                penguinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        System.out.println("Continue with this animal? (1 = yes / 2 = no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 4:
                    // Saving all animals to file
                    writeObjectsToFile(tigerObject, penguinObject, dolphinObject);
                    break;

                case 5:
                    // Reading all animals from file
                    readObjectsFromFile();
                    break;

                default:
                    System.out.println("Invalid animal selection.");
            }

            System.out.println("Continue main Zoo menu? (1 = yes / 2 = no):");
            continueOuterLoop = keyboard.nextInt();

        } while (continueOuterLoop == 1);
    }

    static int animalChoiceMenu(Scanner keyboard) {
        System.out.println("\n******* ZOO ANIMAL CHOICE MENU *******");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");
        System.out.println("4. Save animals to file");
        System.out.println("5. Load animals from file");
        System.out.println("Enter your choice (1-5):");
        return keyboard.nextInt();
    }

    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal) {
        System.out.println("\n***** ANIMAL DETAILS MENU for " + animal.getNameOfAnimal() + " *****");
        System.out.println("1. Set properties");
        System.out.println("2. Display properties");
        System.out.println("3. Display movement");
        System.out.println("4. Display eating");
        System.out.println("Enter your choice (1-4):");
        return keyboard.nextInt();
    }

    // Generalized writeObjectsToFile method
    private static void writeObjectsToFile(Animal tiger, Animal penguin, Animal dolphin) {
        try (ObjectOutputStream tigerOut = new ObjectOutputStream(new FileOutputStream("tiger.txt"));
             ObjectOutputStream penguinOut = new ObjectOutputStream(new FileOutputStream("penguin.txt"));
             ObjectOutputStream dolphinOut = new ObjectOutputStream(new FileOutputStream("dolphin.txt"))) {

            tigerOut.writeObject(tiger);
            penguinOut.writeObject(penguin);
            dolphinOut.writeObject(dolphin);

            System.out.println("Animal data has been saved successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while saving the data.");
            e.printStackTrace();
        }
    }

    private static void readObjectsFromFile() {
        try (ObjectInputStream tigerIn = new ObjectInputStream(new FileInputStream("tiger.txt"));
             ObjectInputStream dolphinIn = new ObjectInputStream(new FileInputStream("dolphin.txt"));
             ObjectInputStream penguinIn = new ObjectInputStream(new FileInputStream("penguin.txt"))) {

            Tiger tiger = (Tiger) tigerIn.readObject();
            Dolphin dolphin = (Dolphin) dolphinIn.readObject();
            Penguin penguin = (Penguin) penguinIn.readObject();

            System.out.println("\n--- LOADED ANIMAL DATA ---");
            System.out.println("Tiger: " + tiger);
            System.out.println("Dolphin: " + dolphin);
            System.out.println("Penguin: " + penguin);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading the data.");
            e.printStackTrace();
        }
    }
}