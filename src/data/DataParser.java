package data;

import model.users.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {
    private static final String SPLIT_REGEX = ",";

    public List<Employee> parseStringsToEmployee(List<String> employeeRows) {

        List<Employee> employees = new ArrayList<>();

        for (String row: employeeRows.stream().skip(1).collect(Collectors.toList())) {
            Employee currentEmployee = parseRowToEmployee(row);
            employees.add(currentEmployee);
        }
        return employees;
    }

    private Employee parseRowToEmployee(String row) {

        String[] employeesRow = row.split(SPLIT_REGEX);
        String employeesId = employeesRow[0];
        String employeesFirstName = employeesRow[1];
        String employeesLastName = employeesRow[2];
        String employeesAge = employeesRow[3];
        String employeesSalary = employeesRow[4];

        Employee result = new Employee(Integer.parseInt(employeesId)
                , employeesFirstName
                , employeesLastName
                , Integer.parseInt(employeesAge)
                , Double.parseDouble(employeesSalary));

        return result;
    }


}
