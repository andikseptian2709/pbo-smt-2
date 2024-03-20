import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        // Dummy data
        bookList.add(new Book("123456", "Book 1", "Author 1", 5));
        bookList.add(new Book("789012", "Book 2", "Author 2", 3));
        userStudent.add(new Student("Andik", "Teknik", "Informatika", "1234567891"));

        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Library System");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Admin admin = new Admin();
                admin.menuAdmin();
                break;
            case 2:
                Student student = new Student();
                student.menuStudent();
                break;
            case 3:
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                menu();
                break;
        }
        scanner.close();
    }

    static class Book {
        String id;
        String title;
        String author;
        int stock;

        Book(String id, String title, String author, int stock) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.stock = stock;
        }
    }

    static class Student {
        String name;
        String faculty;
        String programStudy;
        String nim;

        Student() {}

        Student(String name, String faculty, String programStudy, String nim) {
            this.name = name;
            this.faculty = faculty;
            this.programStudy = programStudy;
            this.nim = nim;
        }

        void displayBooks() {
            System.out.println("Book List:");
            for (Book book : bookList) {
                System.out.println("Title: " + book.title + ", Author: " + book.author + ", Stock: " + book.stock);
            }
        }

        void logout() {
            System.out.println("Logging out...");
            menu();
        }

        void menuStudent() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome, " + name);
            System.out.println("1. Display Books");
            System.out.println("2. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    menuStudent();
                    break;
            }
            scanner.close();
        }
    }

    static class Admin {
        String adminUsername = "admin";
        String adminPassword = "password";

        void addStudent() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student nim (15 digits):");
            String nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("Invalid nim, must be 15 digits.");
                return;
            }
            System.out.println("Enter student faculty:");
            String faculty = scanner.nextLine();
            System.out.println("Enter student program study:");
            String programStudy = scanner.nextLine();

            Student student = new Student(name, faculty, programStudy, nim);
            userStudent.add(student);
            System.out.println("Student added successfully.");
        }

        void displayStudents() {
            System.out.println("Student List:");
            for (Student student : userStudent) {
                System.out.println("Name: " + student.name + ", Faculty: " + student.faculty + ", Program Study: " + student.programStudy + ", NIM: " + student.nim);
            }
        }

        void menuAdmin() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter admin username:");
            String username = scanner.nextLine();
            System.out.println("Enter admin password:");
            String password = scanner.nextLine();

            if (!username.equals(adminUsername) || !password.equals(adminPassword)) {
                System.out.println("Invalid credentials, please try again.");
                menuAdmin();
                return;
            }

            System.out.println("Welcome, Admin");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    menu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    menuAdmin();
                    break;
            }
            scanner.close();
        }
    }
}