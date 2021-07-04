package model.users;

public record Employee(int employeeId,
                       String firstName,
                       String lastName,
                       int age,
                       double salary) {

    @Override
    public int employeeId() {
        return employeeId;
    }

    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public double salary() {
        return salary;
    }

    @Override
    public String toString() {
        return " " + employeeId +
                ". " + firstName +
                " " + lastName +
                ", age: " + age +
                ", salary: " + salary ;
    }
}
