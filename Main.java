import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeRecordManagementSystem system = new EmployeeRecordManagementSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println("Employee Record Management System:");
            System.out.println("1. Insert Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Show Employee Details");
            System.out.println("6. Display All Employees");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (system.isIdExist(id)) {
                        System.out.println("Error: Employee ID already exists. Try again with a different ID.");
                        break;
                    }

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter first day of work (YYYY-MM-DD): ");
                    String firstDayOfWork = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter work hours: ");
                    int workHours = scanner.nextInt();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    system.insert(name, id, firstDayOfWork, phoneNumber, address, workHours, salary);
                    System.out.println("Employee inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter employee ID to delete: ");
                    system.delete(scanner.nextInt());
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter ID of the employee you want to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (!system.isIdExist(id)) {
                        System.out.println("Error: Employee ID does not exist. Try again with a different ID.");
                        break;
                    }

                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new first day of work (YYYY-MM-DD): ");
                    firstDayOfWork = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter new work hours: ");
                    workHours = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    salary = scanner.nextDouble();

                    system.update(id, name, firstDayOfWork, phoneNumber, address, workHours, salary);
                    System.out.println("Employee updated successfully!");
                    break;


                case 4:
                    scanner.nextLine();
                    System.out.print("Enter ID of the employee whose salary you want to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (!system.isIdExist(id)) {
                        System.out.println("Error: Employee ID does not exist. Try again with a different ID.");
                        break;
                    }

                    System.out.print("Enter new salary: ");
                    salary = scanner.nextDouble();

                    system.updateSalary(id, salary);
                    System.out.println("Salary updated successfully!");
                    break;


                case 5:
                    System.out.print("Enter employee ID to show details: ");
                    system.showDetails(scanner.nextInt());
                    break;

                case 6:
                    system.displayAllEmployees();
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
