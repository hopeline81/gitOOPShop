package ui;

import ui.employees.manager.EmployeeController;

import java.util.Scanner;

public class LoginMenu {
    public void showFirstMenuOptions() {
        System.out.println("Избери една опция:");
        System.out.println("---------------------------\n" +
                "   1. Влез като служител \n" +
                "   2. Влез като клиент \n" +
                "   3. Изход \n" +
                "----------------------------");
        doTheOptionsForTheFirstMenu();
    }

    private void doTheOptionsForTheFirstMenu() {
        Scanner input = new Scanner(System.in);
        byte userChoice = input.nextByte();
        switch (userChoice) {
            case 1:
                EmployeeController controllerEmployee = new EmployeeController();
                controllerEmployee.promptForCredentials();
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Грешен избор, моля изберете пак:");
                doTheOptionsForTheFirstMenu();
        }
    }
}
