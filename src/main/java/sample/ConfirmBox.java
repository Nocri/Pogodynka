package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    public static boolean isTrue;

    public static String display(String title, String message){
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label label1 = new Label(message);
        TextField textField = new TextField();

        Button yesButton = new Button("Add");
        yesButton.setOnAction(event -> {isTrue = true; stage.close();});
        Button noButton = new Button("Cancel");
        noButton.setOnAction(event -> {isTrue = false; stage.close();});

        VBox vBox = new VBox(10);

        HBox editTextBox = new HBox(10);
        editTextBox.getChildren().addAll(label1, textField);

        HBox buttonsBox = new HBox(10);
        buttonsBox.getChildren().addAll(yesButton, noButton);
        vBox.getChildren().addAll(editTextBox, buttonsBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.showAndWait();

        return textField.getCharacters().toString();
    }

}
