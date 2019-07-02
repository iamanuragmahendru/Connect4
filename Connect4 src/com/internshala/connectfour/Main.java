package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Controller controller;

	@Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
	    GridPane rootGridPane = loader.load();

	    controller = loader.getController();
	    controller.createPlayground();

	    Pane menuPane = (Pane) rootGridPane.getChildren().get(0);

	    MenuBar menuBar = createMenu();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    menuPane.getChildren().add(menuBar);

	    Scene scene = new Scene(rootGridPane);

	    primaryStage.setScene(scene);
        primaryStage.setTitle("Connet Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar createMenu() {

	    Menu fileMenu = new Menu("File");
	    MenuItem newMenuItem = new MenuItem("New Game");

	    newMenuItem.setOnAction(event -> controller.resetGame());

	    MenuItem resetMenuItem = new MenuItem("Reset Game");

	    resetMenuItem.setOnAction(event -> controller.resetGame());

	    SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	    MenuItem exitMenuItem = new MenuItem("Exit");

	    exitMenuItem.setOnAction(event -> {
	    	exitGame();
	    });

	    fileMenu.getItems().addAll(newMenuItem, resetMenuItem, separatorMenuItem, exitMenuItem);

	    Menu helpMenu = new Menu("Help");
	    MenuItem aboutGame = new MenuItem("About Game");

	    aboutGame.setOnAction(event -> aboutConnect4());

	    SeparatorMenuItem separator = new SeparatorMenuItem();
	    MenuItem aboutMe = new MenuItem("About Me");

	    aboutMe.setOnAction(event -> aboutMe());

	    helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

	    MenuBar menuBar = new MenuBar();
	    menuBar.getMenus().addAll(fileMenu, helpMenu);

	    return menuBar;

    }

	private void aboutMe() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Anurag Mahendru");
		alert.setContentText("I love to play around with code and create games." +
				"Connect4 is one of them.");

		alert.show();
	}

	private void aboutConnect4() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two-player connection game in which the " +
				"players first choose a color and then take turns dropping colored discs " +
				"from the top into a seven-column, six-row vertically suspended grid. " +
				"The pieces fall straight down, occupying the next available space within the column. " +
				"The objective of the game is to be the first to form a horizontal, vertical, " +
				"or diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.");
		alert.show();

	}

	private void exitGame() {

		Platform.exit();
		System.exit(0);

	}

}
