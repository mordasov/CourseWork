import java.util.Objects;

public class Employee {
    private static int countId;

    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int department;
    private int salary;

    Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.id = ++countId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && department == employee.department && salary == employee.salary &&
                firstName.equals(employee.firstName) &&
                middleName.equals(employee.middleName) &&
                lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", ФИО: " + lastName + " " + firstName + " " + middleName +
                ", подразделение: " + department + ", ЗП: " + salary + ";";
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

}
