package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
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

public class Main extends Application {
    public FileChooser chooser = new FileChooser();
    XMLValidator xv = new XMLValidator();
    XMLSerializer xs = new XMLSerializer();
    XMLtoHTML xth = new XMLtoHTML();

    String[] dates = { "2020-12-20", "2020-12-21", "2020-12-22", "2020-12-23", "2020-12-24", "2020-12-25" };

    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setTitle("XML Validator");

        Label nameL = new Label("Name");
        nameL.setPadding(new Insets(5,10,5,10));
        final TextField nameT = new TextField();

        Label surnameL = new Label("Surname");
        surnameL.setPadding(new Insets(5,10,5,10));

        final TextField surnameT = new TextField();

        Label ageL = new Label("Age");
        ageL.setPadding(new Insets(5,10,5,10));

        final TextField ageT = new TextField();

        TilePane r = new TilePane();

        // create a label
        Label l = new Label("Select courses date");

        // add label
        final VBox Hdates = new VBox();
        final ArrayList<CheckBox> cBoxList = new ArrayList<CheckBox>();

        for (int i = 0; i < dates.length; i++) {

            // create a checkbox
            CheckBox c = new CheckBox(dates[i]);
            cBoxList.add(c);
            // add label
            Hdates.getChildren().add(c);

            // set IndeterMinate
            //c.setIndeterminate(true);
        }


        VBox labels = new VBox(nameL, surnameL, ageL);
        VBox values = new VBox(nameT, surnameT, ageT);

        HBox hBoxForm = new HBox(labels, values);

        Button save = new Button("Save");
        Button validate = new Button("Validate");
        Button generateHtml = new Button("Generate HTML");

        HBox hBoxButtons = new HBox(save, validate, generateHtml);
        hBoxButtons.setPadding(new Insets(10,10,10,25));
        VBox vBoxAll = new VBox(hBoxForm, l, Hdates, hBoxButtons);

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = chooser.showOpenDialog(primaryStage);
                String msg = xv.validate(file.getAbsolutePath(), "C:/Users/samue/Projekty/sipvs/src/test/resources/scheme.xsd");
                if (msg == null) {
                    new Alert(Alert.AlertType.CONFIRMATION, "XML is VALID!").showAndWait();
                } else {
                    new Alert(Alert.AlertType.ERROR, "XML is INVALID!\n" + msg).showAndWait();
                }
            }
        };

        validate.setOnAction(buttonHandler);

        EventHandler<ActionEvent> saveHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<String> finalDates = new ArrayList<>();
                for (int i = 0; i < dates.length; i++){
                    if (cBoxList.get(i).isSelected()){
                        finalDates.add(dates[i]);                    }
                }

                if (!isAlpha(nameT.getText()) || nameT.getText().length() == 0 ||
                        !isAlpha(surnameT.getText()) || surnameT.getText().length() == 0 ||
                        ageT.getText().length() == 0 || finalDates.isEmpty()){
                    new Alert(Alert.AlertType.ERROR, "Some inputs are Invalid or Empty!").showAndWait();
                } else {
                    try {

                        Integer.parseInt(ageT.getText());
                        Registration reg = new Registration(nameT.getText(), surnameT.getText(), Integer.parseInt(ageT.getText()), finalDates);
                        File file = chooser.showSaveDialog(primaryStage);
                        try {

                            xs.serializeXML(file.getAbsolutePath() + ".xml", reg);

                        } catch (IOException e) {
                            System.out.println("niekde je chyba");
                        }
                    } catch (NumberFormatException e) {
                        new Alert(Alert.AlertType.ERROR, "Age must be number!").showAndWait();
                    }
                }
            }
        };

        save.setOnAction(saveHandler);

        EventHandler<ActionEvent> showHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File fileOpen = chooser.showOpenDialog(primaryStage);
                File fileToSave = chooser.showSaveDialog(primaryStage);
                xth.convertXMLToHTML(new StreamSource(fileOpen),new StreamSource(new File("C:/Users/samue/Projekty/sipvs/src/test/resources/test_xsl.xsl")),fileToSave.getAbsolutePath() + ".html");
            }
        };

        generateHtml.setOnAction(showHandler);

        Scene scene = new Scene(vBoxAll, 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public boolean isNum(String age) {
        if (Integer.parseInt(age) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
