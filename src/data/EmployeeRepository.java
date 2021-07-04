package data;

import model.users.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static EmployeeRepository instance;
    private List<Employee> employees;

    private EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> provideAllEmployees() {
        return employees;
    }

    public static EmployeeRepository getInstance() {
        if(instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }
}