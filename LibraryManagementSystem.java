import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class represents a book entity
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// User class represents a library user
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}

// Library class manages books and users
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean checkAvailability(Book book) {
        return book.isAvailable();
    }

    public void borrowBook(User user, Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(user.getName() + " borrowed '" + book.getTitle() + "'.");
        } else {
            System.out.println("Sorry, '" + book.getTitle() + "' is not available.");
        }
    }

    public void returnBook(User user, Book book) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println(user.getName() + " returned '" + book.getTitle() + "'.");
        } else {
            System.out.println("Error: This book is already available in the library.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Library instance
        Library library = new Library();

        // Adding books to the library
        System.out.println("Enter book details:");

        Book book1 = createBookFromUserInput(scanner);
        library.addBook(book1);

        Book book2 = createBookFromUserInput(scanner);
        library.addBook(book2);

        Book book3 = createBookFromUserInput(scanner);
        library.addBook(book3);

        Book book4 = createBookFromUserInput(scanner);
        library.addBook(book4);

        // Adding users to the library
        System.out.println("Enter user details:");

        User user1 = createUserFromUserInput(scanner);
        library.addUser(user1);

        User user2 = createUserFromUserInput(scanner);
        library.addUser(user2);

        User user3 = createUserFromUserInput(scanner);
        library.addUser(user3);

        User user4 = createUserFromUserInput(scanner);
        library.addUser(user4);

        // Borrowing and returning books
        library.borrowBook(user1, book1);
        library.borrowBook(user2, book2);

        library.borrowBook(user1, book1);
        library.borrowBook(user3, book3);
        library.borrowBook(user4, book4);

        library.returnBook(user1, book1);
        library.returnBook(user2, book2);
        library.returnBook(user4, book4);
        library.returnBook(user1, book1);

        // Checking availability and borrowing books
        if (library.checkAvailability(book3)) {
            library.borrowBook(user3, book3);
        } else {
            System.out.println("Sorry, 'The Martian' is not available for borrowing.");
        }

        if (library.checkAvailability(book4)) {
            library.borrowBook(user4, book4);
        } else {
            System.out.println("Sorry, 'The Great Gatsby' is not available for borrowing.");
        }

        // Close the scanner
        scanner.close();
    }

    // Helper method to create a Book from user input
    private static Book createBookFromUserInput(Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        return new Book(bookId, title, author);
    }

    // Helper method to create a User from user input
    private static User createUserFromUserInput(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        return new User(userId, name);
    }
}
