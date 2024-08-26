import java.util.*;

class Employee {

    String name;

    int id;

    String firstDayOfWork;

    String phoneNumber;

    String address;

    int workHours;

    double salary;

    Employee next;



    public Employee(String name, int id, String firstDayOfWork, String phoneNumber, String address, int workHours, double salary) {

        this.name = name;

        this.id = id;

        this.firstDayOfWork = firstDayOfWork;

        this.phoneNumber = phoneNumber;

        this.address = address;

        this.workHours = workHours;

        this.salary = salary;

        this.next = null;

    }


}



class EmployeeRecordManagementSystem {

    private Employee head;


    public EmployeeRecordManagementSystem() {

        head = null;

    }


    public void insert(String name, int id, String firstDayOfWork, String phoneNumber, String address, int workHours, double salary) {

        Employee newEmployee = new Employee(name, id, firstDayOfWork, phoneNumber, address, workHours, salary);

        newEmployee.next = head;

        head = newEmployee;

    }


    public void delete(int id) {
        Employee current = head;
        Employee prev = null;


        while (current != null && current.id != id) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println(id + " not found in the list");
            return;
        }

        if (prev == null) { // The node to delete is the head
            head = current.next;
        } else { // The node to delete is not the head
            prev.next = current.next;
        }

        System.out.println(id + " deleted from the list");
    }

    public void update(int id, String name, String firstDayOfWork, String phoneNumber, String address, int workHours, double salary) {

        Employee current = head;



        while (current != null && current.id != id) {

            current = current.next;

        }



        if (current == null) {

            System.out.println(id + " not found in the list");

            return;

        }



        current.name = name;

        current.firstDayOfWork = firstDayOfWork;

        current.phoneNumber = phoneNumber;

        current.address = address;

        current.workHours = workHours;

        current.salary = salary;

        System.out.println(id + " updated in the list");

    }


    public void updateSalary(int id, double salary) {

        Employee current = head;


        while (current != null && current.id != id) {

            current = current.next;

        }


        if (current == null) {

            System.out.println(id + " not found in the list");

            return;

        }

        current.salary = salary;

        System.out.println(id + " updated in the list");

    }


    public void showDetails(int id) {

        Employee current = head;


        while (current != null && current.id != id) {

            current = current.next;

        }


        if (current == null) {

            System.out.println(id + " not found in the list");

            return;

        }


        System.out.println("id: " + id
                + "\nname: " + current.name
                + "\nFist day of week: " + current.firstDayOfWork
                + "\nphone Number: " + current.phoneNumber
                + "\nThe address: " + current.address
                + "\nwork hours: " + current.workHours
                + "\nthe Salary: " + current.salary);

    }

    public boolean isIdExist(int id) {
        Employee current = head;
        while (current != null) {
            if (current.id == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayAllEmployees() {
        if (head == null) {
            System.out.println("No employees in the system.");
            return;
        }

        Employee current = head;
        System.out.println("List of all employees:");
        while (current != null) {
            System.out.println("ID: " + current.id + ", Name: " + current.name + ", First Day of Work: " + current.firstDayOfWork +
                    ", Phone Number: " + current.phoneNumber + ", Address: " + current.address +
                    ", Work Hours: " + current.workHours + ", Salary: $" + current.salary);
            current = current.next;
        }
    }


}