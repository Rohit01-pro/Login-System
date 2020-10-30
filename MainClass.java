import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    static Scanner input = new Scanner(System.in);

    static void register() {
        try {
            FileWriter file = new FileWriter("users.txt", true);

            System.out.println("\n\t####\tREGISTER\t####\n");

            System.out.print("Enter Email: ");
            String email = input.next();

            System.out.print("\nEnter Password: ");
            String password = input.next();

            file.write(email + "  " + password + "\n");
            file.close();
            System.out.println("\nRegister Successfull");

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    static void login() {
        try {
            File file = new File("users.txt");
            Scanner fileInput = new Scanner(file);

            System.out.println("\n\t####\tLOGIN\t####\n");
            System.out.print("Enter Email: ");
            String email = input.next();

            System.out.print("\nEnter Password: ");
            String password = input.next();

            String usersEmail[] = new String[50];
            String userspasssword[] = new String[50];
            int u = -1;

            while (fileInput.hasNextLine()) {
                String data = fileInput.nextLine();
                String array[] = data.split("  ");
                u++;
                usersEmail[u] = array[0];
                userspasssword[u] = array[1];
            }

            boolean authenticate = false;
            for (int i = 0; i <= u; i++) {
                if (usersEmail[i].compareTo(email) == 0 && userspasssword[i].compareTo(password) == 0) {
                    authenticate = true;
                    break;
                }
            }
            if (authenticate)
                System.out.println("\nLogin Successfull");
            else
                System.out.println("\nIncorrect Email or Password.");

            fileInput.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    static void display() {
        try {
            File file = new File("users.txt");
            Scanner fileInput = new Scanner(file);
            String usersEmail[] = new String[50];
            String userspasssword[] = new String[50];
            int u = -1;

            while (fileInput.hasNextLine()) {
                String data = fileInput.nextLine();
                String array[] = data.split("  ");
                u++;
                usersEmail[u] = array[0];
                userspasssword[u] = array[1];
            }
            // For Displaying Users
            line();
            System.out.printf("%-35s %s", "EMAIL", "PASSWORD");
            line();

            for (int i = 0; i <= u; i++) {
                System.out.printf("%-35s %s\n", usersEmail[i], userspasssword[i]);
            }
            fileInput.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    static void line() {
        System.out.println("");
        for (int i = 1; i <= 50; i++)
            System.out.print("-");
        System.out.println("");

    }

    // Menu List
    static byte menuList() {
        clearConsole();
        System.out.println("\n\t####\tLOGIN SYSTEM\t####\n");
        System.out.println("[1]  Login");
        System.out.println("[2]  Register");
        System.out.println("[3]  Display Users");
        System.out.println("[4]  Exit");

        byte choice = 0;
        try {
            System.out.print("\nEnter Your Choice: ");
            choice = input.nextByte();
        } catch (Exception ex) {
            System.out.println("\n\nInvalid Choice");
        }
        return choice;
    }

    // To clear the Console 
    static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    // To Get Key Press
    static void getKeyPress() {
        try {
            char ch = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // static void isValidEmail(String email){
          
    // }
    public static void main(String[] args) {

        while (true) {
            switch (menuList()) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.exit(1);
                    System.out.println("\n\t####\tTHANK YOU\t####\n");
                    break;
                default:
                    System.out.println("\n***\tInvalid Choice\t***\n");
            }
            System.out.print("\nPress Enter ->");
            getKeyPress();
        }

    }
}
