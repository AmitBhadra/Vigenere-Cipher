package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;

/**
 * Created by AMIT on 11-08-2015.
 */
public class encryptIt {

    public static String msg = "";



    public static void display()
    {


        final String yeah;
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Encrypt It!");
        window.setMinWidth(500);

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        gridPane.setHgap(10);

        Label Cipher=new Label("Message:");
        GridPane.setConstraints(Cipher, 0, 0);
        TextField ciInput=new TextField();
        ciInput.setPrefWidth(400);
        GridPane.setConstraints(ciInput, 1, 0);

        Label Key=new Label("Key:");
        GridPane.setConstraints(Key, 0, 1);
        TextField keyInput=new TextField();
        keyInput.setPrefWidth(400);

        GridPane.setConstraints(keyInput, 1, 1);


        Button button=new Button("Solve");
        GridPane.setConstraints(button, 0, 2);
        button.setOnAction(e -> {
            String text = ciInput.getText();
            String key = keyInput.getText();

            find(text, key);


        });
        System.out.println(msg);


        //TextField nameInput=new TextField("Hey");
        //nameInput.setPrefWidth(400);
        //GridPane.setConstraints(nameInput, 1, 3);
        Label label2=new Label(msg);
        GridPane.setConstraints(label2, 1, 3);




        gridPane.getChildren().addAll(keyInput, Key,Cipher,ciInput, button, label2);
        Scene scene=new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();


    }
    public static void find(String text, String key)
    {

        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Encrypt It!");
        window.setMinWidth(500);

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        gridPane.setHgap(10);

        msg="";



        System.out.println(key);
        System.out.println(text);

        key = key.toUpperCase();
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            msg += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }

        //Label label2=new Label(msg);
        //GridPane.setConstraints(label2, 1, 3);
        Label Message=new Label("Cipher:");
        GridPane.setConstraints(Message, 0, 3);
        TextField nameInput=new TextField(msg);
        nameInput.setPrefWidth(400);
        GridPane.setConstraints(nameInput, 1, 3);
        gridPane.getChildren().addAll(nameInput, Message);
        Scene scene=new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();


    }
}




