package javas;
import java.util.Scanner;

public class Project {

    static Scanner sc = new Scanner(System.in);
    static String username;
    static String password;

    static void login() {
        System.out.println("||| Welcome to Electricity Billing |||");
        System.out.println("---------------------------------------");
        System.out.println("Login into your Account\n");

        System.out.print("Username: ");
        username = sc.nextLine();
        
        System.out.print("Password: ");
        password = sc.nextLine();

      
        boolean isValidUser = checkValidUser(username);

        if (isValidUser) {
            System.out.println("LoggedIn Successfully!!!");
            System.out.println("======================================\n");
        } else {
            System.out.println();
            System.out.println("**Invalid username or password. Please try again**.\n");
            login(); // Prompt for login again if invalid
        }
    }

    static boolean checkValidUser(String username) {
        // Check if the username exists in your data
        // For simplicity, let's assume you have a predefined list of valid usernames
        return username.equalsIgnoreCase("siva") ||
               username.equalsIgnoreCase("nitheesh") ||
               username.equalsIgnoreCase("santhosh") ||
               username.equalsIgnoreCase("prem");
    }

    static void mainMenu() {
        System.out.println("\tWelcome to the Interface\n");
        System.out.println("     1. Customer Information");
        System.out.println("     2. Meter Reading Details");
        System.out.println("     3. Bill Details");
        System.out.println("     4. Tariff Details\n");

        System.out.print("Enter your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline character

        switch (choice) {
            case 1:
                custInfo();
                break;
            case 2:
                readingDetails();
                break;
            case 3:
                bill();
                break;
            case 4:
                tariffDetails();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.\n");
                mainMenu();
                return; // exit mainMenu() after handling default case
        }

        mainMenu(); // after executing chosen option, display main menu again
    }

    static void custInfo() {
        switch (username.toLowerCase()) {
            case "siva":
                displayCustomerInfo("Siva", "3/68 Periyar Street, Salem", "42841", "Residential");
                break;
            case "nitheesh":
                displayCustomerInfo("Nitheesh", "8/34 Gandhi Street, Chennai", "6432", "Residential");
                break;
            case "santhosh":
                displayCustomerInfo("Santhosh", "5/94 Nehru Street, Covai", "45466", "Residential");
                break;
            case "prem":
                displayCustomerInfo("Prem", "8/34 Gandhi Street, Chennai", "6432", "Residential");
                break;
            default:
                System.out.println("\tUser not available\n");
                break;
        }
    }

    static void displayCustomerInfo(String name, String address, String customID, String connectionType) {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Custom ID: " + customID);
        System.out.println("Connection Type: " + connectionType + "\n");
    }

    static void readingDetails() {
        switch (username.toLowerCase()) {
            case "siva":
                displayMeterDetails("41", "12/03/2014", "Smart Meter", "Residential Building", "Active", "Monthly");
                break;
            case "prem":
                displayMeterDetails("381", "14/05/2017", "Smart Meter", "Residential Building", "Active", "Monthly");
                break;
            case "nitheesh":
                displayMeterDetails("472", "24/08/2016", "Smart Meter", "Residential Building", "Active", "Monthly");
                break;
            case "santhosh":
                displayMeterDetails("42", "07/05/2020", "Analog Meter", "Residential Building", "Active", "Monthly");
                break;
            default:
                System.out.println("\tUser is not Available\n");
                break;
        }
    }

    static void displayMeterDetails(String meterNumber, String installationDate, String meterType,
                                    String meterLocation, String meterStatus, String readingFrequency) {
        System.out.println("Meter number: " + meterNumber);
        System.out.println("Installation Date: " + installationDate);
        System.out.println("Meter Type: " + meterType);
        System.out.println("Meter Location: " + meterLocation);
        System.out.println("Meter Status: " + meterStatus);
        System.out.println("Reading Frequency: " + readingFrequency + "\n");
    }

    static void bill() {
        System.out.print("Enter your Meter Number: ");
        int meterNumber = sc.nextInt();
        System.out.print("Enter Units Consumed: ");
        int unitsConsumed = sc.nextInt();

        double totalBill = calculateBill(unitsConsumed);
        System.out.println("Total Bill: Rs. " + totalBill + "\n");
    }

    static double calculateBill(int unitsConsumed) {
        double totalBill = 0.0;
        if (unitsConsumed <= 100) {
            totalBill = 0.0;
        } else if (unitsConsumed <= 200) {
            totalBill = (unitsConsumed - 100) * 1.5;
        } else if (unitsConsumed <= 500) {
            totalBill = 100 * 1.5 + (unitsConsumed - 200) * 2;
        } else if (unitsConsumed <= 1000) {
            totalBill = 100 * 1.5 + 300 * 2 + (unitsConsumed - 500) * 2.5;
        } else {
            System.out.println("Contact support for consumption above 1000 units");
        }
        return totalBill;
    }

    static void tariffDetails() {
        System.out.println("=================================");
        System.out.println("||       Tariff Details        ||");
        System.out.println("=================================");
        System.out.println("1. Up to 100 units: Free of charge");
        System.out.println("2. 101 to 200 units: Rs. 1.5 per unit");
        System.out.println("3. 201 to 500 units: Rs. 2 per unit");
        System.out.println("4. 501 to 1000 units: Rs. 2.5 per unit");
        System.out.println("=================================\n");
    }

    public static void main(String[] args) {
        login();
        mainMenu();
        sc.close();
    }
}
