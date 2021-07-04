package ui.employees.manager;

public class ViewEmployee implements ViewListener {

    @Override
    public void printEmployee(String firstName, String lastName) {
        System.out.println("Welcome " + firstName + " " + lastName);
    }

    @Override
    public void printError() {
        System.out.println("Wrong ID or name. Please try again!");
    }
}