public class Book {
private String title;
private int year;
private String author;

    public Book(String t, int y, String a) {
    title = t;
    year = y;
    author = a;
}

    public String toString() {
return "Título: " + title + "\n" +
"Ano: " + year + "\n" +
"Autor: " + author + "\n";
    }
}
