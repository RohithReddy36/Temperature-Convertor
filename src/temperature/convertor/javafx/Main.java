package temperature.convertor.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application{


	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();

		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu()
	{
		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItems = new MenuItem("New");
		newMenuItems.setOnAction(event -> System.out.println("new is clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItems = new MenuItem("Quit");
		quitMenuItems.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItems, separatorMenuItem, quitMenuItems);
		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutMenu = new MenuItem("About");
		aboutMenu.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutMenu);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp()
	{
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Web App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Blah Blah Blah Blah");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickBtn = alertDialog.showAndWait();

		if (clickBtn.isPresent() && clickBtn.get() == yesBtn) {
			System.out.println("Yes Button is Clicked");
		} else {
			System.out.println("No Button is Clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
