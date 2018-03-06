package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    public Label dayLabel1, dayLabel2, dayLabel3, dayLabel4, dayLabel5;

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
    }
}
