package hu.petrik.filmdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDb {
    Connection conn;

    public MovieDb() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmdb", "root", "");
    }

    public List<Movie> getMovies() throws SQLException {
        List<Movie> movieList = new ArrayList<>();

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM filmek");
        while (result.next()) {
            int id = result.getInt("id");
            String title = result.getString("title");
            String category = result.getString("category");
            int length = result.getInt("length");
            int rating = result.getInt("rating");
            Movie m = new Movie(id, title, category, length, rating);
            movieList.add(m);
        }

        return movieList;
    }
}
