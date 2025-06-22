import java.util.Scanner;

public class EmployeeManager {
    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    public static void addEmployee(Employee emp) {
        if (count < MAX) {
            employees[count++] = emp;
            System.out.println("Employee added: " + emp);
        } else {
            System.out.println("Cannot add more employees.");
        }
    }

    public static void traverseEmployees() {
        System.out.println("All Employees:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Alice", "Manager", 80000));
        addEmployee(new Employee(2, "Bob", "Developer", 60000));
        addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        traverseEmployees();

        searchEmployee(2);
        deleteEmployee(2);
        traverseEmployees();
    }
}
