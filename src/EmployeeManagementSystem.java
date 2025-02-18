public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new ContractEmployee("Aktan", 1, 150.5, 300);
        employees[1] = new FullTimeEmployee("Azamat", 2, 40000);
        for (Employee e: employees) {
            e.displayEmployeeInfo();
        }
    }
}

abstract class Employee {
    String name;
    int id;
    double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();
    void displayEmployeeInfo() {
        System.out.printf("""
                Name:%s
                Salary:%.2f som
                """, name, calculateSalary());
    }

}

interface Payable {
    double getPaymentAmount();

}

class FullTimeEmployee extends Employee implements  Payable {
    FullTimeEmployee(String name, int id, double baseSalary) {
        super(name, id, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary * 1.2 + getPaymentAmount();
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }
}

class ContractEmployee extends Employee implements  Payable {
    private double hours;
    private double paymentForHour;

    ContractEmployee(String name, int id, double hours, double paymentForHour) {
        super(name, id, 0);
        this.hours = hours;
        this.paymentForHour = paymentForHour;
    }

    @Override
    double calculateSalary() {
        return baseSalary + getPaymentAmount();
    }

    @Override
    public double getPaymentAmount() {
        return hours * paymentForHour;
    }
}
