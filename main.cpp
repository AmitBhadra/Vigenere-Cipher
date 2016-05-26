package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;

import java.awt.*;


public class Main extends Application {

    Stage window;
    ComboBox<String> comboBox;
    Scene scene1,scene2;


    @Override
    public void start(Stage primaryStage) throws Exception{


        window=primaryStage;
        window.setTitle("Vigenere Cipher");

        Label label=new Label("This is a simple Viegenere Cipher GUI using Javafx");
        GridPane.setConstraints(label, 0, 0);


        comboBox= new ComboBox<String>();
        comboBox.getItems().addAll(
                "Encrypt",
                "Decrypt"
        );
        comboBox.setPromptText("Enter your choice");
        GridPane.setConstraints(comboBox, 0, 2);


        comboBox.setOnAction(e -> chooseActivity(comboBox.getValue()));



        //layout
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        gridPane.getChildren().addAll(comboBox, label);



        window.setScene(new Scene(gridPane, 300, 200));
        window.show();
    }

    private void chooseActivity(String choice)
    {
        if(choice.equals("Encrypt"))
            Encrypt(window);
        else
            Decrypt();
    }

    private void Encrypt(Stage primaryStage)
    {
        encryptIt.display();

    }

    private void Decrypt(){
        decryptIt.display();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
