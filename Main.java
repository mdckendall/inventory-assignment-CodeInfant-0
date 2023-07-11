import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class InventoryItem {
    private String name;
    private String serialNumber;
    private int value;

    public InventoryItem(String name, String serialNumber, int value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ", " + serialNumber + ", " + value;
    }
}

class InventorySystem {
    private List<InventoryItem> inventory;

    public InventorySystem() {
        inventory = new ArrayList<>();
    }

    public void addItem(String name, String serialNumber, int value) {
        InventoryItem item = new InventoryItem(name, serialNumber, value);
        inventory.add(item);
        System.out.println("Item added successfully.");
    }

    public void deleteItem(String serialNumber) {
        boolean found = false;
        for (InventoryItem item : inventory) {
            if (item.getSerialNumber().equals(serialNumber)) {
                inventory.remove(item);
                found = true;
                System.out.println("Item deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in the inventory.");
        }
    }

    public void updateItem(String serialNumber, String newName, int newValue) {
        boolean found = false;
        for (InventoryItem item : inventory) {
            if (item.getSerialNumber().equals(serialNumber)) {
                item.setName(newName);
                item.setValue(newValue);
                found = true;
                System.out.println("Item updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in the inventory.");
        }
    }

    public void showAllItems() {
        for (InventoryItem item : inventory) {
            System.out.println(item.getName() + ", " + item.getSerialNumber() + ", " + item.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Enter the name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the serial number:");
                    String serialNumber = scanner.nextLine();
                    System.out.println("Enter the value in dollars (whole number):");
                    int value = getIntInput(scanner);
                    inventorySystem.addItem(name, serialNumber, value);
                    break;
                case 2:
                    System.out.println("Enter the serial number of the item to delete:");
                    String deleteSerialNumber = scanner.nextLine();
                    inventorySystem.deleteItem(deleteSerialNumber);
                    break;
                case 3:
                    System.out.println("Enter the serial number of the item to update:");
                    String updateSerialNumber = scanner.nextLine();
                    System.out.println("Enter the new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new value in dollars (whole number):");
                    int newValue = getIntInput(scanner);
                    inventorySystem.updateItem(updateSerialNumber, newName, newValue);
                    break;
                case 4:
                    inventorySystem.showAllItems();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Press 1 to add an item.");
        System.out.println("Press 2 to delete an item.");
        System.out.println("Press 3 to update an item.");
        System.out.println("Press 4 to show all the items.");
        System.out.println("Press 5 to quit the program.");
    }

    private static int getIntInput(Scanner scanner) {
        int input = -1;
        try {
            input = scanner.nextInt();
            scanner.nextLine(); 
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
        }
        return input;
    }
}

