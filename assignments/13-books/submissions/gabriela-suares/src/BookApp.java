class Book {
    protected String title;
    protected int year;
    protected String author;

    public Book(String title, int year, String author) {
this.title = title;
this.year = year;
this.author = author;
    }

    @Override
public String toString() {
return "Título: " + title + ", Autor: " + author + ", Ano: " + year;
    }
}
class PrintBook extends Book {
    private String publisher;
    private String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
super(title, year, author);
this.publisher = publisher;
this.isbn = isbn;
    }

    @Override
public String toString() {
return super.toString() + ", Editora: " + publisher + ", ISBN: " + isbn;
    }
}

    class AudioBook extends Book {
private double fileSizeInMB;
private int playLengthInMinutes;
private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
super(title, year, author);
this.fileSizeInMB = fileSizeInMB;
this.playLengthInMinutes = playLengthInMinutes;
this.narrator = narrator;
    }

    @Override
public String toString() {
return super.toString() + ", Tamanho do Arquivo: " + fileSizeInMB + "MB, Duração: " + playLengthInMinutes + " minutos, Narrador: " + narrator;
    }
}


public class BookApp {
    public static void main(String[] args) {
Book genericBook = new Book("Programação Java", 2020, "Ana Silva");
PrintBook printedBook = new PrintBook("Java Impresso", 2021, "Carlos Souza", "Editora ABC", "978-3-16-148410-0");
AudioBook audioBook = new AudioBook("Java em Áudio", 2022, "Fernanda Lima", 150.5, 320, "João Pedro");

System.out.println(genericBook.toString());
System.out.println(printedBook.toString());
System.out.println(audioBook.toString());
    }
}
