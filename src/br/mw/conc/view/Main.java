package br.mw.conc.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.mw.conc.model.persistencia.FabricaEntityManager;

public class Main extends Application {
	@Override
	// public void start(Stage primaryStage) {
	public void start(Stage palco) {
		try {
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Iniciando o JPA.
			FabricaEntityManager.obtemEntityManager();
			URL arquivoFXML = getClass().getResource("./Principal.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			palco.setScene(new Scene(fxmlParent));
			palco.setTitle("Concurseiro");
			palco.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
