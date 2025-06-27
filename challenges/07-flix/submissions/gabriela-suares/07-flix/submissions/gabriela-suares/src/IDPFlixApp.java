import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IDPFlixApp {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String user = "postgres";
        String password = "postgres";
        String filePath = "./data/new_films.txt";
        List<Film> films = FilmFileReader.readFilms(filePath);
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
            for (Film film : films) {
            insertStmt.setString(1, film.getTitle());
            insertStmt.setInt(2, film.getLanguageId());
            insertStmt.setInt(3, film.getRentalDuration());
            insertStmt.setDouble(4, film.getRentalRate());
            insertStmt.setDouble(5, film.getReplacementCost());
            insertStmt.executeUpdate();
    }
}
    String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
    updateStmt.executeUpdate();
}
    String selectSql = "SELECT title, rental_rate FROM film WHERE rent_duration = 99";
    try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
    ResultSet rs = selectStmt.executeQuery()) {
    while (rs.next()) {
    String title = rs.getString("title");
    double rentalRate = rs.getDouble("rental_rate");
    System.out.println(title + " - " + rentalRate);
}
}
    } catch (Exception e) {
        e.printStackTrace();
}
}
}