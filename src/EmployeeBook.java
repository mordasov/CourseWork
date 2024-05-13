import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class EmployeeBook {
    private Employee[] employees;

    EmployeeBook(int size) {
        employees = new Employee[size];
    }

    //Очень сложно
    //=================//

    //добавить сотрудника (task 3.4-a)
    public boolean addNewEmployee(Employee e) {
        boolean isAdded = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                isAdded = true;
                break;
            }
        }
        if (isAdded) {
            System.out.println("Добавлен новый сотрудник > " + e);
        } else {
            System.out.println("Внимание! Место закончилось! Сотрудник " + e.getFullName() + " НЕ добавлен!!!");
        }
        return isAdded;
    }

    //удалить сотрудника по ID (task 3.4-b)
    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                System.out.println("Внимание! Сотрудник " + employees[i].getFullName() + " удален из EmployeeBook!");
                employees[i] = null;
                break;
            }
        }
    }

    //получить сотрудника по ID (task 3.5)
    public Employee getEmployee(int id) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                index = i;
            }
        }
        return employees[index];
    }

    //Базовая сложность
    //=================//

    //вывести в консоль неотформатированный список всех сотрудников со всеми данными (task-1.8.а-1)
    public void printListOfEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                System.out.println("[null]");
            } else {
                System.out.println(employees[i]);
            }
        }
        System.out.println();
    }

    //вывести в консоль отформатированный список всех сотрудников со всеми данными (task-1.8.а-2)
    public void printFormatListOfEmployees() {
        System.out.println("-".repeat(70));
        System.out.printf("%-3s%-33s%-12s%-10s%n", "ID", "ФИО", "Отдел", "Зарплата");
        System.out.println("-".repeat(70));
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                System.out.println("[null]");
            } else {
                System.out.printf("%-3d%-35s%-7d% 10d%n",
                        employees[i].getId(), employees[i].getFullName(), employees[i].getDepartment(), employees[i].getSalary());
            }
        }

        System.out.println("-".repeat(70));
    }

    //посчитать сумму затрат на ЗП в месяц (task-1.8.b)
    public int calculateSalaryForMonth() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    //найти сотрудника с минимальной ЗП (task-1.8.c-1)
    public Employee minSalaryEmployee() {
        int minSalary = MAX_VALUE;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    //найти сотрудника с минимальной ЗП (task-1.8.c-2 если есть несколько сотрудников с одинаковой минимальной ЗП);
    public void printEmployeesWithMinSalary() {
        Employee minSalaryEmployee = minSalaryEmployee();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == minSalaryEmployee.getSalary()) {
                System.out.println(employees[i]);
            }
        }
        System.out.println();
    }

    //найти сотрудника с максимальной ЗП (task-1.8.d-1);
    public Employee maxSalaryEmployee() {
        int maxSalary = MIN_VALUE;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    //найти сотрудника с минимальной ЗП (task-1.8.d-2 если есть несколько сотрудников с одинаковой масимальной ЗП);
    public void printEmployeesWithMaxSalary() {
        Employee maxSalaryEmployee = maxSalaryEmployee();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == maxSalaryEmployee.getSalary()) {
                System.out.println(employees[i]);
            }
        }
        System.out.println();
    }

    //подсчитать среднее значение зарплат (task-1.8.e)
    public int avgSalaryEmployee() {
        return calculateSalaryForMonth() / employees.length;
    }

    //распечатать ФИО всех сотрудников (task-1.8.f)
    public void printFullNameEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
        System.out.println();
    }

    //Повышенная сложность
    //=================//

    //проиндексировать ЗП у всех сотрудников (2.1)
    public void indexSalary(int percentIncrease) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                int increase = employees[i].getSalary() * percentIncrease / 100;
                employees[i].setSalary(employees[i].getSalary() + increase);
            }
        }
    }

    //найти сотрудника с минимальной ЗП в отделе (task-2.2.а)
    public Employee findMinSalaryEmployeeDepartment(int department) {
        int minSalaryInDepartment = MAX_VALUE;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null &&
                    employees[i].getDepartment() == department &&
                    employees[i].getSalary() < minSalaryInDepartment) {
                minSalaryInDepartment = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    //найти сотрудника с максимальной ЗП в отделе (task-2.2.b)
    public Employee findMaxSalaryEmployeeDepartment(int department) {
        int maxSalaryInDepartment = MIN_VALUE;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() > maxSalaryInDepartment) {
                maxSalaryInDepartment = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index];
    }

    //найти сумму затрат ЗП по отделу (task-2.2.с)
    public int findSumSalaryOfDepartmentForMonth(int department) {
        int sumSalaryDepatment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sumSalaryDepatment += employees[i].getSalary();
            }
        }
        return sumSalaryDepatment;
    }

    //найти среднюю ЗП по отделу (task-2.2.d)
    public int findAvgSalaryOfDepartment(int department) {
        int quantityEmployeeOfDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                quantityEmployeeOfDepartment++;
            }
        }
        if (quantityEmployeeOfDepartment == 0) {
            return 0;
        } else {
            return findSumSalaryOfDepartmentForMonth(department) / quantityEmployeeOfDepartment;
        }
    }

    //проиндексировать ЗП по отделу на процент (task-2.2.e)
    public void indexSalaryDepartment(int department, int percentIncrease) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                int increase = employees[i].getSalary() * percentIncrease / 100;
                employees[i].setSalary(employees[i].getSalary() + increase);
            }
        }
    }

    //напечатать всех сотрудников определенного отдела - все данные, кроме отдела (task-2.2.f)
    public void printEmployeeOfDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                printEmployee(i);
            }
        }
        System.out.println();
    }

    //распечатать всех сотрудников с ЗП меньше числа-параметра (ID,ФИО,ЗП) (task-2.3.a)
    public void printEmployeeSalaryLessThan(int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                printEmployee(i);
            }
        }
        System.out.println();
    }

    //распечатать всех сотрудников с ЗП больше числа-параметра (ID,ФИО,ЗП) (task-2.3.b)
    public void printEmployeeSalaryMoreThan(int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                printEmployee(i);
            }
        }
        System.out.println();
    }

    //напечатать сотрудника по индксу
    public void printEmployee(int index) {
        System.out.printf("ID: %d, ФИО: %s %s %s, ЗП: %d;%n",
                employees[index].getId(),
                employees[index].getLastName(), employees[index].getFirstName(), employees[index].getMiddleName(),
                employees[index].getSalary());
    }
}
