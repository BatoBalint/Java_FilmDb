package hu.petrik.filmdb;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainController {
    @FXML
    private TableColumn<Movie, String> titleCol;
    @FXML
    private TableColumn<Movie, Integer> lengthCol;
    @FXML
    private TableColumn<Movie, String> categoryCol;
    @FXML
    private TableColumn<Movie, Integer> ratingCol;
    @FXML
    private TableView<Movie> movieTable;

    public void initialize() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));

        try {
            MovieDb db = new MovieDb();
            List<Movie> movies = db.getMovies();
            for (Movie m : movies) {
                movieTable.getItems().add(m);
            }
        } catch (Exception e) {
            errorOccured(e);
        }
    }

    @FXML
    private void addClick() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("add-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Felvetel");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            errorOccured(e);
        }
    }

    @FXML
    public void editClick() {

    }

    @FXML
    public void deleteClick() {

    }

    private void errorOccured(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(e.getClass().toString());
        alert.setContentText(e.getMessage());
        alert.setHeight(300);
        Timer alertTimer = new Timer();
        alertTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {alert.show(); });
            }
        }, 300);
    }
}