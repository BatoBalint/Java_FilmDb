package hu.petrik.filmdb;

import javafx.scene.control.*;
import javafx.fxml.FXML;

public class AddController {

    @FXML
    private ChoiceBox<Integer> ratingChbx;
    @FXML
    private Spinner<Integer> lengthSpnr;
    @FXML
    private TextField categoryEtxt;
    @FXML
    private Button addBtn;
    @FXML
    private TextField titleEtxt;

    @javafx.fxml.FXML
    public void addBtnClick() {
        String title = titleEtxt.getText().toString();
        String category = categoryEtxt.getText().toString();
        int length = lengthSpnr.getValue();
        int rating = ratingChbx.getValue();  //meg nem megy, szar a java
        if (title.isEmpty()) {
            new Alert(Alert.AlertType.NONE, "Nem lehet ures a cim mezo", ButtonType.OK).show();
        } else if (category.isEmpty()) {
            new Alert(Alert.AlertType.NONE, "Nem lehet ures a kategoria mezo", ButtonType.OK).show();
        } else {

        }
    }
}
