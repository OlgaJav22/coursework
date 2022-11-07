import org.w3c.dom.ls.LSOutput;

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
        employees[7] = new Employee("Графский Геннадий Ильич", 5, 73280.00);
        printListEmployees();
        System.out.println("\n Сумма зарплат всех работников за текущий месяц составила: " + calculateSumSalary());

        System.out.println("\n Сотрудник с минимальной заработной платой: " + findSalaryMin());

        System.out.println("\n Сотрудник с максимальной заработной платой: " + findSalaryMax());

        System.out.println("\n Среднее значение зарплат действующих сотрудников: " + (int)findAverageValueSalary());

        findFullNameCurrentEmployees();
        System.out.println();
        raisSalaryEmployees();
        int number = 5;
        System.out.println("\n Сотрудник с минимальной зарплатой в отделе № " + number + "\t" + findSalaryMin1(number));
        System.out.println("\n Сотрудник с максимальной зарплатой в отделе № " + number + "\t" + findSalaryMax1(number));
        System.out.println("\n Общая сумма зарплат сотрудников отдела № " + number + "\t" + "составила: " + calculateSumSalaryDepart(number));
        System.out.println("\n Средняя зарплата по отделу № " + number + " составила: " + findAverageValueSalary1(number));
        raisSalaryEmployees1(number);
        printListEmployees1(number);
        System.out.println("\n Сотрудники с зарплатой меньше 35000 рублей: ");
        printListEmployeesSalaryMinSpecified(35000);

        System.out.println("\n Сотрудники с зарплатой большей или равной  35000 рублей: ");
        printListEmployeesSalaryMaxSpecified(35000);
    }
// базовый уровень
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
    // повышенная сложность
    public static void raisSalaryEmployees() {
        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                total = employees[i].getSalary() + (employees[i].getSalary() * 0.01);
                System.out.println(employees[i].getFullName() + " - " + total);
            }
        }

    }

    public static Employee [] findEmployeeDepart(int number) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null && employees[i].getDepartament()==number) {
                counter++;
            }
        }
        Employee[] result = new Employee[counter];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null && employees[i].getDepartament()==number) {
                result[index] = employees[i];
                index++;
            }
        }
        return result;
    }

    public static Employee findSalaryMin1(int depart) {
        Employee employeeDepart = null;
        Employee [] empl = findEmployeeDepart(depart);
        double minSalary = Double.POSITIVE_INFINITY;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() < minSalary) {
                minSalary = empl[i].getSalary();
                employeeDepart = empl[i];


            }
        }
        return employeeDepart;
    }

    public static Employee findSalaryMax1(int depart) {
        Employee employeeDepart = null;
        Employee [] empl = findEmployeeDepart(depart);
        double maxSalary = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() > maxSalary) {
                maxSalary = empl[i].getSalary();
                employeeDepart = empl[i];
            }
        }
        return employeeDepart;
    }
    public static double calculateSumSalaryDepart(int number) {

        double  sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartament()==number) {
                sum = sum + employees[i].getSalary();

            }
        }
        return sum;
    }
    public static double findAverageValueSalary1(int number) {
        int countСurrentEmployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartament()==number) {
                countСurrentEmployees++;
            }
        }
        return  calculateSumSalaryDepart(number)/ countСurrentEmployees;
    }

    public static void raisSalaryEmployees1(int number) {
        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartament()==number ) {
                total = employees[i].getSalary() + (employees[i].getSalary() * 0.01);
                System.out.println("\n" + employees[i].getFullName() + " - " + total);
            }
        }
    }

    public static void printListEmployees1(int number) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartament()==number) {
                System.out.println(employees[i].getId() + ".\t" + employees[i].getFullName() + "; " + " Заработная плата: " + (int)employees[i].getSalary() + " рублей.");
            }
        }
    }

    public static void printListEmployeesSalaryMinSpecified(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary()<salary) {
                System.out.println(employees[i].getId() + ".\t" + employees[i].getFullName() + "; " + " Заработная плата: " + (int)employees[i].getSalary() + " рублей.");
            }
        }
    }
    public static void printListEmployeesSalaryMaxSpecified(double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary()>=salary) {
                System.out.println(employees[i].getId() + ".\t" + employees[i].getFullName() + "; " + " Заработная плата: " + (int)employees[i].getSalary() + " рублей.");
            }
        }
    }
}




