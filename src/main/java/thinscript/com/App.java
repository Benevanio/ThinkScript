package thinscript.com;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema da livraria com Java FX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}