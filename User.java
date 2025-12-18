package M3_GroupProjectList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class User {

    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name == null ? "" : name.trim();
    }

    public int getId() { 
    	return id; 
    	}
    public String getName() { 
    	return name; 
    	}

    @Override
    public String toString() {
        return name + " (\nID: " + id + ")";
    }

    public static void main(String[] args) {
        App.run();
    }

    /* ===================== Book Class ===================== */
    static class Book {
        private final int id;
        private String title;
        private String author;
        private boolean borrowed;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title == null ? "" : title.trim();
            this.author = author == null ? "" : author.trim();
            this.borrowed = false;
        }

        public int getId() { 
        	return id;
        	}
        public String getTitle() {
        	return title;
        	}
        public String getAuthor() {
        	return author;
        	}
        public boolean isBorrowed() {
        	return borrowed;
        	}

        public void setTitle(String title) {
        	this.title = title.trim();
        	}
        public void setAuthor(String author) {
        	this.author = author.trim();
        	}
        public void setBorrowed(boolean borrowed) {
        	this.borrowed = borrowed;
        	}

        public String toString() {
            return "\nID: " + id + "\nTitle: " + title +
                   "\nAuthor: " + author + (borrowed ? " (Borrowed)" : "");
        }
    }

    /* ===================== Loan Class ===================== */
    static class Loan {
        private final int loanId;
        private final int bookId;
    //    private final int userId;
        private final String userName;

        public Loan(int loanId, int bookId, int userId, String userName) {
            this.loanId = loanId;
            this.bookId = bookId;
    //        this.userId = userId;
            this.userName = userName;
        }

        public int getBookId() { 
        	return bookId; 
        	}
        public String getUserName() { 
        	return userName; 
        	}

        public String toString() {
            return "Loan #" + loanId +
                   " | Book ID: " + bookId +
                   " | Borrower: " + userName;
        }
    }

    /* ===================== Library Class ===================== */
    static class Library {
        private final List<Book> books = new ArrayList<>();
        private final List<Loan> loans = new ArrayList<>();
        private int nextLoanId = 1;

        public List<Book> getAllBooks() { 
        	return new ArrayList<>(books); 
        	}

        public List<Book> getAvailableBooks() {
            List<Book> a = new ArrayList<>();
            for (Book b : books) if (!b.isBorrowed()) a.add(b);
            return a;
        }

        public List<Book> getBorrowedBooks() {
            List<Book> a = new ArrayList<>();
            for (Book b : books) if (b.isBorrowed()) a.add(b);
            return a;
        }

        public Optional<Book> findBookById(int id) {
            for (Book b : books) if (b.getId() == id) return Optional.of(b);
            return Optional.empty();
        }

        public boolean addBook(Book b) {
            for (Book x : books) if (x.getId() == b.getId()) return false;
            books.add(b);
            return true;
        }

        public boolean removeBook(int id) {
            Optional<Book> b = findBookById(id);
            if (!b.isPresent()) return false;

            loans.removeIf(l -> l.getBookId() == id);
            books.remove(b.get());
            return true;
        }

        public boolean updateBook(int id, String nt, String na) {
            Optional<Book> b = findBookById(id);
            if (!b.isPresent()) return false;
            if (b.get().isBorrowed()) return false;

            if (!nt.trim().isEmpty()) b.get().setTitle(nt);
            if (!na.trim().isEmpty()) b.get().setAuthor(na);
            return true;
        }

        public Optional<Loan> findLoanByBookId(int id) {
            for (Loan l : loans) if (l.getBookId() == id) return Optional.of(l);
            return Optional.empty();
        }

        public boolean borrowBook(int id, User u) {
            Optional<Book> b = findBookById(id);
            if (!b.isPresent() || b.get().isBorrowed()) return false;

            b.get().setBorrowed(true);
            loans.add(new Loan(nextLoanId++, id, u.getId(), u.getName()));
            return true;
        }

        public boolean returnBook(int id) {
            Optional<Book> b = findBookById(id);
            if (!b.isPresent() || !b.get().isBorrowed()) return false;

            loans.removeIf(l -> l.getBookId() == id);
            b.get().setBorrowed(false);
            return true;
        }

/*        public void seed() {
            addBook(new Book(1, "Title Book 1", "Author 1"));
            addBook(new Book(2, "Title Book 2", "Author 2"));
            addBook(new Book(3, "Title Book 3", "Author 3"));
            addBook(new Book(4, "Title Book 4", "Author 4"));
            addBook(new Book(5, "Title Book 5", "Author 5"));
        } */
    }

    /* ===================== Application Logic ===================== */
    static class App {
        private static final Scanner SC = new Scanner(System.in);

        public static void run() {

            System.out.println("================================");
            System.out.println("        Library System");
            System.out.println("================================\n");

            // Automatically create default user
            User currentUser = new User(1, "Default User");

            Library lib = new Library();
  //          lib.seed();

            boolean running = true;
            while (running) {
                printMenu();
                int c = readMenu("\nChoice: ", 0, 8);

                switch (c) {
                    case 1: showAll(lib); break;
                    case 2: showAvail(lib); break;
                    case 3: showBorrowed(lib); break;
                    case 4: borrow(lib, currentUser); break;
                    case 5: returnBook(lib); break;
                    case 6: add(lib); break;
                    case 7: remove(lib); break;
                    case 8: update(lib); break;
                    case 0: running = false; break;
                }
                System.out.println();
            }

            System.out.println("\nExiting... Goodbye!");
        }

        /* ===== Menu ===== */

        private static void printMenu() {
            System.out.println("=== Library Menu ===");
            System.out.println("[1] Display All Books");
            System.out.println("[2] Display Available Books");
            System.out.println("[3] Display All Borrowed Books");
            System.out.println("[4] Borrow Book");
            System.out.println("[5] Return Book");
            System.out.println("[6] Add Book");
            System.out.println("[7] Remove Book");
            System.out.println("[8] Update Book");
            System.out.println("[0] Exit");
        }

        /* ===== Actions ===== */

        private static void showAll(Library lib) {
            for (Book b : lib.getAllBooks()) {
                System.out.println(b);
                System.out.println();
            }
        }

        private static void showAvail(Library lib) {
            for (Book b : lib.getAvailableBooks()) {
                System.out.println("\nID: " + b.getId());
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
                System.out.println();
            }
        }

        private static void showBorrowed(Library lib) {
            for (Book b : lib.getBorrowedBooks()) {
               // String borrower = lib.findLoanByBookId(b.getId())
               //         .map(Loan::getUserName)
               //         .orElse("Unknown");

                System.out.println("\nID: " + b.getId());
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
             //   System.out.println("Borrower: " + borrower);
                System.out.println();
            }
        }

        private static void borrow(Library lib, User u) {
            int id = readInt("\nEnter Book ID to borrow: ");
            System.out.println(lib.borrowBook(id, u)
                ? "\nBook borrowed successfully!"
                : "\nCannot borrow book.");
        }

        private static void returnBook(Library lib) {
            int id = readInt("Enter Book ID to return: ");
            System.out.println(lib.returnBook(id)
                ? "\nBook returned successfully!"
                : "\nCannot return book.");
        }

        private static void add(Library lib) {
            int id = readInt("\nEnter Book ID: ");
            String t = readNonEmpty("Enter Book Title: ");
            String a = readNonEmpty("Enter Book Author: ");

            System.out.println(lib.addBook(new Book(id, t, a))
                ? "\nBook added successfully!"
                : "\nBook ID already exists!");
        }

        private static void remove(Library lib) {
            int id = readInt("\nEnter Book ID to remove: ");
            System.out.println(lib.removeBook(id)
                ? "\nBook removed successfully!"
                : "\nBook not found.");
        }

        private static void update(Library lib) {
            int id = readInt("\nEnter Book ID to update: ");
            Optional<Book> b = lib.findBookById(id);
            if (!b.isPresent()) {
                System.out.println("\nBook not found.");
                return;
            }
            if (b.get().isBorrowed()) {
                System.out.println("\nBook is borrowed and cannot be updated.");
                return;
            }

            String nt = readLine("New Title: ");
            String na = readLine("New Author: ");

            System.out.println(lib.updateBook(id, nt, na)
                ? "\nBook updated successfully!"
                : "\nUpdate failed.");
        }

        /* ===== Input Helpers ===== */

        private static int readInt(String p) {
            while (true) {
                System.out.print(p);
                String s = SC.nextLine().trim();
                if (s.matches("\\d+")) return Integer.parseInt(s);
                System.out.println("\nEnter a valid positive number.");
            }
        }

        private static int readMenu(String p, int min, int max) {
            while (true) {
                System.out.print(p);
                String s = SC.nextLine().trim();
                if (s.matches("\\d+")) {
                    int v = Integer.parseInt(s);
                    if (v >= min && v <= max) return v;
                }
                System.out.println("\nInvalid choice.");
            }
        }

        private static String readNonEmpty(String p) {
            String s = "";
            while (s.trim().isEmpty()) {
                               System.out.print(p);
                s = SC.nextLine();
                if (s.trim().isEmpty()) System.out.println("\nInput cannot be empty.");
            }
            return s.trim();
        }

        private static String readLine(String p) {
            System.out.print(p);
            return SC.nextLine();
        }
    }
}
