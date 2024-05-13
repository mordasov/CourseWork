public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);

        Employee employee1 = new Employee("Владимиров", "Владимир", "Владимирович",
                1, 200_000);
        Employee employee2 = new Employee("Петров", "Пётр", "Петрович",
                1, 10_000);
        Employee employee3 = new Employee("Максимов", "Максим", "Максимович",
                3, 33_000);
        Employee employee4 = new Employee("Иванов", "Иван", "Иванович",
                2, 10_000);
        Employee employee5 = new Employee("Сергеев", "Сергей", "Сергеевич",
                2, 50_000);
        Employee employee6 = new Employee("Дмитриев", "Дмитрий", "Дмитриевич",
                4, 100_000);
        Employee employee7 = new Employee("Андреев", "Андрей", "Андреевич",
                5, 80_000);
        Employee employee8 = new Employee("Михайлов", "Михаил", "Михайлович",
                2, 40_000);
        Employee employee9 = new Employee("Денисов", "Денис", "Денисович",
                3, 200_000);
        Employee employee10 = new Employee("Алексеев", "Алексей", "Алексеевич",
                1, 20_000);
        Employee employee11 = new Employee("Афанасьев", "Афанасий", "Афанасьевич",
                4, 10_000);
        Employee employee12 = new Employee("Борисов", "Борис", "Борисович",
                2, 300_000);

        System.out.println("[3.4.a] >> добавить в EmployeeBook новых сотрудников:");
        employeeBook.addNewEmployee(employee1);
        employeeBook.addNewEmployee(employee2);
        employeeBook.addNewEmployee(employee3);
        employeeBook.addNewEmployee(employee4);
        employeeBook.addNewEmployee(employee5);
        employeeBook.addNewEmployee(employee6);
        employeeBook.addNewEmployee(employee7);
        employeeBook.addNewEmployee(employee8);
        employeeBook.addNewEmployee(employee9);
        employeeBook.addNewEmployee(employee10);
        employeeBook.addNewEmployee(employee11);
        employeeBook.addNewEmployee(employee12);
        System.out.println();


        System.out.println("[1.8.a-1] >> вывести в консоль неотформатированный список всех сотрудников со всеми данными:");
        employeeBook.printListOfEmployees();

        System.out.println("[1.8.a-2] >> вывести в консоль отформатированный список всех сотрудников со всеми данными:");
        employeeBook.printFormatListOfEmployees();

        System.out.println("[1.8.b] >> вывести в консоль сумму затрат за месяц:");
        System.out.println(employeeBook.calculateSalaryForMonth() + "\n");

        System.out.println("[1.8.c-1] >> вывести в консоль первого из списка сотрудника с минимальной ЗП:");
        System.out.println(employeeBook.minSalaryEmployee() + "\n");

        System.out.println("[1.8.c-2] >> вывести в консоль сотрудников с минимальной ЗП:");
        employeeBook.printEmployeesWithMinSalary();

        System.out.println("[1.8.d-1] >> вывести в консоль первопопавшегося сотрудника с максимальной ЗП:");
        System.out.println(employeeBook.maxSalaryEmployee() + "\n");

        System.out.println("[1.8.d-2] >> вывести в консоль сотрудников с максимальной ЗП:");
        employeeBook.printEmployeesWithMaxSalary();

        System.out.println("[1.8.e] >> вывести в консоль среднее значение затрат за месяц:");
        System.out.println(employeeBook.avgSalaryEmployee() + "\n");

        System.out.println("[1.8.f] >> вывести в консоль ФИО всех сотрудников:");
        employeeBook.printFullNameEmployees();

        int percentIncrease = 5;
        System.out.println("[2.1] >> проиндексировать ЗП на " + percentIncrease + " процентов и вывести в консоль:");
        employeeBook.indexSalary(percentIncrease);
        employeeBook.printFormatListOfEmployees();

        int dep1 = 1;
        System.out.println("[2.2-a] >> вывести в консоль сотрудника с минимальной ЗП отдела #" + dep1 + ":");
        System.out.println(employeeBook.findMinSalaryEmployeeDepartment(dep1) + "\n");

        int dep2 = 2;
        System.out.println("[2.2-b] >> вывести в консоль сотрудника с максимальной ЗП отдела #" + dep2 + ":");
        System.out.println(employeeBook.findMaxSalaryEmployeeDepartment(dep2) + "\n");

        int dep3 = 3;
        System.out.println("[2.2-c] >> вывести в консоль сумму затрат на ЗП по отделу #" + dep3 + ":");
        System.out.println(employeeBook.findSumSalaryOfDepartmentForMonth(dep3) + "\n");


        System.out.println("[2.2-d] >> вывести в консоль среднюю ЗП по отделу #" + dep3 + ":");
        System.out.println(employeeBook.findAvgSalaryOfDepartment(dep3) + "\n");

        int percentIncreaseDepartment = 10;
        System.out.println("[2.2-e] >> проиндексировать ЗП отдела #" + dep3 + " на " + percentIncreaseDepartment +
                " процентов");
        employeeBook.indexSalaryDepartment(dep3, percentIncreaseDepartment);

        System.out.println("[2.2-f] >> вывести в консоль всех сотрудников отдела #" + dep3 + ":");
        employeeBook.printEmployeeOfDepartment(dep3);

        int goalSalary = 50_000;
        System.out.println("[2.3-a] >> вывести в консоль всех сотрудников c ЗП меньше чем " + goalSalary + ":");
        employeeBook.printEmployeeSalaryLessThan(goalSalary);

        System.out.println("[2.3-b] >> вывести в консоль всех сотрудников c ЗП больше чем " + goalSalary + ":");
        employeeBook.printEmployeeSalaryMoreThan(goalSalary);

        int id5 = 5;
        int id7 = 7;
        int id9 = 9;
        System.out.println("[3.4-b] >> удалить сотрудников по ID " + id5 + ", ID " + id7 + ", ID " + id9 +
                " и вывести список сотрудников:");
        employeeBook.deleteEmployee(id5);
        employeeBook.deleteEmployee(id7);
        employeeBook.deleteEmployee(id9);
        employeeBook.printFormatListOfEmployees();

        System.out.println("[3.4-a] >> добавить новых сотрудников в свободную ячейку и вывести список сотрудников:");
        employeeBook.addNewEmployee(employee11);
        employeeBook.addNewEmployee(employee12);
        employeeBook.printFormatListOfEmployees();

        int id4 = 4;
        System.out.println("[3.5] >> получить сотрудника по ID #" + id4 + " и вывести его на консоль:");
        System.out.println(employeeBook.getEmployee(id4));
    }

}