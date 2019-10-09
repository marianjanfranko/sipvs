package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("HBox Experiment 1");

        Label nameL = new Label("Name");
        nameL.setPadding(new Insets(5,10,5,10));
        TextField nameT = new TextField();

        Label surnameL = new Label("Surname");
        surnameL.setPadding(new Insets(5,10,5,10));

        TextField surnameT = new TextField();

        Label ageL = new Label("Age");
        ageL.setPadding(new Insets(5,10,5,10));

        TextField ageT = new TextField();

        Label courseDateL = new Label("Course date");
        courseDateL.setPadding(new Insets(5,10,5,10));

        TextField courseDateT = new TextField();

        VBox hBoxName = new VBox(nameL, surnameL, ageL, courseDateL);
        VBox hBoxNames = new VBox(nameT, surnameT, ageT, courseDateT);
//        HBox hBoxSurname = new HBox(, surnameT);
//        HBox hBoxAge = new HBox( , ageT);
        HBox hBoxCourseDate = new HBox(hBoxName, hBoxNames);

//        VBox vbox = new VBox(hBoxName, hBoxSurname, hBoxAge, hBoxCourseDate);

        Scene scene = new Scene(hBoxCourseDate, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
