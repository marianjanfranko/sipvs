package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import xmlutils.XMLSerializer;
import xmlutils.XMLValidator;
import xmlutils.XMLtoHTML;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {
    public FileChooser chooser = new FileChooser();
    XMLValidator xv = new XMLValidator();
    XMLSerializer xs = new XMLSerializer();
    XMLtoHTML xth = new XMLtoHTML();

    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setTitle("XML Validator");

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

        VBox labels = new VBox(nameL, surnameL, ageL, courseDateL);
        VBox values = new VBox(nameT, surnameT, ageT, courseDateT);

        HBox hBoxForm = new HBox(labels, values);

        Button save = new Button("Save");
        Button validate = new Button("Validate");
        Button generateHtml = new Button("Generate HTML");

        HBox hBoxButtons = new HBox(save, validate, generateHtml);
        hBoxButtons.setPadding(new Insets(10,10,10,25));
        VBox vBoxAll = new VBox(hBoxForm, hBoxButtons);

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = chooser.showOpenDialog(primaryStage);
                System.out.println(xv.validate(file.getAbsolutePath(), "C:/Users/samue/Projekty/sipvs/src/test/resources/scheme.xsd"));
            }
        };

        validate.setOnAction(buttonHandler);

        EventHandler<ActionEvent> saveHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Registration reg = new Registration("Marek", "Otruba", 23, new ArrayList<Date>());
                File file = chooser.showSaveDialog(primaryStage);
                try {
                  xs.serializeXML(file.getAbsolutePath(), reg);
                } catch (IOException e) {
                    System.out.println("niekde je chyba");
                }
            }
        };

        save.setOnAction(saveHandler);

        EventHandler<ActionEvent> showHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = chooser.showOpenDialog(primaryStage);
                    xth.convertXMLToHTML(new StreamSource(file),new StreamSource(new File("C:/Users/samue/Projekty/sipvs/src/test/resources/test_xsl.xsl")),"C:/Users/samue/Projekty/sipvs/src/test/resources/final.html");
            }
        };

        generateHtml.setOnAction(showHandler);

        Scene scene = new Scene(vBoxAll, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
