package florbalovaLiga;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.UIManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main {
//	private Stage primaryStage;
//	private AnchorPane mainLayout;

//	@Override
//	public void start(Stage primaryStage) throws IOException {
//		this.primaryStage = primaryStage;
//		this.primaryStage.setTitle("Registračný formulár");
//		this.primaryStage.setResizable(false);
//		showMainView();
//	}

//	private void showMainView() throws IOException {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("/florbalovaLigaView/MainView.fxml"));
//
//		mainLayout = loader.load();
//		Scene scene = new Scene(mainLayout);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}


	public static void main(String[] args) throws Exception {
		DocVerifyUtils docVerifier = DocVerifyUtils.getInstance();
		ArrayList listOfFiles = new ArrayList();
		File file = new File("C:/Users/samue/Projekty/PosledneZadanie/docs/06XadesT.xml");

		String sb = "";

		listOfFiles.add(file);
		sb = docVerifier.checkDocuments(listOfFiles);
	}
}
