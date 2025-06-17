import java.util.InputMismatchException;
import java.util.Scanner;

import device.iPhone;
import menu.iphoneMenu;

public class main {
    private static final Scanner scanner = new Scanner(System.in);
    //Método para limpar a tela do console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void main(String[] args) {
        iPhone myIphone = new iPhone();
        String Alerta = "";
        iphoneMenu.setIphoneInstance(myIphone);
        int option = 0;
        do {
            clearScreen();
            System.out.println("================================================");
            System.out.println("Welcome to the iPhone Menu Application");
            System.out.println("================================================");
            System.out.println("Please select an option:");
            System.out.println("1  -  Music");
            System.out.println("2  -  Video");
            System.out.println("3  -  Phone");
            System.out.println("4  -  Internet");
            System.out.println("5  -  Exit");
            System.out.println("================================================");
            System.out.println("Alert: " + Alerta);
            System.out.println("================================================");
            Alerta = "";
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                Alerta = "Invalid input. Please enter a number between 1 and 5.";
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> iphoneMenu.displayMusicMenu();
                case 2 -> iphoneMenu.displayVideoMenu();
                case 3 -> iphoneMenu.displayPhoneMenu();
                case 4 -> iphoneMenu.displayInternetMenu();
                case 5 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> Alerta = "Invalid option. Please try again.";
            }
        } while (option != 5);
    }
}