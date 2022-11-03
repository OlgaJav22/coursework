public class Main {
    private static Employee[] employees;

    public static void main(String[] args) {

        employees = new Employee[10];
        employees[0] = new Employee("Иванов Василий Ивановчи", 1, 54_500.00);
        employees[2] = new Employee("Березина Мария Степановна", 2, 38_200.00);
        employees[3] = new Employee("Сажина Нина Сергеевна", 2, 31_500.00);
        employees[4] = new Employee("Носов Евгений Антонович", 3, 74_000.00);
        employees[5] = new Employee("Дроздов Юрий Леонидович", 5, 65700.00);
        employees[8] = new Employee("Ковязина Юлия Викторовна", 5, 59800.00);
        printListEmployees();
        System.out.println("\n Сумма зарплат всех работников за текущий месяц составила: " + calculateSumSalary());

        System.out.println("\n Сотрудник с минимальной заработной платой: " + findSalaryMin());

        System.out.println("\n Сотрудник с максимальной заработной платой: " + findSalaryMax());

        System.out.println("\n Среднее значение зарплат действующих сотрудников: " + findAverageValueSalary());
        findFullNameCurrentEmployees();
    }

    public static void printListEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static double calculateSumSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }

    public static Employee findSalaryMin() {
        Employee employee = employees[0];
        double minSalary = Double.POSITIVE_INFINITY;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                employee = employees[i];
            }
        }
        return employee;
    }

    public static Employee findSalaryMax() {
        Employee employee = employees[0];
        double maxSalary = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                employee = employees[i];
            }
        }
        return employee;
    }

    public static double findAverageValueSalary() {
        int countСurrentEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                countСurrentEmployees++;
            }
        }
        return calculateSumSalary() / countСurrentEmployees;
    }

    public static void findFullNameCurrentEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("\n " + employees[i].getFullName() + ";");
            }
        }

    }
}