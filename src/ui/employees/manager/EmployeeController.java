package ui.employees.manager;

import data.DataParser;
import data.EmployeeRepository;
import data.FileManager;
import data.OnEventListener;
import model.users.Employee;
import ui.MenuManager;
import ui.employees.printsForEmployee.PrintMessagesEmployees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController implements OnEventListener {
    private final DataParser dataParser = new DataParser();
    private final ViewListener viewListener = new ViewEmployee();
    private final PrintMessagesEmployees printMessagesEmployees = new PrintMessagesEmployees();
    private final MenuManager menuManager = new MenuManager();

    public EmployeeController() {
        FileManager fileManager = new FileManager(this);
        fileManager.readEmployeesDataFile();
    }

    public void promptForCredentials() {
        Scanner input = new Scanner(System.in);
        printMessagesEmployees.printMessageForLoginEmployeeWithID();
        int employeeID = input.nextInt();

        printMessagesEmployees.printMessageForLoginEmployeeWithFirstName();
        String employeeFirstName = input.next();

        printMessagesEmployees.printMessageForLoginEmployeeWithLastName();
        String employeeLastName = input.next();

        if(checkEmployeeExist(employeeID, employeeFirstName, employeeLastName)) {
            viewListener.printEmployee(employeeFirstName, employeeLastName);
            menuManager.chooseOptionFromMenu();
        }else{
            viewListener.printError();
            promptForCredentials();
        }
    }

    private boolean checkEmployeeExist(int id, String firstName, String lastName) {
        return EmployeeRepository.getInstance().provideAllEmployees().stream()
                .anyMatch(employee -> employee.employeeId() == id &&
                        employee.firstName().equals(firstName) &&
                        employee.lastName().equals(lastName));
    }

    @Override
    public void onRead(ArrayList<String> resultEmployeesData) {
        List<Employee> employees = dataParser.parseStringsToEmployee(resultEmployeesData);
        EmployeeRepository.getInstance().setEmployees(employees);
    }

    @Override
    public void onWrite() {
    }
}
