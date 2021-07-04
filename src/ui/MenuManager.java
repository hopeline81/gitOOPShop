package ui;

import data.EmployeeRepository;
import data.ProductRepository;
import model.users.Employee;
import ui.employees.manager.EmployeeController;
import ui.employees.printsForEmployee.PrintMenu;
import ui.employees.printsForEmployee.PrintMessagesEmployees;
import ui.product.manager.ControllerProduct;

import java.util.Comparator;
import java.util.Scanner;

public class MenuManager {
    private final PrintMessagesEmployees printMessagesEmployees = new PrintMessagesEmployees();
    private final LoginMenu loginMenu = new LoginMenu();
    private final PrintMenu printMenu = new PrintMenu();
    private final ControllerProduct controllerProduct = new ControllerProduct();

    public void chooseOptionFromMenu() {
        byte option;
        Scanner input = new Scanner(System.in);
        do {
            printMenu.EmployeeMenu();
            option = input.nextByte();
            switch (option) {
                case 1: controllerProduct.printAllProducts(ProductRepository.getInstance().provideAllProducts());
                    break;
                case 2:controllerProduct.printAllProductsSortedByNamePriceOrDate();
                    break;
                case 3:
                    controllerProduct.printSpecificProductById();
                    break;
                case 4:
                    controllerProduct.printProductsWithPriceHigherOrEqualToUserSetPrice();
                    break;
                case 5:
                    controllerProduct.printProductsWithPriceLowerOrEqualToUserSetPrice();
                    break;
                case 6:
                    controllerProduct.printProductsWithQualityHigherOrEqualToUserSetQuantity();
                    break;
                case 7:
                    controllerProduct.printProductsWithQualityLowerOrEqualToUserSetQuantity();
                    break;
                case 8:
                    controllerProduct.addNewProduct();
                    controllerProduct.saveChanges();
                    controllerProduct.printAllProducts(ProductRepository.getInstance().provideAllProducts());
                    break;
                case 9:
                    controllerProduct.changeProductPrice();
                    break;
                case 10:
                    controllerProduct.changeProductQuantity();
                    controllerProduct.printAllProducts(ProductRepository.getInstance().provideAllProducts());
                    break;
                case 11:
                    break;
                case 12:
                    controllerProduct.deleteSelectedProduct();
                    controllerProduct.printAllProducts(ProductRepository.getInstance().provideAllProducts());
                    break;
                case 13:
                    printMessagesEmployees.printMessageTypeOfSortingEmployees();
                    chooseTypeSortingEmployee();
                    break;
                case 14:
                    loginMenu.showFirstMenuOptions();
                case 15:
                    controllerProduct.saveChanges();
                default:
                    printMessagesEmployees.printMessageError();
                    chooseOptionFromMenu();
            }
        } while (option != 14);
    }

    public void chooseTypeSortingEmployee() {
        Scanner scanner = new Scanner(System.in);
        byte option = scanner.nextByte();
        switch (option) {
            case 1 -> sortEmployeeByName();
            case 2 -> sortEmployeeBySalary();
            default -> {
                System.out.println("Choose 1 or 2");
                chooseTypeSortingEmployee();
            }
        }
    }

    private void sortEmployeeBySalary() {
        EmployeeRepository.getInstance().provideAllEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::salary))
                .forEach(System.out::println);
    }

    private void sortEmployeeByName() {
        EmployeeRepository.getInstance().provideAllEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::firstName))
                .forEach(System.out::println);
    }
}
