//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        book1.printBookDetails();
        System.out.println();
//        System.out.println(book1.getBookInfo());

        Book printedBook = new PrintedBook("1984", "George Orwell", 1949, "Secker & Warburg", 328);
//        printedBook.bookType();
        printedBook.printBookDetails();
//        System.out.println(printedBook.getBookInfo());

        System.out.println();
        Book ebook = new EBook("Introduction to CS", "Miss Munara", 2011, 5.6, "PDF");
//        ebook.bookType();
        ebook.printBookDetails();
//        System.out.println(ebook.getBookInfo());
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookInfo() {
        return "Title: " + title + " by " + author + ", published in " + yearPublished;
    }

    public void printBookDetails() {
        System.out.printf("""
                Title: %s
                Author: %s
                Year of publication: %d
                """, title, author, yearPublished);
    }
    public void printBook() {
        System.out.println("Printing the book...");
    }

}

class PrintedBook extends Book {
    private int numberOfPages;
    private String publisher;
    private double price;

    public PrintedBook(String title, String author, int yearPublished, String publisher, int numberOfPages) {
        super(title, author, yearPublished);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.price = numberOfPages * 2 + 100;
    }
    public PrintedBook(String title, String author, int yearPublished, int numberOfPages) {
        super(title, author, yearPublished);
        this.numberOfPages = numberOfPages;
        this.price = numberOfPages * 2 + 100;
    }

    public void bookType() {
        System.out.println("This is a printed book");
    }


    @Override
    public String getBookInfo() {
        return super.getBookInfo() + ", publisher: " + publisher + ", number of pages: " + numberOfPages ;
    }

    @Override
    public void printBookDetails() {
        System.out.println("Printed Book Info:");
        super.printBookDetails();
        System.out.printf("""
                Publisher: %s
                Number of pages: %d
                Book type: PrintedBook
                Price: $%.2f
                """, publisher, numberOfPages, price);
    }
}

class EBook extends Book {
    private double fileSizeMB;
    private String fileFormat;
    private double price;

    public EBook(String title, String author, int yearPublished, double fileSizeMB, String fileFormat) {
        super(title, author, yearPublished);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
        this.price = fileSizeMB * 100 ;
        if (fileFormat.equals("PDF")) {
            // discount 10% if pdf
            this.price = 0.9 * this.price;
        }
    }
    public EBook(String title, String author, int yearPublished, String fileFormat) {
        super(title, author, yearPublished);
        this.fileFormat = fileFormat;
        if (fileFormat.equals("PDF")) {
            // free if pdf
            this.price = 0;
        }
    }

    public void bookType() {
        System.out.println("This is an e-book");
    }


    @Override
    public String getBookInfo() {
        return super.getBookInfo() + ", file size in MB: " + fileSizeMB + ", file format: " + fileFormat ;
    }

    @Override
    public void printBookDetails() {
        System.out.println("EBook Info:");
        super.printBookDetails();
        System.out.printf("""
                File size in MB: %.1f
                File format: %s
                Book type: EBook
                Price: $%.2f
                """, fileSizeMB, fileFormat, price);
    }
}


