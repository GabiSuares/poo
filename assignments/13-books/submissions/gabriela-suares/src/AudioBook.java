public class AudioBook extends Book {
    private final double fileSizeInMB;
    private final int playLengthInMinutes;
    private final String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTamanho do arquivo: " + fileSizeInMB + " MB" +
               "\nDuração: " + playLengthInMinutes + " minutos" +
               "\nNarrador: " + narrator;
    }
}
