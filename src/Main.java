import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getInfo() {
        return title + " by " + author + " (" + (isAvailable ? "Есть в продаже" : "Не в продаже") + ")";
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Добавляем книги
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("Абай жолы", "Мухтар Ауэзов");
        Book book4 = new Book("Махаббат қызық мол жылдар", "Бердыбек Сокпакбаев");

        boolean continueSystem = true;

        while (continueSystem) {
            // Список доступных книг
            System.out.println("Available Books:");
            System.out.println("1. " + book1.getInfo());
            System.out.println("2. " + book2.getInfo());
            System.out.println("3. " + book3.getInfo());
            System.out.println("4. " + book4.getInfo());

            // Пользователь выбирает книгу
            System.out.print("Select a book to borrow (1, 2, 3, or 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            // Выбор книги
            Book selectedBook = null;
            if (choice == 1) {
                selectedBook = book1;
            } else if (choice == 2) {
                selectedBook = book2;
            } else if (choice == 3) {
                selectedBook = book3;
            } else if (choice == 4) {
                selectedBook = book4;
            } else {
                System.out.println("Invalid choice. Please restart the program.");
                return;
            }

            // Пользователь берёт книгу
            selectedBook.borrowBook();

            // Сохранение данных о пользователе
            System.out.print("\nEnter your name to save the record: ");
            String userName = scanner.nextLine();

            System.out.println("\nSaved Record:");
            System.out.println("User: " + userName + " borrowed \"" + selectedBook.title + "\" by " + selectedBook.author);

            // Предложение выбрать ещё книгу
            System.out.print("\nЕщё книга нужна? (да/нет): ");
            String continueChoice = scanner.nextLine();

            if (!"да".equalsIgnoreCase(continueChoice)) {
                continueSystem = false;
                System.out.println("Спасибо за использование нашей системы!");
            }
        }

        scanner.close();
    }
}