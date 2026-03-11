import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        void display() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        }
    }

    static class Library {

        ArrayList<Book> books = new ArrayList<>();

        void addBook(String title, String author) {
            books.add(new Book(title, author));
            System.out.println("Book added successfully.");
        }

        void displayBooks() {

            if (books.isEmpty()) {
                System.out.println("No books available.");
                return;
            }

            for (Book b : books) {
                System.out.println("------------------");
                b.display();
            }
        }

        void borrowBook(String title) {

            for (Book b : books) {

                if (b.title.equalsIgnoreCase(title)) {

                    if (b.isAvailable) {
                        b.isAvailable = false;
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book already borrowed.");
                    }
                    return;
                }
            }

            System.out.println("Book not found.");
        }

        void returnBook(String title) {

            for (Book b : books) {

                if (b.title.equalsIgnoreCase(title)) {

                    if (!b.isAvailable) {
                        b.isAvailable = true;
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book was not borrowed.");
                    }
                    return;
                }
            }

            System.out.println("Book not found.");
        }

        void searchBook(String title) {

            for (Book b : books) {

                if (b.title.equalsIgnoreCase(title)) {
                    b.display();
                    return;
                }
            }

            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.addBook("Clean Code", "Robert C. Martin");
        library.addBook("Effective Java", "Joshua Bloch");
        library.addBook("Head First Java", "Kathy Sierra");
        library.addBook("Java: The Complete Reference", "Herbert Schildt");
        library.addBook("Introduction to Algorithms", "Thomas H. Cormen");
        library.addBook("Design Patterns", "Erich Gamma");
        library.addBook("The Pragmatic Programmer", "Andrew Hunt");
        library.addBook("Code Complete", "Steve McConnell");
        library.addBook("Python Crash Course", "Eric Matthes");
        library.addBook("Structure and Interpretation of Computer Programs", "Harold Abelson");

        int choice;

        do {

            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Borrow Book");
            System.out.println("4 Return Book");
            System.out.println("5 Search Book");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    library.addBook(title, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter book title to borrow: ");
                    title = sc.nextLine();
                    library.borrowBook(title);
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    title = sc.nextLine();
                    library.returnBook(title);
                    break;

                case 5:
                    System.out.print("Enter book title to search: ");
                    title = sc.nextLine();
                    library.searchBook(title);
                    break;

                case 6:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}