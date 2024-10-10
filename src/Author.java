import java.util.ArrayList;
import java.util.HashMap;

class Author {
    String name;
    int age;
    String favouriteGenre;

    public Author(String name, int age, String favouriteGenre) {
        this.name = name;
        this.age = age;
        this.favouriteGenre = favouriteGenre;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + favouriteGenre + ")";
    }
}

class Book {
    String title;
    String genre;
    int numberOfPages;

    public Book(String title, String genre, int numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ", " + numberOfPages + " pages)";
    }
}

class Library {
    private HashMap<Author, ArrayList<Book>> library;

    public Library() {
        this.library = new HashMap<>();
    }

    public void addAuthor(Author author) {
        library.putIfAbsent(author, new ArrayList<>());
    }

    public void addBookToAuthor(String authorName, Book book) {
        for (Author author : library.keySet()) {
            if (author.name.equals(authorName)) {
                library.get(author).add(book);
                return;
            }
        }
        System.out.println("Author not found");
    }

    public ArrayList<Book> getBooksOfAuthor(String authorName) {
        for (Author author : library.keySet()) {
            if (author.name.equals(authorName)) {
                return library.get(author);
            }
        }
        return new ArrayList<>();
    }

    public ArrayList<Author> getAllAuthors() {
        return new ArrayList<>(library.keySet());
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (ArrayList<Book> bookList : library.values()) {
            books.addAll(bookList);
        }
        return books;
    }

    public void getAllBooksAndAuthors() {
        for (Author author : library.keySet()) {
            System.out.println(author + " wrote:");
            for (Book book : library.get(author)) {
                System.out.println("  - " + book);
            }
        }
    }
}

