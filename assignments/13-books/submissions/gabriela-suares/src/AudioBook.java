public class AudioBook extends Book {
private double sizeMB;
private int lengthMin;
private String voice;

    public AudioBook(String t, int y, String a, double s, int l, String v) {
super(t, y, a);
sizeMB = s;
lengthMin = l;
voice = v;
    }

    public String toString() {
return super.toString() +
"Tamanho do Arquivo: " + sizeMB + " MB\n" +
"Duração: " + lengthMin + " minutos\n" +
"Narrador: " + voice + "\n\n";
    }
}
