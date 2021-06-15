package hu.ak_akademia.hellofx;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button firstButton = new Button();
		firstButton.setMinSize(100, 100);
		firstButton.setText("1");
		firstButton.setStyle("-fx-text-fill: transparent;");
		firstButton.setOnAction(e -> {
			firstButton.setStyle("-fx-text-fill: black;");
		});
		Button secondButton = new Button();
		secondButton.setMinSize(100, 100);
		secondButton.setText("1");
		secondButton.setStyle("-fx-text-fill: transparent;");
		secondButton.setOnAction(e -> {
			secondButton.setStyle("-fx-text-fill: black;");
			if (firstButton.getText()
					.equals(secondButton.getText())) {
				Thread t1 = new Thread(() ->  {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					secondButton.setStyle("-fx-text-fill: transparent;");
					firstButton.setStyle("-fx-text-fill: transparent;");
				});
				t1.start();
			}
		});
		FlowPane pane = new FlowPane();
		pane.getChildren()
				.addAll(firstButton, secondButton);
		primaryStage.setTitle("Test");
		primaryStage.setScene(new Scene(pane, 400, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
