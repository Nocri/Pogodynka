package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    public Label dayLabel1, dayLabel2, dayLabel3, dayLabel4, dayLabel5;
    public ChoiceBox cityChoiceBox;
    public Button addButton;

    List<String> cities = Arrays.asList("Łódź", "Zgierz", "Konstantynów");

    public void initialize(URL location, ResourceBundle resources) {
        imageView1.setImage(new Image("resources/10d.png"));
        imageView2.setImage(new Image("resources/10d.png"));
        imageView3.setImage(new Image("resources/10d.png"));
        imageView4.setImage(new Image("resources/10d.png"));
        imageView5.setImage(new Image("resources/10d.png"));

        dayLabel1.setText("poniedziałek");
        dayLabel2.setText("poniedziałek");
        dayLabel3.setText("poniedziałek");
        dayLabel4.setText("poniedziałek");
        dayLabel5.setText("poniedziałek");

        cityChoiceBox.getItems().addAll(cities);
        cityChoiceBox.setValue(cities.get(0));

        addButton.setOnAction(event -> {
                    String newCity = ConfirmBox.display("Dodaj miasto", "Nazwa miasta:");
                    if (!newCity.isEmpty()) {
                        cityChoiceBox.getItems().add(newCity);
                    }
                }
        );
    }

}
