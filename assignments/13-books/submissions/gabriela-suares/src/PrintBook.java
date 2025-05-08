public class PrintBook extends Book {
    private String publisher;
    private String isbn;

    public PrintBook(String t, int y, String a, String p, String i) {
super(t, y, a);
publisher = p;
isbn = i;
}

    public String toString() {
    return super.toString() +
"Editora: " + publisher + "\n" +
"ISBN: " + isbn + "\n\n";
    }
}
