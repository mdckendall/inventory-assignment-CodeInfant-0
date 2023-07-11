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

    
    public String toString() {
        return name + ", " + serialNumber + ", " + value;
    }
}

public class InventorySystem {
    private static List<InventoryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    showAllItems();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("Press 1 to add an item.");
        System.out.println("Press 2 to delete an item.");
        System.out.println("Press 3 to update an item.");
        System.out.println("Press 4 to show all the items.");
        System.out.println("Press 5 to quit the program.");
    }

    private static int getIntInput() {
        int input = -1;
        try {
            input = scanner.nextInt();
            scanner.nextLine(); 
        } catch (InputMismatchException e) {
            scanner.nextLine(); 
        }
        return input;
    }

    private static void addItem() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the serial number:");
        String serialNumber = scanner.nextLine();
        System.out.println("Enter the value in dollars (whole number):");
        int value = getIntInput();
        InventoryItem item = new InventoryItem(name, serialNumber, value);
        inventory.add(item);
        System.out.println("Item added successfully.");
    }

    private static void deleteItem() {
        System.out.println("Enter the serial number of the item to delete:");
        String serialNumber = scanner.nextLine();
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

    private static void updateItem() {
        System.out.println("Enter the serial number of the item to update:");
        String serialNumber = scanner.nextLine();
        boolean found = false;
        for (InventoryItem item : inventory) {
            if (item.getSerialNumber().equals(serialNumber)) {
                System.out.println("Enter the new name:");
                String newName = scanner.nextLine();
                System.out.println("Enter the new value in dollars (whole number):");
                int newValue = getIntInput();
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

    private static void showAllItems() {
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }
}
